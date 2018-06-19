/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lcorra
 */
@Entity
@Table(name = "Desligado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Desligado.findAll", query = "SELECT d FROM Desligado d")
    , @NamedQuery(name = "Desligado.findByIdDesligado", query = "SELECT d FROM Desligado d WHERE d.idDesligado = :idDesligado")
    , @NamedQuery(name = "Desligado.findByDataDesligado", query = "SELECT d FROM Desligado d WHERE d.dataDesligado = :dataDesligado")
    , @NamedQuery(name = "Desligado.findByHoraDesligado", query = "SELECT d FROM Desligado d WHERE d.horaDesligado = :horaDesligado")})
public class Desligado implements Serializable {

    @Column(name = "horaDesligado")
    private String horaDesligado;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idDesligado")
    private Integer idDesligado;
    @Column(name = "dataDesligado")
    @Temporal(TemporalType.DATE)
    private Date dataDesligado;
    @JoinColumn(name = "Acionado_idAcionado", referencedColumnName = "idAcionado")
    @ManyToOne(optional = false)
    private Acionado acionadoidAcionado;

    public Desligado() {
    }

    public Desligado(Integer idDesligado) {
        this.idDesligado = idDesligado;
    }

    public Integer getIdDesligado() {
        return idDesligado;
    }

    public void setIdDesligado(Integer idDesligado) {
        this.idDesligado = idDesligado;
    }

    public Date getDataDesligado() {
        return dataDesligado;
    }

    public void setDataDesligado(Date dataDesligado) {
        this.dataDesligado = dataDesligado;
    }


    public Acionado getAcionadoidAcionado() {
        return acionadoidAcionado;
    }

    public void setAcionadoidAcionado(Acionado acionadoidAcionado) {
        this.acionadoidAcionado = acionadoidAcionado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDesligado != null ? idDesligado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desligado)) {
            return false;
        }
        Desligado other = (Desligado) object;
        if ((this.idDesligado == null && other.idDesligado != null) || (this.idDesligado != null && !this.idDesligado.equals(other.idDesligado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return " idDesligado = " + idDesligado +"\ndata = "
                +sdf.format(dataDesligado)+"\nhora = "
                +horaDesligado+"\n"; 
    }

    public String getHoraDesligado() {
        return horaDesligado;
    }

    public void setHoraDesligado(String horaDesligado) {
        this.horaDesligado = horaDesligado;
    }
    
}
