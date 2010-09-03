package fagdag.innovasjon.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static fagdag.innovasjon.domain.Utility.Type.*;

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
@SuppressWarnings({"UnusedDeclaration"})
public enum Skill {
    SneakAttack(true),

    ClimbWall(true, Rope, GrapplingHook),

    
    SetArson(true, Gasolin, Matches),
    Stab(false, Knife, Katana),
    SwordFight(false, Katana, Sword);

    private Boolean needsAll;
    private Set<Utility.Type> necessaryUtilities;

    Skill(boolean needsAll, Utility.Type... ass) {
        this.needsAll = needsAll;
        necessaryUtilities = new HashSet<Utility.Type>(Arrays.asList(ass));
    }

    boolean hasNecessaryUtilities(Set<Utility.Type> available) {
        if (needsAll) {
            return available.containsAll(necessaryUtilities);
        } else {
            for (Utility.Type utility : necessaryUtilities) {
                if (available.contains(utility)) {
                    return true;
                }
            }
            return false;
        }
    }
}