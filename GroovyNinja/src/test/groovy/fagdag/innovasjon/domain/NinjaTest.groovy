package fagdag.innovasjon.domain

import org.joda.time.DateTime
import org.junit.Before
import org.junit.Test
import static fagdag.innovasjon.domain.Skill.SwordFight
import static fagdag.innovasjon.domain.Utility.Type.*
import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertTrue

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
class NinjaTest {

    Ninja3 ninja

    @Before
    public void setup() {
        ninja = new Ninja3(name: "Erik")
        Skill.values().each { skill ->
            ninja.addSkill skill
        }
    }

    @Test
    def void ignoreAccessorMethods() {
        ninja.name = "Hachisuka Tenzo"
//        assert ninja.getName(), ninja.name
        println "Hi ${ninja.name}, mah daawg!"
    }

    @Test
    def void shouldBeSenseiWithAllSkills() {
        assertTrue(ninja.isSensei())
    }

    @Test
    def void shouldFailAsSenseiWithoutSkill() {
        println ninja.skills
        ninja.removeSkill(Skill.Stab)
        println ninja.skills
        assertFalse(ninja.isSensei())
    }

    @Test
    def void shouldClimbWall() {

        ninja = new Ninja3(
                skills: [Skill.ClimbWall],
                kills: 10
        )

        println ninja

        ninja.utilities << new Tool(type: GrapplingHook) << new Tool(type: Rope)

        def s = "Erik"
        def c = {
            println "$s u: ${it.type}"
        }

        ninja.utilities.each(c)

        println "-----------------"
        s = "Mikz"
        ninja.utilities.each c
        assertTrue(ninja.can(Skill.ClimbWall));
    }

    @Test
    public void shouldImpressErik() {
        println ninja.name.size()
        println ninja.'name'.'size'()
        println ninja['name'].'size'()

        ninja.name = null
        println ninja.'name'?.'size'()
        assert ninja.'name'?.'size'() != 4
    }

    @Test
    public void shouldImplementNinjaWithGroovy() {
        ninja = new Ninja3()
        ninja.skills = Skill.values().asType(List)
        assert ninja.isSensei()

        ninja.utilities << new Weapon(
                type: Katana,
                mojo: 20,
                acquired: new DateTime("1279-02-01"),
                nickname: "VirginSlayer"
        )
        ninja.utilities << new Tool(
                type: GrapplingHook,
                price: 10,
                description: "Climbin' those walls"
        )

        assert ninja.weapons.size() == 1
        assert ninja.can(SwordFight)
    }

    @Test
    public void shouldNeedOnlyOneTypeOfSwordToSwordFight() {
        ninja = new Ninja3(skills: [SwordFight])
        assert !ninja.can(SwordFight)

        ninja.utilities << new Weapon(type: Katana)
        assert ninja.can(SwordFight)
    }


}
