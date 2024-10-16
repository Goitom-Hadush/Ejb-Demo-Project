/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hatersata
 */
@Entity
@Table(name = "papms_lu_sub_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PapmsLuSubCategory.findAll", query = "SELECT p FROM PapmsLuSubCategory p"),
    @NamedQuery(name = "PapmsLuSubCategory.findByLuSubCatId", query = "SELECT p FROM PapmsLuSubCategory p WHERE p.luSubCatId = :luSubCatId"),
    @NamedQuery(name = "PapmsLuSubCategory.findBySubCatName", query = "SELECT p FROM PapmsLuSubCategory p WHERE p.subCatName = :subCatName"),
    @NamedQuery(name = "PapmsLuSubCategory.findByDescription", query = "SELECT p FROM PapmsLuSubCategory p WHERE p.description = :description"),
    @NamedQuery(name = "PapmsLuSubCategory.findByMatCode", query = "SELECT p FROM PapmsLuSubCategory p WHERE p.matCode = :matCode")})
public class PapmsLuSubCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LU_SUB_CAT_ID")
    private Integer luSubCatId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SUB_CAT_NAME")
    private String subCatName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MAT_CODE")
    private int matCode;
    @JoinColumn(name = "LU_MAT_CAT_ID", referencedColumnName = "LU_MAT_CAT_ID")
    @ManyToOne(optional = false)
    private PapmsLuMaterialCategory luMatCatId;

    public PapmsLuSubCategory() {
    }

    public PapmsLuSubCategory(Integer luSubCatId) {
        this.luSubCatId = luSubCatId;
    }

    public PapmsLuSubCategory(Integer luSubCatId, String subCatName, String description, int matCode) {
        this.luSubCatId = luSubCatId;
        this.subCatName = subCatName;
        this.description = description;
        this.matCode = matCode;
    }

    public Integer getLuSubCatId() {
        return luSubCatId;
    }

    public void setLuSubCatId(Integer luSubCatId) {
        this.luSubCatId = luSubCatId;
    }

    public String getSubCatName() {
        return subCatName;
    }

    public void setSubCatName(String subCatName) {
        this.subCatName = subCatName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMatCode() {
        return matCode;
    }

    public void setMatCode(int matCode) {
        this.matCode = matCode;
    }

    public PapmsLuMaterialCategory getLuMatCatId() {
        return luMatCatId;
    }

    public void setLuMatCatId(PapmsLuMaterialCategory luMatCatId) {
        this.luMatCatId = luMatCatId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (luSubCatId != null ? luSubCatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PapmsLuSubCategory)) {
            return false;
        }
        PapmsLuSubCategory other = (PapmsLuSubCategory) object;
        if ((this.luSubCatId == null && other.luSubCatId != null) || (this.luSubCatId != null && !this.luSubCatId.equals(other.luSubCatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.entity.PapmsLuSubCategory[ luSubCatId=" + luSubCatId + " ]";
    }
    
}
