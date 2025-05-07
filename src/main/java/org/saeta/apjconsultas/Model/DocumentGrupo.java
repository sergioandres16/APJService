package org.saeta.apjconsultas.Model;

public class DocumentGrupo {
    private String id;
    private String nombre;

    public DocumentGrupo(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public DocumentGrupo() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}