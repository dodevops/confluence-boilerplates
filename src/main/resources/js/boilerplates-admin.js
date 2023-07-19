/* global AJS */

AJS.toInit(function ($) {

    'use strict'

    $('#boilerplates-edit').click(function (e) {
        e.preventDefault()
        $('#boilerplates-configuration').addClass('editing')
    })

})
