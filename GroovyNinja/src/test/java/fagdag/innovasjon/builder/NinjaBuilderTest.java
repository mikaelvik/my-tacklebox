package fagdag.innovasjon.builder;

import fagdag.innovasjon.domain.Ninja;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static fagdag.innovasjon.domain.Skill.ClimbWall;
import static fagdag.innovasjon.domain.Skill.Stab;
import static fagdag.innovasjon.domain.Utility.Type.*;
import static org.junit.Assert.*;

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
public class NinjaBuilderTest {

    private BaseBuilder builder;
    Ninja ninja;

    @Before
    public void setup() {
        builder = BaseBuilder.start()
                .ninja()
                .skill(ClimbWall)
                .weapon(Knife).mojo(10)
                .weapon(Shuriken).acquired(new DateTime().minusDays(10))
                .tool(Rope);
        ninja = builder.get();
    }

    @Test
    public void shouldDemandNecessaryToolsForClimbingWall() {
        assertFalse(ninja.can(ClimbWall));

        builder.tool(GrapplingHook).doApply();
        assertTrue(ninja.can(ClimbWall));
    }

    @Test
    public void shouldChangeNinjaName() {
        String oldName = ninja.getName();

        builder.editNinja().name("Judoole");
        assertNotSame(oldName, ninja.getName());
    }

    @Test
    public void shouldGetNinjaFromSetupBuilder() {
        ninja = BaseBuilder.start().stabbingNinja().get();
        assertTrue(ninja.can(Stab));
        assertFalse(ninja.can(ClimbWall));
    }

}