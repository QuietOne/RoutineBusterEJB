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
public class ResultPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idClient")
    private int idClient;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTest")
    private int idTest;

    public ResultPK() {
    }

    public ResultPK(int idClient, int idTest) {
        this.idClient = idClient;
        this.idTest = idTest;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idClient;
        hash += (int) idTest;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResultPK)) {
            return false;
        }
        ResultPK other = (ResultPK) object;
        if (this.idClient != other.idClient) {
            return false;
        }
        if (this.idTest != other.idTest) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.ResultPK[ idClient=" + idClient + ", idTest=" + idTest + " ]";
    }
    
}
