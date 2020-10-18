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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "EVENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e")
    , @NamedQuery(name = "Event.findByEventId", query = "SELECT e FROM Event e WHERE e.eventId = :eventId")
    , @NamedQuery(name = "Event.findByEventName", query = "SELECT e FROM Event e WHERE e.eventName = :eventName")
    , @NamedQuery(name = "Event.findByEventDateStart", query = "SELECT e FROM Event e WHERE e.eventDateStart = :eventDateStart")
    , @NamedQuery(name = "Event.findByEventDateEnd", query = "SELECT e FROM Event e WHERE e.eventDateEnd = :eventDateEnd")
    , @NamedQuery(name = "Event.findByEventDiscountValue", query = "SELECT e FROM Event e WHERE e.eventDiscountValue = :eventDiscountValue")
    , @NamedQuery(name = "Event.findByEventImageUrl", query = "SELECT e FROM Event e WHERE e.eventImageUrl = :eventImageUrl")})
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EVENT_ID")
    private Long eventId;
    @Basic(optional = false)
    @Column(name = "EVENT_NAME")
    private String eventName;
    @Basic(optional = false)
    @Column(name = "EVENT_DATE_START")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventDateStart;
    @Basic(optional = false)
    @Column(name = "EVENT_DATE_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventDateEnd;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "EVENT_DISCOUNT_VALUE")
    private BigDecimal eventDiscountValue;
    @Column(name = "EVENT_IMAGE_URL")
    private String eventImageUrl;
    @ManyToMany(mappedBy = "eventCollection")
    private Collection<Book> bookCollection;

    public Event() {
    }

    public Event(Long eventId) {
        this.eventId = eventId;
    }

    public Event(Long eventId, String eventName, Date eventDateStart, Date eventDateEnd, BigDecimal eventDiscountValue) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDateStart = eventDateStart;
        this.eventDateEnd = eventDateEnd;
        this.eventDiscountValue = eventDiscountValue;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDateStart() {
        return eventDateStart;
    }

    public void setEventDateStart(Date eventDateStart) {
        this.eventDateStart = eventDateStart;
    }

    public Date getEventDateEnd() {
        return eventDateEnd;
    }

    public void setEventDateEnd(Date eventDateEnd) {
        this.eventDateEnd = eventDateEnd;
    }

    public BigDecimal getEventDiscountValue() {
        return eventDiscountValue;
    }

    public void setEventDiscountValue(BigDecimal eventDiscountValue) {
        this.eventDiscountValue = eventDiscountValue;
    }

    public String getEventImageUrl() {
        return eventImageUrl;
    }

    public void setEventImageUrl(String eventImageUrl) {
        this.eventImageUrl = eventImageUrl;
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
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bookshop.Event[ eventId=" + eventId + " ]";
    }
    
}
