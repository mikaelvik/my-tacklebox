package fagdag.innovasjon.builder

import fagdag.innovasjon.domain.Ninja

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
class NinjaBuilder extends BaseBuilder {

    def Ninja ninja

    NinjaBuilder create() {
        ninja = new Ninja()
        this
    }

    public NinjaBuilder name(String name) {
        ninja.name = name
        this
    }

    protected void apply() {
//        println "ninja.holder ${holder}"
        holder.current = ninja
        holder.ninja = ninja
    }
    
}
