package io.dodevops.confluence.boilerplates.config;

import com.atlassian.bandana.BandanaManager;
import com.atlassian.confluence.setup.bandana.ConfluenceBandanaContext;
import com.atlassian.plugin.spring.scanner.annotation.export.ExportAsService;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Boilerplates configuration manager
 */
@ExportAsService({BoilerplatesConfigurationManager.class})
@Named
public class DefaultBoilerplatesConfigurationManager implements BoilerplatesConfigurationManager {

    private final BandanaManager bandanaManager;

    @Inject
    public DefaultBoilerplatesConfigurationManager(
        @ComponentImport final BandanaManager bandanaManager
    ) {
        this.bandanaManager = bandanaManager;
    }

    public boolean getSpaceRestricted() {

        Boolean spaceRestricted = (Boolean)this.bandanaManager.getValue(
            ConfluenceBandanaContext.GLOBAL_CONTEXT,
            "boilerplates.space-restricted"
        );

        if (spaceRestricted == null) {

            spaceRestricted = false;

        }
        return spaceRestricted;
    }

    public String getLabel() {

        String tag = (String)this.bandanaManager.getValue(
            ConfluenceBandanaContext.GLOBAL_CONTEXT,
            "boilerplates.label"
        );

        if (tag == null) {

            tag = "boilerplate";

        }

        return tag;
    }

    public String getBoilerplateSpace() {
        String boilerplateSpace = (String)this.bandanaManager.getValue(
            ConfluenceBandanaContext.GLOBAL_CONTEXT,
            "boilerplates.boilerplate-space"
        );

        if (boilerplateSpace == null) {

            boilerplateSpace = "";

        }

        return boilerplateSpace;

    }

    public String getGroupingString() {
        String groupingString = (String)this.bandanaManager.getValue(
            ConfluenceBandanaContext.GLOBAL_CONTEXT,
            "boilerplates.grouping-string"
        );

        if (groupingString == null) {
            groupingString = "_";
        }

        return groupingString;

    }

    public void setSpaceRestricted(final boolean spaceRestricted) {

        this.bandanaManager.setValue(
            ConfluenceBandanaContext.GLOBAL_CONTEXT,
            "boilerplates.space-restricted",
            spaceRestricted
        );

    }

    public void setLabel(final String label) {
        this.bandanaManager.setValue(
            ConfluenceBandanaContext.GLOBAL_CONTEXT,
            "boilerplates.label",
            label
        );

    }

    public void setBoilerplateSpace(final String boilerplateSpace) {

        this.bandanaManager.setValue(
            ConfluenceBandanaContext.GLOBAL_CONTEXT,
            "boilerplates.boilerplate-space",
            boilerplateSpace
        );

    }

    public void setGroupingString(final String groupingString) {

        this.bandanaManager.setValue(
            ConfluenceBandanaContext.GLOBAL_CONTEXT,
            "boilerplates.grouping-string",
            groupingString
        );

    }

}
