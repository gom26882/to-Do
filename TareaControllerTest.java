import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TareaControllerTest {
    private TareaController controlador;
    private AlmacenarTareas almacenamiento;

    @BeforeEach
    void setUp() {
        almacenamiento = new AlmacenamientoMemoria();
        controlador = new TareaController(almacenamiento);
    }



    @Test
    void testAgregarVariosElementosYRevisarIds() {
        Tarea t = controlador.agregarTarea("atender estudiantes","Ximena");
        Tarea t2 = controlador.agregarTarea("atender estudiantes","Luis Diego");
        Tarea t3 = controlador.agregarTarea("atender estudiantes","william");
        assertEquals(0, t.getId());
        assertEquals(1, t2.getId());
        assertEquals(2, t3.getId());
    }

    @Test
    void validarCambioDeEstado() {
        Tarea t3 = controlador.agregarTarea("atender estudiantes","william");
        controlador.completarTarea(t3.getId());
        assertTrue(t3.getCompletada());
    }

    @Test 
    void estCompletarTareaInexistenteLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            controlador.completarTarea(99);
        });
    }

    @Test 
    void  testCompletarTareaYaCompletadaLanzaExcepcion() {
        Tarea t4 = controlador.agregarTarea("Calculo","terminar tarea 7 de calculo");
        controlador.completarTarea(t4.getId());

        assertThrows(IllegalStateException.class, () -> {
            controlador.completarTarea(t4.getId());
        });
    }

    @Test
    void testEliminarTareaExistente(){
        Tarea tarea = controlador.agregarTarea("Estudiar", "Repasar calculo");
        assertNotNull(almacenamiento.buscarPorId(tarea.getId()));
        controlador.eliminarTarea(tarea.getId());
        assertNull(almacenamiento.buscarPorId(tarea.getId()));
    }

    @Test 
    void testEliminarTareaInexistenteLanzaExcepcion(){
        assertThrows(IllegalArgumentException.class, () -> {
        controlador.eliminarTarea(99);
        });
    }




}
