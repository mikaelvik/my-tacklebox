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
//        println "create"
        SetupBuilder.create()
    }

    def NinjaBuilder ninja() {
//        println "ninja"
        doApply()
        new NinjaBuilder(holder: holder).create()
    }


    def WeaponBuilder weapon() {
//        println "weapon"
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
//            println "applying"
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
