/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "SHIPPING_OFFER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShippingOffer.findAll", query = "SELECT s FROM ShippingOffer s")
    , @NamedQuery(name = "ShippingOffer.findByShippingOfferId", query = "SELECT s FROM ShippingOffer s WHERE s.shippingOfferId = :shippingOfferId")
    , @NamedQuery(name = "ShippingOffer.findByShippingOfferName", query = "SELECT s FROM ShippingOffer s WHERE s.shippingOfferName = :shippingOfferName")
    , @NamedQuery(name = "ShippingOffer.findByShippingOfferDetails", query = "SELECT s FROM ShippingOffer s WHERE s.shippingOfferDetails = :shippingOfferDetails")
    , @NamedQuery(name = "ShippingOffer.findByShippingOfferConditions", query = "SELECT s FROM ShippingOffer s WHERE s.shippingOfferConditions = :shippingOfferConditions")
    , @NamedQuery(name = "ShippingOffer.findByShippingOfferHtPrice", query = "SELECT s FROM ShippingOffer s WHERE s.shippingOfferHtPrice = :shippingOfferHtPrice")
    , @NamedQuery(name = "ShippingOffer.findByShippingOfferPostIt", query = "SELECT s FROM ShippingOffer s WHERE s.shippingOfferPostIt = :shippingOfferPostIt")})
public class ShippingOffer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SHIPPING_OFFER_ID")
    private Long shippingOfferId;
    @Basic(optional = false)
    @Column(name = "SHIPPING_OFFER_NAME")
    private String shippingOfferName;
    @Column(name = "SHIPPING_OFFER_DETAILS")
    private String shippingOfferDetails;
    @Basic(optional = false)
    @Column(name = "SHIPPING_OFFER_CONDITIONS")
    private String shippingOfferConditions;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "SHIPPING_OFFER_HT_PRICE")
    private BigDecimal shippingOfferHtPrice;
    @Column(name = "SHIPPING_OFFER_POST_IT")
    private String shippingOfferPostIt;
    @JoinColumn(name = "CARRIER_ID", referencedColumnName = "CARRIER_ID")
    @ManyToOne(optional = false)
    private Carrier carrierId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shippingOfferId")
    private Collection<Order> order1Collection;

    public ShippingOffer() {
    }

    public ShippingOffer(Long shippingOfferId) {
        this.shippingOfferId = shippingOfferId;
    }

    public ShippingOffer(Long shippingOfferId, String shippingOfferName, String shippingOfferConditions, BigDecimal shippingOfferHtPrice) {
        this.shippingOfferId = shippingOfferId;
        this.shippingOfferName = shippingOfferName;
        this.shippingOfferConditions = shippingOfferConditions;
        this.shippingOfferHtPrice = shippingOfferHtPrice;
    }

    public Long getShippingOfferId() {
        return shippingOfferId;
    }

    public void setShippingOfferId(Long shippingOfferId) {
        this.shippingOfferId = shippingOfferId;
    }

    public String getShippingOfferName() {
        return shippingOfferName;
    }

    public void setShippingOfferName(String shippingOfferName) {
        this.shippingOfferName = shippingOfferName;
    }

    public String getShippingOfferDetails() {
        return shippingOfferDetails;
    }

    public void setShippingOfferDetails(String shippingOfferDetails) {
        this.shippingOfferDetails = shippingOfferDetails;
    }

    public String getShippingOfferConditions() {
        return shippingOfferConditions;
    }

    public void setShippingOfferConditions(String shippingOfferConditions) {
        this.shippingOfferConditions = shippingOfferConditions;
    }

    public BigDecimal getShippingOfferHtPrice() {
        return shippingOfferHtPrice;
    }

    public void setShippingOfferHtPrice(BigDecimal shippingOfferHtPrice) {
        this.shippingOfferHtPrice = shippingOfferHtPrice;
    }

    public String getShippingOfferPostIt() {
        return shippingOfferPostIt;
    }

    public void setShippingOfferPostIt(String shippingOfferPostIt) {
        this.shippingOfferPostIt = shippingOfferPostIt;
    }

    public Carrier getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Carrier carrierId) {
        this.carrierId = carrierId;
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
        hash += (shippingOfferId != null ? shippingOfferId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShippingOffer)) {
            return false;
        }
        ShippingOffer other = (ShippingOffer) object;
        if ((this.shippingOfferId == null && other.shippingOfferId != null) || (this.shippingOfferId != null && !this.shippingOfferId.equals(other.shippingOfferId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bookshop.ShippingOffer[ shippingOfferId=" + shippingOfferId + " ]";
    }
    
}
