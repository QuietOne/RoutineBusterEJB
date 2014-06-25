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
@Table(name = "answeritem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Answeritem.findAll", query = "SELECT a FROM Answeritem a"),
    @NamedQuery(name = "Answeritem.findByIdTest", query = "SELECT a FROM Answeritem a WHERE a.answeritemPK.idTest = :idTest"),
    @NamedQuery(name = "Answeritem.findByIdQuestion", query = "SELECT a FROM Answeritem a WHERE a.answeritemPK.idQuestion = :idQuestion"),
    @NamedQuery(name = "Answeritem.findByIdItemTest", query = "SELECT a FROM Answeritem a WHERE a.answeritemPK.idItemTest = :idItemTest"),
    @NamedQuery(name = "Answeritem.findByIdAnswer", query = "SELECT a FROM Answeritem a WHERE a.answeritemPK.idAnswer = :idAnswer")})
public class Answeritem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AnsweritemPK answeritemPK;
    @JoinColumn(name = "idQuestion", referencedColumnName = "idQuestion", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Question question;
    @JoinColumn(name = "idAnswer", referencedColumnName = "idAnswer", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Answer answer;
    @JoinColumn(name = "idItemTest", referencedColumnName = "idItemTest", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Testitem testitem;
    @JoinColumn(name = "idTest", referencedColumnName = "idTest", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Test test;

    public Answeritem() {
    }

    public Answeritem(AnsweritemPK answeritemPK) {
        this.answeritemPK = answeritemPK;
    }

    public Answeritem(int idTest, int idQuestion, int idItemTest, int idAnswer) {
        this.answeritemPK = new AnsweritemPK(idTest, idQuestion, idItemTest, idAnswer);
    }

    public AnsweritemPK getAnsweritemPK() {
        return answeritemPK;
    }

    public void setAnsweritemPK(AnsweritemPK answeritemPK) {
        this.answeritemPK = answeritemPK;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (answeritemPK != null ? answeritemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Answeritem)) {
            return false;
        }
        Answeritem other = (Answeritem) object;
        if ((this.answeritemPK == null && other.answeritemPK != null) || (this.answeritemPK != null && !this.answeritemPK.equals(other.answeritemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Answeritem[ answeritemPK=" + answeritemPK + " ]";
    }
    
}
