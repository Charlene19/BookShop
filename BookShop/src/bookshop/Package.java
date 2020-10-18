/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Charlène
 */
@Entity
@Table(name = "PACKAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Package.findAll", query = "SELECT p FROM Package p")
    , @NamedQuery(name = "Package.findByPackageId", query = "SELECT p FROM Package p WHERE p.packageId = :packageId")
    , @NamedQuery(name = "Package.findByPackageTrackingNumber", query = "SELECT p FROM Package p WHERE p.packageTrackingNumber = :packageTrackingNumber")
    , @NamedQuery(name = "Package.findByPackageShippingDate", query = "SELECT p FROM Package p WHERE p.packageShippingDate = :packageShippingDate")
    , @NamedQuery(name = "Package.findByPackagePostIt", query = "SELECT p FROM Package p WHERE p.packagePostIt = :packagePostIt")})
public class Package implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PACKAGE_ID")
    private Long packageId;
    @Basic(optional = false)
    @Column(name = "PACKAGE_TRACKING_NUMBER")
    private String packageTrackingNumber;
    @Basic(optional = false)
    @Column(name = "PACKAGE_SHIPPING_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date packageShippingDate;
    @Column(name = "PACKAGE_POST_IT")
    private String packagePostIt;
    @JoinTable(name = "ASSOC_ORDER_PACKAGE", joinColumns = {
        @JoinColumn(name = "PACKAGE_ID", referencedColumnName = "PACKAGE_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")})
    @ManyToMany
    private Collection<Order1> order1Collection;

    public Package() {
    }

    public Package(Long packageId) {
        this.packageId = packageId;
    }

    public Package(Long packageId, String packageTrackingNumber, Date packageShippingDate) {
        this.packageId = packageId;
        this.packageTrackingNumber = packageTrackingNumber;
        this.packageShippingDate = packageShippingDate;
    }

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public String getPackageTrackingNumber() {
        return packageTrackingNumber;
    }

    public void setPackageTrackingNumber(String packageTrackingNumber) {
        this.packageTrackingNumber = packageTrackingNumber;
    }

    public Date getPackageShippingDate() {
        return packageShippingDate;
    }

    public void setPackageShippingDate(Date packageShippingDate) {
        this.packageShippingDate = packageShippingDate;
    }

    public String getPackagePostIt() {
        return packagePostIt;
    }

    public void setPackagePostIt(String packagePostIt) {
        this.packagePostIt = packagePostIt;
    }

    @XmlTransient
    public Collection<Order1> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order1> order1Collection) {
        this.order1Collection = order1Collection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (packageId != null ? packageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Package)) {
            return false;
        }
        Package other = (Package) object;
        if ((this.packageId == null && other.packageId != null) || (this.packageId != null && !this.packageId.equals(other.packageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bookshop.Package[ packageId=" + packageId + " ]";
    }
    
}
