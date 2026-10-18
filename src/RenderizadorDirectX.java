public class RenderizadorDirectX extends RenderizadorBase {

    public RenderizadorDirectX() {
        super("DirectX");
    }

    @Override
    protected String detalleInicializacion() {
        return "dispositivo D3D y cadena de intercambio (swap chain) creados";
    }

    @Override
    protected void ejecutarDibujo(String nombreMalla) {
        System.out.println("[DirectX] DrawIndexed sobre el command list -> " + nombreMalla);
    }
}