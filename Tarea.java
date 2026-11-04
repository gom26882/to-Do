public class Tarea {

    //ATRIBUTOS
    private int id;
    private String titulo;
    private String descripcion;
    private boolean completada;
    
    //Constructor
    public Tarea(int id, String t, String c) {
        this.id = id;
        titulo = t;
        descripcion = c;
        completada = false;
    }
    //METODOS

    void setCompletada(boolean estadoNuevo){
        completada = estadoNuevo;
    }

    boolean getCompletada(){
        return completada;
    }

    int getId(){
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

}