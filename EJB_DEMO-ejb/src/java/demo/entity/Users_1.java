/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hatersata
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users_1.findAll", query = "SELECT u FROM Users_1 u"),
    @NamedQuery(name = "Users_1.findByUserId", query = "SELECT u FROM Users_1 u WHERE u.userId = :userId"),
    @NamedQuery(name = "Users_1.findByFName", query = "SELECT u FROM Users_1 u WHERE u.fName = :fName"),
    @NamedQuery(name = "Users_1.findByLName", query = "SELECT u FROM Users_1 u WHERE u.lName = :lName"),
    @NamedQuery(name = "Users_1.findByAge", query = "SELECT u FROM Users_1 u WHERE u.age = :age"),
    @NamedQuery(name = "Users_1.findByBirthDate", query = "SELECT u FROM Users_1 u WHERE u.birthDate = :birthDate")})
public class Users_1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "f_name")
    private String fName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "l_name")
    private String lName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "age")
    private int age;
    @Basic(optional = false)
    @NotNull
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Address_1> addressList;

    public Users_1() {
    }

    public Users_1(Integer userId) {
        this.userId = userId;
    }

    public Users_1(Integer userId, String fName, String lName, int age, Date birthDate) {
        this.userId = userId;
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.birthDate = birthDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @XmlTransient
    public List<Address_1> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address_1> addressList) {
        this.addressList = addressList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users_1)) {
            return false;
        }
        Users_1 other = (Users_1) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.entity.Users_1[ userId=" + userId + " ]";
    }
    
}
