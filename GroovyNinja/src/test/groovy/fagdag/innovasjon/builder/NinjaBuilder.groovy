package fagdag.innovasjon.builder

import fagdag.innovasjon.domain.Ninja
import fagdag.innovasjon.domain.Skill

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
class NinjaBuilder extends BaseBuilder {

    def Ninja ninja

    NinjaBuilder create() {
        ninja = new Ninja(
                name: "Hattori Hanzo",
                skills: [Skill.SetArson, Skill.Stab]
        )
        this
    }

    public NinjaBuilder restore() {
        ninja = holder.ninja
        holder.current = ninja
        this
    }

    public NinjaBuilder name(String name) {
        ninja.name = name
        this
    }

    protected void apply() {
        holder.current = ninja
        holder.ninja = ninja
    }

}
