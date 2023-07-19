package io.dodevops.confluence.boilerplates.action;

import com.atlassian.confluence.core.ConfluenceActionSupport;
import io.dodevops.confluence.boilerplates.config.BoilerplatesConfigurationManager;

/**
 * View configuration
 */
public class ViewConfigurationAction extends ConfluenceActionSupport {
    private static final long serialVersionUID = -5094392621708027975L;

    private BoilerplatesConfigurationManager boilerplatesConfigurationManager;

    public ViewConfigurationAction() {
    }

    public boolean getSpaceRestricted() {

        return boilerplatesConfigurationManager.getSpaceRestricted();

    }

    public String getLabel() {

        return boilerplatesConfigurationManager.getLabel();

    }

    public String getBoilerplateSpace() {

        return boilerplatesConfigurationManager.getBoilerplateSpace();

    }

    public String getGroupingString() {

        return boilerplatesConfigurationManager.getGroupingString();

    }

    @SuppressWarnings("unused")
    public void setBoilerplatesConfigurationManager(final BoilerplatesConfigurationManager boilerplatesConfigurationManager) {
        this.boilerplatesConfigurationManager = boilerplatesConfigurationManager;
    }

    @Override
    public void validate() {
    }

    public String execute() {
        return "success";
    }

}
