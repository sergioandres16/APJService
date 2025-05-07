package org.saeta.apjconsultas.Repository;

import org.saeta.apjconsultas.Entity.CloudGrupo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<CloudGrupo, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM cloud_grupo ORDER BY 1 DESC")
    List<CloudGrupo> getListDocumentGrupo();
}