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
@Table(name = "desligado")
@NamedQueries({
    @NamedQuery(name = "Desligado.findAll", query = "SELECT d FROM Desligado d")})
public class Desligado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idalarme")
    private Integer idalarme;
    @Column(name = "datadesligado")
    private String datadesligado;
    @Column(name = "horadesligado")
    private String horadesligado;
    @Column(name = "remediodesligado")
    private String remediodesligado;

    public Desligado() {
    }

    public Desligado(Integer idalarme) {
        this.idalarme = idalarme;
    }

    public Integer getIdalarme() {
        return idalarme;
    }

    public void setIdalarme(Integer idalarme) {
        this.idalarme = idalarme;
    }

    public String getDatadesligado() {
        return datadesligado;
    }

    public void setDatadesligado(String datadesligado) {
        this.datadesligado = datadesligado;
    }

    public String getHoradesligado() {
        return horadesligado;
    }

    public void setHoradesligado(String horadesligado) {
        this.horadesligado = horadesligado;
    }

    public String getRemediodesligado() {
        return remediodesligado;
    }

    public void setRemediodesligado(String remediodesligado) {
        this.remediodesligado = remediodesligado;
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
        if (!(object instanceof Desligado)) {
            return false;
        }
        Desligado other = (Desligado) object;
        if ((this.idalarme == null && other.idalarme != null) || (this.idalarme != null && !this.idalarme.equals(other.idalarme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Desligado[ idalarme=" + idalarme + " ]";
    }
    
}
