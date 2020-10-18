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
@Table(name = "EMPLOYEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findByEmployeeId", query = "SELECT e FROM Employee e WHERE e.employeeId = :employeeId")
    , @NamedQuery(name = "Employee.findByEmployeeLogin", query = "SELECT e FROM Employee e WHERE e.employeeLogin = :employeeLogin")
    , @NamedQuery(name = "Employee.findByEmployeePassword", query = "SELECT e FROM Employee e WHERE e.employeePassword = :employeePassword")
    , @NamedQuery(name = "Employee.findByEmployeeDateStart", query = "SELECT e FROM Employee e WHERE e.employeeDateStart = :employeeDateStart")
    , @NamedQuery(name = "Employee.findByEmployeeDateEnd", query = "SELECT e FROM Employee e WHERE e.employeeDateEnd = :employeeDateEnd")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;
    @Basic(optional = false)
    @Column(name = "EMPLOYEE_LOGIN")
    private String employeeLogin;
    @Basic(optional = false)
    @Column(name = "EMPLOYEE_PASSWORD")
    private String employeePassword;
    @Basic(optional = false)
    @Column(name = "EMPLOYEE_DATE_START")
    @Temporal(TemporalType.TIMESTAMP)
    private Date employeeDateStart;
    @Basic(optional = false)
    @Column(name = "EMPLOYEE_DATE_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date employeeDateEnd;
    @ManyToMany(mappedBy = "employeeCollection")
    private Collection<Group1> group1Collection;

    public Employee() {
    }

    public Employee(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Employee(Long employeeId, String employeeLogin, String employeePassword, Date employeeDateStart, Date employeeDateEnd) {
        this.employeeId = employeeId;
        this.employeeLogin = employeeLogin;
        this.employeePassword = employeePassword;
        this.employeeDateStart = employeeDateStart;
        this.employeeDateEnd = employeeDateEnd;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeLogin() {
        return employeeLogin;
    }

    public void setEmployeeLogin(String employeeLogin) {
        this.employeeLogin = employeeLogin;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public Date getEmployeeDateStart() {
        return employeeDateStart;
    }

    public void setEmployeeDateStart(Date employeeDateStart) {
        this.employeeDateStart = employeeDateStart;
    }

    public Date getEmployeeDateEnd() {
        return employeeDateEnd;
    }

    public void setEmployeeDateEnd(Date employeeDateEnd) {
        this.employeeDateEnd = employeeDateEnd;
    }

    @XmlTransient
    public Collection<Group1> getGroup1Collection() {
        return group1Collection;
    }

    public void setGroup1Collection(Collection<Group1> group1Collection) {
        this.group1Collection = group1Collection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bookshop.Employee[ employeeId=" + employeeId + " ]";
    }
    
}
