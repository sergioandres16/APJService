package org.saeta.apjconsultas.Model;

import java.util.ArrayList;

public class ResponseDocumentURL {
    private String mensaje;
    private ArrayList<DocumentURL> listaDocumentos;

    public ResponseDocumentURL(String mensaje, ArrayList<DocumentURL> listaDocumentos) {
        this.mensaje = mensaje;
        this.listaDocumentos = listaDocumentos;
    }

    public ResponseDocumentURL() {}

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ArrayList<DocumentURL> getListaDocumentos() {
        return listaDocumentos;
    }

    public void setListaDocumentos(ArrayList<DocumentURL> listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }
}