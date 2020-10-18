/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Charlène
 */
@Embeddable
public class PaymentPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "PAYMENT_ID")
    private long paymentId;
    @Basic(optional = false)
    @Column(name = "PAYMENT_SUB_ID")
    private String paymentSubId;

    public PaymentPK() {
    }

    public PaymentPK(long paymentId, String paymentSubId) {
        this.paymentId = paymentId;
        this.paymentSubId = paymentSubId;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentSubId() {
        return paymentSubId;
    }

    public void setPaymentSubId(String paymentSubId) {
        this.paymentSubId = paymentSubId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) paymentId;
        hash += (paymentSubId != null ? paymentSubId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentPK)) {
            return false;
        }
        PaymentPK other = (PaymentPK) object;
        if (this.paymentId != other.paymentId) {
            return false;
        }
        if ((this.paymentSubId == null && other.paymentSubId != null) || (this.paymentSubId != null && !this.paymentSubId.equals(other.paymentSubId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bookshop.PaymentPK[ paymentId=" + paymentId + ", paymentSubId=" + paymentSubId + " ]";
    }
    
}
