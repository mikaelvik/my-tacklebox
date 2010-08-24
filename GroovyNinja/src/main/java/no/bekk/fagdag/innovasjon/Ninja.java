package no.bekk.fagdag.innovasjon;

import java.util.HashSet;
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

}