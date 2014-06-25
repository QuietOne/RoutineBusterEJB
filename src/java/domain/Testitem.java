/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @NamedQuery(name = "Testitem.findByIdItemTest", query = "SELECT t FROM Testitem t WHERE t.testitemPK.idItemTest = :idItemTest"),
    @NamedQuery(name = "Testitem.findByIdTest", query = "SELECT t FROM Testitem t WHERE t.testitemPK.idTest = :idTest"),
    @NamedQuery(name = "Testitem.findByIdQuestion", query = "SELECT t FROM Testitem t WHERE t.testitemPK.idQuestion = :idQuestion")})
public class Testitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TestitemPK testitemPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testitem", fetch = FetchType.LAZY)
    private List<Answeritem> answeritemList;
    @JoinColumn(name = "idQuestion", referencedColumnName = "idQuestion", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Question question;
    @JoinColumn(name = "idTest", referencedColumnName = "idTest", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Test test;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testitem", fetch = FetchType.LAZY)
    private List<Answered> answeredList;

    public Testitem() {
    }

    public Testitem(TestitemPK testitemPK) {
        this.testitemPK = testitemPK;
    }

    public Testitem(int idItemTest, int idTest, int idQuestion) {
        this.testitemPK = new TestitemPK(idItemTest, idTest, idQuestion);
    }

    public TestitemPK getTestitemPK() {
        return testitemPK;
    }

    public void setTestitemPK(TestitemPK testitemPK) {
        this.testitemPK = testitemPK;
    }

    @XmlTransient
    public List<Answeritem> getAnsweritemList() {
        return answeritemList;
    }

    public void setAnsweritemList(List<Answeritem> answeritemList) {
        this.answeritemList = answeritemList;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
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
        hash += (testitemPK != null ? testitemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Testitem)) {
            return false;
        }
        Testitem other = (Testitem) object;
        if ((this.testitemPK == null && other.testitemPK != null) || (this.testitemPK != null && !this.testitemPK.equals(other.testitemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Testitem[ testitemPK=" + testitemPK + " ]";
    }
    
}
