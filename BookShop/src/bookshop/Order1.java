/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "ORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o")
    , @NamedQuery(name = "Order1.findByOrderId", query = "SELECT o FROM Order1 o WHERE o.orderId = :orderId")
    , @NamedQuery(name = "Order1.findByOrderCreationDate", query = "SELECT o FROM Order1 o WHERE o.orderCreationDate = :orderCreationDate")
    , @NamedQuery(name = "Order1.findByOrderShippingTimeLimit", query = "SELECT o FROM Order1 o WHERE o.orderShippingTimeLimit = :orderShippingTimeLimit")
    , @NamedQuery(name = "Order1.findByOrderUserIp", query = "SELECT o FROM Order1 o WHERE o.orderUserIp = :orderUserIp")
    , @NamedQuery(name = "Order1.findByOrderComment", query = "SELECT o FROM Order1 o WHERE o.orderComment = :orderComment")
    , @NamedQuery(name = "Order1.findByAssocShippingOfferCommandHtPrice", query = "SELECT o FROM Order1 o WHERE o.assocShippingOfferCommandHtPrice = :assocShippingOfferCommandHtPrice")})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ORDER_ID")
    private Long orderId;
    @Basic(optional = false)
    @Column(name = "ORDER_CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderCreationDate;
    @Basic(optional = false)
    @Column(name = "ORDER_SHIPPING_TIME_LIMIT")
    private String orderShippingTimeLimit;
    @Basic(optional = false)
    @Column(name = "ORDER_USER_IP")
    private String orderUserIp;
    @Column(name = "ORDER_COMMENT")
    private String orderComment;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "ASSOC_SHIPPING_OFFER_COMMAND_HT_PRICE")
    private BigDecimal assocShippingOfferCommandHtPrice;
    @ManyToMany(mappedBy = "order1Collection")
    private Collection<Package> packageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private Collection<Payment> paymentCollection;
    @JoinColumn(name = "DELIVERY_ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    @ManyToOne(optional = false)
    private Address deliveryAddressId;
    @JoinColumn(name = "BILLING_ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    @ManyToOne(optional = false)
    private Address billingAddressId;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    @ManyToOne(optional = false)
    private Customer customerId;
    @JoinColumn(name = "SHIPPING_OFFER_ID", referencedColumnName = "SHIPPING_OFFER_ID")
    @ManyToOne(optional = false)
    private ShippingOffer shippingOfferId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private Collection<OrderRow> orderRowCollection;

    public Order1() {
    }

    public Order1(Long orderId) {
        this.orderId = orderId;
    }

    public Order1(Long orderId, Date orderCreationDate, String orderShippingTimeLimit, String orderUserIp, BigDecimal assocShippingOfferCommandHtPrice) {
        this.orderId = orderId;
        this.orderCreationDate = orderCreationDate;
        this.orderShippingTimeLimit = orderShippingTimeLimit;
        this.orderUserIp = orderUserIp;
        this.assocShippingOfferCommandHtPrice = assocShippingOfferCommandHtPrice;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderCreationDate() {
        return orderCreationDate;
    }

    public void setOrderCreationDate(Date orderCreationDate) {
        this.orderCreationDate = orderCreationDate;
    }

    public String getOrderShippingTimeLimit() {
        return orderShippingTimeLimit;
    }

    public void setOrderShippingTimeLimit(String orderShippingTimeLimit) {
        this.orderShippingTimeLimit = orderShippingTimeLimit;
    }

    public String getOrderUserIp() {
        return orderUserIp;
    }

    public void setOrderUserIp(String orderUserIp) {
        this.orderUserIp = orderUserIp;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }

    public BigDecimal getAssocShippingOfferCommandHtPrice() {
        return assocShippingOfferCommandHtPrice;
    }

    public void setAssocShippingOfferCommandHtPrice(BigDecimal assocShippingOfferCommandHtPrice) {
        this.assocShippingOfferCommandHtPrice = assocShippingOfferCommandHtPrice;
    }

    @XmlTransient
    public Collection<Package> getPackageCollection() {
        return packageCollection;
    }

    public void setPackageCollection(Collection<Package> packageCollection) {
        this.packageCollection = packageCollection;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    public Address getDeliveryAddressId() {
        return deliveryAddressId;
    }

    public void setDeliveryAddressId(Address deliveryAddressId) {
        this.deliveryAddressId = deliveryAddressId;
    }

    public Address getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(Address billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public ShippingOffer getShippingOfferId() {
        return shippingOfferId;
    }

    public void setShippingOfferId(ShippingOffer shippingOfferId) {
        this.shippingOfferId = shippingOfferId;
    }

    @XmlTransient
    public Collection<OrderRow> getOrderRowCollection() {
        return orderRowCollection;
    }

    public void setOrderRowCollection(Collection<OrderRow> orderRowCollection) {
        this.orderRowCollection = orderRowCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bookshop.Order1[ orderId=" + orderId + " ]";
    }
    
}
