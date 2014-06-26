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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tihomir Radosavljvic
 * @version 1.0
 */
@Entity
@Table(name = "test")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t"),
    @NamedQuery(name = "Test.findByIdTest", query = "SELECT t FROM Test t WHERE t.idTest = :idTest")})
public class Test implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTest")
    private Integer idTest;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "test", fetch = FetchType.LAZY)
    private List<Result> resultList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "test", fetch = FetchType.LAZY)
    private List<Answeritem> answeritemList;
    @JoinColumn(name = "idCat", referencedColumnName = "idCat")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Category idCat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "test", fetch = FetchType.LAZY)
    private List<Testitem> testitemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "test", fetch = FetchType.LAZY)
    private List<Answered> answeredList;

    public Test() {
    }

    public Test(Integer idTest) {
        this.idTest = idTest;
    }

    public Integer getIdTest() {
        return idTest;
    }

    public void setIdTest(Integer idTest) {
        this.idTest = idTest;
    }

    @XmlTransient
    public List<Result> getResultList() {
        return resultList;
    }

    public void setResultList(List<Result> resultList) {
        this.resultList = resultList;
    }

    @XmlTransient
    public List<Answeritem> getAnsweritemList() {
        return answeritemList;
    }

    public void setAnsweritemList(List<Answeritem> answeritemList) {
        this.answeritemList = answeritemList;
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
        hash += (idTest != null ? idTest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Test)) {
            return false;
        }
        Test other = (Test) object;
        if ((this.idTest == null && other.idTest != null) || (this.idTest != null && !this.idTest.equals(other.idTest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Test[ idTest=" + idTest + " ]";
    }
    
}
