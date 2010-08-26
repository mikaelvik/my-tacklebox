package fagdag.innovasjon.domain

import org.junit.Before
import org.junit.Test
import static org.junit.Assert.*

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
class NinjaTest {

    Ninja ninja

    @Before
    public void setup() {
        ninja = new Ninja()
        Skill.values().each { skill ->
            ninja.addSkill skill
        }
    }

    @Test
    def void ignoreAccessorMethods() {
        ninja.name = "Hachisuka Tenzo"
        assertEquals(ninja.getName(), ninja.name)
        print "Hi ${ninja.name}, mah daawg!"
    }

    @Test
    def void shouldBeSenseiWithAllSkills() {
        assertTrue(ninja.isSensei())
    }

    @Test
    def void shouldFailAsSenseiWithoutSkill() {
        ninja.removeSkill(Skill.Stab)
        assertFalse(ninja.isSensei())
    }

    @Test
    def void shouldClimbWall(){

        ninja = new Ninja(
                skills: [Skill.ClimbWall],
                utilities: [Tool.Rope, Tool.GrapplingHook],
                kills: 10
        )

        println ninja

        ninja.utilities << Weapon.Shuriken << Weapon.Poison

        // closure
        ninja.utilities.each { utility ->
            println "u: ${utility}"
        }
//        for (Weapon weapon : ninja.getWeapons()) {
//            System.out.println("w: " + weapon);
//        }
//
//        for (Skill skill : ninja.getSkills()) {
//            System.out.println("s: " + skill);
//        }

        assertTrue(ninja.can(Skill.ClimbWall));
    }

}
