package fagdag.innovasjon.builder

import fagdag.innovasjon.domain.Ninja
import fagdag.innovasjon.domain.Weapon

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
abstract class BaseBuilder {

    ObjectHolder holder
    Boolean applied = false

    def static SetupBuilder start() {
        SetupBuilder.create()
    }

    def NinjaBuilder ninja() {
        doApply()
        new NinjaBuilder(holder: holder).create()
    }


    def WeaponBuilder weapon() {
        doApply()
        new WeaponBuilder(holder: holder).create()
    }

    def SkillBuilder skill() {
        doApply()
        new SkillBuilder(holder: holder).create()
    }

    protected abstract void apply()

    public def doApply() {
        if (!applied) {
            apply()
            applied = true
        }
        applied
    }

    public Ninja get() {
        doApply()
        holder.ninja
    }
    
}
