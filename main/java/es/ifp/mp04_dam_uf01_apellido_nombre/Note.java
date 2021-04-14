package es.ifp.mp04_dam_uf01_apellido_nombre;

public class Note {

    protected int id;
    protected String titulo;
    protected String telefono;
    protected String lugar;
    protected String cliente;
    protected String URL;

    public Note(int id, String titulo, String telefono, String lugar, String cliente, String URL) {

        this.id = id;
        this.titulo = titulo;
        this.telefono = telefono;
        this.lugar = lugar;
        this.cliente = cliente;
        this.URL = URL;

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLugar() {
        return this.lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getCliente() {
        return this.cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getURL() {
        return this.URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
