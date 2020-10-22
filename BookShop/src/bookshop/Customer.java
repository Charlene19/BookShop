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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findByCustomerId", query = "SELECT c FROM Customer c WHERE c.customerId = :customerId")
    , @NamedQuery(name = "Customer.findByCustomerLName", query = "SELECT c FROM Customer c WHERE c.customerLName = :customerLName")
    , @NamedQuery(name = "Customer.findByCustomerFName", query = "SELECT c FROM Customer c WHERE c.customerFName = :customerFName")
    , @NamedQuery(name = "Customer.findByCustomerEmail", query = "SELECT c FROM Customer c WHERE c.customerEmail = :customerEmail")
    , @NamedQuery(name = "Customer.findByCustomerUsername", query = "SELECT c FROM Customer c WHERE c.customerUsername = :customerUsername")
    , @NamedQuery(name = "Customer.findByCustomerPassword", query = "SELECT c FROM Customer c WHERE c.customerPassword = :customerPassword")
    , @NamedQuery(name = "Customer.findByCustomerPostIt", query = "SELECT c FROM Customer c WHERE c.customerPostIt = :customerPostIt")
    , @NamedQuery(name = "Customer.findByClientDate", query = "SELECT c FROM Customer c WHERE c.clientDate = :clientDate")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CUSTOMER_ID")
    private Long customerId;
    @Basic(optional = false)
    @Column(name = "CUSTOMER_L_NAME")
    private String customerLName;
    @Basic(optional = false)
    @Column(name = "CUSTOMER_F_NAME")
    private String customerFName;
    @Basic(optional = false)
    @Column(name = "CUSTOMER_EMAIL")
    private String customerEmail;
    @Column(name = "CUSTOMER_USERNAME")
    private String customerUsername;
    @Basic(optional = false)
    @Column(name = "CUSTOMER_PASSWORD")
    private String customerPassword;
    @Column(name = "CUSTOMER_POST_IT")
    private String customerPostIt;
    @Column(name = "CLIENT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date clientDate;
    @ManyToMany(mappedBy = "customerCollection")
    private Collection<Address> addressCollection;
    @ManyToMany(mappedBy = "customerCollection1")
    private Collection<Address> addressCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private Collection<Comment> commentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private Collection<Order> order1Collection;

    public Customer() {
    }

    public Customer(Long customerId) {
        this.customerId = customerId;
    }

    public Customer(Long customerId, String customerLName, String customerFName, String customerEmail, String customerPassword) {
        this.customerId = customerId;
        this.customerLName = customerLName;
        this.customerFName = customerFName;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerLName() {
        return customerLName;
    }

    public void setCustomerLName(String customerLName) {
        this.customerLName = customerLName;
    }

    public String getCustomerFName() {
        return customerFName;
    }

    public void setCustomerFName(String customerFName) {
        this.customerFName = customerFName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerPostIt() {
        return customerPostIt;
    }

    public void setCustomerPostIt(String customerPostIt) {
        this.customerPostIt = customerPostIt;
    }

    public Date getClientDate() {
        return clientDate;
    }

    public void setClientDate(Date clientDate) {
        this.clientDate = clientDate;
    }

    @XmlTransient
    public Collection<Address> getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(Collection<Address> addressCollection) {
        this.addressCollection = addressCollection;
    }

    @XmlTransient
    public Collection<Address> getAddressCollection1() {
        return addressCollection1;
    }

    public void setAddressCollection1(Collection<Address> addressCollection1) {
        this.addressCollection1 = addressCollection1;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @XmlTransient
    public Collection<Order> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order> order1Collection) {
        this.order1Collection = order1Collection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bookshop.Customer[ customerId=" + customerId + " ]";
    }
    
}
