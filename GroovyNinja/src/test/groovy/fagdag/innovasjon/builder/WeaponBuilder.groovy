package fagdag.innovasjon.builder

import fagdag.innovasjon.domain.Utility
import fagdag.innovasjon.domain.Weapon
import org.joda.time.DateTime
import static fagdag.innovasjon.domain.Utility.Type.*

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
class WeaponBuilder extends BaseBuilder {

    def Weapon weapon

    def WeaponBuilder create(Utility.Type type) {
        weapon = new Weapon(
                type: type ? type : Katana,
                mojo: 10
        )
        this
    }

    def WeaponBuilder type(Utility.Type type) {
        weapon.type = type
        this
    }

    def WeaponBuilder mojo(Integer mojo) {
        weapon.mojo = mojo
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
