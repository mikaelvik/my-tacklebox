package fagdag.innovasjon.builder

import fagdag.innovasjon.domain.Weapon

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
class WeaponBuilder extends BaseBuilder {

    def Weapon weapon

    def WeaponBuilder create() {
        weapon = Weapon.Katana
        this
    }

    def WeaponBuilder type(Weapon newWeapon) {
        weapon = newWeapon
        this
    }

    def WeaponBuilder strength() {
        this
    }

    protected void apply() {
        holder.current = weapon
        holder.ninja.addWeapon(weapon)
    }
    
}
