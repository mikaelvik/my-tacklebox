package fagdag.innovasjon.builder

import static fagdag.innovasjon.domain.Skill.*
import static fagdag.innovasjon.domain.Utility.Type.*

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
class SetupBuilder extends BaseBuilder {

    private SetupBuilder() {
    }

    def static SetupBuilder create() {
        def builder = new SetupBuilder()
        builder.holder = new ObjectHolder()
        builder
    }

    def ToolBuilder wallClimbingNinja() {
        ninja().skill(ClimbWall).tool(GrapplingHook).tool(Rope)
    }

    def WeaponBuilder stabbingNinja() {
        ninja().skill(Stab).weapon(Knife)
    }

    def WeaponBuilder swordFightingNinja() {
        ninja().skill(SwordFight).weapon(Katana)
    }

    protected void apply() { }

}
