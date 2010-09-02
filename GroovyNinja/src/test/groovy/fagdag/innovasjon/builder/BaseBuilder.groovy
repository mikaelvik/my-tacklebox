package fagdag.innovasjon.builder

import fagdag.innovasjon.domain.Ninja
import fagdag.innovasjon.domain.Utility
import fagdag.innovasjon.domain.Skill

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

    def NinjaBuilder editNinja() {
        doApply()
        new NinjaBuilder(holder: holder).restore()
    }

    def WeaponBuilder weapon(Utility.Type type) {
        doApply()
        new WeaponBuilder(holder: holder).create(type)
    }

    def ToolBuilder tool(Utility.Type type) {
        doApply()
        new ToolBuilder(holder: holder).create(type)
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
