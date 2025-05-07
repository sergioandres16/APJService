package org.saeta.apjconsultas.Model;

public class DocumentURL {
    private String id;
    private String nombreArchivo;
    private String estado;
    private String enlace;

    public DocumentURL(String id, String nombreArchivo, String estado, String enlace) {
        this.id = id;
        this.nombreArchivo = nombreArchivo;
        this.estado = estado;
        this.enlace = enlace;
    }

    public DocumentURL() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
}