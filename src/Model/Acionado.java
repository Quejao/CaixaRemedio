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
@Table(name = "acionado")
@NamedQueries({
    @NamedQuery(name = "Acionado.findAll", query = "SELECT a FROM Acionado a")})
public class Acionado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idacionado")
    private Integer idacionado;
    @Column(name = "dataacionado")
    private String dataacionado;
    @Column(name = "horaacionado")
    private String horaacionado;
    @Column(name = "remedioacionado")
    private String remedioacionado;

    public Acionado() {
    }

    public Acionado(Integer idacionado) {
        this.idacionado = idacionado;
    }

    public Integer getIdacionado() {
        return idacionado;
    }

    public void setIdacionado(Integer idacionado) {
        this.idacionado = idacionado;
    }

    public String getDataacionado() {
        return dataacionado;
    }

    public void setDataacionado(String dataacionado) {
        this.dataacionado = dataacionado;
    }

    public String getHoraacionado() {
        return horaacionado;
    }

    public void setHoraacionado(String horaacionado) {
        this.horaacionado = horaacionado;
    }

    public String getRemedioacionado() {
        return remedioacionado;
    }

    public void setRemedioacionado(String remedioacionado) {
        this.remedioacionado = remedioacionado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idacionado != null ? idacionado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acionado)) {
            return false;
        }
        Acionado other = (Acionado) object;
        if ((this.idacionado == null && other.idacionado != null) || (this.idacionado != null && !this.idacionado.equals(other.idacionado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Acionado[ idacionado=" + idacionado + ", "+ dataacionado + ", " +horaacionado+", "+remedioacionado+" ]";
    }
    
}
