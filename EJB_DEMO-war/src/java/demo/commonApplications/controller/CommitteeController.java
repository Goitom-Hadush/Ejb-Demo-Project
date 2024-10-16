///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package et.gov.insa.erp.commonApplications.controller;
//
//import et.gov.insa.erp.commonApplications.bussinessLogic.ComCommitteeBeanLocal;
//import et.gov.insa.erp.commonApplications.bussinessLogic.ComExternalCommitteeBeanLocal;
//import et.gov.insa.erp.commonApplications.bussinessLogic.ComLuCommitteeTypeBeanLocal;
//import et.gov.insa.erp.commonApplications.entity.ComCommittee;
//import et.gov.insa.erp.commonApplications.entity.ComCommitteeDetail;
//import et.gov.insa.erp.commonApplications.entity.ComCommitteeExternal;
//import et.gov.insa.erp.commonApplications.entity.ComLuCommitteeType;
//import et.gov.insa.erp.commonApplications.util.JsfUtil;
//import et.gov.insa.erp.hrms.entity.HrEmploye;
//import et.gov.insa.erp.hrms.entity.HrEmployee;
//import et.gov.insa.erp.hrms.integration.HrEmployeeBeanLocal;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import javax.ejb.EJB;
//import javax.faces.model.DataModel;
//import javax.faces.model.ListDataModel;
//import javax.faces.model.SelectItem;
//import javax.faces.view.ViewScoped;
//import javax.inject.Named;
//import javax.inject.Inject;
//import org.primefaces.event.RowEditEvent;
//import org.primefaces.event.SelectEvent;
//
///**
// *
// * @author fele
// */
//@Named(value = "committeeController")
//@ViewScoped
//public class CommitteeController implements Serializable {
//
//    private String memberType = "internal";
//    private DataModel<ComCommitteeDetail> committeeMemberDataModel;
//    private DataModel<ComCommitteeExternal> externalCommitteeMemberDataModel;
//
//    private List<ComCommitteeExternal> extMemberDetailList;
//
//    private String rowDuplicate = "";
//    private String rowDuplicateExt = "";
//    private String saveorUpdateBundle = "Create";
//
//    @EJB
//    private ComCommitteeBeanLocal committeeBeanLocal;
//
//    @EJB
//    private ComLuCommitteeTypeBeanLocal committeeTypeBeanLocal;
//
//    @EJB
//    private HrEmployeeBeanLocal employeeBeanLocal;
//
//    @EJB
//    private ComExternalCommitteeBeanLocal externalCommitteeBeanLocal;
//
//    @Inject
//    private ComCommittee committee;
//
//    @Inject
//    private ComCommitteeDetail committeeDetail;
//
//    @Inject
//    private ComCommitteeExternal externalCommitteeDetail;
//
//    @Inject
//    private ComLuCommitteeType luCommitteeType;
//
//    @Inject
//    private HrEmployee employee;
//
//    @Inject
//    private HrEmploye employe;
//
//    //Set<HrEmployee> checkMemberr = new HashSet<>();
//    Set<HrEmployee> checkMember = new HashSet<>();
//    Set<String> checkExternalMember = new HashSet<>();
//
//     List<ComCommitteeDetail> listComDetil = new ArrayList<>();
//     List<ComCommitteeExternal> listExternal = new ArrayList<>();
//    
//    /**
//     * Creates a new instance of CommitteeController
//     */
//    public CommitteeController() {
//    }
//
//    public void clearPage() {
//        committee = null;
//        committeeDetail = null;
//        externalCommitteeDetail = null;
//        committeeMemberDataModel = null;
//        externalCommitteeMemberDataModel = null;
//    }
//
//    public void saveCommitteeInfo() {
//         System.out.println("==========saveCommitteInfo 1=============");
//        if (validateDate()) {
//             System.out.println("==========saveCommitteInfo 2=============");
//            if (validateDataTable()) {
//             System.out.println("==========saveCommitteInfo 3=============");
//                if (saveorUpdateBundle.equals("Create")) {
//
//                    if (committeeBeanLocal.checkCommitteeExistence(committee)) {
//                        JsfUtil.addErrorMessage("Committee Information Already Registered !!");
//                    } else {
//                        try {
//                            System.out.println("=======save========");
//                            committee.setComCommitteeDetailList(listComDetil);
//                            System.out.println("=======save 11========"+committee.getComCommitteeDetailList().size());
//                            committee.setComCommitteeExternalList(listExternal);
//                              System.out.println("=======save 11234========"+committee.getComCommitteeExternalList().size());
//                            committeeBeanLocal.saveCommitteeInfo(committee);
//                            System.out.println("============savedddddddddddddd===========");
//                            JsfUtil.addSuccessMessage("Committee Information Successfully Registered !!");
//                            clearPage();
//                        } catch (Exception e) {
//                            JsfUtil.addErrorMessage("Something Occured on saving Data !!");
//                        }
//
//                    }
//
//                } else if (saveorUpdateBundle.equals("Update")) {
//                    try {
//                        committeeBeanLocal.updateCommitteeInfo(committee);
//                        JsfUtil.addSuccessMessage("Committee Information Successfully Updated !!");
//                        clearPage();
//                    } catch (Exception e) {
//                        JsfUtil.addErrorMessage("Something Occured on Modifining Data !!");
//                    }
//                }
//    
//            } else {
//                JsfUtil.addErrorMessage("Committee member information is required !!");
//            }
//        } else {
//            JsfUtil.addErrorMessage("Invalid validity period!!");
//        }
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
//    public SelectItem[] getAllCommitteType() {
//        return JsfUtil.getSelectItems(committeeTypeBeanLocal.selectAllCommitteeType(), true);
//    }
//
//    public ArrayList<HrEmployee> searchEmployeeByName(String input) {
//        ArrayList<HrEmployee> employeeList = null;
//        employee.setFirstName(input);
//        employeeList = employeeBeanLocal.searchEmployeeByName(employee);
//        return employeeList;
//    }
//
//    public SelectItem[] searchAllEmployee() {
//        List<HrEmployee> employeeList = employeeBeanLocal.searchAllEmployee();
//        System.out.println("=======empList===="+employeeList);
//        return JsfUtil.getSelectItems(employeeList, true);
//    }
//
//    public ArrayList<ComCommittee> searchCommitteeListByCommitteeNamePrefix(String name) {
//        committee.setCommitteeName(name);
//        return committeeBeanLocal.searchCommitteeListByCommitteeNamePrefix(committee);
//    }
//
//    public void getCommitteeInfo(SelectEvent event) {
//        System.out.println("==========autocompelete===============");
//        listComDetil=null;
//        committee.setCommitteeId(Integer.parseInt(String.valueOf(event.getObject())));
//        System.out.println("=====committe event======"+ committee.getCommitteeId());
//        committee = committeeBeanLocal.searchCommitteeInfoByCommitteeId(committee);
//        System.out.println("=====committe internal list======"+ committee.getComCommitteeDetailList().size()+"=======List======="+committee.getComCommitteeDetailList());
//        System.out.println("=====committe External list======"+ committee.getComCommitteeExternalList().size()+"=======List======="+committee.getComCommitteeExternalList());
//        
//        
//        for (int i = 0; i < committee.getComCommitteeDetailList().size(); i++) {
//             System.out.println("===========Internal=========");
//           //listComDetil.add((ComCommitteeDetail) committee.getComCommitteeDetailList());
//            checkMember.add(committee.getComCommitteeDetailList().get(i).getMemberId());
//        }
//
//        if (committee.getComCommitteeExternalList().size() > 0) {
//            System.out.println("===========External=========");
//            extMemberDetailList = committee.getComCommitteeExternalList();
//            //listExternal.add((ComCommitteeExternal) committee.getComCommitteeExternalList());
//            for (int j = 0; j < committee.getComCommitteeExternalList().size(); j++) {
//                checkExternalMember.add(committee.getComCommitteeExternalList().get(j).getExternalMemberName());
//            }
//        }
//
//        setSaveorUpdateBundle("Update");
//
//        recreateDataModel1();
//        recreateExternalDataModel1();
//    }
//    
//    public void recreateDataModel1() {
//        committeeMemberDataModel = null;
//        committeeMemberDataModel = new ListDataModel(new ArrayList<>(committee.getComCommitteeDetailList()));
//    }
//
//    public void recreateExternalDataModel1() {
//        externalCommitteeMemberDataModel = null;
//        externalCommitteeMemberDataModel = new ListDataModel(new ArrayList<>(committee.getComCommitteeExternalList()));
//    }
//
//    public void searchEmployeeAction(SelectEvent event) {
//        employee.setEmpId(event.getObject().toString());
//    }
//
//    public void clearPopUp() {
//        committeeDetail = null;
//    }
//
//    public void clearExtPopUp() {
//        externalCommitteeDetail = null;
//    }
//
//    public void addCommitteeMember() {
//        System.out.println("======add internal memeber=======");
//        if (!checkMember.contains(committeeDetail.getMemberId())) {
//            rowDuplicate = "";
//            System.out.println("=============Responsibility==========="+committeeDetail.getResponsibility());
//            System.out.println("============ID========="+committeeDetail.getMemberId());
//            listComDetil.add(committeeDetail);
//            //committee.getComCommitteeDetailList().add(committeeDetail);
//            committeeDetail.setCommitteeId(committee);
//            checkMember.add(committeeDetail.getMemberId());
//            recreateDataModel();
//            clearPopUp();
//        } else {
//            rowDuplicate = "Committee Member Duplicated !!";
//        }
//
//    }
//
//    public boolean validateDate() {
//        boolean valid = true;
//        if (committee.getValidFrom() != null && committee.getValidTo() != null) {
//            if (committee.getValidTo().after(committee.getValidFrom())) {
//                valid = true;
//            } else {
//                valid = false;
//            }
//        }
//        return valid;
//    }
//
//    public boolean validateDataTable() {
//        boolean valid = true;
//        if (getCommitteeMemberDataModel().getRowCount() < 0) {
//            valid = false;
//        }
//        return valid;
//    }
//
//    
//    public void addExternalCommitteeMember() {
//
//        if (!checkExternalMember.contains(externalCommitteeDetail.getExternalMemberName())) {
//            rowDuplicateExt = "";
//            listExternal.add(externalCommitteeDetail);
//          //  committee.getComCommitteeExternalList().add(externalCommitteeDetail);
//            externalCommitteeDetail.setCommitteeId(committee);
//            checkExternalMember.add(externalCommitteeDetail.getExternalMemberName());
//            recreateExternalDataModel();
//            getExtMemberDetailList().add(externalCommitteeDetail);
//            clearExtPopUp();
//        } else {
//            rowDuplicateExt = "Committee Member Duplicated !!";
//        }
//
//    }
//
//    public void recreateDataModel() {
//        committeeMemberDataModel = null;
//        committeeMemberDataModel = new ListDataModel(new ArrayList<>(listComDetil));
//    }
//
//    public void recreateExternalDataModel() {
//        externalCommitteeMemberDataModel = null;
//        externalCommitteeMemberDataModel = new ListDataModel(new ArrayList<>(listExternal));
//    }
//
//    /**
//     * @return the memberType
//     */
//    public String getMemberType() {
//        return memberType;
//    }
//
//    /**
//     * @param memberType the memberType to set
//     */
//    public void setMemberType(String memberType) {
//        this.memberType = memberType;
//    }
//
//    /**
//     * @return the committee
//     */
//    public ComCommittee getCommittee() {
//        if (committee == null) {
//            committee = new ComCommittee();
//        }
//        return committee;
//    }
//
//    /**
//     * @param committee the committee to set
//     */
//    public void setCommittee(ComCommittee committee) {
//        this.committee = committee;
//    }
//
//    /**
//     * @return the committeeDetail
//     */
//    public ComCommitteeDetail getCommitteeDetail() {
//        if (committeeDetail == null) {
//            committeeDetail = new ComCommitteeDetail();
//        }
//        return committeeDetail;
//    }
//
//    /**
//     * @param committeeDetail the committeeDetail to set
//     */
//    public void setCommitteeDetail(ComCommitteeDetail committeeDetail) {
//        this.committeeDetail = committeeDetail;
//    }
//
//    /**
//     * @return the luCommitteeType
//     */
//    public ComLuCommitteeType getLuCommitteeType() {
//        if (luCommitteeType == null) {
//            luCommitteeType = new ComLuCommitteeType();
//        }
//        return luCommitteeType;
//    }
//
//    /**
//     * @param luCommitteeType the luCommitteeType to set
//     */
//    public void setLuCommitteeType(ComLuCommitteeType luCommitteeType) {
//        this.luCommitteeType = luCommitteeType;
//    }
//
//    /**
//     * @return the rowDuplicate
//     */
//    public String getRowDuplicate() {
//        return rowDuplicate;
//    }
//
//    /**
//     * @param rowDuplicate the rowDuplicate to set
//     */
//    public void setRowDuplicate(String rowDuplicate) {
//        this.rowDuplicate = rowDuplicate;
//    }
//
//    /**
//     * @return the committeeMemberDataModel
//     */
//    public DataModel<ComCommitteeDetail> getCommitteeMemberDataModel() {
//        if (committeeMemberDataModel == null) {
//            committeeMemberDataModel = new ListDataModel<>();
//        }
//        return committeeMemberDataModel;
//    }
//
//    /**
//     * @param committeeMemberDataModel the committeeMemberDataModel to set
//     */
//    public void setCommitteeMemberDataModel(DataModel<ComCommitteeDetail> committeeMemberDataModel) {
//        this.committeeMemberDataModel = committeeMemberDataModel;
//    }
//
//    /**
//     * @return the employee
//     */
//    public HrEmployee getEmployee() {
//        if (employee == null) {
//            employee = new HrEmployee();
//        }
//        return employee;
//    }
//
//    /**
//     * @param employee the employee to set
//     */
//    public void setEmployee(HrEmployee employee) {
//        this.employee = employee;
//    }
//
//    /**
//     * @return the rowDuplicateExt
//     */
//    public String getRowDuplicateExt() {
//        return rowDuplicateExt;
//    }
//
//    /**
//     * @param rowDuplicateExt the rowDuplicateExt to set
//     */
//    public void setRowDuplicateExt(String rowDuplicateExt) {
//        this.rowDuplicateExt = rowDuplicateExt;
//    }
//
//    /**
//     * @return the externalCommitteeDetail
//     */
//    public ComCommitteeExternal getExternalCommitteeDetail() {
//        if (externalCommitteeDetail == null) {
//            externalCommitteeDetail = new ComCommitteeExternal();
//        }
//        return externalCommitteeDetail;
//    }
//
//    /**
//     * @param externalCommitteeDetail the externalCommitteeDetail to set
//     */
//    public void setExternalCommitteeDetail(ComCommitteeExternal externalCommitteeDetail) {
//        this.externalCommitteeDetail = externalCommitteeDetail;
//    }
//
//    /**
//     * @return the externalCommitteeMemberDataModel
//     */
//    public DataModel<ComCommitteeExternal> getExternalCommitteeMemberDataModel() {
//        if (externalCommitteeMemberDataModel == null) {
//            externalCommitteeMemberDataModel = new ListDataModel<>();
//        }
//        return externalCommitteeMemberDataModel;
//    }
//
//    /**
//     * @param externalCommitteeMemberDataModel the
//     * externalCommitteeMemberDataModel to set
//     */
//    public void setExternalCommitteeMemberDataModel(DataModel<ComCommitteeExternal> externalCommitteeMemberDataModel) {
//        this.externalCommitteeMemberDataModel = externalCommitteeMemberDataModel;
//    }
//
//    /**
//     * @return the employe
//     */
//    public HrEmploye getEmploye() {
//        if (employe == null) {
//            employe = new HrEmploye();
//        }
//        return employe;
//    }
//
//    /**
//     * @param employe the employe to set
//     */
//    public void setEmploye(HrEmploye employe) {
//        this.employe = employe;
//    }
//
//    public void onRowEdit(RowEditEvent event) {
//        int rowIndex = committeeMemberDataModel.getRowIndex();
//        ComCommitteeDetail committeeOrg = new ComCommitteeDetail();
////        committeeOrg = extMemberDetailList.get(rowIndex);
//
//        ComCommitteeDetail comMem = (ComCommitteeDetail) event.getObject();
//
//        boolean found = false;
//        for (int i = 0; i < committee.getComCommitteeDetailList().size(); i++) {
//            if (i != rowIndex) {
//                if (committee.getComCommitteeDetailList().get(i).getMemberId().equals(comMem.getMemberId())) {
//                    found = true;
//                    break;
//                }
//            }
//        }
//
//        if (found == true) {
//            JsfUtil.addErrorMessage("Member Information Duplicated !!");
//            comMem.setMemberId(null);
//            committee.getComCommitteeDetailList().set(rowIndex, comMem);
//            recreateDataModel();
//        } else {
//            committee.getComCommitteeDetailList().set(rowIndex, comMem);
//            recreateDataModel();
//        }
//    }
//
//    public void onRowCancel(RowEditEvent event) {
//    }
//
//    public void onRowDelete(RowEditEvent event) {
//        committee.getComCommitteeDetailList().remove(event.getObject());
//    }
//
//    public void onExtRowEdit(RowEditEvent event) {
//        int rowIndex = externalCommitteeMemberDataModel.getRowIndex();
//        ComCommitteeExternal extCommitteeOrg = new ComCommitteeExternal();
//        extCommitteeOrg = extMemberDetailList.get(rowIndex);
//
//        ComCommitteeExternal extCom = (ComCommitteeExternal) event.getObject();
//
//        boolean found = false;
//        for (int i = 0; i < committee.getComCommitteeExternalList().size(); i++) {
//            if (i != rowIndex) {
//                if (committee.getComCommitteeExternalList().get(i).getExternalMemberName().equals(extCommitteeOrg.getExternalMemberName())) {
//                    found = true;
//                    break;
//                }
//            }
//        }
//
//        if (found == true) {
//            JsfUtil.addErrorMessage("Member Information Duplicated !!");
//            extCommitteeOrg.setExternalMemberName(null);
//            committee.getComCommitteeExternalList().set(rowIndex, extCommitteeOrg);
//            recreateExternalDataModel();
//        } else {
//            committee.getComCommitteeExternalList().set(rowIndex, extCommitteeOrg);
//            recreateExternalDataModel();
//        }
//
////        if (checkExternalMember.contains(extCom.getExternalMemberName())) {
////            JsfUtil.addErrorMessage("Member Information Duplicated !!");
////        }else {            
////            committee.getComCommitteeExternalList().set(rowIndex, extCommitteeOrg);
////            recreateExternalDataModel();
////        }
//    }
//
//    public void onExtRowCancel(RowEditEvent event) {
//    }
//
//    public void removeInternalMemberDetail() {
//        int rowIndex = committeeMemberDataModel.getRowIndex();
//        ComCommitteeDetail internalCommittee = committee.getComCommitteeDetailList().get(rowIndex);
//        committee.getComCommitteeDetailList().remove(rowIndex);
//        recreateDataModel();
//        if (saveorUpdateBundle.equals("Update")) {
//            committeeBeanLocal.deleteInternalCommitteeInfo(internalCommittee);
//        }
//    }
//
//    public void removeExternalMemberDetail() {
//        int rowIndex = externalCommitteeMemberDataModel.getRowIndex();
//        ComCommitteeExternal externalCommittee = committee.getComCommitteeExternalList().get(rowIndex);
//        committee.getComCommitteeExternalList().remove(rowIndex);
//        recreateExternalDataModel();
//        if (saveorUpdateBundle.equals("Update")) {
//            committeeBeanLocal.deleteExternalCommitteeInfo(externalCommittee);
//        }
//    }
//
//    /**
//     * @return the extMemberDetailList
//     */
//    public List<ComCommitteeExternal> getExtMemberDetailList() {
//        if (extMemberDetailList == null) {
//            extMemberDetailList = new ArrayList<>();
//        }
//        return extMemberDetailList;
//    }
//
//    /**
//     * @param extMemberDetailList the extMemberDetailList to set
//     */
//    public void setExtMemberDetailList(List<ComCommitteeExternal> extMemberDetailList) {
//        this.extMemberDetailList = extMemberDetailList;
//    }
//
//}
