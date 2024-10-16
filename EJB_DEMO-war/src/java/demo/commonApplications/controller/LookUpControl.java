///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package et.gov.insa.erp.commonApplications.controller;
//
//import et.gov.insa.erp.commonApplications.util.JsfUtil;
//import et.gov.insa.erp.commonApplications.bussinessLogic.LookUpBeanLocal;
//import et.gov.insa.erp.commonApplications.entity.LookUp;
//import et.gov.insa.erp.commonApplications.util.CellKey;
//import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import javax.ejb.EJB;
//import javax.faces.component.UIComponent;
//import javax.faces.component.UISelectItem;
//import javax.faces.component.html.HtmlInputHidden;
//import javax.faces.component.html.HtmlInputText;
//import javax.faces.component.html.HtmlOutputLabel;
//import javax.faces.component.html.HtmlPanelGrid;
//import javax.faces.component.html.HtmlSelectOneMenu;
//import javax.faces.event.ValueChangeEvent;
//import javax.faces.model.DataModel;
//import javax.faces.model.ListDataModel;
//import javax.faces.model.SelectItem;
//import javax.faces.view.ViewScoped;
//import org.primefaces.event.SelectEvent;
//
///**
// *
// * @author Tsehayu Tilahun
// */
//@Named("lookUpControl")
//@ViewScoped
//public class LookUpControl implements Serializable {
//
//    @EJB
//    private LookUpBeanLocal lookUpBeanLocal;
//
//    private LookUp lookUp;
//
//    /**
//     * Creates a new instance of LookUpControl
//     */
//    public LookUpControl() {
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="Initialization">
//    public SelectItem[] getSystemList() {
//        SelectItem[] items = new SelectItem[11];
//        items[0] = new SelectItem("", "--- Select One ---");
//        items[1] = new SelectItem("HR", "HRMS");
//        items[2] = new SelectItem("FMS", "IBFMS");
//        items[3] = new SelectItem("PAPMS", "PAPMS");
//        items[4] = new SelectItem("SCMS", "SCMS");
//        items[5] = new SelectItem("SMS", "SMS");
//        items[6] = new SelectItem("SPRAS", "SPRAS");
//        items[7] = new SelectItem("LIMS", "LIMS");
//        items[8] = new SelectItem("PMMS", "PMMS");
//        items[9] = new SelectItem("WF", "WORKFLOW");
//        items[10] = new SelectItem("COM", "COMMON");
//        return items;
//    }
//
//    public class LookUpTableList implements Serializable {
//
//        public LookUpTableList() {
//        }
//        String name;
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//    }
//    String selectedSystem;
//    private ArrayList<LookUpTableList> tableList = new ArrayList<LookUpTableList>();
//    ArrayList<String> columns = new ArrayList<String>();
//    private int rows = 0;
//    ArrayList<String[]> _data;
//    private HashMap cellMap = new HashMap();
//    private DataModel columnDataModel;
//    private DataModel rowDataModel;
//    private HtmlPanelGrid divLabel = new HtmlPanelGrid();
//    private HtmlPanelGrid divValue = new HtmlPanelGrid();
//    private HtmlOutputLabel lblMessage = new HtmlOutputLabel();
//    private HtmlPanelGrid pnlContainer = new HtmlPanelGrid();
//    private String txtTableName;
//    private ArrayList<SelectItem> tableColumn = null;
//    int Cursor_Row = -1;
//    private int selectedRow = 0;
//    private ArrayList<Boolean> rowSelection = new ArrayList<Boolean>();
//    String lblTableName;
//    String saveRender = "hidden";
//    String updateRender = "hidden";
//    String message = null;
//
//    // </editor-fold>
//    
//    // <editor-fold defaultstate="collapsed" desc="Getter AND Setter">
//    public DataModel getRowDataModel() {
//        return rowDataModel;
//    }
//
//    public DataModel getColumnDataModel() {
//        return columnDataModel;
//    }
//
//    public String getSelectedSystem() {
//        if (selectedSystem == null) {
//            selectedSystem = new String();
//        }
//        return selectedSystem;
//    }
//
//    public void setSelectedSystem(String selectedSystem) {
//        this.selectedSystem = selectedSystem;
//    }
//
//    public ArrayList<LookUpTableList> getTableList() {
//        if (tableList == null) {
//            tableList = new ArrayList<>();
//        }
//        return tableList;
//    }
//
//    public void setTableList(ArrayList<LookUpTableList> tableList) {
//        this.tableList = tableList;
//    }
//
//    public LookUp getLookUp() {
//        if (lookUp == null) {
//            lookUp = new LookUp();
//        }
//        return lookUp;
//    }
//
//    public void setLookUp(LookUp lookUp) {
//        this.lookUp = lookUp;
//    }
//
//    public int getRows() {
//        return rows;
//    }
//
//    public HtmlPanelGrid getDivLabel() {
//        divLabel.setStyle("left: 24px;");
//        return divLabel;
//    }
//
//    public void setDivLabel(HtmlPanelGrid divLabel) {
//        this.divLabel = divLabel;
//    }
//
//    public HtmlPanelGrid getDivValue() {
//        divValue.setStyle("display: block; left: 190px;");
//        return divValue;
//    }
//
//    public void setDivValue(HtmlPanelGrid divValue) {
//        this.divValue = divValue;
//    }
//
//    public HtmlPanelGrid getPnlContainer() {
//        return pnlContainer;
//    }
//
//    public void setPnlContainer(HtmlPanelGrid pnlContainer) {
//        this.pnlContainer = pnlContainer;
//    }
//
//    public String getTxtTableName() {
//        return txtTableName;
//    }
//
//    public void setTxtTableName(String txtTableName) {
//        this.txtTableName = txtTableName;
//    }
//
//    public ArrayList<SelectItem> getTableColumn() {
//        return tableColumn;
//    }
//
//    public void setTableColumn(ArrayList<SelectItem> tableColumn) {
//        this.tableColumn = tableColumn;
//    }
//
//    public int getCursor_Row() {
//        return Cursor_Row;
//    }
//
//    public void setCursor_Row(int Cursor_Row) {
//        this.Cursor_Row = Cursor_Row;
//    }
//
//    public boolean isrowSelection() {
//        return rowSelection.get(selectedRow);
//    }
//
//    public String getLblTableName() {
//        return lblTableName;
//    }
//
//    public void setLblTableName(String lblTableName) {
//        this.lblTableName = lblTableName;
//    }
//
//    public HtmlOutputLabel getLblMessage() {
//        return lblMessage;
//    }
//
//    public void setLblMessage(HtmlOutputLabel lblMessage) {
//        this.lblMessage = lblMessage;
//    }
//
//    public String getSaveRender() {
//        return saveRender;
//    }
//
//    public void setSaveRender(String saveRender) {
//        this.saveRender = saveRender;
//    }
//
//    public String getUpdateRender() {
//        return updateRender;
//    }
//
//    public void setUpdateRender(String updateRender) {
//        this.updateRender = updateRender;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    // </editor-fold>
//    
//    // <editor-fold defaultstate="collapsed" desc="Main">
//    public void selectedSystemEvent(ValueChangeEvent vce) {
//        if (vce.getNewValue() != null) {
//            tableList.clear();
//            int tableNameSize = -1;
//            ArrayList<String> tableNames = lookUpBeanLocal.getLookUpTables(vce.getNewValue().toString());
//            if (tableNames != null) {
//                tableNameSize = tableNames.size();
//            }
//            if (tableNameSize > 0) {
//                for (int i = 0; i < tableNames.size(); i++) {
//                    LookUpTableList tableName = new LookUpTableList();
//                    tableName.setName(tableNames.get(i));
//                    tableList.add(tableName);
//                }
//            }
//        }
//    }
//
//    public void onRowSelect(SelectEvent event) {
//        if (event.getObject() != null) {
//            LookUpTableList list = (LookUpTableList) event.getObject();
//            String selectedTbl = list.getName();
//            setTxtTableName(selectedTbl);
//            setLblTableName(selectedTbl);
//            rowDataModel = null;
//            columnDataModel = null;
//            Cursor_Row = -1;
//            populateTblData(selectedTbl);
//            populatePopUp(Cursor_Row);
//            saveRender = "display";
//            updateRender = "hidden";
//            message = null;
//        }
//    }
//
//    public void onRowSelectForUpdate(SelectEvent event) {
//        if (event.getObject() != null) {
//            Cursor_Row = Integer.parseInt(event.getObject().toString()) - 1;
//            populatePopUp(Cursor_Row);
//            saveRender = "hidden";
//            updateRender = "display";
//            message = null;
//        }
//    }
//
//    private void populateTblData(String selectedTbl) {
//        if (selectedTbl != null && selectedTbl != "") {
//            getLookUp().setTableName(selectedTbl);
//            columns = lookUpBeanLocal.getColumns(lookUp);
//            HashMap tableInfo = new HashMap();
//            tableInfo.put("name", selectedTbl);
//            tableInfo.put("noColumn", columns.size());
//            if (lookUpBeanLocal.selectData(tableInfo) == null) {
//                rows = 0;
//            } else {
//                _data = lookUpBeanLocal.selectData(tableInfo);
//                rows = _data.size();
//            }
//            generateDataModels();
//        }
//    }
//
//    private void generateDataModels() {
//        List rowList = new ArrayList();
//        for (int i = 1; i <= rows; i++) {
//            rowList.add(String.valueOf(i));
//        }
//        rowDataModel = new ListDataModel(rowList);
//        columnDataModel = new ListDataModel(columns);
//    }
//
//    public String getCellValue() {
//        if (rowDataModel.isRowAvailable() && columnDataModel.isRowAvailable() && _data != null) {
//            cellMap.clear();
//            String row = (String) rowDataModel.getRowData();
//            int currentRow = Integer.parseInt(row);
//            Object column = columnDataModel.getRowData();
//            int currentColumn = ((ArrayList) columnDataModel.getWrappedData()).indexOf(column);
//            Object key = new CellKey(row, column);
//            if (!cellMap.containsKey(key)) {
//                if (_data.get(currentRow - 1)[currentColumn] != null && _data.get(currentRow - 1)[currentColumn].contains("ForeignKey")) {
//                    cellMap.put(key, _data.get(currentRow - 1)[currentColumn].toString().split("@")[0]);
//                } else {
//                    cellMap.put(key, _data.get(currentRow - 1)[currentColumn]);
//                }
//            }
//            return (String) cellMap.get(key);
//        }
//        return null;
//    }
//// </editor-fold>
//
//    // <editor-fold defaultstate="collapsed" desc="PopUp">
//    private void populatePopUp(int cursor) {
//        String[] _rowData = null;
//        if (cursor >= 0) {
//            _rowData = _data.get(cursor);
//        } else {
//            _rowData = null;
//        }
//
//        getDivLabel().getChildren().clear();
//        getDivValue().getChildren().clear();
//        getPnlContainer().getChildren().clear();
//        for (int i = 0; i < columns.size(); i++) {
//            int top = 24 * (i + 1);
//            HtmlOutputLabel fieldLable = new HtmlOutputLabel();
//            if (i != 0) {
//                fieldLable.setValue(columns.get(i));
//                fieldLable.setStyle("display: block; position: "
//                        + "absolute; top: " + top + "px");
//                getDivLabel().getChildren().add(fieldLable);
//            }
//            if (lookUpBeanLocal.checkForeignKey(getTxtTableName()).contains(columns.get(i)) == true) {
//                HtmlSelectOneMenu fieldValue = new HtmlSelectOneMenu();
//                fieldValue.setId("cmb" + i);
//                tableColumn = lookUpBeanLocal.refTableDetail(getTxtTableName(), columns.get(i));
//                UISelectItem itemSelect = new UISelectItem();
//                itemSelect.setItemLabel("Please select One");
//                itemSelect.setItemValue("null");
//                fieldValue.getChildren().add(itemSelect);
//                for (int z = 0; z < tableColumn.size(); z++) {
//                    UISelectItem item = new UISelectItem();
//                    item.setItemLabel(tableColumn.get(z).getLabel().toString());
//                    item.setItemValue(tableColumn.get(z).getValue().toString());
//                    fieldValue.getChildren().add(item);
//                }
//                fieldValue.setStyle("display: block; position: "
//                        + "absolute; left:150px; top: " + top + "px");
//                if (_rowData != null) {
//                    fieldValue.setValue(_rowData[i].toString().split("@")[1]);
//                }
//                getDivValue().getChildren().add(fieldValue);
//
//            } else if (lookUpBeanLocal.checkPrimaryKey(getTxtTableName()).equals(columns.get(i)) ) {
//                HtmlInputHidden fieldValue = new HtmlInputHidden();
//                fieldValue.setId("hdn" + i);
//                if (_rowData != null) {
//                    fieldValue.setValue(_rowData[i]);
//                } else {
//                    fieldValue.setValue(0);
//                }
//                getDivValue().getChildren().add(fieldValue);
//            } else {
//                HtmlInputText fieldValue = new HtmlInputText();
//                fieldValue.setId("txtValue" + i);
//                if (_rowData != null) {
//                    fieldValue.setValue(_rowData[i]);
//                } else {
//                    fieldValue.setValue(null);
//                }
//                fieldValue.setStyle("display: block; position: "
//                        + "absolute; left:150px; top: " + top + "px");
//                getDivValue().getChildren().add(fieldValue);
//            }
//
//        }
//        getPnlContainer().getChildren().add(getDivLabel());
//        getPnlContainer().getChildren().add(getDivValue());
//    }
//
//    public void btnAdd() {
//        boolean validResult = true;
//        List<UIComponent> newData = getDivValue().getChildren();
//        ArrayList<String> rowData = new ArrayList();
//        for (int i = 0; i < newData.size(); i++) {
//            if (newData.get(i).getId().contains("cmb") == true) {
//                HtmlSelectOneMenu item = (HtmlSelectOneMenu) newData.get(i);
//                rowData.add(item.getValue().toString());
//                if (item.getValue().toString().compareToIgnoreCase("null") == 0 || item.getValue().toString().compareToIgnoreCase("") == 0) {
//                    String required = lookUpBeanLocal.checkRequiredOrNot(getTxtTableName(), columns.get(i));
//                    if ("N".equals(required)) {
//                        validResult = false;
//                        message = columns.get(i) + ": Value is Required";
//                       // message = ": Value is Required";
//                          System.out.println("addmessage"+message);
//                        break;
//                    }
//                }
//            } else if (newData.get(i).getId().contains("hdn") == true) {
//                HtmlInputHidden item = (HtmlInputHidden) newData.get(i);
//                rowData.add(item.getValue().toString());
//            } else {
//                    System.out.println("3addmessage"+message);
//                HtmlInputText fieldValue = (HtmlInputText) newData.get(i);
//                rowData.add(fieldValue.getValue().toString());
//                if (fieldValue.getValue().equals("") ) {
//                      System.out.println("4addmessage"+message);
//                    String required = lookUpBeanLocal.checkRequiredOrNot(getTxtTableName(), columns.get(i));
//                     System.out.println("required"+required);
//                    if ("N".equals(required)) {
//                        validResult = false;
//                     message = columns.get(i) + ": Value is Required";
//                      //   message =  ": Value is Required";
//                        System.out.println("2addmessage"+message);
//                        // message =  ": Value is Required";
//                        //JsfUtil.addErrorMessage("Field are reuired");
//                        break;
//                    }
//                }
//            }
//        }
//        if (validResult) {
//            message = null;
//            int saveResult = -1;
//            saveResult = lookUpBeanLocal.saveLookUp(           
//                    getTxtTableName(),
//                    columns.toString(),
//                    rowData.toString());
//             System.out.println("controlmessage"+saveResult);
//            if (saveResult != -1) {
//                populateTblData(getTxtTableName());
//                Cursor_Row = -1;
//                populatePopUp(Cursor_Row);
//                saveRender = "display";
//                updateRender = "hidden";
//                JsfUtil.addSuccessMessage("lookUp Data Created");
//            } else {
//                 // message =  " Values are Required";
//                JsfUtil.addSuccessMessage("Something Occured on Data Creation");
//            }
//        }
//       
//
//    }
//
//    public void btnUpdate() {
//        boolean validResult = true;
//        List<UIComponent> newData = getDivValue().getChildren();
//        ArrayList<String> rowData = new ArrayList();
//        for (int i = 0; i < newData.size(); i++) {
//            if (newData.get(i).getId().contains("cmb") == true) {
//                HtmlSelectOneMenu item = (HtmlSelectOneMenu) newData.get(i);
//                rowData.add(item.getValue().toString());
//                if (item.getValue().toString().compareToIgnoreCase("null") == 0) {
//                    String required = lookUpBeanLocal.checkRequiredOrNot(getTxtTableName(), columns.get(i));
//                    if ("N".equals(required)) {
//                        validResult = false;
//                        message = columns.get(i) + ": Value is Required";
//                        break;
//                    }
//                }
//            } else if (newData.get(i).getId().contains("hdn") == true) {
//                HtmlInputHidden item = (HtmlInputHidden) newData.get(i);
//                rowData.add(item.getValue().toString());
//            } else {
//                HtmlInputText fieldValue = (HtmlInputText) newData.get(i);
//                rowData.add(fieldValue.getValue().toString());
//                if (fieldValue.getValue().toString().compareToIgnoreCase("") == 0) {
//                    String required = lookUpBeanLocal.checkRequiredOrNot(getTxtTableName(), columns.get(i));
//                    if ("N".equals(required)) {
//                        validResult = false;
//                        message = columns.get(i) + ": Value is Required";
//                        break;
//                    }
//                }
//            }
//        }
//
//        if (validResult) {
//            message = null;
//            int updateResult = -1;
//            updateResult = lookUpBeanLocal.updateLookUp(
//                    getTxtTableName(),
//                    columns.toString(),
//                    rowData.toString());
//            if (updateResult != -1) {
//                populateTblData(getTxtTableName());
//                Cursor_Row = -1;
//                populatePopUp(Cursor_Row);
//                JsfUtil.addSuccessMessage("lookUp Data Modified");
//                saveRender = "display";
//                updateRender = "hidden";
//            } else {
//                JsfUtil.addSuccessMessage("Something Occured on Data Modified");
//            }
//        }
//
//    }
//    // </editor-fold>
//    
//    
//
//}
