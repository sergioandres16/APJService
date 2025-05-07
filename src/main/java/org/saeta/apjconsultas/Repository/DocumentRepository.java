package org.saeta.apjconsultas.Repository;

import org.saeta.apjconsultas.Dto.BodyDocumentoDTO;
import org.saeta.apjconsultas.Entity.CloudDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentRepository extends JpaRepository<CloudDocumento, Integer> {

    /**
     * Devuelve la información de un solo documento (filtrando también por grupo).
     */
    @Query(
            nativeQuery = true,
            value =
                    "SELECT cd.do_iddocumento AS id, cd.do_nombre AS name, cd.do_filegen AS filegen, cd.do_filefir AS filefir, " +
                            "       cg.gr_idgrupo AS idgrupo, cg.gr_nombre AS gruponame, COUNT(cc.co_estado) AS cant_env " +
                            "FROM cloud_documento cd " +
                            "INNER JOIN cloud_grupo cg                      ON cg.gr_idgrupo                  = cd.do_idgrupo " +
                            "INNER JOIN cloud_documento_procesofirma cdp    ON cdp.dp_iddocumento             = cd.do_iddocumento " +
                            "INNER JOIN cloud_firmante cf                   ON cf.fi_idfirmante               = cdp.dp_idfirmante " +
                            "LEFT  JOIN cloud_correo cc                    ON cdp.dp_iddocumentoprocesofirma = cc.co_idprocesofirma " +
                            "WHERE cd.do_periodo ILIKE '%' || ?1 || '%' " +
                            "  AND cf.fi_docide     = ?2 " +
                            "  AND cd.do_idgrupo    = ?3 " +
                            "  AND cd.do_estado     = '1' " +
                            "GROUP BY cd.do_iddocumento, cd.do_nombre, cd.do_filegen, cd.do_filefir, cg.gr_idgrupo, cg.gr_nombre " +
                            "HAVING COUNT(cc.co_estado) > 0 " +
                            "ORDER BY cd.do_iddocumento DESC"
    )
    Optional<BodyDocumentoDTO> getInfoDocument(String periodo, String docIde, Integer idGrupo);

    /**
     * Devuelve la lista de documentos del firmante sin filtrar por grupo.
     */
    @Query(
            nativeQuery = true,
            value =
                    "SELECT cd.do_iddocumento AS id, cd.do_nombre AS name, cd.do_filegen AS filegen, cd.do_filefir AS filefir, " +
                            "       cg.gr_idgrupo AS idgrupo, cg.gr_nombre AS gruponame, COUNT(cc.co_estado) AS cant_env " +
                            "FROM cloud_documento cd " +
                            "INNER JOIN cloud_grupo cg                      ON cg.gr_idgrupo                  = cd.do_idgrupo " +
                            "INNER JOIN cloud_documento_procesofirma cdp    ON cdp.dp_iddocumento             = cd.do_iddocumento " +
                            "INNER JOIN cloud_firmante cf                   ON cf.fi_idfirmante               = cdp.dp_idfirmante " +
                            "LEFT  JOIN cloud_correo cc                    ON cdp.dp_iddocumentoprocesofirma = cc.co_idprocesofirma " +
                            "WHERE cd.do_periodo ILIKE '%' || ?1 || '%' " +
                            "  AND cf.fi_docide     = ?2 " +
                            "  AND cd.do_estado     = '1' " +
                            "GROUP BY cd.do_iddocumento, cd.do_nombre, cd.do_filegen, cd.do_filefir, cg.gr_idgrupo, cg.gr_nombre " +
                            "HAVING COUNT(cc.co_estado) > 0 " +
                            "ORDER BY cd.do_iddocumento DESC"
    )
    List<BodyDocumentoDTO> getListDocument(String periodo, String docIde);
}