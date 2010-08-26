package fagdag.innovasjon.builder

import fagdag.innovasjon.domain.Utility
import fagdag.innovasjon.domain.Weapon
import org.joda.time.DateTime

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
class WeaponBuilder extends BaseBuilder {

    def Weapon weapon

    def WeaponBuilder create(Utility.Type type) {
        weapon = new Weapon(
                type: type ? type : Utility.Type.Katana,
                mojoStrength: 10
        )
        this
    }

    def WeaponBuilder type(Utility.Type type) {
        weapon.type = type
        this
    }

    def WeaponBuilder mojoStrength(Integer mojoStrength) {
        weapon.mojoStrength = mojoStrength
        this
    }

    def WeaponBuilder acquired(DateTime date) {
        weapon.acquired = date
        this
    }

    protected void apply() {
        holder.current = weapon
        holder.ninja.addWeapon(weapon)
    }

}
