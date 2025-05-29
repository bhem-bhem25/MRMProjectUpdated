/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package secure.sms;

import all_requests.Request;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import all_requests.RequestDAO;
import all_requests.RequestDAOImpl;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import supplies.*;
/**
 *
 * @author Lenovo
 */
public class AdminGUI extends javax.swing.JFrame {
    private RequestDAOImpl requestDAOImpl = new RequestDAOImpl();
    private SupplyDAOImpl supplyDAOImpl = new SupplyDAOImpl();
    private Supply supply = null;
    /**
     * Creates new form AdminGUI
     */
    public AdminGUI() {
        initComponents();
        refreshTables();
    }
    
    public void refreshTBL() {
        ArrayList<Request> requests = requestDAOImpl.read_all(); // use your actual DAO instance here
        DefaultTableModel model = (DefaultTableModel) requestsTBL.getModel();
        model.setRowCount(0); // Clear table before repopulating

        for (Request request : requests) {
            model.addRow(new Object[]{
                request.getId(),
                request.getUser_id(),
                request.getRequest_type(),
                request.getRequest_info(),
                request.getPriority(),
                request.getDate_created()
            });
        }
    }
    
    public void refreshConsumableTBL(){
        DefaultTableModel model = (DefaultTableModel) consumableTBL.getModel();
        model.setRowCount(0);
        
        for(Supply supply : supplyDAOImpl.read_all()){
            if (supply.getName().startsWith("Con:")) {
                model.addRow(new Object[]{
                    supply.getSupply_id(), 
                    supply.getName().substring(4),
                    supply.getQuantity(),
                    supply.getPreferences()
                });
            }
        }
    }
    
    public void refreshEquipmentTBL(){
        DefaultTableModel model = (DefaultTableModel) equipmentTBL.getModel();
        model.setRowCount(0);
        
        for(Supply supply : supplyDAOImpl.read_all()){
            if (supply.getName().startsWith("Equ:")) {
                model.addRow(new Object[]{
                    supply.getSupply_id(), 
                    supply.getName().substring(4),
                    supply.getQuantity(),
                    supply.getPreferences()
                });
            }
        }
    }
    
    public void refreshTechnologyTBL(){
        DefaultTableModel model = (DefaultTableModel) technologyTBL.getModel();
        model.setRowCount(0);
        
        for(Supply supply : supplyDAOImpl.read_all()){
            if (supply.getName().startsWith("Tec:")) {
                model.addRow(new Object[]{
                    supply.getSupply_id(), 
                    supply.getName().substring(4),
                    supply.getQuantity(),
                    supply.getPreferences()
                });
            }
        }
    }
    
    public void refreshOthersTBL(){
        DefaultTableModel model = (DefaultTableModel) othersTBL.getModel();
        model.setRowCount(0);
        
        for(Supply supply : supplyDAOImpl.read_all()){
            if (supply.getName().startsWith("Oth:")) {
                model.addRow(new Object[]{
                    supply.getSupply_id(), 
                    supply.getName().substring(4),
                    supply.getQuantity(),
                    supply.getPreferences()
                });
            }
        }
    }

    
    public void refreshTables(){
        refreshTBL();
        refreshConsumableTBL();
        refreshEquipmentTBL();
        refreshTechnologyTBL();
        refreshOthersTBL();
    }
    
    public void searchConsumableTable(String str){
        DefaultTableModel model = (DefaultTableModel) consumableTBL.getModel();
        model.setRowCount(0);
        
        for(Supply supply : supplyDAOImpl.search(str)){
            model.addRow(new Object[]{
                supply.getSupply_id(), 
                supply.getName(),
                supply.getQuantity(),
                supply.getPreferences()
            });
        }    
    }
    
    public void searchEquipmentTable(String str){
        DefaultTableModel model = (DefaultTableModel) equipmentTBL.getModel();
        model.setRowCount(0);
        
        for(Supply supply : supplyDAOImpl.search(str)){
            model.addRow(new Object[]{
                supply.getSupply_id(), 
                supply.getName(),
                supply.getQuantity(),
                supply.getPreferences()
            });
        }    
    }
    
