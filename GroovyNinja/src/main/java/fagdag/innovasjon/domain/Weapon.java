package fagdag.innovasjon.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.joda.time.DateTime;

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
public class Weapon extends Utility {

    private Integer mojo;
    private DateTime acquired;
    private String nickname;

    public void setMojo(Integer mojoStrength) {
        this.mojo = mojoStrength;
    }

    public void setAcquired(DateTime acquired) {
        this.acquired = acquired;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Weapon)) {
            return false;
        } else if (this == o) {
            return true;
        }
        Weapon other = (Weapon) o;
        return new EqualsBuilder()
                .append(type, other.type)
                .append(mojo, other.mojo)
                .append(acquired, other.acquired)
                .append(nickname, other.nickname)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(31, 67)
                .append(type)
                .append(mojo)
                .append(acquired)
                .append(nickname)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("type", type)
                .append("mojo", mojo)
                .append("acquired", acquired)
                .append("nickname", nickname)
                .toString();
    }

}
