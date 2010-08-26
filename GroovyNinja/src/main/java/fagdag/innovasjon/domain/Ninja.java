package fagdag.innovasjon.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
public class Ninja {

    private String name;
    private Set<Skill> skills;
    private Set<Utility> utilities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Utility> getUtilities() {
        if (utilities == null) {
            utilities = new HashSet<Utility>();
        }
        return utilities;
    }

    public void addWeapon(Weapon weapon) {
        getUtilities().add(weapon);
    }
    
    public Set<Skill> getSkills() {
        if (skills == null) {
            skills = new HashSet<Skill>();
        }
        return skills;
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

    public List<Weapon> getWeapons() {
        List<Weapon> weapons = new ArrayList<Weapon>();
        for (Utility utility : utilities) {
            if (utility instanceof Weapon) {
                weapons.add((Weapon) utility);
            }
        }
        return weapons;
    }
}