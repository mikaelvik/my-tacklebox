package fagdag.innovasjon.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
public abstract class Utility {

    protected Type type;

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        Tanto,
        Katana,
        Sword,
        Shuriken,
        Knife,
        Explosive,
        Poison,
        GrapplingHook,
        Chisel,
        Rope,
        Gasolin,
        Matches
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }

}