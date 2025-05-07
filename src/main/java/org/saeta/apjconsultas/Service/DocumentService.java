package org.saeta.apjconsultas.Service;

import org.saeta.apjconsultas.Dto.BodyDocumentoDTO;
import org.saeta.apjconsultas.Entity.CloudGrupo;
import org.saeta.apjconsultas.Model.DocumentBase64;
import org.saeta.apjconsultas.Model.DocumentGrupo;
import org.saeta.apjconsultas.Model.DocumentURL;
import org.saeta.apjconsultas.Repository.DocumentRepository;
import org.saeta.apjconsultas.Repository.GrupoRepository;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {
    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    GrupoRepository grupoRepository;

    private final String raizRutaDocumentFir = "/var/www/apj.plussigner.com/public_html/APJ/boleta/";

    public ArrayList<DocumentBase64> obtenerDocumentoBase64(ArrayList<String> listaGrupos, String dni, String periodo) throws IOException {
        ArrayList<DocumentBase64> documentBase64ArrayList = new ArrayList<>();

        if (!listaGrupos.isEmpty()) {

            for (String grupo : listaGrupos) {
                Optional<BodyDocumentoDTO> bodyDocumentoDTOOptional = this.documentRepository.getInfoDocument(periodo, dni, Integer.valueOf(Integer.parseInt(grupo)));
                if (bodyDocumentoDTOOptional.isPresent()) {
                    String cadenaDocumentFir = ((BodyDocumentoDTO)bodyDocumentoDTOOptional.get()).getFilefir();
                    String rutaDocumentoFirmado = "/var/www/apj.plussigner.com/public_html/APJ/boleta/" + cadenaDocumentFir.replaceFirst("^\\.\\./", "");

                    byte[] pdfBytes = obtenerDocumentoBytes(rutaDocumentoFirmado);
                    String estado = "";
                    if (pdfBytes == null) {
                        estado = "Documento No firmado";
                    } else {
                        estado = "Documento Firmado";
                    }
                    DocumentBase64 documentBase64 = new DocumentBase64(String.valueOf(((BodyDocumentoDTO)bodyDocumentoDTOOptional.get()).getId()), ((BodyDocumentoDTO)bodyDocumentoDTOOptional.get()).getName(), estado, pdfBytes);
                    documentBase64ArrayList.add(documentBase64);
                }
            }
        } else {

            List<BodyDocumentoDTO> listDocument = this.documentRepository.getListDocument(periodo, dni);
            for (BodyDocumentoDTO documentoDTO : listDocument) {
                String cadenaDocumentFir = documentoDTO.getFilefir();
                String rutaDocumentoFirmado = "/var/www/apj.plussigner.com/public_html/APJ/boleta/" + cadenaDocumentFir.replaceFirst("^\\.\\./", "");
                byte[] pdfBytes = obtenerDocumentoBytes(rutaDocumentoFirmado);
                String estado = "";
                if (pdfBytes == null) {
                    estado = "Documento No firmado";
                } else {
                    estado = "Documento Firmado";
                }
                DocumentBase64 documentBase64 = new DocumentBase64(String.valueOf(documentoDTO.getId()), documentoDTO.getName(), estado, pdfBytes);
                documentBase64ArrayList.add(documentBase64);
            }
        }

        return documentBase64ArrayList;
    }

    public ArrayList<DocumentURL> obtenerDocumentosURL(ArrayList<String> listaGrupos, String dni, String periodo) {
        ArrayList<DocumentURL> documentURLArrayList = new ArrayList<>();
        if (!listaGrupos.isEmpty()) {

            for (String grupo : listaGrupos) {
                Optional<BodyDocumentoDTO> bodyDocumentoDTOOptional = this.documentRepository.getInfoDocument(periodo, dni, Integer.valueOf(Integer.parseInt(grupo)));
                if (bodyDocumentoDTOOptional.isPresent()) {
                    String cadenaDocumentFir = ((BodyDocumentoDTO)bodyDocumentoDTOOptional.get()).getFilefir();
                    String rutaDocumentoFirmado = "/var/www/apj.plussigner.com/public_html/APJ/boleta/" + cadenaDocumentFir.replaceFirst("^\\.\\./", "");
                    byte[] pdfBytes = obtenerDocumentoBytes(rutaDocumentoFirmado);
                    String enlaceDescarga = "https://apj.plussigner.com/APJ/boleta/sys/servicios/download.php?etv2r=";
                    String estado = "";
                    if (pdfBytes == null) {
                        enlaceDescarga = enlaceDescarga;
                        estado = "Documento No firmado";
                    } else {

                        enlaceDescarga = enlaceDescarga + cadenaDocumentFir;
                        estado = "Documento Firmado";
                    }

                    DocumentURL documentURL = new DocumentURL(String.valueOf(((BodyDocumentoDTO)bodyDocumentoDTOOptional.get()).getId()), ((BodyDocumentoDTO)bodyDocumentoDTOOptional.get()).getName(), estado, enlaceDescarga);
                    documentURLArrayList.add(documentURL);
                }
            }
        } else {

            List<BodyDocumentoDTO> listDocument = this.documentRepository.getListDocument(periodo, dni);
            for (BodyDocumentoDTO documentoDTO : listDocument) {
                String cadenaDocumentFir = documentoDTO.getFilefir();
                String rutaDocumentoFirmado = "/var/www/apj.plussigner.com/public_html/APJ/boleta/" + cadenaDocumentFir.replaceFirst("^\\.\\./", "");
                byte[] pdfBytes = obtenerDocumentoBytes(rutaDocumentoFirmado);
                String enlaceDescarga = "https://apj.plussigner.com/APJ/boleta/sys/servicios/download.php?etv2r=";
                String estado = "";
                if (pdfBytes == null) {
                    enlaceDescarga = enlaceDescarga;
                    estado = "Documento No firmado";
                } else {

                    enlaceDescarga = enlaceDescarga + cadenaDocumentFir;
                    estado = "Documento Firmado";
                }
                DocumentURL documentURL = new DocumentURL(String.valueOf(documentoDTO.getId()), documentoDTO.getName(), estado, enlaceDescarga);
                documentURLArrayList.add(documentURL);
            }
        }

        return documentURLArrayList;
    }

    public ArrayList<DocumentGrupo> obtenerlistadoDocumentos() {
        ArrayList<DocumentGrupo> documentGrupoArrayList = new ArrayList<>();
        List<CloudGrupo> cloudGrupoList = this.grupoRepository.getListDocumentGrupo();
        for (CloudGrupo grupo : cloudGrupoList) {
            documentGrupoArrayList.add(new DocumentGrupo(String.valueOf(grupo.getId()), grupo.getGrNombre()));
        }
        return documentGrupoArrayList;
    }

    public byte[] obtenerDocumentoBytes(String ruta) {
        try {
            FileInputStream inputStream = new FileInputStream(new File(ruta));

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }

            byte[] pdfBytes = byteArrayOutputStream.toByteArray();

            inputStream.close();
            byteArrayOutputStream.close();
            return pdfBytes;
        } catch (Exception e) {
            return null;
        }
    }

    public String transformarBase64(String cadena) {
        byte[] cadenaBytes = cadena.getBytes();
        String base64String = Base64.getEncoder().encodeToString(cadenaBytes);
        return base64String;
    }
}