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
@Table(name = "CARD_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CardType.findAll", query = "SELECT c FROM CardType c")
    , @NamedQuery(name = "CardType.findByCardTypeId", query = "SELECT c FROM CardType c WHERE c.cardTypeId = :cardTypeId")
    , @NamedQuery(name = "CardType.findByCardTypeName", query = "SELECT c FROM CardType c WHERE c.cardTypeName = :cardTypeName")
    , @NamedQuery(name = "CardType.findByCardTypeLogoUrl", query = "SELECT c FROM CardType c WHERE c.cardTypeLogoUrl = :cardTypeLogoUrl")})
public class CardType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CARD_TYPE_ID")
    private Long cardTypeId;
    @Basic(optional = false)
    @Column(name = "CARD_TYPE_NAME")
    private String cardTypeName;
    @Basic(optional = false)
    @Column(name = "CARD_TYPE_LOGO_URL")
    private String cardTypeLogoUrl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cardTypeId")
    private Collection<Payment> paymentCollection;
    @JoinColumn(name = "PAYMENT_ORGANIZATION_ID", referencedColumnName = "PAYMENT_ORGANIZATION_ID")
    @ManyToOne(optional = false)
    private PaymentOrganization paymentOrganizationId;

    public CardType() {
    }

    public CardType(Long cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public CardType(Long cardTypeId, String cardTypeName, String cardTypeLogoUrl) {
        this.cardTypeId = cardTypeId;
        this.cardTypeName = cardTypeName;
        this.cardTypeLogoUrl = cardTypeLogoUrl;
    }

    public Long getCardTypeId() {
        return cardTypeId;
    }

    public void setCardTypeId(Long cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public String getCardTypeName() {
        return cardTypeName;
    }

    public void setCardTypeName(String cardTypeName) {
        this.cardTypeName = cardTypeName;
    }

    public String getCardTypeLogoUrl() {
        return cardTypeLogoUrl;
    }

    public void setCardTypeLogoUrl(String cardTypeLogoUrl) {
        this.cardTypeLogoUrl = cardTypeLogoUrl;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    public PaymentOrganization getPaymentOrganizationId() {
        return paymentOrganizationId;
    }

    public void setPaymentOrganizationId(PaymentOrganization paymentOrganizationId) {
        this.paymentOrganizationId = paymentOrganizationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cardTypeId != null ? cardTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CardType)) {
            return false;
        }
        CardType other = (CardType) object;
        if ((this.cardTypeId == null && other.cardTypeId != null) || (this.cardTypeId != null && !this.cardTypeId.equals(other.cardTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bookshop.CardType[ cardTypeId=" + cardTypeId + " ]";
    }
    
}
