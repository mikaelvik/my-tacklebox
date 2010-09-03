package fagdag.innovasjon.domain;


import org.apache.commons.lang.builder.ToStringBuilder

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
@SuppressWarnings("GroovyAssignabilityCheck")
class Ninja3 implements NinjaPrototype {

    private String name
    private String dojo
    private Integer kills
    private Set<Skill> skills = []
    private Set<Utility> utilities = []

    def addUtility(utility) {
        utilities << utility
    }

    def void addWeapon(Weapon weapon) {
        addUtility weapon
    }

    def void addTool(Tool tool) {
        addUtility tool
    }

    def void addSkill(Skill skill) {
        skills << skill
    }

    def removeSkill(skill) {
        skills.remove skill
    }

    def boolean isSensei() {
        (Skill.values() - skills).size() == 0
    }

    Ninja methodMissing(String methodName, args) {
        this."${methodName}" = args[0]
        this
    }

    def boolean can(Skill skill) {
        Set available = utilities.collect {
            it.type
        }
        skill in skills && skill.hasNecessaryUtilities(available)
    }

    def Set<Utility> getUtilities() {
        utilities
    }

    def Set<Weapon> getWeapons() {
        utilities.findAll {
            it.class == Weapon
        }

    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this)
    }
}