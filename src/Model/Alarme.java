/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author leotr
 */
@Entity
@Table(name = "alarme")
@NamedQueries({
    @NamedQuery(name = "Alarme.findAll", query = "SELECT a FROM Alarme a")})
public class Alarme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idalarme")
    private Integer idalarme;
    @Column(name = "dataalarme")
    private String dataalarme;
    @Column(name = "horaalarme")
    private String horaalarme;
    @Column(name = "remedioalarme")
    private String remedioalarme;

    public Alarme() {
    }

    public Alarme(Integer idalarme) {
        this.idalarme = idalarme;
    }

    public Integer getIdalarme() {
        return idalarme;
    }

    public void setIdalarme(Integer idalarme) {
        this.idalarme = idalarme;
    }

    public String getDataalarme() {
        return dataalarme;
    }

    public void setDataalarme(String dataalarme) {
        this.dataalarme = dataalarme;
    }

    public String getHoraalarme() {
        return horaalarme;
    }

    public void setHoraalarme(String horaalarme) {
        this.horaalarme = horaalarme;
    }

    public String getRemedioalarme() {
        return remedioalarme;
    }

    public void setRemedioalarme(String remedioalarme) {
        this.remedioalarme = remedioalarme;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalarme != null ? idalarme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alarme)) {
            return false;
        }
        Alarme other = (Alarme) object;
        if ((this.idalarme == null && other.idalarme != null) || (this.idalarme != null && !this.idalarme.equals(other.idalarme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Alarme[ idalarme=" + idalarme + ", "+ dataalarme + ", " +horaalarme+", "+remedioalarme+" ]";
    }
    
}
