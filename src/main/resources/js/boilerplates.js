// Atlassian Confluence Boilerplates plugin
/* global Boilerplates, AJS */
(
    function () {

        'use strict'

        function BoilerplatesPlugin () {

            /**
             * Initialize Boilerplates plugin and adds the toolbar button
             */
            this.init = () => {
                const button = Boilerplates.Templates.toolbar()

                // Add button to toolbar after "Insert" command
                AJS.$('.rte-toolbar-group-insert').after(button)

                // Fill up boilerplate submenu
                this.updateList()
            }

            /**
             * Update submenu
             */
            this.updateList = () => {

                // Remove current entries
                AJS.$('.boilerplates-entry').remove()

                // Get configuration
                AJS.$.ajax({
                    url: AJS.Confluence.getBaseUrl() +
                        '/rest/boilerplates/1.0/config.json',
                    type: 'GET',
                    success: (configData) => {
                        this.configData = configData

                        // Fetch new list, build up CQL
                        const cqlComponents = []

                        if (configData.spaceRestricted) {
                            // Space should be restricted to current space

                            cqlComponents.push(
                                'space=%22' +
                                AJS.Confluence.PageLocation.get().spaceKey +
                                '%22'
                            )
                        }

                        // Add label to search for
                        cqlComponents.push(
                            'label=%22' +
                            configData.label +
                            '%22'
                        )

                        let cql = cqlComponents.join('%20AND%20')

                        if (configData.boilerplateSpace !== '') {
                            // Add default boilerplate space query

                            cql = '(' + cql + ')%20OR%20('
                            cql += 'label=%22' + configData.label + '%22'
                            cql += '%20AND%20'
                            cql += 'space=%22' + configData.boilerplateSpace + '%22'
                            cql += ')'
                        }

                        cql += '%20ORDER%20BY%20title'

                        // Fetch matching boilerplates
                        AJS.$.ajax({
                            url: AJS.Confluence.getBaseUrl() +
                                '/rest/api/content/search?cql=' + cql,
                            type: 'GET',
                            success: this.buildMenu
                        })

                    }
                })

            }

            this.buildMenu = (data) => {

                if (data.results.length === 0) {
                    // We have no resulting boilerplates. Remove
                    // the button

                    AJS.$('.rte-toolbar-group-boilerplates')
                        .remove()
                    return
                }

                // Build up menu structure
                const menu = {}

                for (let i = 0; i < data.results.length; i = i + 1) {

                    const result = data.results[i]
                    const parts = result.title.split(
                        this.configData.groupingString
                    )

                    let reference = menu

                    for (let a = 0; a < parts.length; a = a + 1) {
                        if (a === parts.length - 1) {
                            reference[parts[a]] = {
                                'type': 'item',
                                'content': Boilerplates.Templates.entry(
                                    {
                                        id: result.id,
                                        tooltip: parts[a],
                                        text: parts[a]
                                    }
                                ),
                                'id': result.id
                            }
                        } else {
                            if (!reference.hasOwnProperty(parts[a])) {
                                let groupName = parts.slice(0, a - 1).join('_')

                                // Replace whitespace with underscores
                                groupName = groupName.replace(/\s/, '_')

                                reference[parts[a]] = {
                                    'type': 'submenu',
                                    'group': groupName,
                                    'name': parts[a]
                                }
                            }

                            reference = reference[parts[a]]
                        }

                    }

                }

                for (const key in menu) {
                    if (menu.hasOwnProperty(key)) {

                        const item = menu[key]
                        if (item.type === 'item') {
                            AJS.$(
                                '#boilerplates-insert-list'
                            ).append(item.content)

                            AJS.$(
                                '#boilerplates-entry-' + item.id
                            ).click(
                                this.insertBoilerplate
                            )
                        } else {
                            this.addSubMenu(
                                AJS.$('#boilerplates-insert-list'),
                                item
                            )
                        }
                    }
                }
            }

            /**
             * Add an items submenu
             *
             * @param parentMenu The parent menu item
             * @param submenu The submenu to build
             */
            this.addSubMenu = (parentMenu, submenu) => {
                const subMenuContent = Boilerplates.Templates.submenu({
                    'group': submenu.group,
                    'tooltip': submenu.name,
                    'text': submenu.name
                })

                parentMenu.append(subMenuContent)

                parentMenu = AJS.$(`#boilerplates-group-entries-${submenu.group}`)

                for (const key in submenu) {
                    if (submenu.hasOwnProperty(key)) {
                        const item = submenu[key]

                        if (typeof item !== 'object') {
                            continue
                        }

                        if (item.type === 'item') {
                            parentMenu.append(item.content)

                            AJS.$(
                                '#boilerplates-entry-' + item.id
                            ).click(
                                this.insertBoilerplate
                            )
                        } else {
                            this.addSubMenu(parentMenu, item)
                        }
                    }
                }
            }

            /**
             * Insert a boilerplate
             * @param ev MouseEvent from submenu
             */
            this.insertBoilerplate = (ev) => {

                // Prevent default event handling
                ev.preventDefault()

                const entry = AJS.$(ev.target)

                // Fetch page content
                AJS.$.ajax({
                    url: AJS.Confluence.getBaseUrl() +
                        '/rest/api/content/' + entry.data('id') +
                        '?expand=body.editor',
                    type: 'GET',
                    success: function (data) {
                        // Insert page content at caret position.
                        const newContent = data.body.editor.value

                        AJS.Rte.getEditor().execCommand(
                            'mceInsertContent', false, newContent
                        )

                    }
                })
            }
        }

        // Call initialization when Editor is initialized
        AJS.bind('init.rte', new BoilerplatesPlugin().init)

    }
)(AJS.$)