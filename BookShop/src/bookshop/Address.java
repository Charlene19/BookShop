/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Charlène
 */
@Entity
@Table(name = "ADDRESS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
    , @NamedQuery(name = "Address.findByAddressId", query = "SELECT a FROM Address a WHERE a.addressId = :addressId")
    , @NamedQuery(name = "Address.findByAddressCompanyName", query = "SELECT a FROM Address a WHERE a.addressCompanyName = :addressCompanyName")
    , @NamedQuery(name = "Address.findByAddressLName", query = "SELECT a FROM Address a WHERE a.addressLName = :addressLName")
    , @NamedQuery(name = "Address.findByAddressFName", query = "SELECT a FROM Address a WHERE a.addressFName = :addressFName")
    , @NamedQuery(name = "Address.findByAddressStreet", query = "SELECT a FROM Address a WHERE a.addressStreet = :addressStreet")
    , @NamedQuery(name = "Address.findByAddressStreetExtra", query = "SELECT a FROM Address a WHERE a.addressStreetExtra = :addressStreetExtra")
    , @NamedQuery(name = "Address.findByAddressPostcode", query = "SELECT a FROM Address a WHERE a.addressPostcode = :addressPostcode")
    , @NamedQuery(name = "Address.findByAddressCity", query = "SELECT a FROM Address a WHERE a.addressCity = :addressCity")
    , @NamedQuery(name = "Address.findByAddressPhone", query = "SELECT a FROM Address a WHERE a.addressPhone = :addressPhone")
    , @NamedQuery(name = "Address.findByAddressPhoneExtra", query = "SELECT a FROM Address a WHERE a.addressPhoneExtra = :addressPhoneExtra")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ADDRESS_ID")
    private Long addressId;
    @Column(name = "ADDRESS_COMPANY_NAME")
    private String addressCompanyName;
    @Column(name = "ADDRESS_L_NAME")
    private String addressLName;
    @Column(name = "ADDRESS_F_NAME")
    private String addressFName;
    @Basic(optional = false)
    @Column(name = "ADDRESS_STREET")
    private String addressStreet;
    @Column(name = "ADDRESS_STREET_EXTRA")
    private String addressStreetExtra;
    @Basic(optional = false)
    @Column(name = "ADDRESS_POSTCODE")
    private String addressPostcode;
    @Basic(optional = false)
    @Column(name = "ADDRESS_CITY")
    private String addressCity;
    @Column(name = "ADDRESS_PHONE")
    private String addressPhone;
    @Column(name = "ADDRESS_PHONE_EXTRA")
    private String addressPhoneExtra;
    @JoinTable(name = "ASSOC_CUSTOMER_BILLING_ADDRESS", joinColumns = {
        @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")})
    @ManyToMany
    private Collection<Customer> customerCollection;
    @JoinTable(name = "ASSOC_ADDRESS_PUBLISHER", joinColumns = {
        @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "PUBLISHER_ID", referencedColumnName = "PUBLISHER_ID")})
    @ManyToMany
    private Collection<Publisher> publisherCollection;
    @JoinTable(name = "ASSOC_CUSTOMER_DELIVERY_ADDRESS", joinColumns = {
        @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")})
    @ManyToMany
    private Collection<Customer> customerCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressId")
    private Collection<Carrier> carrierCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryAddressId")
    private Collection<Order1> order1Collection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billingAddressId")
    private Collection<Order1> order1Collection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressId")
    private Collection<PaymentOrganization> paymentOrganizationCollection;

    public Address() {
    }

    public Address(Long addressId) {
        this.addressId = addressId;
    }

    public Address(Long addressId, String addressStreet, String addressPostcode, String addressCity) {
        this.addressId = addressId;
        this.addressStreet = addressStreet;
        this.addressPostcode = addressPostcode;
        this.addressCity = addressCity;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAddressCompanyName() {
        return addressCompanyName;
    }

    public void setAddressCompanyName(String addressCompanyName) {
        this.addressCompanyName = addressCompanyName;
    }

    public String getAddressLName() {
        return addressLName;
    }

    public void setAddressLName(String addressLName) {
        this.addressLName = addressLName;
    }

    public String getAddressFName() {
        return addressFName;
    }

    public void setAddressFName(String addressFName) {
        this.addressFName = addressFName;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressStreetExtra() {
        return addressStreetExtra;
    }

    public void setAddressStreetExtra(String addressStreetExtra) {
        this.addressStreetExtra = addressStreetExtra;
    }

    public String getAddressPostcode() {
        return addressPostcode;
    }

    public void setAddressPostcode(String addressPostcode) {
        this.addressPostcode = addressPostcode;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    public String getAddressPhoneExtra() {
        return addressPhoneExtra;
    }

    public void setAddressPhoneExtra(String addressPhoneExtra) {
        this.addressPhoneExtra = addressPhoneExtra;
    }

    @XmlTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    @XmlTransient
    public Collection<Publisher> getPublisherCollection() {
        return publisherCollection;
    }

    public void setPublisherCollection(Collection<Publisher> publisherCollection) {
        this.publisherCollection = publisherCollection;
    }

    @XmlTransient
    public Collection<Customer> getCustomerCollection1() {
        return customerCollection1;
    }

    public void setCustomerCollection1(Collection<Customer> customerCollection1) {
        this.customerCollection1 = customerCollection1;
    }

    @XmlTransient
    public Collection<Carrier> getCarrierCollection() {
        return carrierCollection;
    }

    public void setCarrierCollection(Collection<Carrier> carrierCollection) {
        this.carrierCollection = carrierCollection;
    }

    @XmlTransient
    public Collection<Order1> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order1> order1Collection) {
        this.order1Collection = order1Collection;
    }

    @XmlTransient
    public Collection<Order1> getOrder1Collection1() {
        return order1Collection1;
    }

    public void setOrder1Collection1(Collection<Order1> order1Collection1) {
        this.order1Collection1 = order1Collection1;
    }

    @XmlTransient
    public Collection<PaymentOrganization> getPaymentOrganizationCollection() {
        return paymentOrganizationCollection;
    }

    public void setPaymentOrganizationCollection(Collection<PaymentOrganization> paymentOrganizationCollection) {
        this.paymentOrganizationCollection = paymentOrganizationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressId != null ? addressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressId == null && other.addressId != null) || (this.addressId != null && !this.addressId.equals(other.addressId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bookshop.Address[ addressId=" + addressId + " ]";
    }
    
}
