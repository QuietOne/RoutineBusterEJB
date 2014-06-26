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
public class TestitemPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idItemTest")
    private int idItemTest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTest")
    private int idTest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idQuestion")
    private int idQuestion;

    public TestitemPK() {
    }

    public TestitemPK(int idItemTest, int idTest, int idQuestion) {
        this.idItemTest = idItemTest;
        this.idTest = idTest;
        this.idQuestion = idQuestion;
    }

    public int getIdItemTest() {
        return idItemTest;
    }

    public void setIdItemTest(int idItemTest) {
        this.idItemTest = idItemTest;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idItemTest;
        hash += (int) idTest;
        hash += (int) idQuestion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestitemPK)) {
            return false;
        }
        TestitemPK other = (TestitemPK) object;
        if (this.idItemTest != other.idItemTest) {
            return false;
        }
        if (this.idTest != other.idTest) {
            return false;
        }
        if (this.idQuestion != other.idQuestion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.TestitemPK[ idItemTest=" + idItemTest + ", idTest=" + idTest + ", idQuestion=" + idQuestion + " ]";
    }
    
}
