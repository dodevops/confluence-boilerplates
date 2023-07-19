package io.dodevops.confluence.boilerplates.config;

/**
 * Boilerplates Configuration Interface
 */
public interface BoilerplatesConfigurationManager {

    boolean getSpaceRestricted();
    String getLabel();
    String getBoilerplateSpace();
    String getGroupingString();

    void setSpaceRestricted(boolean spaceRestricted);

    void setLabel(String label);

    void setBoilerplateSpace(String boilerplateSpace);

    void setGroupingString(String groupingString);

}
