/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hatersata
 */
@Entity
@Table(name = "papms_lu_material_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PapmsLuMaterialCategory_1.findAll", query = "SELECT p FROM PapmsLuMaterialCategory_1 p"),
    @NamedQuery(name = "PapmsLuMaterialCategory_1.findByLuMatCatId", query = "SELECT p FROM PapmsLuMaterialCategory_1 p WHERE p.luMatCatId = :luMatCatId"),
    @NamedQuery(name = "PapmsLuMaterialCategory_1.findByCategoryName", query = "SELECT p FROM PapmsLuMaterialCategory_1 p WHERE p.categoryName = :categoryName"),
    @NamedQuery(name = "PapmsLuMaterialCategory_1.findByDescription", query = "SELECT p FROM PapmsLuMaterialCategory_1 p WHERE p.description = :description"),
    @NamedQuery(name = "PapmsLuMaterialCategory_1.findByMatCatCode", query = "SELECT p FROM PapmsLuMaterialCategory_1 p WHERE p.matCatCode = :matCatCode")})
public class PapmsLuMaterialCategory_1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LU_MAT_CAT_ID")
    private Integer luMatCatId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CATEGORY_NAME")
    private String categoryName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "MAT_CAT_CODE")
    private String matCatCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "luMatCatId")
    private List<PapmsLuSubCategory_1> papmsLuSubCategoryList;

    public PapmsLuMaterialCategory_1() {
    }

    public PapmsLuMaterialCategory_1(Integer luMatCatId) {
        this.luMatCatId = luMatCatId;
    }

    public PapmsLuMaterialCategory_1(Integer luMatCatId, String categoryName, String description, String matCatCode) {
        this.luMatCatId = luMatCatId;
        this.categoryName = categoryName;
        this.description = description;
        this.matCatCode = matCatCode;
    }

    public Integer getLuMatCatId() {
        return luMatCatId;
    }

    public void setLuMatCatId(Integer luMatCatId) {
        this.luMatCatId = luMatCatId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMatCatCode() {
        return matCatCode;
    }

    public void setMatCatCode(String matCatCode) {
        this.matCatCode = matCatCode;
    }

    @XmlTransient
    public List<PapmsLuSubCategory_1> getPapmsLuSubCategoryList() {
        return papmsLuSubCategoryList;
    }

    public void setPapmsLuSubCategoryList(List<PapmsLuSubCategory_1> papmsLuSubCategoryList) {
        this.papmsLuSubCategoryList = papmsLuSubCategoryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (luMatCatId != null ? luMatCatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PapmsLuMaterialCategory_1)) {
            return false;
        }
        PapmsLuMaterialCategory_1 other = (PapmsLuMaterialCategory_1) object;
        if ((this.luMatCatId == null && other.luMatCatId != null) || (this.luMatCatId != null && !this.luMatCatId.equals(other.luMatCatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.entity.PapmsLuMaterialCategory_1[ luMatCatId=" + luMatCatId + " ]";
    }
    
}