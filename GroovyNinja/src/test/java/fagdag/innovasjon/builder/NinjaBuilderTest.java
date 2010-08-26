package fagdag.innovasjon.builder;

import fagdag.innovasjon.domain.Ninja;
import fagdag.innovasjon.domain.Skill;
import fagdag.innovasjon.domain.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static fagdag.innovasjon.domain.Skill.ClimbWall;
import static fagdag.innovasjon.domain.Utility.Type.*;
import static org.junit.Assert.assertTrue;

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
public class NinjaBuilderTest {
    private BaseBuilder builder;

    @Before
    public void setup() {
        builder = BaseBuilder.start()
                .ninja()
                .skill(ClimbWall)
                .weapon(Knife)
                .weapon(Shuriken);
    }

    @Test
    public void shouldDemandNecessaryToolsForClimbingWall() {
        Ninja ninja = builder.get();
        assertTrue(ninja.can(ClimbWall));

        builder.weapon(GrapplingHook).weapon(Rope).doApply();
        assertTrue(ninja.can(ClimbWall));
    }

    @Test
    public void shouldChangeNinjaName() {
        Ninja ninja = builder.get();
        String oldName = ninja.getName();

        builder.editNinja().name("Judoole");
        Assert.assertNotSame(oldName, ninja.getName());
    }


}