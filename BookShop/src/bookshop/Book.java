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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "BOOK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b")
    , @NamedQuery(name = "Book.findByBookIsbn", query = "SELECT b FROM Book b WHERE b.bookIsbn = :bookIsbn")
    , @NamedQuery(name = "Book.findByBookTitle", query = "SELECT b FROM Book b WHERE b.bookTitle = :bookTitle")
    , @NamedQuery(name = "Book.findByBookSubtitle", query = "SELECT b FROM Book b WHERE b.bookSubtitle = :bookSubtitle")
    , @NamedQuery(name = "Book.findByBookHtPrice", query = "SELECT b FROM Book b WHERE b.bookHtPrice = :bookHtPrice")
    , @NamedQuery(name = "Book.findByBookCoverUrl", query = "SELECT b FROM Book b WHERE b.bookCoverUrl = :bookCoverUrl")
    , @NamedQuery(name = "Book.findByBookSummary", query = "SELECT b FROM Book b WHERE b.bookSummary = :bookSummary")
    , @NamedQuery(name = "Book.findByBookStockQty", query = "SELECT b FROM Book b WHERE b.bookStockQty = :bookStockQty")
    , @NamedQuery(name = "Book.findByBookShelf", query = "SELECT b FROM Book b WHERE b.bookShelf = :bookShelf")
    , @NamedQuery(name = "Book.findByBookPostIt", query = "SELECT b FROM Book b WHERE b.bookPostIt = :bookPostIt")})
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BOOK_ISBN")
    private String bookIsbn;
    @Basic(optional = false)
    @Column(name = "BOOK_TITLE")
    private String bookTitle;
    @Column(name = "BOOK_SUBTITLE")
    private String bookSubtitle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "BOOK_HT_PRICE")
    private BigDecimal bookHtPrice;
    @Basic(optional = false)
    @Column(name = "BOOK_COVER_URL")
    private String bookCoverUrl;
    @Column(name = "BOOK_SUMMARY")
    private String bookSummary;
    @Basic(optional = false)
    @Column(name = "BOOK_STOCK_QTY")
    private int bookStockQty;
    @Basic(optional = false)
    @Column(name = "BOOK_SHELF")
    private String bookShelf;
    @Column(name = "BOOK_POST_IT")
    private String bookPostIt;
    @JoinTable(name = "ASSOC_BOOK_EVENT", joinColumns = {
        @JoinColumn(name = "BOOK_ISBN", referencedColumnName = "BOOK_ISBN")}, inverseJoinColumns = {
        @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID")})
    @ManyToMany
    private Collection<Event> eventCollection;
    @JoinTable(name = "ASSOC_BOOK_AUTHOR", joinColumns = {
        @JoinColumn(name = "BOOK_ISBN", referencedColumnName = "BOOK_ISBN")}, inverseJoinColumns = {
        @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "AUTHOR_ID")})
    @ManyToMany
    private Collection<Author> authorCollection;
    @JoinTable(name = "ASSOC_BOOK_KEYWORD", joinColumns = {
        @JoinColumn(name = "BOOK_ISBN", referencedColumnName = "BOOK_ISBN")}, inverseJoinColumns = {
        @JoinColumn(name = "KEYWORD_ID", referencedColumnName = "KEYWORD_ID")})
    @ManyToMany
    private Collection<Keyword> keywordCollection;
    @ManyToMany(mappedBy = "bookCollection")
    private Collection<Category> categoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookIsbn")
    private Collection<Comment> commentCollection;
    @JoinColumn(name = "PUBLISHER_ID", referencedColumnName = "PUBLISHER_ID")
    @ManyToOne(optional = false)
    private Publisher publisherId;
    @JoinColumn(name = "VAT_ID", referencedColumnName = "VAT_ID")
    @ManyToOne(optional = false)
    private Vat vatId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookIsbn")
    private Collection<OrderRow> orderRowCollection;

    public Book() {
    }

    public Book(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public Book(String bookIsbn, String bookTitle, BigDecimal bookHtPrice, String bookCoverUrl, int bookStockQty, String bookShelf) {
        this.bookIsbn = bookIsbn;
        this.bookTitle = bookTitle;
        this.bookHtPrice = bookHtPrice;
        this.bookCoverUrl = bookCoverUrl;
        this.bookStockQty = bookStockQty;
        this.bookShelf = bookShelf;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookSubtitle() {
        return bookSubtitle;
    }

    public void setBookSubtitle(String bookSubtitle) {
        this.bookSubtitle = bookSubtitle;
    }

    public BigDecimal getBookHtPrice() {
        return bookHtPrice;
    }

    public void setBookHtPrice(BigDecimal bookHtPrice) {
        this.bookHtPrice = bookHtPrice;
    }

    public String getBookCoverUrl() {
        return bookCoverUrl;
    }

    public void setBookCoverUrl(String bookCoverUrl) {
        this.bookCoverUrl = bookCoverUrl;
    }

    public String getBookSummary() {
        return bookSummary;
    }

    public void setBookSummary(String bookSummary) {
        this.bookSummary = bookSummary;
    }

    public int getBookStockQty() {
        return bookStockQty;
    }

    public void setBookStockQty(int bookStockQty) {
        this.bookStockQty = bookStockQty;
    }

    public String getBookShelf() {
        return bookShelf;
    }

    public void setBookShelf(String bookShelf) {
        this.bookShelf = bookShelf;
    }

    public String getBookPostIt() {
        return bookPostIt;
    }

    public void setBookPostIt(String bookPostIt) {
        this.bookPostIt = bookPostIt;
    }

    @XmlTransient
    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }

    @XmlTransient
    public Collection<Author> getAuthorCollection() {
        return authorCollection;
    }

    public void setAuthorCollection(Collection<Author> authorCollection) {
        this.authorCollection = authorCollection;
    }

    @XmlTransient
    public Collection<Keyword> getKeywordCollection() {
        return keywordCollection;
    }

    public void setKeywordCollection(Collection<Keyword> keywordCollection) {
        this.keywordCollection = keywordCollection;
    }

    @XmlTransient
    public Collection<Category> getCategoryCollection() {
        return categoryCollection;
    }

    public void setCategoryCollection(Collection<Category> categoryCollection) {
        this.categoryCollection = categoryCollection;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    public Publisher getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Publisher publisherId) {
        this.publisherId = publisherId;
    }

    public Vat getVatId() {
        return vatId;
    }

    public void setVatId(Vat vatId) {
        this.vatId = vatId;
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
        hash += (bookIsbn != null ? bookIsbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.bookIsbn == null && other.bookIsbn != null) || (this.bookIsbn != null && !this.bookIsbn.equals(other.bookIsbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bookshop.Book[ bookIsbn=" + bookIsbn + " ]";
    }
    
}
