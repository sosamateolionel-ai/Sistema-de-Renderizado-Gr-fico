public class RenderizadorVulkan extends RenderizadorBase {

    public RenderizadorVulkan() {
        super("Vulkan");
    }

    @Override
    protected String detalleInicializacion() {
        return "instancia, dispositivo lógico y colas de comandos configurados explícitamente";
    }

    @Override
    protected void ejecutarDibujo(String nombreMalla) {
        System.out.println("[Vulkan] vkCmdDrawIndexed grabado en el command buffer -> " + nombreMalla);
    }
}