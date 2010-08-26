package fagdag.innovasjon.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
public enum Skill {
    Sneak,
    ClimbWall(Tool.Rope, Tool.GrapplingHook),
    SetArson(Tool.Gasolin, Tool.Matches),
    Stab(Weapon.Knife);

    private Set<Utility> necessaryUtilities;

    Skill(Utility... ass) {
        necessaryUtilities = new HashSet<Utility>(Arrays.asList(ass));
    }
}