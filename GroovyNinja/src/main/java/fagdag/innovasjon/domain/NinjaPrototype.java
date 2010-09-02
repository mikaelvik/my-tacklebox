package fagdag.innovasjon.domain;

import java.util.List;
import java.util.Set;

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
public interface NinjaPrototype {

    boolean isSensei();

    boolean can(Skill skill);

    void addSkill(Skill skill);

    void addTool(Tool tool);

    void addWeapon(Weapon weapon);

    Set<Utility> getUtilities();

    Set<Weapon> getWeapons();
    
}
