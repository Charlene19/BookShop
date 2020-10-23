/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Charlène
 */
@Entity
@Table(name = "PAYMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p")
    , @NamedQuery(name = "Payment.findByPaymentId", query = "SELECT p FROM Payment p WHERE p.paymentPK.paymentId = :paymentId")
    , @NamedQuery(name = "Payment.findByPaymentSubId", query = "SELECT p FROM Payment p WHERE p.paymentPK.paymentSubId = :paymentSubId")
    , @NamedQuery(name = "Payment.findByAssocPaymentOrderDate", query = "SELECT p FROM Payment p WHERE p.assocPaymentOrderDate = :assocPaymentOrderDate")
    , @NamedQuery(name = "Payment.findByAssocPaymentOrderPostIt", query = "SELECT p FROM Payment p WHERE p.assocPaymentOrderPostIt = :assocPaymentOrderPostIt")})
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PaymentPK paymentPK;
    @Basic(optional = false)
    @Column(name = "ASSOC_PAYMENT_ORDER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assocPaymentOrderDate;
    @Column(name = "ASSOC_PAYMENT_ORDER_POST_IT")
    private String assocPaymentOrderPostIt;
    @JoinColumn(name = "CARD_TYPE_ID", referencedColumnName = "CARD_TYPE_ID")
    @ManyToOne(optional = false)
    private CardType cardTypeId;
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")
    @ManyToOne(optional = false)
    private Order1 orderId;

    public Payment() {
    }

    public Payment(PaymentPK paymentPK) {
        this.paymentPK = paymentPK;
    }

    public Payment(PaymentPK paymentPK, Date assocPaymentOrderDate) {
        this.paymentPK = paymentPK;
        this.assocPaymentOrderDate = assocPaymentOrderDate;
    }

    public Payment(long paymentId, String paymentSubId) {
        this.paymentPK = new PaymentPK(paymentId, paymentSubId);
    }

    public PaymentPK getPaymentPK() {
        return paymentPK;
    }

    public void setPaymentPK(PaymentPK paymentPK) {
        this.paymentPK = paymentPK;
    }

    public Date getAssocPaymentOrderDate() {
        return assocPaymentOrderDate;
    }

    public void setAssocPaymentOrderDate(Date assocPaymentOrderDate) {
        this.assocPaymentOrderDate = assocPaymentOrderDate;
    }

    public String getAssocPaymentOrderPostIt() {
        return assocPaymentOrderPostIt;
    }

    public void setAssocPaymentOrderPostIt(String assocPaymentOrderPostIt) {
        this.assocPaymentOrderPostIt = assocPaymentOrderPostIt;
    }

    public CardType getCardTypeId() {
        return cardTypeId;
    }

    public void setCardTypeId(CardType cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public Order1 getOrderId() {
        return orderId;
    }

    public void setOrderId(Order1 orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentPK != null ? paymentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.paymentPK == null && other.paymentPK != null) || (this.paymentPK != null && !this.paymentPK.equals(other.paymentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bookshop.Payment[ paymentPK=" + paymentPK + " ]";
    }
    
}
