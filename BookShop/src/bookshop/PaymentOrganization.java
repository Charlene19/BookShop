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
import javax.persistence.ManyToOne;
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
@Table(name = "PAYMENT_ORGANIZATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentOrganization.findAll", query = "SELECT p FROM PaymentOrganization p")
    , @NamedQuery(name = "PaymentOrganization.findByPaymentOrganizationId", query = "SELECT p FROM PaymentOrganization p WHERE p.paymentOrganizationId = :paymentOrganizationId")
    , @NamedQuery(name = "PaymentOrganization.findByPaymentOrganizationName", query = "SELECT p FROM PaymentOrganization p WHERE p.paymentOrganizationName = :paymentOrganizationName")})
public class PaymentOrganization implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PAYMENT_ORGANIZATION_ID")
    private Long paymentOrganizationId;
    @Basic(optional = false)
    @Column(name = "PAYMENT_ORGANIZATION_NAME")
    private String paymentOrganizationName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentOrganizationId")
    private Collection<CardType> cardTypeCollection;
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    @ManyToOne(optional = false)
    private Address addressId;

    public PaymentOrganization() {
    }

    public PaymentOrganization(Long paymentOrganizationId) {
        this.paymentOrganizationId = paymentOrganizationId;
    }

    public PaymentOrganization(Long paymentOrganizationId, String paymentOrganizationName) {
        this.paymentOrganizationId = paymentOrganizationId;
        this.paymentOrganizationName = paymentOrganizationName;
    }

    public Long getPaymentOrganizationId() {
        return paymentOrganizationId;
    }

    public void setPaymentOrganizationId(Long paymentOrganizationId) {
        this.paymentOrganizationId = paymentOrganizationId;
    }

    public String getPaymentOrganizationName() {
        return paymentOrganizationName;
    }

    public void setPaymentOrganizationName(String paymentOrganizationName) {
        this.paymentOrganizationName = paymentOrganizationName;
    }

    @XmlTransient
    public Collection<CardType> getCardTypeCollection() {
        return cardTypeCollection;
    }

    public void setCardTypeCollection(Collection<CardType> cardTypeCollection) {
        this.cardTypeCollection = cardTypeCollection;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentOrganizationId != null ? paymentOrganizationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentOrganization)) {
            return false;
        }
        PaymentOrganization other = (PaymentOrganization) object;
        if ((this.paymentOrganizationId == null && other.paymentOrganizationId != null) || (this.paymentOrganizationId != null && !this.paymentOrganizationId.equals(other.paymentOrganizationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bookshop.PaymentOrganization[ paymentOrganizationId=" + paymentOrganizationId + " ]";
    }
    
}
