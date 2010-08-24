package no.bekk.fagdag.innovasjon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static no.bekk.fagdag.innovasjon.Tool.*;
import static no.bekk.fagdag.innovasjon.Weapon.Knife;

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
public enum Skill {
    Sneak,
    ClimbWall(Rope, GrapplingHook),
    SetArson(Gasolin, Matches),
    Stab(Knife);

    private Set<Utility> necessaryUtilities;

    Skill(Utility... ass) {
        necessaryUtilities = new HashSet<Utility>(Arrays.asList(ass));
    }
}