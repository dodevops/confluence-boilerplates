package io.dodevops.confluence.boilerplates.action;

import com.atlassian.confluence.core.ConfluenceActionSupport;
import io.dodevops.confluence.boilerplates.config.BoilerplatesConfigurationManager;

/**
 * Update Configuration
 */
public class UpdateConfigurationAction extends ConfluenceActionSupport {
    private static final long serialVersionUID = -4540819017990944132L;

    private BoilerplatesConfigurationManager boilerplatesConfigurationManager;
    private String spaceRestricted;
    private String label;
    private String boilerplateSpace;
    private String groupingString;

    public UpdateConfigurationAction() {
    }

    private boolean isSpaceRestricted() {

        return "on".equals(this.spaceRestricted);

    }

    @SuppressWarnings("unused")
    public void setSpaceRestricted(final String spaceRestricted) {

        this.spaceRestricted = spaceRestricted;

    }

    public String getLabel() {

        return label;

    }

    public void setLabel(final String label) {

        this.label = label;

    }

    public String getBoilerplateSpace() {
        return boilerplateSpace;
    }

    @SuppressWarnings("unused")
    public void setBoilerplateSpace(final String boilerplateSpace) {
        this.boilerplateSpace = boilerplateSpace;
    }

    @Override
    public void validate() {
    }

    public String execute() {

        this.boilerplatesConfigurationManager.setSpaceRestricted(
            this.isSpaceRestricted()
        );
        this.boilerplatesConfigurationManager.setLabel(this.getLabel());
        this.boilerplatesConfigurationManager.setBoilerplateSpace(
            this.getBoilerplateSpace()
        );
        this.boilerplatesConfigurationManager.setGroupingString(
            this.getGroupingString()
        );

        return "success";

    }

    @SuppressWarnings("unused")
    public void setBoilerplatesConfigurationManager(final BoilerplatesConfigurationManager boilerplatesConfigurationManager) {
        this.boilerplatesConfigurationManager = boilerplatesConfigurationManager;
    }

    public String getGroupingString() {
        return groupingString;
    }

    @SuppressWarnings("unused")
    public void setGroupingString(final String groupingString) {
        this.groupingString = groupingString;
    }
}
