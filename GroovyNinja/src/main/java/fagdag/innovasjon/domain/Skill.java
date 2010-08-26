package fagdag.innovasjon.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static fagdag.innovasjon.domain.Utility.Type.*;

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
public enum Skill {
    SneakAttack,
    ClimbWall(Rope, GrapplingHook),
    SetArson(Gasolin, Matches),
    Stab(Knife);

    private Set<Utility.Type> necessaryUtilities;

    Skill(Utility.Type... ass) {
        necessaryUtilities = new HashSet<Utility.Type>(Arrays.asList(ass));
    }

    boolean hasNecessaryUtilities(Set<Utility> available) {
        Set<Utility.Type> availableTypes = new HashSet<Utility.Type>();
        for (Utility availableUtility : available) {
            availableTypes.add(availableUtility.getType());
        }
        return availableTypes.containsAll(necessaryUtilities);
    }
}