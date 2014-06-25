/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author tihomir
 */
@Embeddable
public class AnsweritemPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTest")
    private int idTest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idQuestion")
    private int idQuestion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idItemTest")
    private int idItemTest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAnswer")
    private int idAnswer;

    public AnsweritemPK() {
    }

    public AnsweritemPK(int idTest, int idQuestion, int idItemTest, int idAnswer) {
        this.idTest = idTest;
        this.idQuestion = idQuestion;
        this.idItemTest = idItemTest;
        this.idAnswer = idAnswer;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public int getIdItemTest() {
        return idItemTest;
    }

    public void setIdItemTest(int idItemTest) {
        this.idItemTest = idItemTest;
    }

    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTest;
        hash += (int) idQuestion;
        hash += (int) idItemTest;
        hash += (int) idAnswer;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnsweritemPK)) {
            return false;
        }
        AnsweritemPK other = (AnsweritemPK) object;
        if (this.idTest != other.idTest) {
            return false;
        }
        if (this.idQuestion != other.idQuestion) {
            return false;
        }
        if (this.idItemTest != other.idItemTest) {
            return false;
        }
        if (this.idAnswer != other.idAnswer) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.AnsweritemPK[ idTest=" + idTest + ", idQuestion=" + idQuestion + ", idItemTest=" + idItemTest + ", idAnswer=" + idAnswer + " ]";
    }
    
}
