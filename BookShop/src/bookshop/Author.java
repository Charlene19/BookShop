/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Charlène
 */
@Entity
@Table(name = "AUTHOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author a")
    , @NamedQuery(name = "Author.findByAuthorId", query = "SELECT a FROM Author a WHERE a.authorId = :authorId")
    , @NamedQuery(name = "Author.findByAuthorLName", query = "SELECT a FROM Author a WHERE a.authorLName = :authorLName")
    , @NamedQuery(name = "Author.findByAuthorFName", query = "SELECT a FROM Author a WHERE a.authorFName = :authorFName")
    , @NamedQuery(name = "Author.findByAuthorPostIt", query = "SELECT a FROM Author a WHERE a.authorPostIt = :authorPostIt")})
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID")
    private Long authorId;
    @Basic(optional = false)
    @Column(name = "AUTHOR_L_NAME")
    private String authorLName;
    @Column(name = "AUTHOR_F_NAME")
    private String authorFName;
    @Column(name = "AUTHOR_POST_IT")
    private String authorPostIt;
    @ManyToMany(mappedBy = "authorCollection")
    private Collection<Book> bookCollection;

    public Author() {
    }

    public Author(Long authorId) {
        this.authorId = authorId;
    }

    public Author(Long authorId, String authorLName) {
        this.authorId = authorId;
        this.authorLName = authorLName;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorLName() {
        return authorLName;
    }

    public void setAuthorLName(String authorLName) {
        this.authorLName = authorLName;
    }

    public String getAuthorFName() {
        return authorFName;
    }

    public void setAuthorFName(String authorFName) {
        this.authorFName = authorFName;
    }

    public String getAuthorPostIt() {
        return authorPostIt;
    }

    public void setAuthorPostIt(String authorPostIt) {
        this.authorPostIt = authorPostIt;
    }

    @XmlTransient
    public Collection<Book> getBookCollection() {
        return bookCollection;
    }

    public void setBookCollection(Collection<Book> bookCollection) {
        this.bookCollection = bookCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authorId != null ? authorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Author)) {
            return false;
        }
        Author other = (Author) object;
        if ((this.authorId == null && other.authorId != null) || (this.authorId != null && !this.authorId.equals(other.authorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bookshop.Author[ authorId=" + authorId + " ]";
    }
    
}
