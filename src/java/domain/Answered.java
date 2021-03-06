/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tihomir
 */
@Entity
@Table(name = "answered")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Answered.findAll", query = "SELECT a FROM Answered a"),
    @NamedQuery(name = "Answered.findByIdMaster", query = "SELECT a FROM Answered a WHERE a.idMaster = :idMaster")})
public class Answered implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMaster")
    private Integer idMaster;
    @JoinColumn(name = "idItemTest", referencedColumnName = "idItemTest")
    @ManyToOne(optional = false)
    private Testitem idItemTest;
    @JoinColumn(name = "idQuestion", referencedColumnName = "idQuestion")
    @ManyToOne(optional = false)
    private Question idQuestion;
    @JoinColumn(name = "idTest", referencedColumnName = "idTest")
    @ManyToOne(optional = false)
    private Test idTest;
    @JoinColumn(name = "idClient", referencedColumnName = "idClient")
    @ManyToOne(optional = false)
    private Client idClient;

    public Answered() {
    }

    public Answered(Integer idMaster) {
        this.idMaster = idMaster;
    }

    public Integer getIdMaster() {
        return idMaster;
    }

    public void setIdMaster(Integer idMaster) {
        this.idMaster = idMaster;
    }

    public Testitem getIdItemTest() {
        return idItemTest;
    }

    public void setIdItemTest(Testitem idItemTest) {
        this.idItemTest = idItemTest;
    }

    public Question getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Question idQuestion) {
        this.idQuestion = idQuestion;
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
        if (!(object instanceof Answered)) {
            return false;
        }
        Answered other = (Answered) object;
        if ((this.idMaster == null && other.idMaster != null) || (this.idMaster != null && !this.idMaster.equals(other.idMaster))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Answered[ idMaster=" + idMaster + " ]";
    }
    
}
