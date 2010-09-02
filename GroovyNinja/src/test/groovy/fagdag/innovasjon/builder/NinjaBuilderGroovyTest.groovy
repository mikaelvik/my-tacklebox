package fagdag.innovasjon.builder

import org.junit.Test
import fagdag.innovasjon.domain.Ninja

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

}
