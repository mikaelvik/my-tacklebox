package fagdag.innovasjon.domain

import org.joda.time.DateTime
import org.junit.Before
import org.junit.Test
import static fagdag.innovasjon.domain.Skill.*
import static fagdag.innovasjon.domain.Utility.Type.*
import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertTrue

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
class NinjaTest {

    NinjaPrototype ninja

    // change implementation...
    Class ninjaClass = Ninja.class // Ninja2.class eller Ninja3.class

    @Before
    def void setup() {
        ninja = ninjaClass.newInstance(name: "Erik")
        Skill.values().each { skill ->
            ninja.addSkill skill
        }
    }

    @Test
    def void shouldPrintNinjaFromConstructorWithProperties() {
        println createNinja()
    }

    def Ninja createNinja() {
        new Ninja(name: "Hattori Hanzö",
                dojo: "Bekkarado",
                kills: 130,
                skills: [SneakAttack, SetArson, SwordFight],
                utilities: [new Weapon(
                        type: Katana,
                        mojo: 33,
                        acquired: new DateTime().minusDays(1),
                        nickname: "SlayerBoy")
                ])
    }

    @Test
    def void shouldShowAccessByPropertiesInsteadOfUglyReflection() {
        ninja = createNinja()

        assert ninja['dojo'] == "Bekkarado"
        assert ninja.'kills' == 130
        assert ninja.'getSkills'().contains(SneakAttack)
        def field = "nickname"
        assert ninja['weapons']?.find { it."$field" == "SlayerBoy"}
    }

    @Test
    def void ignoreAccessorMethods() {
        ninja.name = "Hachisuka Tenzo"
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

        ninja = ninjaClass.newInstance(
                skills: [Skill.ClimbWall],
                kills: 10
        )

        println ninja

        ninja.utilities << new Tool(type: GrapplingHook) << new Tool(type: Rope)

        def s = "Erik"
        def c = {
            println "$s u: ${it.type}"
        }

        ninja.utilities.each { utility ->
            println utility
        }

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
        ninja = ninjaClass.newInstance()
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

    @Test
    public void should() {
        Ninja3 ninja = new Ninja3(
                utilities: [
                        new Tool(type: GrapplingHook),
                        new Weapon(type: Sword),
                        new Weapon(type: Katana),
                        new Tool(type: Rope),
                        new Weapon(type: Shuriken)
                ]
        )

        ninja.weapons.each {
            println it.type
        }
    }


}
