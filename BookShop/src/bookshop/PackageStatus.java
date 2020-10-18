/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Charlène
 */
@Entity
@Table(name = "PACKAGE_STATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PackageStatus.findAll", query = "SELECT p FROM PackageStatus p")
    , @NamedQuery(name = "PackageStatus.findByPackageStatusId", query = "SELECT p FROM PackageStatus p WHERE p.packageStatusId = :packageStatusId")
    , @NamedQuery(name = "PackageStatus.findByPackageStatusName", query = "SELECT p FROM PackageStatus p WHERE p.packageStatusName = :packageStatusName")})
public class PackageStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PACKAGE_STATUS_ID")
    private Long packageStatusId;
    @Basic(optional = false)
    @Column(name = "PACKAGE_STATUS_NAME")
    private String packageStatusName;

    public PackageStatus() {
    }

    public PackageStatus(Long packageStatusId) {
        this.packageStatusId = packageStatusId;
    }

    public PackageStatus(Long packageStatusId, String packageStatusName) {
        this.packageStatusId = packageStatusId;
        this.packageStatusName = packageStatusName;
    }

    public Long getPackageStatusId() {
        return packageStatusId;
    }

    public void setPackageStatusId(Long packageStatusId) {
        this.packageStatusId = packageStatusId;
    }

    public String getPackageStatusName() {
        return packageStatusName;
    }

    public void setPackageStatusName(String packageStatusName) {
        this.packageStatusName = packageStatusName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (packageStatusId != null ? packageStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PackageStatus)) {
            return false;
        }
        PackageStatus other = (PackageStatus) object;
        if ((this.packageStatusId == null && other.packageStatusId != null) || (this.packageStatusId != null && !this.packageStatusId.equals(other.packageStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bookshop.PackageStatus[ packageStatusId=" + packageStatusId + " ]";
    }
    
}
