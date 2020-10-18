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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "GROUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Group1.findAll", query = "SELECT g FROM Group1 g")
    , @NamedQuery(name = "Group1.findByGroupId", query = "SELECT g FROM Group1 g WHERE g.groupId = :groupId")
    , @NamedQuery(name = "Group1.findByGroupName", query = "SELECT g FROM Group1 g WHERE g.groupName = :groupName")})
public class Group1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "GROUP_ID")
    private Integer groupId;
    @Basic(optional = false)
    @Column(name = "GROUP_NAME")
    private String groupName;
    @JoinTable(name = "ASSOC_PERMISSION_GROUP", joinColumns = {
        @JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "PERMISSION_ID", referencedColumnName = "PERMISSION_ID")})
    @ManyToMany
    private Collection<Permission> permissionCollection;
    @JoinTable(name = "ASSOC_GROUP_EMPLOYEE", joinColumns = {
        @JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")})
    @ManyToMany
    private Collection<Employee> employeeCollection;

    public Group1() {
    }

    public Group1(Integer groupId) {
        this.groupId = groupId;
    }

    public Group1(Integer groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @XmlTransient
    public Collection<Permission> getPermissionCollection() {
        return permissionCollection;
    }

    public void setPermissionCollection(Collection<Permission> permissionCollection) {
        this.permissionCollection = permissionCollection;
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Group1)) {
            return false;
        }
        Group1 other = (Group1) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bookshop.Group1[ groupId=" + groupId + " ]";
    }
    
}
