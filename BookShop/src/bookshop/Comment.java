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
@Table(name = "COMMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c")
    , @NamedQuery(name = "Comment.findByCommentId", query = "SELECT c FROM Comment c WHERE c.commentId = :commentId")
    , @NamedQuery(name = "Comment.findByCommentTitle", query = "SELECT c FROM Comment c WHERE c.commentTitle = :commentTitle")
    , @NamedQuery(name = "Comment.findByCommentRating", query = "SELECT c FROM Comment c WHERE c.commentRating = :commentRating")
    , @NamedQuery(name = "Comment.findByCommentText", query = "SELECT c FROM Comment c WHERE c.commentText = :commentText")
    , @NamedQuery(name = "Comment.findByCommentDate", query = "SELECT c FROM Comment c WHERE c.commentDate = :commentDate")
    , @NamedQuery(name = "Comment.findByCommentUserIp", query = "SELECT c FROM Comment c WHERE c.commentUserIp = :commentUserIp")
    , @NamedQuery(name = "Comment.findByCommentEditDate", query = "SELECT c FROM Comment c WHERE c.commentEditDate = :commentEditDate")})
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COMMENT_ID")
    private Long commentId;
    @Basic(optional = false)
    @Column(name = "COMMENT_TITLE")
    private String commentTitle;
    @Basic(optional = false)
    @Column(name = "COMMENT_RATING")
    private short commentRating;
    @Basic(optional = false)
    @Column(name = "COMMENT_TEXT")
    private String commentText;
    @Basic(optional = false)
    @Column(name = "COMMENT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentDate;
    @Basic(optional = false)
    @Column(name = "COMMENT_USER_IP")
    private String commentUserIp;
    @Column(name = "COMMENT_EDIT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentEditDate;
    @JoinColumn(name = "BOOK_ISBN", referencedColumnName = "BOOK_ISBN")
    @ManyToOne(optional = false)
    private Book bookIsbn;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    @ManyToOne(optional = false)
    private Customer customerId;
    @JoinColumn(name = "ORDER_ROW_ID", referencedColumnName = "ORDER_ROW_ID")
    @ManyToOne(optional = false)
    private OrderRow orderRowId;
    @OneToMany(mappedBy = "commentId")
    private Collection<OrderRow> orderRowCollection;

    public Comment() {
    }

    public Comment(Long commentId) {
        this.commentId = commentId;
    }

    public Comment(Long commentId, String commentTitle, short commentRating, String commentText, Date commentDate, String commentUserIp) {
        this.commentId = commentId;
        this.commentTitle = commentTitle;
        this.commentRating = commentRating;
        this.commentText = commentText;
        this.commentDate = commentDate;
        this.commentUserIp = commentUserIp;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getCommentTitle() {
        return commentTitle;
    }

    public void setCommentTitle(String commentTitle) {
        this.commentTitle = commentTitle;
    }

    public short getCommentRating() {
        return commentRating;
    }

    public void setCommentRating(short commentRating) {
        this.commentRating = commentRating;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentUserIp() {
        return commentUserIp;
    }

    public void setCommentUserIp(String commentUserIp) {
        this.commentUserIp = commentUserIp;
    }

    public Date getCommentEditDate() {
        return commentEditDate;
    }

    public void setCommentEditDate(Date commentEditDate) {
        this.commentEditDate = commentEditDate;
    }

    public Book getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(Book bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public OrderRow getOrderRowId() {
        return orderRowId;
    }

    public void setOrderRowId(OrderRow orderRowId) {
        this.orderRowId = orderRowId;
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
        hash += (commentId != null ? commentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.commentId == null && other.commentId != null) || (this.commentId != null && !this.commentId.equals(other.commentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bookshop.Comment[ commentId=" + commentId + " ]";
    }
    
}
