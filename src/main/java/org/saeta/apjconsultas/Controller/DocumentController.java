package org.saeta.apjconsultas.Controller;

import org.saeta.apjconsultas.Model.DocumentBase64;
import org.saeta.apjconsultas.Model.DocumentGrupo;
import org.saeta.apjconsultas.Model.DocumentURL;
import org.saeta.apjconsultas.Model.ResponseDocumentBase64;
import org.saeta.apjconsultas.Model.ResponseDocumentURL;
import org.saeta.apjconsultas.Model.ResponseTiposDocumentales;
import org.saeta.apjconsultas.Service.DocumentService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin
@RequestMapping({"/documentos"})
public class DocumentController {
    private final String authorizationToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkFEU0FDQXNERkFTREpEU0ExMjQyMzE0ZGFzZDEzMjEzMTMyZHNhZzR0Z3JmZHNnYWRzYWRhZGFzJ2lkbTEwd3l1MTMxMmwsZCcxOWhqZWRzYWRhc2Rhc2Rhc2RhczEzMjEzMjE0c2RhZDExLG1kJzFqZDEyZCJ9";

    @Autowired
    DocumentService documentService;

    @GetMapping({"/base64"})
    public ResponseEntity<ResponseDocumentBase64> obtenerDocumentosBase64(@RequestHeader("Authorization") String token, @RequestParam("dni") String dni, @RequestParam("periodo") String periodo, @RequestParam(value = "grupo", required = false) String grupo) throws IOException {
        ArrayList<String> listaGrupos;
        if (!"eyJhbGciOiJIUzI1NiIsInR5cCI6IkFEU0FDQXNERkFTREpEU0ExMjQyMzE0ZGFzZDEzMjEzMTMyZHNhZzR0Z3JmZHNnYWRzYWRhZGFzJ2lkbTEwd3l1MTMxMmwsZCcxOWhqZWRzYWRhc2Rhc2Rhc2RhczEzMjEzMjE0c2RhZDExLG1kJzFqZDEyZCJ9".equalsIgnoreCase(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseDocumentBase64("Error de Autenticación", new ArrayList()));
        }

        if (grupo.contains(",")) {
            String[] grupos = grupo.split(",");
            listaGrupos = new ArrayList<>(Arrays.asList(grupos));
        } else {
            listaGrupos = new ArrayList<>();
            listaGrupos.add(grupo);
        }

        try {
            periodo = periodo.replace("-", " ");
            System.out.println(periodo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDocumentBase64("Error en parámetro periodo", new ArrayList()));
        }

        ArrayList<DocumentBase64> listDocumentoBase64 = this.documentService.obtenerDocumentoBase64(listaGrupos, dni, periodo);

        ResponseDocumentBase64 responseDocumentBase64 = new ResponseDocumentBase64("Solicitud Exitosa", listDocumentoBase64);
        return ResponseEntity.status(HttpStatus.OK).body(responseDocumentBase64);
    }

    @GetMapping({"/url"})
    public ResponseEntity<ResponseDocumentURL> obtenerDocumentosURL(@RequestHeader("Authorization") String token, @RequestParam("dni") String dni, @RequestParam("periodo") String periodo, @RequestParam(value = "grupo", required = false) String grupo) {
        ArrayList<String> listaGrupos;
        if (!"eyJhbGciOiJIUzI1NiIsInR5cCI6IkFEU0FDQXNERkFTREpEU0ExMjQyMzE0ZGFzZDEzMjEzMTMyZHNhZzR0Z3JmZHNnYWRzYWRhZGFzJ2lkbTEwd3l1MTMxMmwsZCcxOWhqZWRzYWRhc2Rhc2Rhc2RhczEzMjEzMjE0c2RhZDExLG1kJzFqZDEyZCJ9".equalsIgnoreCase(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseDocumentURL("Error de Autenticación", new ArrayList()));
        }

        if (grupo != null) {
            if (grupo.contains(",")) {
                String[] grupos = grupo.split(",");
                listaGrupos = new ArrayList<>(Arrays.asList(grupos));
            } else {
                listaGrupos = new ArrayList<>();
                listaGrupos.add(grupo);
            }
        } else {
            listaGrupos = new ArrayList<>();
        }

        try {
            periodo = periodo.replace("-", " ");
            System.out.println(periodo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDocumentURL("Error en parámetro periodo", new ArrayList()));
        }

        ArrayList<DocumentURL> listDocumentoURL = this.documentService.obtenerDocumentosURL(listaGrupos, dni, periodo);

        ResponseDocumentURL responseDocumentURL = new ResponseDocumentURL("Solicitud Exitosa", listDocumentoURL);
        return ResponseEntity.status(HttpStatus.OK).body(responseDocumentURL);
    }

    @GetMapping({"/listar"})
    public ResponseEntity<ResponseTiposDocumentales> obtenerDocumentosListado(@RequestHeader("Authorization") String token) {
        if (!"eyJhbGciOiJIUzI1NiIsInR5cCI6IkFEU0FDQXNERkFTREpEU0ExMjQyMzE0ZGFzZDEzMjEzMTMyZHNhZzR0Z3JmZHNnYWRzYWRhZGFzJ2lkbTEwd3l1MTMxMmwsZCcxOWhqZWRzYWRhc2Rhc2Rhc2RhczEzMjEzMjE0c2RhZDExLG1kJzFqZDEyZCJ9".equalsIgnoreCase(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseTiposDocumentales("Error de Autenticación", new ArrayList()));
        }

        ArrayList<DocumentGrupo> listaGrupos = this.documentService.obtenerlistadoDocumentos();

        ResponseTiposDocumentales responseTiposDocumentales = new ResponseTiposDocumentales("Solicitud Exitosa", listaGrupos);
        return ResponseEntity.status(HttpStatus.OK).body(responseTiposDocumentales);
    }

    @ExceptionHandler({ResponseStatusException.class})
    public ResponseEntity<ResponseDocumentBase64> faltaTokenHeader() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseDocumentBase64("Falta token de autenticación", new ArrayList()));
    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ResponseEntity<ResponseDocumentBase64> faltaParametros() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDocumentBase64("Falta parámetros requeridos", new ArrayList()));
    }
}