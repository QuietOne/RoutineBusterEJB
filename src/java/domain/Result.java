/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author tihomir
 */
@Entity
@Table(name = "result")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Result.findAll", query = "SELECT r FROM Result r"),
    @NamedQuery(name = "Result.findByDate", query = "SELECT r FROM Result r WHERE r.date = :date"),
    @NamedQuery(name = "Result.findByValue", query = "SELECT r FROM Result r WHERE r.value = :value"),
    @NamedQuery(name = "Result.findByIdMaster", query = "SELECT r FROM Result r WHERE r.idMaster = :idMaster")})
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "value")
    private Integer value;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMaster")
    private Integer idMaster;
    @JoinColumn(name = "idTest", referencedColumnName = "idTest")
    @ManyToOne(optional = false)
    private Test idTest;
    @JoinColumn(name = "idClient", referencedColumnName = "idClient")
    @ManyToOne(optional = false)
    private Client idClient;

    public Result() {
    }

    public Result(Integer idMaster) {
        this.idMaster = idMaster;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getIdMaster() {
        return idMaster;
    }

    public void setIdMaster(Integer idMaster) {
        this.idMaster = idMaster;
    }

    public Test getIdTest() {
        return idTest;
    }

    public void setIdTest(Test idTest) {
        this.idTest = idTest;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaster != null ? idMaster.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Result)) {
            return false;
        }
        Result other = (Result) object;
        if ((this.idMaster == null && other.idMaster != null) || (this.idMaster != null && !this.idMaster.equals(other.idMaster))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Result[ idMaster=" + idMaster + " ]";
    }
    
}
