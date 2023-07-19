package it.io.dodevops.confluence.boilerplates;

import com.atlassian.plugins.osgi.test.AtlassianPluginsTestRunner;
import io.dodevops.confluence.boilerplates.config.BoilerplatesConfigurationManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AtlassianPluginsTestRunner.class)
public class ConfigurationManagerTest {

    private BoilerplatesConfigurationManager boilerplatesConfigurationManager;

    public ConfigurationManagerTest() {
    }

    @Test
    public void testGetLabel() {

        String currentLabel = boilerplatesConfigurationManager.getLabel();

        Assert.assertNotNull(
            "Label is null!",
            currentLabel
        );

        Assert.assertNotSame(
            "Label is empty!",
            currentLabel,
            ""
        );

    }

    @Test
    public void testSetLabel() {

        String currentLabel = boilerplatesConfigurationManager.getLabel();

        boilerplatesConfigurationManager.setLabel("__TEST__");

        String setLabel = boilerplatesConfigurationManager.getLabel();

        Assert.assertEquals(
            "Label has not been set",
            setLabel,
            "__TEST__"
        );

        boilerplatesConfigurationManager.setLabel(currentLabel);

        setLabel = boilerplatesConfigurationManager.getLabel();

        Assert.assertEquals(
            "Old label couldn't be set",
            currentLabel,
            setLabel
        );

    }

    @Test
    public void testGetSpaceRestricted() {

        Boolean currentSpaceRestricted =
            boilerplatesConfigurationManager.getSpaceRestricted();

        Assert.assertNotNull(
            "SpaceRestricted is null!",
            currentSpaceRestricted
        );

    }

    @Test
    public void testSetSpaceRestricted() {

        Boolean currentSpaceRestricted =
            boilerplatesConfigurationManager.getSpaceRestricted();

        boilerplatesConfigurationManager.setSpaceRestricted(
            !currentSpaceRestricted
        );

        Boolean setSpaceRestricted = boilerplatesConfigurationManager
            .getSpaceRestricted();

        Assert.assertNotSame(
            "SpaceRestricted couldn't be set.",
            setSpaceRestricted,
            currentSpaceRestricted
        );

        boilerplatesConfigurationManager.
            setSpaceRestricted(currentSpaceRestricted);

        setSpaceRestricted = boilerplatesConfigurationManager
            .getSpaceRestricted();

        Assert.assertEquals(
            "SpaceRestricted could't be set to the old value",
            setSpaceRestricted,
            currentSpaceRestricted
        );

    }

    @Test
    public void testGetBoilerplateSpace() {

        String currentBoilerplateSpace =
            boilerplatesConfigurationManager.getBoilerplateSpace();

        Assert.assertNotNull(
            "Default BoilerplateSpace is null!",
            currentBoilerplateSpace
        );

    }

    @Test
    public void testSetBoilerplateSpace() {

        String currentBoilerplateSpace =
            boilerplatesConfigurationManager.getBoilerplateSpace();

        boilerplatesConfigurationManager.setBoilerplateSpace("__TEST__");

        String setBoilerplateSpace =
            boilerplatesConfigurationManager.getBoilerplateSpace();

        Assert.assertSame(
            "Default BoilerplateSpace couldn't be set.",
            setBoilerplateSpace,
            "__TEST__"
        );

        boilerplatesConfigurationManager.setBoilerplateSpace(
            currentBoilerplateSpace
        );

        setBoilerplateSpace =
            boilerplatesConfigurationManager.getBoilerplateSpace();

        Assert.assertSame(
            "Default BoilerplateSpace couldn't be reset.",
            currentBoilerplateSpace,
            setBoilerplateSpace
        );

    }

    @Test
    public void testGetGroupingString() {

        String currentGroupingString =
            boilerplatesConfigurationManager.getGroupingString();

        Assert.assertNotNull(
            "Grouping String is null!",
            currentGroupingString
        );

    }

    @Test
    public void testSetGroupingString() {

        String currentGroupingString =
            boilerplatesConfigurationManager.getGroupingString();

        boilerplatesConfigurationManager.setGroupingString("__TEST__");

        String setGroupingString =
            boilerplatesConfigurationManager.getGroupingString();

        Assert.assertSame(
            "Grouping string couldn't be set.",
            setGroupingString,
            "__TEST__"
        );

        boilerplatesConfigurationManager.setGroupingString(
            currentGroupingString
        );

        setGroupingString =
            boilerplatesConfigurationManager.getGroupingString();

        Assert.assertSame(
            "Grouping string couldn't be reset.",
            currentGroupingString,
            setGroupingString
        );

    }

}