    public void searchTechnologyTable(String str){
        DefaultTableModel model = (DefaultTableModel)technologyTBL.getModel();
        model.setRowCount(0);
        
        for(Supply supply : supplyDAOImpl.search(str)){
            model.addRow(new Object[]{
                supply.getSupply_id(), 
                supply.getName(),
                supply.getQuantity(),
                supply.getPreferences()
            });
        }    
    }
    
    public void searchOthersTable(String str){
        DefaultTableModel model = (DefaultTableModel) othersTBL.getModel();
        model.setRowCount(0);
        
        for(Supply supply : supplyDAOImpl.search(str)){
            model.addRow(new Object[]{
                supply.getSupply_id(), 
                supply.getName(),
                supply.getQuantity(),
                supply.getPreferences()
            });
        }    
    }
    
     public void resetConsumableTab(){
        refreshConsumableTBL();
        consumableNameTF.setText("");
        consumableQuantityTF.setText("");
        consumablePreferencesTF.setText("");
        consumableSaveBTN.setText("Save");
    }
     
     public void resetEquipmentTab(){
        refreshEquipmentTBL();
        equipmentNameTF.setText("");
        equipmentQuantityTF.setText("");
        equipmentPreferencesTF.setText("");
        equipmentSaveBTN.setText("Save");
    }
     
     public void resetTechnologyTab(){
        refreshTechnologyTBL();
        technologyNameTF.setText("");
        technologyQuantityTF.setText("");
        technologyPreferencesTF.setText("");
        technologySaveBTN.setText("Save");
    }
     
     public void resetOthersTab(){
        refreshOthersTBL();
        othersNameTF.setText("");
        othersQuantityTF.setText("");
        othersPreferencesTF.setText("");
        othersSaveBTN.setText("Save");
    }
        
    




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        consumablePUM = new javax.swing.JPopupMenu();
        consumableUpdate = new javax.swing.JMenuItem();
        consumableDelete = new javax.swing.JMenuItem();
        equipmentPUM = new javax.swing.JPopupMenu();
        equipmentUpdate = new javax.swing.JMenuItem();
        equipmentDelete = new javax.swing.JMenuItem();
        technologyPUM = new javax.swing.JPopupMenu();
        technologyUpdate = new javax.swing.JMenuItem();
        technologyDelete = new javax.swing.JMenuItem();
        othersPUM = new javax.swing.JPopupMenu();
        othersUpdate = new javax.swing.JMenuItem();
        othersDelete = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        requestsTBL = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        consumableTBL = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        consumableNameTF = new javax.swing.JTextField();
        consumablePreferencesTF = new javax.swing.JTextField();
        consumableQuantityTF = new javax.swing.JTextField();
        consumableSaveBTN = new javax.swing.JButton();
        consumableCancelTF = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        consumableSearchBTN = new javax.swing.JButton();
        consumableSearchTF = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        equipmentTBL = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        equipmentQuantityTF = new javax.swing.JTextField();
        equipmentNameTF = new javax.swing.JTextField();
        equipmentSaveBTN = new javax.swing.JButton();
        equipmentCancelBTN = new javax.swing.JButton();
        equipmentPreferencesTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        equipmentSearchBTN = new javax.swing.JButton();
        equipmentSearchTF = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        technologyTBL = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        technologyNameTF = new javax.swing.JTextField();
        technologyQuantityTF = new javax.swing.JTextField();
        technologySaveBTN = new javax.swing.JButton();
        technologyCancelBTN = new javax.swing.JButton();
        technologyPreferencesTF = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        technologySearchTF = new javax.swing.JTextField();
        technologySearchBTN = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        othersTBL = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        othersNameTF = new javax.swing.JTextField();
        othersQuantityTF = new javax.swing.JTextField();
        othersPreferencesTF = new javax.swing.JTextField();
        othersSaveBTN = new javax.swing.JButton();
        othersCancelBTN = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        othersSearchTF = new javax.swing.JTextField();
        othersSearchBTN = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();

