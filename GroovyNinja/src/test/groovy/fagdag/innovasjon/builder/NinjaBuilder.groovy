package fagdag.innovasjon.builder

import fagdag.innovasjon.domain.Ninja
import fagdag.innovasjon.domain.Skill
import static fagdag.innovasjon.domain.Skill.SetArson
import static fagdag.innovasjon.domain.Skill.Stab

/**
 * Builder for ninjas. Add methods for all the fields you want
 * to be able to set explicitly (from java). If you write your tests in
 * Groovy methodMissing will handle anything you'd like to set.  
 *
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
class NinjaBuilder extends BaseBuilder {


    def Ninja ninja



    NinjaBuilder create() {

        ninja = new Ninja(
                name: "Hattori Hanzo",
                kills: 667,
                skills: [SetArson, Stab]
        )

        this
    }

    public NinjaBuilder restore() {
        ninja = holder.ninja
        holder.current = ninja
        this
    }

    NinjaBuilder methodMissing(String methodName, args) {
        ninja."${methodName}" = args[0]
        this
    }

    public NinjaBuilder name(String name) {
        ninja.name = name
        this
    }

    public NinjaBuilder skill(Skill skill) {
        ninja.skills << skill
        this
    }

    protected void apply() {
        holder.current = ninja
        holder.ninja = ninja
    }

}

