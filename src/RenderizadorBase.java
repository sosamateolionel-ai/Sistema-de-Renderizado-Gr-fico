public abstract class RenderizadorBase implements MotorGrafico {

    protected String api;
    protected boolean contextoInicializado;
    protected int mallasDibujadas;

    public RenderizadorBase(String api) {
        this.api = api;
        this.contextoInicializado = false;
        this.mallasDibujadas = 0;
    }

    @Override
    public boolean inicializarContexto() {

        if (contextoInicializado) {
            System.out.println("[" + api + "] El contexto ya estaba inicializado.");
            return false;
        }

        contextoInicializado = true;
        System.out.println("[" + api + "] Contexto inicializado: " + detalleInicializacion() + ".");
        return true;
    }

    @Override
    public boolean dibujarMalla(String nombreMalla) {

        if (!contextoInicializado) {
            System.out.println("[" + api + "] Error: contexto no inicializado, no se puede dibujar \""
                    + nombreMalla + "\".");
            return false;
        }

        if (nombreMalla == null || nombreMalla.trim().isEmpty()) {
            System.out.println("[" + api + "] Error: nombre de malla vacío.");
            return false;
        }

        ejecutarDibujo(nombreMalla);
        mallasDibujadas++;
        return true;
    }

    @Override
    public void liberarRecursos() {

        if (!contextoInicializado) {
            System.out.println("[" + api + "] No hay recursos que liberar.");
            return;
        }

        contextoInicializado = false;
        System.out.println("[" + api + "] Recursos liberados (" + mallasDibujadas + " mallas dibujadas en la sesión).");
        mallasDibujadas = 0;
    }

    // Cada API gráfica define lo suyo
    protected abstract String detalleInicializacion();

    protected abstract void ejecutarDibujo(String nombreMalla);
}