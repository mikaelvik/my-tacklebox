package fagdag.innovasjon.builder

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 * @since 1.0
 */
class SetupBuilder extends BaseBuilder {

    private SetupBuilder() {
    }

    def static SetupBuilder create() {
//        println "creating"
        def builder = new SetupBuilder()
//        println "set holder"
        builder.holder = new ObjectHolder()
//        println "setup.holder ${builder.holder}"
        builder
    }

    protected void apply() { }

}
