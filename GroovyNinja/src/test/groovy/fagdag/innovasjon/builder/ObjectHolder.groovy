package fagdag.innovasjon.builder

import fagdag.innovasjon.domain.Ninja

/**
 * Holds references to the domain object.
 * - current object being built
 * - the ninja
 *
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
class ObjectHolder {
    def current
    Ninja ninja
}
