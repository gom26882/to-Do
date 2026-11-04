import java.util.List;
import java.util.Scanner;

public class VistaTerminal {
    private Scanner scanner;
    private TareaController controlador;
    
    public VistaTerminal() {
        this.scanner = new Scanner(System.in);
        AlmacenarTareas almacenamiento = new AlmacenamientoMemoria();
        this.controlador = new TareaController(almacenamiento);
    }

    public void mostrarMenu() {

        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- todolist Nuestra---");
            System.out.println( "1. Agregar tarea");
            System.out.println("2. Completar tarea");
            System.out.println("3. Eliminar tarea");
            System.out.println("4. Listar tareas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            String opcion = scanner.nextLine();
            
            switch (opcion) {
                case "1":
                    System.out.print("Descripción de la tarea: ");
                    String desc = scanner.nextLine();
                    System.out.print("Titulo de la tarea: ");
                    String titulo = scanner.nextLine();
                    controlador.agregarTarea(titulo, desc);
                    System.out.println("Tarea agregada.");
                    
                break;

                case "2":

                try {
                    System.out.println("ID de la tarea a completar: ");
                    int idACompletar = Integer.parseInt(scanner.nextLine());
                    controlador.completarTarea(idACompletar);
                }
                catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }

                break;
                
                case "3":
                    try {
                    System.out.print("ID de la tarea a eliminar: ");
                    int idAEliminar = Integer.parseInt(scanner.nextLine());

                    controlador.eliminarTarea(idAEliminar);
                    System.out.println("Tarea eliminada");

                } catch (NumberFormatException e) {
                    System.out.println("Ingresew un número válido");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "4":
                    List<Tarea> tareas = controlador.listarTareas();
                    if (tareas.isEmpty()) {
                        System.out.println("No hay tareas");
                    } else {
                        System.out.println("\n--- Tareas  ---");

                        for (Tarea tarea : tareas) {
                            String estado = "Pendiente";

                            if (tarea.getCompletada()) {
                                estado = "Completada";
                            }

                            System.out.println("ID: " + tarea.getId());
                            System.out.println("Título: " + tarea.getTitulo());
                            System.out.println("Descripción: " + tarea.getDescripcion());
                            System.out.println("Estado: " + estado);
                            System.out.println("-------------------------");
                        }
                    }

                break;

                case "5":
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}


