package fagdag.innovasjon.builder;

import fagdag.innovasjon.domain.Ninja;
import fagdag.innovasjon.domain.Skill;
import fagdag.innovasjon.domain.Weapon;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static fagdag.innovasjon.domain.Skill.*;
import static fagdag.innovasjon.domain.Utility.Type.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
@SuppressWarnings({"UnusedDeclaration"})
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
        assertFalse(


                ninja.can(ClimbWall)

        );
        builder.tool(GrapplingHook).doApply();
        assertTrue(ninja.can(ClimbWall));
    }

    @Test
    public void shouldGetNinjaFromSetupBuilder() {
        ninja = BaseBuilder.start().stabbingNinja().get();
        assertTrue(ninja.can(Stab));
        assertFalse(ninja.can(ClimbWall));
    }

    @Test
    public void should() {
        System.out.println(": " + createNinja());
    }


    public Ninja createNinja() {
        Ninja ninja = new Ninja();
        ninja.setName("Hattori Hanzö");
        ninja.setDojo("Bekkarado");
        ninja.setKills(130);
        ninja.setSkills(new HashSet<Skill>(asList(SneakAttack, SetArson, SwordFight)));

        Weapon weapon = new Weapon();
        weapon.setType(Katana);
        weapon.setMojo(33);
        weapon.setAcquired(new DateTime().minusDays(1));
        weapon.setNickname("SlayerBoy");
        ninja.addWeapon(weapon);
        
        return ninja;
    }


}
