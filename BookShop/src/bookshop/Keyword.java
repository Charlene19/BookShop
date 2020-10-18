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
@Table(name = "KEYWORD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Keyword.findAll", query = "SELECT k FROM Keyword k")
    , @NamedQuery(name = "Keyword.findByKeywordId", query = "SELECT k FROM Keyword k WHERE k.keywordId = :keywordId")
    , @NamedQuery(name = "Keyword.findByKeywordName", query = "SELECT k FROM Keyword k WHERE k.keywordName = :keywordName")})
public class Keyword implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KEYWORD_ID")
    private Long keywordId;
    @Basic(optional = false)
    @Column(name = "KEYWORD_NAME")
    private String keywordName;
    @ManyToMany(mappedBy = "keywordCollection")
    private Collection<Book> bookCollection;

    public Keyword() {
    }

    public Keyword(Long keywordId) {
        this.keywordId = keywordId;
    }

    public Keyword(Long keywordId, String keywordName) {
        this.keywordId = keywordId;
        this.keywordName = keywordName;
    }

    public Long getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(Long keywordId) {
        this.keywordId = keywordId;
    }

    public String getKeywordName() {
        return keywordName;
    }

    public void setKeywordName(String keywordName) {
        this.keywordName = keywordName;
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
        hash += (keywordId != null ? keywordId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Keyword)) {
            return false;
        }
        Keyword other = (Keyword) object;
        if ((this.keywordId == null && other.keywordId != null) || (this.keywordId != null && !this.keywordId.equals(other.keywordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bookshop.Keyword[ keywordId=" + keywordId + " ]";
    }
    
}
