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
    @Column(name = "iddesligado")
    private Integer iddesligado;
    @Column(name = "datadesligado")
    private String datadesligado;
    @Column(name = "horadesligado")
    private String horadesligado;
    @Column(name = "remediodesligado")
    private String remediodesligado;

    public Desligado() {
    }

    public Desligado(Integer iddesligado) {
        this.iddesligado = iddesligado;
    }

    public Integer getIddesligado() {
        return iddesligado;
    }

    public void setIddesligado(Integer iddesligado) {
        this.iddesligado = iddesligado;
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
        hash += (iddesligado != null ? iddesligado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desligado)) {
            return false;
        }
        Desligado other = (Desligado) object;
        if ((this.iddesligado == null && other.iddesligado != null) || (this.iddesligado != null && !this.iddesligado.equals(other.iddesligado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Desligado[ iddesligado=" + iddesligado + ", "+ datadesligado + ", " +horadesligado+", "+remediodesligado+" ]";
    }
    
}
