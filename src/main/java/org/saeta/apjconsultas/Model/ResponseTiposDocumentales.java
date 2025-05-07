package org.saeta.apjconsultas.Model;

import java.util.ArrayList;

public class ResponseTiposDocumentales {
    private String mensaje;
    private ArrayList<DocumentGrupo> listaDocumentos;

    public ResponseTiposDocumentales(String mensaje, ArrayList<DocumentGrupo> listaDocumentos) {
        this.mensaje = mensaje;
        this.listaDocumentos = listaDocumentos;
    }

    public ResponseTiposDocumentales() {}

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ArrayList<DocumentGrupo> getListaDocumentos() {
        return listaDocumentos;
    }

    public void setListaDocumentos(ArrayList<DocumentGrupo> listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }
}