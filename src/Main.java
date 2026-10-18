static void cicloGrafico(MotorGrafico motor, String[] mallas) {

    motor.inicializarContexto();

    for (String malla : mallas) {
        motor.dibujarMalla(malla);
    }

    motor.liberarRecursos();
}
void main() {

    String[] escena = {"Personaje", "Arbol", "Terreno"};

    MotorGrafico motor; // variable del tipo de la interfaz

    System.out.println("===== Ciclo con OpenGL =====");
    motor = new RenderizadorOpenGL();
    cicloGrafico(motor, escena);

    System.out.println("\n===== Cambio a DirectX =====");
    motor = new RenderizadorDirectX();
    cicloGrafico(motor, escena);

    System.out.println("\n===== Cambio a Vulkan =====");
    motor = new RenderizadorVulkan();
    cicloGrafico(motor, escena);

    System.out.println("\n===== Validaciones de estado (Vulkan) =====");
    motor.dibujarMalla("Enemigo");    // contexto liberado
    motor.liberarRecursos();          // nada que liberar
    motor.inicializarContexto();
    motor.inicializarContexto();      // ya inicializado
    motor.dibujarMalla("");           // nombre vacío
    motor.liberarRecursos();

}
