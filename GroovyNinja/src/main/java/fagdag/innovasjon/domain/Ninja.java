package fagdag.innovasjon.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
@SuppressWarnings({"UnusedDeclaration"})
public class Ninja {

    private String name;
    private String dojo;
    private Integer kills;
    private Set<Skill> skills = new HashSet<Skill>();
    private Set<Utility> utilities = new HashSet<Utility>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDojo() {
        return dojo;
    }

    public void setDojo(String dojo) {
        this.dojo = dojo;
    }

    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Set<Utility> getUtilities() {
        return utilities;
    }

    public void setUtilities(Set<Utility> utilities) {
        this.utilities = utilities;
    }

    private void addUtility(Utility utility) {
        utilities.add(utility);
    }

    public void addWeapon(Weapon weapon) {
        addUtility(weapon);
    }

    public void addTool(Tool tool) {
        addUtility(tool);
    }

    public void addSkill(Skill skill) {
        getSkills().add(skill);
    }

    public void removeSkill(Skill skill) {
        getSkills().remove(skill);
    }

    public boolean isSensei() {
        for (Skill skill : Skill.values()) {
            if (!getSkills().contains(skill)) {
                return false;
            }
        }
        return true;
    }

    public boolean can(Skill skill) {
        Set<Utility.Type> types = new HashSet<Utility.Type>();
        for (Utility utility : getUtilities()) {
            types.add(utility.getType());
        }
        return skill.hasNecessaryUtilities(types);
    }

    public List<Weapon> getWeapons() {
        List<Weapon> weapons = new ArrayList<Weapon>();
        for (Utility utility : utilities) {
            if (utility instanceof Weapon) {
                weapons.add((Weapon) utility);
            }
        }
        return weapons;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}