package org.saeta.apjconsultas.Entity;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cloud_documento")
public class CloudDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "do_iddocumento", nullable = false)
    private Integer id;

    @Column(name = "do_idgrupo", nullable = false)
    private Integer doIdgrupo;

    @Column(name = "do_nombre", nullable = false, length = 100)
    private String doNombre;

    @Column(name = "do_sede", length = 2147483647)
    private String doSede;

    @Column(name = "do_cav", length = 35)
    private String doCav;

    @Column(name = "do_filegen", length = 2147483647)
    private String doFilegen;

    @Column(name = "do_filefir", length = 2147483647)
    private String doFilefir;

    @Column(name = "do_etapaproceso", nullable = false)
    private Integer doEtapaproceso;

    @Column(name = "do_observacion", length = 2147483647)
    private String doObservacion;

    @Column(name = "do_datireg", nullable = false)
    private Instant doDatireg;

    @Column(name = "do_regpor", nullable = false)
    private Integer doRegpor;

    @Column(name = "do_datimod", nullable = false)
    private Instant doDatimod;

    @Column(name = "do_modpor", nullable = false)
    private Integer doModpor;

    @Column(name = "do_estado", nullable = false, length = 2147483647)
    private String doEstado;

    @Column(name = "do_periodo", nullable = false, length = 2147483647)
    private String doPeriodo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoIdgrupo() {
        return doIdgrupo;
    }

    public void setDoIdgrupo(Integer doIdgrupo) {
        this.doIdgrupo = doIdgrupo;
    }

    public String getDoNombre() {
        return doNombre;
    }

    public void setDoNombre(String doNombre) {
        this.doNombre = doNombre;
    }

    public String getDoSede() {
        return doSede;
    }

    public void setDoSede(String doSede) {
        this.doSede = doSede;
    }

    public String getDoCav() {
        return doCav;
    }

    public void setDoCav(String doCav) {
        this.doCav = doCav;
    }

    public String getDoFilegen() {
        return doFilegen;
    }

    public void setDoFilegen(String doFilegen) {
        this.doFilegen = doFilegen;
    }

    public String getDoFilefir() {
        return doFilefir;
    }

    public void setDoFilefir(String doFilefir) {
        this.doFilefir = doFilefir;
    }

    public Integer getDoEtapaproceso() {
        return doEtapaproceso;
    }

    public void setDoEtapaproceso(Integer doEtapaproceso) {
        this.doEtapaproceso = doEtapaproceso;
    }

    public String getDoObservacion() {
        return doObservacion;
    }

    public void setDoObservacion(String doObservacion) {
        this.doObservacion = doObservacion;
    }

    public Instant getDoDatireg() {
        return doDatireg;
    }

    public void setDoDatireg(Instant doDatireg) {
        this.doDatireg = doDatireg;
    }

    public Integer getDoRegpor() {
        return doRegpor;
    }

    public void setDoRegpor(Integer doRegpor) {
        this.doRegpor = doRegpor;
    }

    public Instant getDoDatimod() {
        return doDatimod;
    }

    public void setDoDatimod(Instant doDatimod) {
        this.doDatimod = doDatimod;
    }

    public Integer getDoModpor() {
        return doModpor;
    }

    public void setDoModpor(Integer doModpor) {
        this.doModpor = doModpor;
    }

    public String getDoEstado() {
        return doEstado;
    }

    public void setDoEstado(String doEstado) {
        this.doEstado = doEstado;
    }

    public String getDoPeriodo() {
        return doPeriodo;
    }

    public void setDoPeriodo(String doPeriodo) {
        this.doPeriodo = doPeriodo;
    }
}