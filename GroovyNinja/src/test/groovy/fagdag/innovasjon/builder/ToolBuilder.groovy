package fagdag.innovasjon.builder

import fagdag.innovasjon.domain.Tool
import fagdag.innovasjon.domain.Utility
import static fagdag.innovasjon.domain.Utility.Type.GrapplingHook

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
class ToolBuilder extends BaseBuilder {

    Tool tool

    def ToolBuilder create(Utility.Type type) {
        tool = new Tool(
                type: type ? type : GrapplingHook,
                price: 0,
                description: "Got nothin to say"
        )
        this
    }

    protected void apply() {
        holder.current = tool
        holder.ninja.addTool(tool)
    }
}
