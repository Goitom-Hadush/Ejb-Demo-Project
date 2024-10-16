///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package et.gov.insa.erp.commonApplications.controller;
//
//import et.gov.insa.erp.commonApplications.bussinessLogic.ComAddressInfoBeanLocal;
//import et.gov.insa.erp.commonApplications.bussinessLogic.ComLuPartyTypeBeanLocal;
//import et.gov.insa.erp.commonApplications.bussinessLogic.ComPartyBeanLocal;
//import et.gov.insa.erp.commonApplications.entity.ComAddressInfo;
//import et.gov.insa.erp.commonApplications.entity.ComCommitteeDetail;
//import et.gov.insa.erp.commonApplications.entity.ComCommitteeExternal;
//import et.gov.insa.erp.commonApplications.entity.ComContactPerson;
//import et.gov.insa.erp.commonApplications.entity.ComLuPartyType;
//import et.gov.insa.erp.commonApplications.entity.ComParty;
//import et.gov.insa.erp.commonApplications.util.JsfUtil;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import javax.ejb.EJB;
//import javax.inject.Named;
//import javax.faces.event.ValueChangeEvent;
//import javax.faces.model.DataModel;
//import javax.faces.model.ListDataModel;
//import javax.faces.model.SelectItem;
//import javax.faces.view.ViewScoped;
//import javax.inject.Inject;
//import org.primefaces.event.RowEditEvent;
//import org.primefaces.event.SelectEvent;
//import org.primefaces.event.UnselectEvent;
//
///**
// *
// * @author fele
// */
//@Named(value = "partyController")
//@ViewScoped
//public class PartyController implements Serializable {
//
//    @EJB
//    private ComAddressInfoBeanLocal comAddressInfoBean;
//
//    @EJB
//    private ComPartyBeanLocal comPartyBean;
//
//    @EJB
//    private ComLuPartyTypeBeanLocal comLuPartyTypeBean;
//
//    @Inject
//    private ComParty party;
//
//    @Inject
//    private ComLuPartyType partyType;
//
//    @Inject
//    private ComContactPerson comContactPerson;
//
//    @Inject
//    private ComAddressInfo addressInfo;
//
//    private DataModel<ComContactPerson> contactPersonDataModel;
//    private DataModel<ComAddressInfo> partyAddressDataModel;
//    Set<String> addressCheck = new HashSet<>();
//
//    private List<ComAddressInfo> filteredAddress;
//
//    private List<ComContactPerson> listContactPerson = new ArrayList<>();
//
//    private String saveorUpdateBundle = "Create";
//    private String addressInfoButton = "Add";
//    private String duplicattion = null;
//    int updateStatus = 0;
//
//    String partyname, partyLocation, partyValFrom, partyDescription, partyTin, partyVat, partyMarket;
//
//    List<ComLuPartyType> comLuPartyTypeALl() {
//        return comLuPartyTypeBean.getAllPatyType();
//        //comLuPartyTypeBea
//    }
//
//    public SelectItem[] getAllPartyType() {
//        SelectItem[] partyList;
//        List<ComLuPartyType> allParty = new ArrayList<>();//comLuPartyTypeBean.getAllPatyType();
//        allParty = comLuPartyTypeBean.getAllPatyType();
//
//        if (allParty.size() > 0) {
//            partyList = new SelectItem[allParty.size() + 1];
//            partyList[0] = new SelectItem("", "---Select---");
//            for (int i = 0; i < allParty.size(); i++) {
//                partyList[i + 1] = new SelectItem(allParty.get(i).getPartyTypeId(), allParty.get(i).getName());
//            }
//        } else {
//            partyList = new SelectItem[1];
//            partyList[0] = new SelectItem("", "---Select---");
//        }
//        return partyList;
//    }
//
//    public boolean validateDate() {
//        boolean valid = true;
//        if (party.getValidFrom() != null && party.getValidTo() != null) {
//            if (party.getValidTo().after(party.getValidFrom())) {
//                valid = true;
//            } else {
//                valid = false;
//            }
//        }
//        return valid;
//    }
//
//    public String save() {
//
//        System.out.println("===========Create 111111=============" + party.getName());
//        party.setAddressInfoId(addressInfo);
//        //party.setPartyTypeId(partyType);
//        System.out.println("===========Create 111111=============");
//        System.out.println("===========party Type ID=============" + party.getPartyTypeId());
//        System.out.println("===========AddressInfoId=============" + party.getAddressInfoId());
//        if (validateDate()) {
//            System.out.println("===========Create 2222=============");
//            if (updateStatus == 0) {
//                System.out.println("===========Create=============");
////                if (comPartyBean.checkPartyExistenceByNameAndTinNo(party)) {
////                    JsfUtil.addErrorMessage("This Party is already registered");
////                } else {
////                    if (!(getContactPersonDataModel().getRowCount() > 0)) {
////                        JsfUtil.addErrorMessage("Contact person is required");
////                    } else {
//                try {
////                    party.setComContactPersonList(listContactPerson);
//
//                   // party.setName(partyname);
//                    // party.setDescription(partyDescription);
////                    comContactPerson.setPartyId(party);
//                    System.out.println("==============Party=============" + party.getComContactPersonList().size());
//                    System.out.println("==============Party Description=============" + party.getDescription());
//                    System.out.println("==============Party Location=============" + party.getLocation());
//                    System.out.println("==============Party Name=============" + party.getName());
//                    System.out.println("==============Party TinNo=============" + party.getTinNo());
//                    System.out.println("==============Party Type=============" + party.getType());
//                    System.out.println("==============Party VatNo=============" + party.getVatNo());
//                    System.out.println("==============Party ValidFrom=============" + party.getValidFrom());
//                    System.out.println("==============Party ValidTo=============" + party.getValidTo());
//                    comPartyBean.save(party);
//                    System.out.println("==========saved============");
//                    System.out.println("============after save=============");
//                    JsfUtil.addSuccessMessage("Party information successfully created");
//                    clearPage();
//                } catch (Exception e) {
//                    System.err.println("==============Exception=========" + e.getMessage());
//                    JsfUtil.addErrorMessage("Something Occured on Data Created");
//                }
////                }
////                 }
//
//            } else {
//                System.out.println(" cont person size = " + getContactPersonDataModel().getRowCount());
//                if (!(getContactPersonDataModel().getRowCount() > 0)) {
//                    JsfUtil.addErrorMessage("Contact person is required");
//                } else {
//                    try {
//                        comPartyBean.update(party);
//                        JsfUtil.addSuccessMessage("Party information successfully updated");
//                        clearPage();
//                    } catch (Exception e) {
//                        JsfUtil.addErrorMessage("Something Occured on Data Modified");
//                    }
//                }
//            }
//        } else {
//            JsfUtil.addErrorMessage("Invalid validity period!!");
//        }
//
//        return null;
//
//    }
//
//    /**
//     * @return the contactPersonDataModel
//     */
//    public DataModel<ComContactPerson> getContactPersonDataModel() {
//        if (contactPersonDataModel == null) {
//            contactPersonDataModel = new ListDataModel();
//        }
//        return contactPersonDataModel;
//    }
//
//    /**
//     * @param contactPersonDataModel the contactPersonDataModel to set
//     */
//    public void setContactPersonDataModel(DataModel<ComContactPerson> contactPersonDataModel) {
//        this.contactPersonDataModel = contactPersonDataModel;
//    }
//
//    /**
//     * @return the saveorUpdateBundle
//     */
//    public String getSaveorUpdateBundle() {
//        return saveorUpdateBundle;
//    }
//
//    /**
//     * @param saveorUpdateBundle the saveorUpdateBundle to set
//     */
//    public void setSaveorUpdateBundle(String saveorUpdateBundle) {
//        this.saveorUpdateBundle = saveorUpdateBundle;
//    }
//
//    public void clearPopUp() {
//        comContactPerson = null;
//    }
//
//    public void clearPage() {
//        party = null;
//        comContactPerson = null;
//        addressInfo = null;
//        partyType = null;
//        contactPersonDataModel = null;
//    }
//
//    public void addContactPersonInfo() {
//        System.out.println(" Test  "+ comContactPerson.getName());
//        if (!addressCheck.contains(comContactPerson.getName()) && !addressCheck.contains(comContactPerson.getPhone())) {
//            duplicattion = "";
//            //party.setComContactPersonList((List<ComContactPerson>) comContactPerson);
//            // party.getComContactPersonList().add(comContactPerson);
//            party.addToParty(comContactPerson);
////            listContactPerson.add(comContactPerson);
////            comContactPerson.setPartyId(party);
//            addressCheck.add(comContactPerson.getName());
//            addressCheck.add(comContactPerson.getPhone());
//            recreateModelDetail();
//            clearPopUp();
//        } else {
//            duplicattion = "Data Table Row Duplicated";
//        }
//    }
//
//    public void recreateModelDetail() {
//        contactPersonDataModel = null;
//        contactPersonDataModel = new ListDataModel(party.getComContactPersonList());
//    }
//
//    /**
//     * @return the duplicattion
//     */
//    public String getDuplicattion() {
//        return duplicattion;
//    }
//
//    /**
//     * @param duplicattion the duplicattion to set
//     */
//    public void setDuplicattion(String duplicattion) {
//        this.duplicattion = duplicattion;
//    }
//
//    /**
//     * @return the comContactPerson
//     */
//    public ComContactPerson getComContactPerson() {
//        if (comContactPerson == null) {
//            comContactPerson = new ComContactPerson();
//        }
//        return comContactPerson;
//    }
//
//    /**
//     * @param comContactPerson the comContactPerson to set
//     */
//    public void setComContactPerson(ComContactPerson comContactPerson) {
//        this.comContactPerson = comContactPerson;
//    }
//
//    /**
//     * @return the party
//     */
//    public ComParty getParty() {
//        if (party == null) {
//            party = new ComParty();
//        }
//        return party;
//    }
//
//    /**
//     * @param party the party to set
//     */
//    public void setParty(ComParty party) {
//        this.party = party;
//    }
//
//    public void updateContactInformation() {
//        comContactPerson = getContactPersonDataModel().getRowData();
//    }
//
//    /**
//     * @return the partyAddressDataModel
//     */
//    public DataModel<ComAddressInfo> getPartyAddressDataModel() {
//        if (partyAddressDataModel == null) {
//            partyAddressDataModel = new ListDataModel<>(new ArrayList<>(comAddressInfoBean.getAllAddressInformation()));
////            partyAddressDataModel = new ListDataModel<>();
//        }
//
//        return partyAddressDataModel;
//    }
//
//    /**
//     * @param partyAddressDataModel the partyAddressDataModel to set
//     */
//    public void setPartyAddressDataModel(DataModel<ComAddressInfo> partyAddressDataModel) {
//        this.partyAddressDataModel = partyAddressDataModel;
//    }
//
//    /**
//     * @return the filteredAddress
//     */
//    public List<ComAddressInfo> getFilteredAddress() {
//        return filteredAddress;
//    }
//
//    /**
//     * @param filteredAddress the filteredAddress to set
//     */
//    public void setFilteredAddress(List<ComAddressInfo> filteredAddress) {
//        this.filteredAddress = filteredAddress;
//    }
//
//    /**
//     * @return the addressInfo
//     */
//    public ComAddressInfo getAddressInfo() {
//        if (addressInfo == null) {
//            addressInfo = new ComAddressInfo();
//        }
//        return addressInfo;
//    }
//
//    /**
//     * @param addressInfo the addressInfo to set
//     */
//    public void setAddressInfo(ComAddressInfo addressInfo) {
//        this.addressInfo = addressInfo;
//    }
//
//    public void onRowSelect(SelectEvent event) {
//        addressInfo.setAddressInfoId(((ComAddressInfo) event.getObject()).getAddressInfoId());
//    }
//
//    public void onRowUnselect(UnselectEvent event) {
////       FacesMessage msg = new FacesMessage("Car Unselected", String.valueOf(((ComAddressInfo) event.getObject()).getAddressInfoId()));
////        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }
//
//    public void removeContactPersonInfo() {
//
//        int rowIndex = contactPersonDataModel.getRowIndex();
//        party.setComContactPersonList(listContactPerson);
//        ComContactPerson contactPerson = party.getComContactPersonList().get(rowIndex);
//        party.getComContactPersonList().remove(rowIndex);
//        recreateModelDetail();
//        if (saveorUpdateBundle.equals("Update")) {
//            comPartyBean.deleteContactPersonInfo(contactPerson);
//        }
//    }
//
//    public void onRowEdit(RowEditEvent event) {
//        if (null != event.getObject()) {
//            
//            int rowIndex = contactPersonDataModel.getRowIndex();
//           
//
//            ComContactPerson comContPerson = (ComContactPerson) event.getObject();
//
//            boolean found = false;
//            for (int i = 0; i < party.getComContactPersonList().size(); i++) {
//                if (i != rowIndex) {
//                    if (party.getComContactPersonList().get(i).getName().equals(comContPerson.getName())
//                            && party.getComContactPersonList().get(i).getPhone().equals(comContPerson.getPhone())) {
//                        found = true;
//                        break;
//                    }
//                }
//            }
//
//            if (found == true) {
//                JsfUtil.addErrorMessage("Member Information Duplicated !!");
//                comContPerson.setName(null);
//                party.getComContactPersonList().set(rowIndex, comContPerson);
//                recreateModelDetail();
//            } else {
//                party.getComContactPersonList().set(rowIndex, comContPerson);
//                recreateModelDetail();
//            }
//        }
//    }
//
//    public void onRowCancel(RowEditEvent event) {
//       //FacesMessage msg = new FacesMessage("Edit Cancelled", ((Car) event.getObject()).getId());
//        //  FacesContext.getCurrentInstance().addMessage(null, msg);
//    }
//
//    /**
//     * @return the partyType
//     */
//    public ComLuPartyType getPartyType() {
//        if (partyType == null) {
//            partyType = new ComLuPartyType();
//        }
//        return partyType;
//    }
//
//    /**
//     * @param partyType the partyType to set
//     */
//    public void setPartyType(ComLuPartyType partyType) {
//        this.partyType = partyType;
//    }
//
//    public ArrayList<ComParty> searchPartyByPartyNameAndTinNo(String input) {
//        ArrayList<ComParty> partyList = new ArrayList<>();
//        partyList = null;
//        party.setName(input);
//        party.setTinNo(input);
//        partyList = comPartyBean.searchPartyByPartyNameAndTinNo(party);
//        System.out.println("====###===partyList=====" + partyList);
//        return partyList;
//    }
//
//    public void getPartyInfo(SelectEvent event) {
//        listContactPerson.clear();
//        party.setName(String.valueOf(event.getObject()));
//        party = comPartyBean.searchPartyByName(party);
//        addressInfo = party.getAddressInfoId();
//        partyType = party.getPartyTypeId();
//
//        listContactPerson = party.getComContactPersonList();
//        for (int i = 0; i < party.getComContactPersonList().size(); i++) {
//            addressCheck.add(party.getComContactPersonList().get(i).getName());
//            addressCheck.add(party.getComContactPersonList().get(i).getPhone());
//        }
//        List<ComAddressInfo> partyAddress = new ArrayList<>();
//        partyAddress.add(party.getAddressInfoId());
//        setPartyAddressDataModel(new ListDataModel<>(new ArrayList<>(partyAddress)));
//        setSaveorUpdateBundle("Update");
//        setAddressInfoButton("Show");
//        updateStatus = 1;
//
//        recreateModelDetail();
//    }
//
//    /**
//     * @return the addressInfoButton
//     */
//    public String getAddressInfoButton() {
//        return addressInfoButton;
//    }
//
//    /**
//     * @param addressInfoButton the addressInfoButton to set
//     */
//    public void setAddressInfoButton(String addressInfoButton) {
//        this.addressInfoButton = addressInfoButton;
//    }
//
//    public void justChecking(ValueChangeEvent event) {
//        System.out.println("===============event==========" + event.getNewValue().toString());
//        int partyid = Integer.parseInt(event.getNewValue().toString());
//        partyType.setPartyTypeId(partyid);
//        party.setPartyTypeId(partyType);
//        System.out.println("=============partyTypeId================" + party.getPartyTypeId());
//    }
//
//    public void partynameHandler(ValueChangeEvent event) {
////         System.out.println("============partyName=========="+event.getNewValue().toString());
//        partyname = party.getName();// event.getNewValue().toString();
//        party.setName(partyname);
//        System.out.println("============partyName 2==========" + partyname);
//    }
//
//    public void partyDescriptionHandler(ValueChangeEvent event) {
//        partyDescription = party.getDescription();
//        System.out.println("==============party Description===========" + partyDescription);
//        party.setDescription(partyDescription);
//        System.out.println("==============party Description===========" + party.getDescription());
//    }
//
//    public void partyTinNoHandler(ValueChangeEvent event) {
//        partyTin = party.getTinNo();
//        System.out.println("==============party Tin ===========" + partyTin);
//        party.setTinNo(partyTin);
//        System.out.println("==============party Tin 2===========" + party.getTinNo());
//    }
//
//    public void partyVatNoHandler(ValueChangeEvent event) {
//        partyVat = party.getVatNo();
//        System.out.println("==============party Vat===========" + partyVat);
//        party.setVatNo(partyVat);
//        System.out.println("==============party Vat 2===========" + party.getVatNo());
//
//    }
//
//    public void partyMarketIdentityHandler(ValueChangeEvent event) {
//        partyMarket = party.getType();
//        System.out.println("==============party MArket===========" + partyMarket);
//        party.setType(partyMarket);
//        System.out.println("==============party MArket 2===========" + party.getType());
//    }
//
//    public void rowDelete() {
//
//    }
//
//}
