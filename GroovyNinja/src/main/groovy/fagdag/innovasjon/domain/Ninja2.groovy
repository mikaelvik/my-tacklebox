package fagdag.innovasjon.domain;


import org.apache.commons.lang.builder.ToStringBuilder

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
class Ninja2 {

    private String name
    private String dojo
    private Integer kills
    private Set<Skill> skills = new HashSet<Skill>()
    private Set<Utility> utilities = new HashSet<Utility>()

    private void addUtility(Utility utility) {
        utilities.add(utility)
    }

    public void addWeapon(Weapon weapon) {
        addUtility(weapon)
    }

    public void addTool(Tool tool) {
        addUtility(tool)
    }

    public void addSkill(Skill skill) {
        skills.add(skill)
    }

    public void removeSkill(Skill skill) {
        skills.remove(skill)
    }

    public boolean isSensei() {
        for (Skill skill: Skill.values()) {
            if (!skills.contains(skill)) {
                return false
            }
        }
        return true
    }

    public boolean can(Skill skill) {
        Set<Utility.Type> types = new HashSet<Utility.Type>()
        for (Utility utility: utilities) {
            types.add(utility.getType())
        }
        return skill.hasNecessaryUtilities(types)
    }

    public List<Weapon> getWeapons() {
        List<Weapon> weapons = new ArrayList<Weapon>()
        for (Utility utility: utilities) {
            if (utility instanceof Weapon) {
                weapons.add((Weapon) utility)
            }
        }
        return weapons
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this)
    }
}