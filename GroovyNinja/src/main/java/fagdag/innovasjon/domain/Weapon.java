package fagdag.innovasjon.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.joda.time.DateTime;

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
public class Weapon extends Utility {

    private Integer mojoStrength;
    private DateTime acquired;

    public void setMojoStrength(Integer mojoStrength) {
        this.mojoStrength = mojoStrength;
    }

    public void setAcquired(DateTime acquired) {
        this.acquired = acquired;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("type", type)
                .append("mojoStrength", mojoStrength)
                .append("acquired", acquired)
                .toString();
    }
}
