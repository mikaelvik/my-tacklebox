package fagdag.innovasjon.builder

import fagdag.innovasjon.domain.Ninja
import org.joda.time.DateTime
import org.junit.Test
import static fagdag.innovasjon.domain.Skill.ClimbWall
import static fagdag.innovasjon.domain.Skill.SwordFight
import static fagdag.innovasjon.domain.Utility.Type.*
import fagdag.innovasjon.domain.Weapon

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
class NinjaBuilderGroovyTest {

    Ninja ninja

    @Test
    public void shouldAddMethodsDynamically() {
        ninja = BaseBuilder.start().ninja().kills(9).dojo("Bekkarado").get()
        println ninja

        println ninja?.name?.trim()?.concat(" is deadly")


        if (ninja?.name?.length() > 10) {


            println ninja
        }
    }

    @Test
    public void shouldDemonstrateClosures() {
        println ""

        ninja = BaseBuilder.start()
                .ninja().name("Hattori Hanzô")
                .skill(ClimbWall)
                .skill(SwordFight)
                .weapon(Knife).mojo(10)
                .weapon(Shuriken).acquired(new DateTime().minusDays(10))
                .tool(Rope).get()

        def myClosure = { utility ->
            utility.type
        }

        // brukast som en anonym funksjon
        println myClosure(ninja.weapons.asList().get(0))
        // finn typen for alle utilities
        println ninja.utilities.collect (myClosure)
        // finn type for alle weapons
        println ninja.utilities.findAll {
            it instanceof Weapon
        }.type

    }


}
