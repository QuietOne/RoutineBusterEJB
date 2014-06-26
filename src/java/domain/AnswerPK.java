package domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Tihomir Radosavljvic
 * @version 1.0
 */
@Embeddable
public class AnswerPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idAnswer")
    private int idAnswer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idQuestion")
    private int idQuestion;

    public AnswerPK() {
    }

    public AnswerPK(int idAnswer, int idQuestion) {
        this.idAnswer = idAnswer;
        this.idQuestion = idQuestion;
    }

    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAnswer;
        hash += (int) idQuestion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnswerPK)) {
            return false;
        }
        AnswerPK other = (AnswerPK) object;
        if (this.idAnswer != other.idAnswer) {
            return false;
        }
        if (this.idQuestion != other.idQuestion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.AnswerPK[ idAnswer=" + idAnswer + ", idQuestion=" + idQuestion + " ]";
    }
    
}
