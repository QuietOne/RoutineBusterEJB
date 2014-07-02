/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tihomir
 */
@Entity
@Table(name = "testitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Testitem.findAll", query = "SELECT t FROM Testitem t"),
    @NamedQuery(name = "Testitem.findByIdItemTest", query = "SELECT t FROM Testitem t WHERE t.idItemTest = :idItemTest")})
public class Testitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idItemTest")
    private Integer idItemTest;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idItemTest")
    private List<Answeritem> answeritemList;
    @JoinColumn(name = "idQuestion", referencedColumnName = "idQuestion")
    @ManyToOne(optional = false)
    private Question idQuestion;
    @JoinColumn(name = "idTest", referencedColumnName = "idTest")
    @ManyToOne(optional = false)
    private Test idTest;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idItemTest")
    private List<Answered> answeredList;

    public Testitem() {
    }

    public Testitem(Integer idItemTest) {
        this.idItemTest = idItemTest;
    }

    public Integer getIdItemTest() {
        return idItemTest;
    }

    public void setIdItemTest(Integer idItemTest) {
        this.idItemTest = idItemTest;
    }

    @XmlTransient
    public List<Answeritem> getAnsweritemList() {
        return answeritemList;
    }

    public void setAnsweritemList(List<Answeritem> answeritemList) {
        this.answeritemList = answeritemList;
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

    @XmlTransient
    public List<Answered> getAnsweredList() {
        return answeredList;
    }

    public void setAnsweredList(List<Answered> answeredList) {
        this.answeredList = answeredList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItemTest != null ? idItemTest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Testitem)) {
            return false;
        }
        Testitem other = (Testitem) object;
        if ((this.idItemTest == null && other.idItemTest != null) || (this.idItemTest != null && !this.idItemTest.equals(other.idItemTest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Testitem[ idItemTest=" + idItemTest + " ]";
    }
    
}
