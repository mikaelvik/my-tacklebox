package fagdag.innovasjon.builder

import fagdag.innovasjon.domain.Skill

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
class SkillBuilder extends BaseBuilder {

    def Skill skill

    def SkillBuilder create(Skill newSkill) {
        skill = newSkill
        this
    }

    def void apply() {
        holder.current = skill
        holder.ninja.addSkill(skill)
    }
}
