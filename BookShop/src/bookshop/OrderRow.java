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
@Table(name = "ORDER_ROW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderRow.findAll", query = "SELECT o FROM OrderRow o")
    , @NamedQuery(name = "OrderRow.findByOrderRowId", query = "SELECT o FROM OrderRow o WHERE o.orderRowId = :orderRowId")
    , @NamedQuery(name = "OrderRow.findByOrderRowQty", query = "SELECT o FROM OrderRow o WHERE o.orderRowQty = :orderRowQty")
    , @NamedQuery(name = "OrderRow.findByOrderRowHtPrice", query = "SELECT o FROM OrderRow o WHERE o.orderRowHtPrice = :orderRowHtPrice")
    , @NamedQuery(name = "OrderRow.findByOrderRowDiscountValue", query = "SELECT o FROM OrderRow o WHERE o.orderRowDiscountValue = :orderRowDiscountValue")})
public class OrderRow implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ORDER_ROW_ID")
    private Long orderRowId;
    @Basic(optional = false)
    @Column(name = "ORDER_ROW_QTY")
    private int orderRowQty;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "ORDER_ROW_HT_PRICE")
    private BigDecimal orderRowHtPrice;
    @Column(name = "ORDER_ROW_DISCOUNT_VALUE")
    private BigDecimal orderRowDiscountValue;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderRowId")
    private Collection<Comment> commentCollection;
    @JoinColumn(name = "BOOK_ISBN", referencedColumnName = "BOOK_ISBN")
    @ManyToOne(optional = false)
    private Book bookIsbn;
    @JoinColumn(name = "COMMENT_ID", referencedColumnName = "COMMENT_ID")
    @ManyToOne
    private Comment commentId;
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")
    @ManyToOne(optional = false)
    private Order1 orderId;

    public OrderRow() {
    }

    public OrderRow(Long orderRowId) {
        this.orderRowId = orderRowId;
    }

    public OrderRow(Long orderRowId, int orderRowQty, BigDecimal orderRowHtPrice) {
        this.orderRowId = orderRowId;
        this.orderRowQty = orderRowQty;
        this.orderRowHtPrice = orderRowHtPrice;
    }

    public Long getOrderRowId() {
        return orderRowId;
    }

    public void setOrderRowId(Long orderRowId) {
        this.orderRowId = orderRowId;
    }

    public int getOrderRowQty() {
        return orderRowQty;
    }

    public void setOrderRowQty(int orderRowQty) {
        this.orderRowQty = orderRowQty;
    }

    public BigDecimal getOrderRowHtPrice() {
        return orderRowHtPrice;
    }

    public void setOrderRowHtPrice(BigDecimal orderRowHtPrice) {
        this.orderRowHtPrice = orderRowHtPrice;
    }

    public BigDecimal getOrderRowDiscountValue() {
        return orderRowDiscountValue;
    }

    public void setOrderRowDiscountValue(BigDecimal orderRowDiscountValue) {
        this.orderRowDiscountValue = orderRowDiscountValue;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    public Book getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(Book bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public Comment getCommentId() {
        return commentId;
    }

    public void setCommentId(Comment commentId) {
        this.commentId = commentId;
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
        hash += (orderRowId != null ? orderRowId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderRow)) {
            return false;
        }
        OrderRow other = (OrderRow) object;
        if ((this.orderRowId == null && other.orderRowId != null) || (this.orderRowId != null && !this.orderRowId.equals(other.orderRowId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bookshop.OrderRow[ orderRowId=" + orderRowId + " ]";
    }
    
}
