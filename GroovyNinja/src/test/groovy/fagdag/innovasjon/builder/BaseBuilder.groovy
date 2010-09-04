package fagdag.innovasjon.builder

import fagdag.innovasjon.domain.Ninja
import fagdag.innovasjon.domain.Utility

/**
 * Super class for all the builders. Make sure that doApply is run
 * when transitioning over to a new builder.
 *
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
abstract class BaseBuilder {

    ObjectHolder holder
    Boolean applied = false

    def static SetupBuilder start() {
        SetupBuilder.create()
    }

    /**
     * Create a ninja builder, passing on the object holder.
     *
     * @return a new NinjaBuilder
     */
    def NinjaBuilder ninja() {
        doApply()
        new NinjaBuilder(holder: holder).create()
    }

    /**
     * Give access to editing the ninja, passing on the object holder.
     * 
     * @return a builder for the ninja
     */
    def NinjaBuilder editNinja() {
        doApply()
        new NinjaBuilder(holder: holder).restore()
    }

    /**
     * Create a weapon builder, passing on the object holder.
     *
     * @param type the utility type of the weapon
     * @return a new WeaponBuilder
     */
    def WeaponBuilder weapon(Utility.Type type) {
        doApply()
        new WeaponBuilder(holder: holder).create(type)
    }

    def WeaponBuilder editWeapon() {
        doApply()
        new WeaponBuilder(holder: holder).restore()
    }

    /**
     * Create a new tool builder, passing on the object holder.
     *
     * @param type the utility type of the tool
     * @return
     */
    def ToolBuilder tool(Utility.Type type) {
        doApply()
        new ToolBuilder(holder: holder).create(type)
    }

    /**
     * Implement this method to add the object being built by your builder
     * to your ninja. Waiting till the object is finished|complete makes sure
     * that the object is added to a set or list with the correct hashcode...  
     */
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