        consumableUpdate.setText("jMenuItem1");
        consumableUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consumableUpdateActionPerformed(evt);
            }
        });
        consumablePUM.add(consumableUpdate);
        consumableUpdate.getAccessibleContext().setAccessibleName("Update");

        consumableDelete.setText("jMenuItem2");
        consumableDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consumableDeleteActionPerformed(evt);
            }
        });
        consumablePUM.add(consumableDelete);
        consumableDelete.getAccessibleContext().setAccessibleName("Delete");

        equipmentUpdate.setText("jMenuItem1");
        equipmentUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipmentUpdateActionPerformed(evt);
            }
        });
        equipmentPUM.add(equipmentUpdate);
        equipmentUpdate.getAccessibleContext().setAccessibleName("Update");

        equipmentDelete.setText("jMenuItem1");
        equipmentDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipmentDeleteActionPerformed(evt);
            }
        });
        equipmentPUM.add(equipmentDelete);
        equipmentDelete.getAccessibleContext().setAccessibleName("Delete");
        equipmentDelete.getAccessibleContext().setAccessibleDescription("");

        technologyUpdate.setText("jMenuItem1");
        technologyUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                technologyUpdateActionPerformed(evt);
            }
        });
        technologyPUM.add(technologyUpdate);
        technologyUpdate.getAccessibleContext().setAccessibleName("Update");

        technologyDelete.setText("jMenuItem1");
        technologyDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                technologyDeleteActionPerformed(evt);
            }
        });
        technologyPUM.add(technologyDelete);
        technologyDelete.getAccessibleContext().setAccessibleName("Delete");

        othersUpdate.setText("jMenuItem1");
        othersUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                othersUpdateActionPerformed(evt);
            }
        });
        othersPUM.add(othersUpdate);
        othersUpdate.getAccessibleContext().setAccessibleName("Update");

        othersDelete.setText("jMenuItem1");
        othersDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                othersDeleteActionPerformed(evt);
            }
        });
        othersPUM.add(othersDelete);
        othersDelete.getAccessibleContext().setAccessibleName("Delete");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 937, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Dashboard", jPanel1);

        jPanel2.setPreferredSize(new java.awt.Dimension(494, 299));

        requestsTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                " ID", "User ID", "Type", "Request Info", "Priority ", "Created"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        requestsTBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                requestsTBLMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(requestsTBL);
        if (requestsTBL.getColumnModel().getColumnCount() > 0) {
            requestsTBL.getColumnModel().getColumn(0).setResizable(false);
            requestsTBL.getColumnModel().getColumn(1).setResizable(false);
            requestsTBL.getColumnModel().getColumn(2).setResizable(false);
            requestsTBL.getColumnModel().getColumn(3).setResizable(false);
            requestsTBL.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Request List", jPanel2);

        consumableTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supply ID", "Supply Name", "Quantity", "Preferences"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        consumableTBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                consumableTBLMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(consumableTBL);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Supplies Entry/Update Form"));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel1.setText("Fill out the fields below...");

        jLabel2.setText("Supply Name:");

        jLabel3.setText("Quantity:");

        jLabel4.setText("Preferences");

        consumableQuantityTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consumableQuantityTFActionPerformed(evt);
            }
        });

        consumableSaveBTN.setText("Save");
        consumableSaveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consumableSaveBTNActionPerformed(evt);
            }
        });

        consumableCancelTF.setText("Cancel");
        consumableCancelTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consumableCancelTFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(consumableSaveBTN)
                                .addGap(18, 18, 18)
                                .addComponent(consumableCancelTF)
                                .addGap(0, 31, Short.MAX_VALUE))
                            .addComponent(consumableQuantityTF)
                            .addComponent(consumablePreferencesTF)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(consumableNameTF)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(consumableNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(consumableQuantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(consumablePreferencesTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consumableSaveBTN)
                    .addComponent(consumableCancelTF))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("Search supply:");

        consumableSearchBTN.setText("Search");
        consumableSearchBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consumableSearchBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(consumableSearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(consumableSearchBTN)))
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(consumableSearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(consumableSearchBTN))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.getAccessibleContext().setAccessibleDescription("");

        jTabbedPane2.addTab("Consumable", jPanel5);

        equipmentTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supply ID", "Supply Name", "Quantity", "Preferences"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        equipmentTBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                equipmentTBLMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(equipmentTBL);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Supplies Entry/Update Form"));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel7.setText("Fill out the fields below...");

        jLabel8.setText("Supply Name:");

        jLabel9.setText("Quantity:");

        jLabel10.setText("Preferences");

        equipmentSaveBTN.setText("Save");
        equipmentSaveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipmentSaveBTNActionPerformed(evt);
            }
        });

        equipmentCancelBTN.setText("Cancel");
        equipmentCancelBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipmentCancelBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(20, 20, 20)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(equipmentSaveBTN)
                                        .addGap(18, 18, 18)
                                        .addComponent(equipmentCancelBTN))
                                    .addComponent(equipmentPreferencesTF, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(equipmentQuantityTF, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                    .addComponent(equipmentNameTF)))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(equipmentNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(equipmentQuantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(equipmentPreferencesTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(equipmentSaveBTN)
                    .addComponent(equipmentCancelBTN))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("Search supply:");

        equipmentSearchBTN.setText("Search");
        equipmentSearchBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipmentSearchBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(equipmentSearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(equipmentSearchBTN))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 7, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(equipmentSearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(equipmentSearchBTN))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        jPanel11.getAccessibleContext().setAccessibleName("Supplies Entry/Update Form");

        jTabbedPane2.addTab("Classroom Equipment", jPanel6);

        technologyTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supply ID", "Supply Name", "Quantity", "Preferences"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        technologyTBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                technologyTBLMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(technologyTBL);

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Supplies Entry/Update Form"));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel12.setText("Fill out the fields below...");

        jLabel13.setText("Supply Name:");

        jLabel14.setText("Quantity:");

        jLabel15.setText("Preferences");

        technologySaveBTN.setText("Save");
        technologySaveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                technologySaveBTNActionPerformed(evt);
            }
        });

        technologyCancelBTN.setText("Cancel");
        technologyCancelBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                technologyCancelBTNActionPerformed(evt);
            }
        });

        technologyPreferencesTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                technologyPreferencesTFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(31, 31, 31)
                        .addComponent(technologyQuantityTF))
                    .addComponent(jLabel12)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(technologyNameTF))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(technologySaveBTN)
                                .addGap(18, 18, 18)
                                .addComponent(technologyCancelBTN))
                            .addComponent(technologyPreferencesTF, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(technologyNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(technologyQuantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(technologyPreferencesTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(technologyCancelBTN)
                    .addComponent(technologySaveBTN))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setText("Search supply:");

        technologySearchBTN.setText("Search");
        technologySearchBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                technologySearchBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(technologySearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(technologySearchBTN)))
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(technologySearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(technologySearchBTN))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel12.getAccessibleContext().setAccessibleName("Supplies Entry/Update Form");

        jTabbedPane2.addTab("Technology", jPanel7);

        othersTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supply ID", "Supply Name", "Quantity", "Preferences"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        othersTBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                othersTBLMouseReleased(evt);
            }
        });
        jScrollPane5.setViewportView(othersTBL);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Supplies Entry/Update Form"));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel17.setText("Fill out the fields below...");

        jLabel18.setText("Supply Name:");

        jLabel19.setText("Quantity:");

        jLabel20.setText("Preferences");

        othersSaveBTN.setText("Save");
        othersSaveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                othersSaveBTNActionPerformed(evt);
            }
        });

        othersCancelBTN.setText("Cancel");
        othersCancelBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                othersCancelBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(othersQuantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(othersNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(othersSaveBTN)
                                .addGap(18, 18, 18)
                                .addComponent(othersCancelBTN))
                            .addComponent(othersPreferencesTF, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(othersNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(othersQuantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(othersPreferencesTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(othersSaveBTN)
                    .addComponent(othersCancelBTN))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel16.setText("Search supply:");

        othersSearchBTN.setText("Search");
        othersSearchBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                othersSearchBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(othersSearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(othersSearchBTN))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(othersSearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(othersSearchBTN))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Others", jPanel8);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Supply List", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 937, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void requestsTBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_requestsTBLMouseClicked
    int row = requestsTBL.getSelectedRow();
    
    if (row >= 0) {
        Object idValue = requestsTBL.getValueAt(row, 0);
        if (idValue != null) {
            int requestId = (int) idValue;
            Request selectedRequest = requestDAOImpl.read_one(requestId);
            if (selectedRequest != null) {
                RequestDetailsGUI dialog = new RequestDetailsGUI (this, selectedRequest);
                dialog.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selected row does not contain a valid ID.");
        }
    }


    }//GEN-LAST:event_requestsTBLMouseClicked

    private void consumableQuantityTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consumableQuantityTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consumableQuantityTFActionPerformed

    private void technologyPreferencesTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_technologyPreferencesTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_technologyPreferencesTFActionPerformed

    private void consumableSaveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consumableSaveBTNActionPerformed
        // TODO add your handling code here:
    String name = consumableNameTF.getText().trim();
    String quantity = consumableQuantityTF.getText().trim();
    String preferences = consumablePreferencesTF.getText().trim();

    if (name.isEmpty() || quantity.isEmpty() || preferences.isEmpty()) {
        JOptionPane.showMessageDialog(null, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Check if the button is in Update mode
    if (consumableSaveBTN.getText().equals("Update")) {
        // Update logic
        supply.setName(name);
        supply.setQuantity(quantity);
        supply.setPreferences(preferences);

        if (supplyDAOImpl.update(supply.getSupply_id(), supply)) {
            JOptionPane.showMessageDialog(null, "Consumable updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to update consumable!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        // Create logic
        Supply supply = new Supply(0, name, quantity, preferences);
        if (supplyDAOImpl.create(supply)) {
            JOptionPane.showMessageDialog(null, "Consumable saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to save consumable!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    resetConsumableTab();

    }//GEN-LAST:event_consumableSaveBTNActionPerformed

    private void consumableCancelTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consumableCancelTFActionPerformed
        // TODO add your handling code here:
        resetConsumableTab();
    }//GEN-LAST:event_consumableCancelTFActionPerformed

    private void equipmentSaveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipmentSaveBTNActionPerformed
        // TODO add your handling code here:
    String name = "Equ:" + equipmentNameTF.getText().trim();
    String quantity = equipmentQuantityTF.getText().trim();
    String preferences = equipmentPreferencesTF.getText().trim();

    if (name.isEmpty() || quantity.isEmpty() || preferences.isEmpty()) {
        JOptionPane.showMessageDialog(null, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (equipmentSaveBTN.getText().equals("Update")) {
        supply.setName(name);
        supply.setQuantity(quantity);
        supply.setPreferences(preferences);

        if (supplyDAOImpl.update(supply.getSupply_id(), supply)) {
            JOptionPane.showMessageDialog(null, "Equipment updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to update equipment!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        Supply supply = new Supply(0, name, quantity, preferences);
        if (supplyDAOImpl.create(supply)) {
            JOptionPane.showMessageDialog(null, "Equipment saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to save equipment!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    resetEquipmentTab();
    }//GEN-LAST:event_equipmentSaveBTNActionPerformed

    private void technologySaveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_technologySaveBTNActionPerformed
        // TODO add your handling code here:
    String name = "Tec:" + technologyNameTF.getText().trim();
    String quantity = technologyQuantityTF.getText().trim();
    String preferences = technologyPreferencesTF.getText().trim();

    if (name.isEmpty() || quantity.isEmpty() || preferences.isEmpty()) {
        JOptionPane.showMessageDialog(null, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (technologySaveBTN.getText().equals("Update")) {
        supply.setName(name);
        supply.setQuantity(quantity);
        supply.setPreferences(preferences);

        if (supplyDAOImpl.update(supply.getSupply_id(), supply)) {
            JOptionPane.showMessageDialog(null, "Technology updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to update technology!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        Supply supply = new Supply(0, name, quantity, preferences);
        if (supplyDAOImpl.create(supply)) {
            JOptionPane.showMessageDialog(null, "Technology saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to save technology!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    resetTechnologyTab();
    }//GEN-LAST:event_technologySaveBTNActionPerformed

    private void othersSaveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_othersSaveBTNActionPerformed
        // TODO add your handling code here:
    String name = "Oth:" + othersNameTF.getText().trim();
    String quantity = othersQuantityTF.getText().trim();
    String preferences = othersPreferencesTF.getText().trim();

    if (name.isEmpty() || quantity.isEmpty() || preferences.isEmpty()) {
        JOptionPane.showMessageDialog(null, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (othersSaveBTN.getText().equals("Update")) {
        supply.setName(name);
        supply.setQuantity(quantity);
        supply.setPreferences(preferences);

        if (supplyDAOImpl.update(supply.getSupply_id(), supply)) {
            JOptionPane.showMessageDialog(null, "Others updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to update Others!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        Supply supply = new Supply(0, name, quantity, preferences);
        if (supplyDAOImpl.create(supply)) {
            JOptionPane.showMessageDialog(null, "Others saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to save Others!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    resetOthersTab();
    }//GEN-LAST:event_othersSaveBTNActionPerformed

    private void equipmentCancelBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipmentCancelBTNActionPerformed
        // TODO add your handling code here:
        resetEquipmentTab();
    }//GEN-LAST:event_equipmentCancelBTNActionPerformed

    private void technologyCancelBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_technologyCancelBTNActionPerformed
        // TODO add your handling code here:
        resetTechnologyTab();
    }//GEN-LAST:event_technologyCancelBTNActionPerformed

    private void othersCancelBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_othersCancelBTNActionPerformed
        // TODO add your handling code here:
        resetOthersTab();
    }//GEN-LAST:event_othersCancelBTNActionPerformed

    private void consumableSearchBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consumableSearchBTNActionPerformed
        // TODO add your handling code here:
        String str = consumableSearchTF.getText();
        
        searchConsumableTable(str);
    }//GEN-LAST:event_consumableSearchBTNActionPerformed

    private void equipmentSearchBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipmentSearchBTNActionPerformed
        // TODO add your handling code here:
        String str = equipmentSearchTF.getText();
        
        searchEquipmentTable(str);
    }//GEN-LAST:event_equipmentSearchBTNActionPerformed

    private void technologySearchBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_technologySearchBTNActionPerformed
        // TODO add your handling code here:
        String str = technologySearchTF.getText();
        
        searchTechnologyTable(str);
    }//GEN-LAST:event_technologySearchBTNActionPerformed

    private void othersSearchBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_othersSearchBTNActionPerformed
        // TODO add your handling code here:
        String str = othersSearchTF.getText();
        
        searchOthersTable(str);
    }//GEN-LAST:event_othersSearchBTNActionPerformed

    private void consumableTBLMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consumableTBLMouseReleased
        // TODO add your handling code here:
        if (evt.isPopupTrigger()) { 
            int row = consumableTBL.rowAtPoint(evt.getPoint());
        
            if (row >= 0) {
                consumableTBL.setRowSelectionInterval(row, row); 
            }

            consumablePUM.show(consumableTBL, evt.getX(), evt.getY()); 
        } else {
            System.out.println("Nothing happened!");
        }
    }//GEN-LAST:event_consumableTBLMouseReleased

    private void consumableUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consumableUpdateActionPerformed
        // TODO add your handling code here:
    DefaultTableModel model = (DefaultTableModel) consumableTBL.getModel();
    int selectedRow = consumableTBL.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a record to update.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int supply_id = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
    this.supply = supplyDAOImpl.read_one(supply_id);

    if (this.supply != null) {
        consumableNameTF.setText(supply.getName());
        consumableQuantityTF.setText(String.valueOf(supply.getQuantity()));
        consumablePreferencesTF.setText(supply.getPreferences());
        consumableSaveBTN.setText("Update");
    }
    }//GEN-LAST:event_consumableUpdateActionPerformed

    private void consumableDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consumableDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) consumableTBL.getModel();
        int supply_id = Integer.parseInt(model.getValueAt(consumableTBL.getSelectedRow(), 0).toString());
        
        int option = JOptionPane.showConfirmDialog(null, 
                "This will delete the record permanently. Are you sure?", 
                "Confirmation", 
                JOptionPane.OK_CANCEL_OPTION);
        
        if(option == JOptionPane.OK_OPTION){
            if(supplyDAOImpl.delete(supply_id) == true){
                JOptionPane.showMessageDialog(null, 
                        "Supply was deleted!", 
                        "Message", 
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, 
                        "Supply was not deleted!", 
                        "Message", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        
        resetConsumableTab();
    }//GEN-LAST:event_consumableDeleteActionPerformed

    private void equipmentTBLMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equipmentTBLMouseReleased
        // TODO add your handling code here:
        if (evt.isPopupTrigger()) { 
            int row = equipmentTBL.rowAtPoint(evt.getPoint());
        
            if (row >= 0) {
                equipmentTBL.setRowSelectionInterval(row, row); 
            }

            equipmentPUM.show(equipmentTBL, evt.getX(), evt.getY()); 
        } else {
            System.out.println("Nothing happened!");
        }
    }//GEN-LAST:event_equipmentTBLMouseReleased

    private void equipmentUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipmentUpdateActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) equipmentTBL.getModel();
    int selectedRow = equipmentTBL.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a record to update.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int supply_id = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
    this.supply = supplyDAOImpl.read_one(supply_id);

    if (this.supply != null) {
        equipmentNameTF.setText(supply.getName().substring(4)); // Remove "Equ:" prefix
        equipmentQuantityTF.setText(String.valueOf(supply.getQuantity()));
        equipmentPreferencesTF.setText(supply.getPreferences());
        equipmentSaveBTN.setText("Update");
    }
    }//GEN-LAST:event_equipmentUpdateActionPerformed

    private void equipmentDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipmentDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) equipmentTBL.getModel();
        int supply_id = Integer.parseInt(model.getValueAt(equipmentTBL.getSelectedRow(), 0).toString());
        
        int option = JOptionPane.showConfirmDialog(null, 
                "This will delete the record permanently. Are you sure?", 
                "Confirmation", 
                JOptionPane.OK_CANCEL_OPTION);
        
        if(option == JOptionPane.OK_OPTION){
            if(supplyDAOImpl.delete(supply_id) == true){
                JOptionPane.showMessageDialog(null, 
                        "Supply was deleted!", 
                        "Message", 
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, 
                        "Supply was not deleted!", 
                        "Message", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        
        resetEquipmentTab();
    }//GEN-LAST:event_equipmentDeleteActionPerformed

    private void technologyTBLMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_technologyTBLMouseReleased
        // TODO add your handling code here:
        if (evt.isPopupTrigger()) { 
            int row = technologyTBL.rowAtPoint(evt.getPoint());
        
            if (row >= 0) {
                technologyTBL.setRowSelectionInterval(row, row); 
            }

            technologyPUM.show(technologyTBL, evt.getX(), evt.getY()); 
        } else {
            System.out.println("Nothing happened!");
        }
    }//GEN-LAST:event_technologyTBLMouseReleased

    private void technologyUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_technologyUpdateActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) technologyTBL.getModel();
    int selectedRow = technologyTBL.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a record to update.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int supply_id = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
    this.supply = supplyDAOImpl.read_one(supply_id);

    if (this.supply != null) {
        technologyNameTF.setText(supply.getName().substring(4)); // Remove "Tec:" prefix
        technologyQuantityTF.setText(String.valueOf(supply.getQuantity()));
        technologyPreferencesTF.setText(supply.getPreferences());
        technologySaveBTN.setText("Update");
    }
    }//GEN-LAST:event_technologyUpdateActionPerformed

    private void technologyDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_technologyDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) technologyTBL.getModel();
        int supply_id = Integer.parseInt(model.getValueAt(technologyTBL.getSelectedRow(), 0).toString());
        
        int option = JOptionPane.showConfirmDialog(null, 
                "This will delete the record permanently. Are you sure?", 
                "Confirmation", 
                JOptionPane.OK_CANCEL_OPTION);
        
        if(option == JOptionPane.OK_OPTION){
            if(supplyDAOImpl.delete(supply_id) == true){
                JOptionPane.showMessageDialog(null, 
                        "Supply was deleted!", 
                        "Message", 
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, 
                        "Supply was not deleted!", 
                        "Message", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        
        resetTechnologyTab();
    }//GEN-LAST:event_technologyDeleteActionPerformed

    private void othersTBLMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_othersTBLMouseReleased
        // TODO add your handling code here:
        if (evt.isPopupTrigger()) { 
            int row = othersTBL.rowAtPoint(evt.getPoint());
        
            if (row >= 0) {
                othersTBL.setRowSelectionInterval(row, row); 
            }

           othersPUM.show(othersTBL, evt.getX(), evt.getY()); 
        } else {
            System.out.println("Nothing happened!");
        }
    }//GEN-LAST:event_othersTBLMouseReleased

    private void othersUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_othersUpdateActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) othersTBL.getModel();
    int selectedRow = othersTBL.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a record to update.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int supply_id = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
    this.supply = supplyDAOImpl.read_one(supply_id);

    if (this.supply != null) {
        othersNameTF.setText(supply.getName().substring(4)); // Remove "Oth:" prefix
        othersQuantityTF.setText(String.valueOf(supply.getQuantity()));
        othersPreferencesTF.setText(supply.getPreferences());
        othersSaveBTN.setText("Update");
    }
    }//GEN-LAST:event_othersUpdateActionPerformed

    private void othersDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_othersDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) othersTBL.getModel();
        int supply_id = Integer.parseInt(model.getValueAt(othersTBL.getSelectedRow(), 0).toString());
        
        int option = JOptionPane.showConfirmDialog(null, 
                "This will delete the record permanently. Are you sure?", 
                "Confirmation", 
                JOptionPane.OK_CANCEL_OPTION);
        
        if(option == JOptionPane.OK_OPTION){
            if(supplyDAOImpl.delete(supply_id) == true){
                JOptionPane.showMessageDialog(null, 
                        "Supply was deleted!", 
                        "Message", 
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, 
                        "Supply was not deleted!", 
                        "Message", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        
        resetOthersTab();
    }//GEN-LAST:event_othersDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton consumableCancelTF;
    private javax.swing.JMenuItem consumableDelete;
    private javax.swing.JTextField consumableNameTF;
    private javax.swing.JPopupMenu consumablePUM;
    private javax.swing.JTextField consumablePreferencesTF;
    private javax.swing.JTextField consumableQuantityTF;
    private javax.swing.JButton consumableSaveBTN;
    private javax.swing.JButton consumableSearchBTN;
    private javax.swing.JTextField consumableSearchTF;
    private javax.swing.JTable consumableTBL;
    private javax.swing.JMenuItem consumableUpdate;
    private javax.swing.JButton equipmentCancelBTN;
    private javax.swing.JMenuItem equipmentDelete;
    private javax.swing.JTextField equipmentNameTF;
    private javax.swing.JPopupMenu equipmentPUM;
    private javax.swing.JTextField equipmentPreferencesTF;
    private javax.swing.JTextField equipmentQuantityTF;
    private javax.swing.JButton equipmentSaveBTN;
    private javax.swing.JButton equipmentSearchBTN;
    private javax.swing.JTextField equipmentSearchTF;
    private javax.swing.JTable equipmentTBL;
    private javax.swing.JMenuItem equipmentUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JButton othersCancelBTN;
    private javax.swing.JMenuItem othersDelete;
    private javax.swing.JTextField othersNameTF;
    private javax.swing.JPopupMenu othersPUM;
    private javax.swing.JTextField othersPreferencesTF;
    private javax.swing.JTextField othersQuantityTF;
    private javax.swing.JButton othersSaveBTN;
    private javax.swing.JButton othersSearchBTN;
    private javax.swing.JTextField othersSearchTF;
    private javax.swing.JTable othersTBL;
    private javax.swing.JMenuItem othersUpdate;
    private javax.swing.JTable requestsTBL;
    private javax.swing.JButton technologyCancelBTN;
    private javax.swing.JMenuItem technologyDelete;
    private javax.swing.JTextField technologyNameTF;
    private javax.swing.JPopupMenu technologyPUM;
    private javax.swing.JTextField technologyPreferencesTF;
    private javax.swing.JTextField technologyQuantityTF;
    private javax.swing.JButton technologySaveBTN;
    private javax.swing.JButton technologySearchBTN;
    private javax.swing.JTextField technologySearchTF;
    private javax.swing.JTable technologyTBL;
    private javax.swing.JMenuItem technologyUpdate;
    // End of variables declaration//GEN-END:variables
}
