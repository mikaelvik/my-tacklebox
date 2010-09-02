package fagdag.innovasjon.builder;

import fagdag.innovasjon.domain.Ninja;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static fagdag.innovasjon.domain.Skill.*;
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
                .ninja().name("Hattori Hanzô")
                .skill(ClimbWall)
                .skill(SwordFight)
                .weapon(Knife).mojo(10)
                .weapon(Shuriken).acquired(new DateTime().minusDays(10))
                .tool(Rope);
        ninja = builder.get();
    }

    @Test
    public void shouldShowStartValues() {
        assertEquals("Hattori Hanzô", ninja.getName());
        assertEquals(2, ninja.getWeapons().size());
        assertFalse(ninja.can(SwordFight));
    }

    @Test
    public void shouldChangeName() {
        builder.editNinja().name("Judoole");
        assertNotSame("Hattori Hanzô", ninja.getName());
    }

    @Test
    public void shouldAddWeapon() {
        builder.editNinja().weapon(Katana).mojo(2000).doApply();
        assertEquals(3, ninja.getWeapons().size());
        assertTrue(ninja.can(SwordFight));
    }

    @Test
    public void shouldDemandNecessaryToolsForClimbingWall() {
        assertFalse(ninja.can(ClimbWall));
        builder.tool(GrapplingHook).doApply();
        assertTrue(ninja.can(ClimbWall));
    }

    @Test
    public void shouldGetNinjaFromSetupBuilder() {
        ninja = BaseBuilder.start().stabbingNinja().get();
        assertTrue(ninja.can(Stab));
        assertFalse(ninja.can(ClimbWall));
    }

}
