public class RenderizadorOpenGL extends RenderizadorBase {

    public RenderizadorOpenGL() {
        super("OpenGL");
    }

    @Override
    protected String detalleInicializacion() {
        return "máquina de estados global, contexto creado en la ventana";
    }

    @Override
    protected void ejecutarDibujo(String nombreMalla) {
        System.out.println("[OpenGL] glBindVertexArray + glDrawElements -> " + nombreMalla);
    }
}