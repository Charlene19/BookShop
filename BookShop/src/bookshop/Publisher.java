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
import javax.persistence.ManyToMany;
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
@Table(name = "PUBLISHER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publisher.findAll", query = "SELECT p FROM Publisher p")
    , @NamedQuery(name = "Publisher.findByPublisherId", query = "SELECT p FROM Publisher p WHERE p.publisherId = :publisherId")
    , @NamedQuery(name = "Publisher.findByPublisherName", query = "SELECT p FROM Publisher p WHERE p.publisherName = :publisherName")
    , @NamedQuery(name = "Publisher.findByPublisherPostIt", query = "SELECT p FROM Publisher p WHERE p.publisherPostIt = :publisherPostIt")})
public class Publisher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PUBLISHER_ID")
    private Long publisherId;
    @Basic(optional = false)
    @Column(name = "PUBLISHER_NAME")
    private String publisherName;
    @Column(name = "PUBLISHER_POST_IT")
    private String publisherPostIt;
    @ManyToMany(mappedBy = "publisherCollection")
    private Collection<Address> addressCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publisherId")
    private Collection<Book> bookCollection;

    public Publisher() {
    }

    public Publisher(Long publisherId) {
        this.publisherId = publisherId;
    }

    public Publisher(Long publisherId, String publisherName) {
        this.publisherId = publisherId;
        this.publisherName = publisherName;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherPostIt() {
        return publisherPostIt;
    }

    public void setPublisherPostIt(String publisherPostIt) {
        this.publisherPostIt = publisherPostIt;
    }

    @XmlTransient
    public Collection<Address> getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(Collection<Address> addressCollection) {
        this.addressCollection = addressCollection;
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
        hash += (publisherId != null ? publisherId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publisher)) {
            return false;
        }
        Publisher other = (Publisher) object;
        if ((this.publisherId == null && other.publisherId != null) || (this.publisherId != null && !this.publisherId.equals(other.publisherId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bookshop.Publisher[ publisherId=" + publisherId + " ]";
    }
    
}
