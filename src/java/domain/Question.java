package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "question")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
    @NamedQuery(name = "Question.findByIdQuestion", query = "SELECT q FROM Question q WHERE q.idQuestion = :idQuestion"),
    @NamedQuery(name = "Question.findByText", query = "SELECT q FROM Question q WHERE q.text = :text"),
    @NamedQuery(name = "Question.findByApproved", query = "SELECT q FROM Question q WHERE q.approved = :approved"),
    @NamedQuery(name = "Question.findByDeleted", query = "SELECT q FROM Question q WHERE q.deleted = :deleted")})
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idQuestion")
    private Integer idQuestion;
    @Size(max = 1000)
    @Column(name = "text")
    private String text;
    @Column(name = "approved")
    private Boolean approved;
    @Column(name = "deleted")
    private Boolean deleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question", fetch = FetchType.LAZY)
    private List<Answeritem> answeritemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question", fetch = FetchType.LAZY)
    private List<Answer> answerList;
    @JoinColumn(name = "idCat", referencedColumnName = "idCat")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category idCat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question", fetch = FetchType.LAZY)
    private List<Testitem> testitemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question", fetch = FetchType.LAZY)
    private List<Answered> answeredList;

    public Question() {
    }

    public Question(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Integer getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @XmlTransient
    public List<Answeritem> getAnsweritemList() {
        return answeritemList;
    }

    public void setAnsweritemList(List<Answeritem> answeritemList) {
        this.answeritemList = answeritemList;
    }

    @XmlTransient
    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public Category getIdCat() {
        return idCat;
    }

    public void setIdCat(Category idCat) {
        this.idCat = idCat;
    }

    @XmlTransient
    public List<Testitem> getTestitemList() {
        return testitemList;
    }

    public void setTestitemList(List<Testitem> testitemList) {
        this.testitemList = testitemList;
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
        hash += (idQuestion != null ? idQuestion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.idQuestion == null && other.idQuestion != null) || (this.idQuestion != null && !this.idQuestion.equals(other.idQuestion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Question[ idQuestion=" + idQuestion + " ]";
    }
    
}
