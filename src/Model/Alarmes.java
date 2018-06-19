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
@Table(name = "Alarmes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alarmes.findAll", query = "SELECT a FROM Alarmes a")
    , @NamedQuery(name = "Alarmes.findByIdAlarmes", query = "SELECT a FROM Alarmes a WHERE a.idAlarmes = :idAlarmes")
    , @NamedQuery(name = "Alarmes.findByDataAlarmes", query = "SELECT a FROM Alarmes a WHERE a.dataAlarmes = :dataAlarmes")
    , @NamedQuery(name = "Alarmes.findByHoraAlarmes", query = "SELECT a FROM Alarmes a WHERE a.horaAlarmes = :horaAlarmes")})
public class Alarmes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idAlarmes")
    private Integer idAlarmes;
    @Column(name = "dataAlarmes")
    @Temporal(TemporalType.DATE)
    private Date dataAlarmes;
    @Column(name = "horaAlarmes")
    private String horaAlarmes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alarmesidAlarmes")
    private Collection<Acionado> acionadoCollection;

    public Alarmes() {
    }

    public Alarmes(Integer idAlarmes) {
        this.idAlarmes = idAlarmes;
    }

    public Integer getIdAlarmes() {
        return idAlarmes;
    }

    public void setIdAlarmes(Integer idAlarmes) {
        this.idAlarmes = idAlarmes;
    }

    public Date getDataAlarmes() {
        return dataAlarmes;
    }

    public void setDataAlarmes(Date dataAlarmes) {
        this.dataAlarmes = dataAlarmes;
    }

    public String getHoraAlarmes() {
        return horaAlarmes;
    }

    public void setHoraAlarmes(String horaAlarmes) {
        this.horaAlarmes = horaAlarmes;
    }

    @XmlTransient
    public Collection<Acionado> getAcionadoCollection() {
        return acionadoCollection;
    }

    public void setAcionadoCollection(Collection<Acionado> acionadoCollection) {
        this.acionadoCollection = acionadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlarmes != null ? idAlarmes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alarmes)) {
            return false;
        }
        Alarmes other = (Alarmes) object;
        if ((this.idAlarmes == null && other.idAlarmes != null) || (this.idAlarmes != null && !this.idAlarmes.equals(other.idAlarmes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return " idAlarme= " + idAlarmes +"\ndata = "
                +sdf.format(dataAlarmes)+"\nhora = "
                +horaAlarmes+"\n"; 
    }
    
}
