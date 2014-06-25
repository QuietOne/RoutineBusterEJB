/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @NamedQuery(name = "Answered.findByIdClient", query = "SELECT a FROM Answered a WHERE a.answeredPK.idClient = :idClient"),
    @NamedQuery(name = "Answered.findByIdTest", query = "SELECT a FROM Answered a WHERE a.answeredPK.idTest = :idTest"),
    @NamedQuery(name = "Answered.findByIdQuestion", query = "SELECT a FROM Answered a WHERE a.answeredPK.idQuestion = :idQuestion"),
    @NamedQuery(name = "Answered.findByIdItemTest", query = "SELECT a FROM Answered a WHERE a.answeredPK.idItemTest = :idItemTest")})
public class Answered implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AnsweredPK answeredPK;
    @JoinColumn(name = "idQuestion", referencedColumnName = "idQuestion", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Question question;
    @JoinColumn(name = "idItemTest", referencedColumnName = "idItemTest", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Testitem testitem;
    @JoinColumn(name = "idTest", referencedColumnName = "idTest", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Test test;
    @JoinColumn(name = "idClient", referencedColumnName = "idClient", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;

    public Answered() {
    }

    public Answered(AnsweredPK answeredPK) {
        this.answeredPK = answeredPK;
    }

    public Answered(int idClient, int idTest, int idQuestion, int idItemTest) {
        this.answeredPK = new AnsweredPK(idClient, idTest, idQuestion, idItemTest);
    }

    public AnsweredPK getAnsweredPK() {
        return answeredPK;
    }

    public void setAnsweredPK(AnsweredPK answeredPK) {
        this.answeredPK = answeredPK;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Testitem getTestitem() {
        return testitem;
    }

    public void setTestitem(Testitem testitem) {
        this.testitem = testitem;
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
        hash += (answeredPK != null ? answeredPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Answered)) {
            return false;
        }
        Answered other = (Answered) object;
        if ((this.answeredPK == null && other.answeredPK != null) || (this.answeredPK != null && !this.answeredPK.equals(other.answeredPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Answered[ answeredPK=" + answeredPK + " ]";
    }
    
}
