package fagdag.innovasjon.builder;

import fagdag.innovasjon.domain.Ninja;
import fagdag.innovasjon.domain.Skill;
import fagdag.innovasjon.domain.Weapon;
import org.junit.Before;
import org.junit.Test;

import static fagdag.innovasjon.domain.Skill.ClimbWall;
import static fagdag.innovasjon.domain.Weapon.*;

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
                .skill().type(ClimbWall)
                .weapon().type(Katana)
                .weapon().type(Knife)
                .weapon().type(Shuriken);
    }

    @Test
    public void should() {
        Ninja ninja = builder.get();

        
        for (Weapon weapon : ninja.getWeapons()) {
            System.out.println("w: " + weapon);
        }

        for (Skill skill : ninja.getSkills()) {
            System.out.println("s: " + skill);
        }
    }


}