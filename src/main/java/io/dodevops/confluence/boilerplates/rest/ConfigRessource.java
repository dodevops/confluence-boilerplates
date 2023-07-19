package io.dodevops.confluence.boilerplates.rest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Config REST Ressource
 */
@XmlRootElement
public class ConfigRessource {
    @SuppressWarnings("FieldCanBeLocal")
    @XmlElement
    private Boolean spaceRestricted;

    @SuppressWarnings("FieldCanBeLocal")
    @XmlElement
    private String label;

    @SuppressWarnings("FieldCanBeLocal")
    @XmlElement
    private String boilerplateSpace;

    @SuppressWarnings("FieldCanBeLocal")
    @XmlElement
    private String groupingString;

    @SuppressWarnings("unused")
    public ConfigRessource() {
    }

    public ConfigRessource(
        final Boolean spaceRestricted, final String tag, final String boilerplateSpace, final String groupingString
    )
    {
        this.spaceRestricted = spaceRestricted;
        this.label = tag;
        this.boilerplateSpace = boilerplateSpace;
        this.groupingString = groupingString;
    }
}
