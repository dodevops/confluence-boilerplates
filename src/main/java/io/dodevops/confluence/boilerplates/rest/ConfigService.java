package io.dodevops.confluence.boilerplates.rest;

import io.dodevops.confluence.boilerplates.config.BoilerplatesConfigurationManager;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Config-REST-Ressource
 */
@Path("/config")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class ConfigService {
    private BoilerplatesConfigurationManager boilerplatesConfigurationManager;

    @Inject
    public ConfigService(final BoilerplatesConfigurationManager boilerplatesConfigurationManager) {
        this.boilerplatesConfigurationManager = boilerplatesConfigurationManager;
    }

    @GET
    public Response getConfig() {
        final ConfigRessource currentConfig = new ConfigRessource(
            this.getBoilerplatesConfigurationManager().getSpaceRestricted(),
            this.getBoilerplatesConfigurationManager().getLabel(),
            this.getBoilerplatesConfigurationManager().getBoilerplateSpace(),
            this.getBoilerplatesConfigurationManager().getGroupingString()
        );

        return Response.ok(currentConfig).build();
    }

    public BoilerplatesConfigurationManager getBoilerplatesConfigurationManager() {
        return boilerplatesConfigurationManager;
    }

    @SuppressWarnings("unused")
    public void setBoilerplatesConfigurationManager(final BoilerplatesConfigurationManager boilerplatesConfigurationManager) {
        this.boilerplatesConfigurationManager = boilerplatesConfigurationManager;
    }
}
