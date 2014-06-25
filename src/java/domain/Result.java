/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @NamedQuery(name = "Result.findByIdClient", query = "SELECT r FROM Result r WHERE r.resultPK.idClient = :idClient"),
    @NamedQuery(name = "Result.findByIdTest", query = "SELECT r FROM Result r WHERE r.resultPK.idTest = :idTest"),
    @NamedQuery(name = "Result.findByDate", query = "SELECT r FROM Result r WHERE r.date = :date"),
    @NamedQuery(name = "Result.findByValue", query = "SELECT r FROM Result r WHERE r.value = :value")})
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResultPK resultPK;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "value")
    private Integer value;
    @JoinColumn(name = "idTest", referencedColumnName = "idTest", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Test test;
    @JoinColumn(name = "idClient", referencedColumnName = "idClient", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;

    public Result() {
    }

    public Result(ResultPK resultPK) {
        this.resultPK = resultPK;
    }

    public Result(int idClient, int idTest) {
        this.resultPK = new ResultPK(idClient, idTest);
    }

    public ResultPK getResultPK() {
        return resultPK;
    }

    public void setResultPK(ResultPK resultPK) {
        this.resultPK = resultPK;
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

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resultPK != null ? resultPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Result)) {
            return false;
        }
        Result other = (Result) object;
        if ((this.resultPK == null && other.resultPK != null) || (this.resultPK != null && !this.resultPK.equals(other.resultPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Result[ resultPK=" + resultPK + " ]";
    }
    
}
