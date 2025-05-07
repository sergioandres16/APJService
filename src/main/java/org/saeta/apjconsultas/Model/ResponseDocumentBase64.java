package org.saeta.apjconsultas.Model;

import java.util.ArrayList;

public class ResponseDocumentBase64 {
    private String mensaje;
    private ArrayList<DocumentBase64> listaDocumentos;

    public ResponseDocumentBase64(String mensaje, ArrayList<DocumentBase64> listaDocumentos) {
        this.mensaje = mensaje;
        this.listaDocumentos = listaDocumentos;
    }

    public ResponseDocumentBase64() {}

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ArrayList<DocumentBase64> getListaDocumentos() {
        return listaDocumentos;
    }

    public void setListaDocumentos(ArrayList<DocumentBase64> listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }
}