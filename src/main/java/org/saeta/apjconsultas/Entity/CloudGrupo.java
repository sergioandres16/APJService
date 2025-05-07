package org.saeta.apjconsultas.Entity;

import java.time.Instant;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cloud_grupo")
public class CloudGrupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gr_idgrupo", nullable = false)
    private Integer id;

    @Column(name = "gr_iddependencia", nullable = false)
    private Integer grIddependencia;

    @Column(name = "gr_idformato")
    private Integer grIdformato;

    @Column(name = "gr_nombre", nullable = false, length = 50)
    private String grNombre;

    @Column(name = "gr_fechaini")
    private LocalDate grFechaini;

    @Column(name = "gr_fechafin")
    private LocalDate grFechafin;

    @Column(name = "gr_descripcion")
    private String grDescripcion;

    @Column(name = "gr_observacion")
    private String grObservacion;

    @Column(name = "gr_datireg", nullable = false)
    private Instant grDatireg;

    @Column(name = "gr_regpor", nullable = false)
    private Integer grRegpor;

    @Column(name = "gr_datimod", nullable = false)
    private Instant grDatimod;

    @Column(name = "gr_modpor", nullable = false)
    private Integer grModpor;

    @Column(name = "gr_estado", nullable = false)
    private String grEstado;

    @Column(name = "gr_urlplantilla", length = 200)
    private String grUrlplantilla;

    @Column(name = "gr_idtipo", nullable = false)
    private Integer grIdtipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrIddependencia() {
        return grIddependencia;
    }

    public void setGrIddependencia(Integer grIddependencia) {
        this.grIddependencia = grIddependencia;
    }

    public Integer getGrIdformato() {
        return grIdformato;
    }

    public void setGrIdformato(Integer grIdformato) {
        this.grIdformato = grIdformato;
    }

    public String getGrNombre() {
        return grNombre;
    }

    public void setGrNombre(String grNombre) {
        this.grNombre = grNombre;
    }

    public LocalDate getGrFechaini() {
        return grFechaini;
    }

    public void setGrFechaini(LocalDate grFechaini) {
        this.grFechaini = grFechaini;
    }

    public LocalDate getGrFechafin() {
        return grFechafin;
    }

    public void setGrFechafin(LocalDate grFechafin) {
        this.grFechafin = grFechafin;
    }

    public String getGrDescripcion() {
        return grDescripcion;
    }

    public void setGrDescripcion(String grDescripcion) {
        this.grDescripcion = grDescripcion;
    }

    public String getGrObservacion() {
        return grObservacion;
    }

    public void setGrObservacion(String grObservacion) {
        this.grObservacion = grObservacion;
    }

    public Instant getGrDatireg() {
        return grDatireg;
    }

    public void setGrDatireg(Instant grDatireg) {
        this.grDatireg = grDatireg;
    }

    public Integer getGrRegpor() {
        return grRegpor;
    }

    public void setGrRegpor(Integer grRegpor) {
        this.grRegpor = grRegpor;
    }

    public Instant getGrDatimod() {
        return grDatimod;
    }

    public void setGrDatimod(Instant grDatimod) {
        this.grDatimod = grDatimod;
    }

    public Integer getGrModpor() {
        return grModpor;
    }

    public void setGrModpor(Integer grModpor) {
        this.grModpor = grModpor;
    }

    public String getGrEstado() {
        return grEstado;
    }

    public void setGrEstado(String grEstado) {
        this.grEstado = grEstado;
    }

    public String getGrUrlplantilla() {
        return grUrlplantilla;
    }

    public void setGrUrlplantilla(String grUrlplantilla) {
        this.grUrlplantilla = grUrlplantilla;
    }

    public Integer getGrIdtipo() {
        return grIdtipo;
    }

    public void setGrIdtipo(Integer grIdtipo) {
        this.grIdtipo = grIdtipo;
    }
}