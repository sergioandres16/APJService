package org.saeta.apjconsultas.Model;

public class DocumentBase64 {
    private String id;
    private String nombreArchivo;
    private String estado;
    private byte[] archivo;

    public DocumentBase64(String id, String nombreArchivo, String estado, byte[] archivo) {
        this.id = id;
        this.nombreArchivo = nombreArchivo;
        this.estado = estado;
        this.archivo = archivo;
    }

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

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }
}