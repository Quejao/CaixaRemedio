/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lcorra
 */
@Entity
@Table(name = "Acionado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acionado.findAll", query = "SELECT a FROM Acionado a")
    , @NamedQuery(name = "Acionado.findByIdAcionado", query = "SELECT a FROM Acionado a WHERE a.idAcionado = :idAcionado")
    , @NamedQuery(name = "Acionado.findByDataAcionado", query = "SELECT a FROM Acionado a WHERE a.dataAcionado = :dataAcionado")
    , @NamedQuery(name = "Acionado.findByHoraAcionado", query = "SELECT a FROM Acionado a WHERE a.horaAcionado = :horaAcionado")
    , @NamedQuery(name = "Acionado.findByDesligadoAcionado", query = "SELECT a FROM Acionado a WHERE a.desligadoAcionado = :desligadoAcionado")})
public class Acionado implements Serializable {

    @JoinColumn(name = "Alarmes_idAlarmes", referencedColumnName = "idAlarmes")
    @ManyToOne(optional = false)
    private Alarmes alarmesidAlarmes;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idAcionado")
    private Integer idAcionado;
    @Column(name = "dataAcionado")
    @Temporal(TemporalType.DATE)
    private Date dataAcionado;
    @Column(name = "horaAcionado")
    @Temporal(TemporalType.TIME)
    private Date horaAcionado;
    @Column(name = "desligadoAcionado")
    private Boolean desligadoAcionado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acionadoidAcionado")
    private Collection<Desligado> desligadoCollection;

    public Acionado() {
    }

    public Acionado(Integer idAcionado) {
        this.idAcionado = idAcionado;
    }

    public Integer getIdAcionado() {
        return idAcionado;
    }

    public void setIdAcionado(Integer idAcionado) {
        this.idAcionado = idAcionado;
    }

    public Date getDataAcionado() {
        return dataAcionado;
    }

    public void setDataAcionado(Date dataAcionado) {
        this.dataAcionado = dataAcionado;
    }

    public Date getHoraAcionado() {
        return horaAcionado;
    }

    public void setHoraAcionado(Date horaAcionado) {
        this.horaAcionado = horaAcionado;
    }

    public Boolean getDesligadoAcionado() {
        return desligadoAcionado;
    }

    public void setDesligadoAcionado(Boolean desligadoAcionado) {
        this.desligadoAcionado = desligadoAcionado;
    }

    @XmlTransient
    public Collection<Desligado> getDesligadoCollection() {
        return desligadoCollection;
    }

    public void setDesligadoCollection(Collection<Desligado> desligadoCollection) {
        this.desligadoCollection = desligadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAcionado != null ? idAcionado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acionado)) {
            return false;
        }
        Acionado other = (Acionado) object;
        if ((this.idAcionado == null && other.idAcionado != null) || (this.idAcionado != null && !this.idAcionado.equals(other.idAcionado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm");
        return " idAcionado = " + idAcionado +"\ndata = "
                +sdf.format(dataAcionado)+"\nhora = "
                +sdfH.format(horaAcionado)+"\n";        
    }

    public Alarmes getAlarmesidAlarmes() {
        return alarmesidAlarmes;
    }

    public void setAlarmesidAlarmes(Alarmes alarmesidAlarmes) {
        this.alarmesidAlarmes = alarmesidAlarmes;
    }
    
}
