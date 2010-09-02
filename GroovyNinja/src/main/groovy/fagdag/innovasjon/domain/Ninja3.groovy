package fagdag.innovasjon.domain;


import org.apache.commons.lang.builder.ToStringBuilder

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
class Ninja3 {

    private String name
    private String dojo
    private Integer kills
    private Set<Skill> skills = []
    private Set<Utility> utilities = []

    def addUtility(utility) {
        utilities << utility
    }

    def addWeapon(weapon) {
        addUtility weapon
    }

    def addTool(tool) {
        addUtility tool
    }

    def addSkill(skill) {
        skills << skill
    }

    def removeSkill(skill) {
        skills.remove skill
    }

    def boolean isSensei() {
        (Skill.values() - skills).size() == 0
    }

    def boolean can(Skill skill) {
        skill.hasNecessaryUtilities(utilities.collect { it.type }.asType(Set))
    }

    def Set<Weapon> getWeapons() {
        (Set) utilities.findAll {
            it instanceof Weapon
        }
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this)
    }
}