package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tihomir Radosavljvic
 * @version 1.0
 */
@Entity
@Table(name = "answer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Answer.findAll", query = "SELECT a FROM Answer a"),
    @NamedQuery(name = "Answer.findByIdAnswer", query = "SELECT a FROM Answer a WHERE a.answerPK.idAnswer = :idAnswer"),
    @NamedQuery(name = "Answer.findByIdQuestion", query = "SELECT a FROM Answer a WHERE a.answerPK.idQuestion = :idQuestion"),
    @NamedQuery(name = "Answer.findByText", query = "SELECT a FROM Answer a WHERE a.text = :text"),
    @NamedQuery(name = "Answer.findByCorrect", query = "SELECT a FROM Answer a WHERE a.correct = :correct")})
public class Answer implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AnswerPK answerPK;
    @Size(max = 250)
    @Column(name = "text")
    private String text;
    @Column(name = "correct")
    private Boolean correct;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "answer", fetch = FetchType.LAZY)
    private List<Answeritem> answeritemList;
    @JoinColumn(name = "idQuestion", referencedColumnName = "idQuestion", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Question question;

    public Answer() {
    }

    public Answer(AnswerPK answerPK) {
        this.answerPK = answerPK;
    }

    public Answer(int idAnswer, int idQuestion) {
        this.answerPK = new AnswerPK(idAnswer, idQuestion);
    }

    public AnswerPK getAnswerPK() {
        return answerPK;
    }

    public void setAnswerPK(AnswerPK answerPK) {
        this.answerPK = answerPK;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (answerPK != null ? answerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Answer)) {
            return false;
        }
        Answer other = (Answer) object;
        if ((this.answerPK == null && other.answerPK != null) || (this.answerPK != null && !this.answerPK.equals(other.answerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Answer[ answerPK=" + answerPK + " ]";
    }
    
}
