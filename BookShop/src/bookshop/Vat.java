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
@Table(name = "VAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vat.findAll", query = "SELECT v FROM Vat v")
    , @NamedQuery(name = "Vat.findByVatId", query = "SELECT v FROM Vat v WHERE v.vatId = :vatId")
    , @NamedQuery(name = "Vat.findByVatRate", query = "SELECT v FROM Vat v WHERE v.vatRate = :vatRate")})
public class Vat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "VAT_ID")
    private Long vatId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "VAT_RATE")
    private BigDecimal vatRate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vatId")
    private Collection<Book> bookCollection;

    public Vat() {
    }

    public Vat(Long vatId) {
        this.vatId = vatId;
    }

    public Vat(Long vatId, BigDecimal vatRate) {
        this.vatId = vatId;
        this.vatRate = vatRate;
    }

    public Long getVatId() {
        return vatId;
    }

    public void setVatId(Long vatId) {
        this.vatId = vatId;
    }

    public BigDecimal getVatRate() {
        return vatRate;
    }

    public void setVatRate(BigDecimal vatRate) {
        this.vatRate = vatRate;
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
        hash += (vatId != null ? vatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vat)) {
            return false;
        }
        Vat other = (Vat) object;
        if ((this.vatId == null && other.vatId != null) || (this.vatId != null && !this.vatId.equals(other.vatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bookshop.Vat[ vatId=" + vatId + " ]";
    }
    
}
