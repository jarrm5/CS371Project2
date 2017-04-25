/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import db.SQLHelper;
import db.SQLHelper.Record;
import db.User;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jarrm5
 */
public class UserAds extends javax.swing.JFrame {
    
    //Capture the user that got to this frame
    private User user;
    private SQLHelper helper;
    private String[] AdvColumns=new String [] {"Title", "Description", "Price", "Date"};
    private String[] MyAdvColumns=new String [] {"ID","Title","Description","Price","Status","Date"};
    
    
    /**
     * Creates new form UserAds
     */
    public UserAds(User user, SQLHelper helper) {
        this.user = user;
        this.helper = helper;
        this.setTitle(user.toString());
        initComponents();
        populate_advertisements_table("");
        populate_myadvertisements_table();
        populate_category_names();
    }
    //Get all the category names for the drop down box
    private void populate_category_names(){
        LinkedList<Record> names=helper.getCategoryNames();
        this.CatFilter.removeAllItems();
        this.CatFilter.addItem("All");
        for(Record n:names){
            this.CatFilter.addItem(n);
        }   
    }
    //Get all advertisements that are active
    //String AND parameter allows for additional filtering
    public void populate_advertisements_table(String AND){
        Object[][] Data=helper.getAdvertisements(AND);
        this.advertisementsJTable.setModel(new DefaultTableModel(Data,AdvColumns));
    }
    //Get all of this user's advertisements
    public void populate_myadvertisements_table(){
        Object[][] Data=helper.getMyAdvertisements(user.getUserId());
        this.myAdvertisementsJTable.setModel(new DefaultTableModel(Data,MyAdvColumns));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        AdvTabs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        advertisementsJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        CatFilter = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        PeriodFilter = new javax.swing.JComboBox();
        SearchTextBox = new javax.swing.JTextField();
        GoButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        myAdvertisementsJTable = new javax.swing.JTable();
        EditButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        advertisementsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(advertisementsJTable);

        jLabel1.setText("Category");

        CatFilter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        CatFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CatFilterActionPerformed(evt);
            }
        });

        jLabel2.setText("Period");

        PeriodFilter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Last 3 Months", "Last 6 Months", "Last 12 Months" }));
        PeriodFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PeriodFilterActionPerformed(evt);
            }
        });

        GoButton.setText("Go");
        GoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Title, Description:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CatFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(PeriodFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(SearchTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CatFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PeriodFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GoButton))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        AdvTabs.addTab("Advertisements", jPanel2);

        myAdvertisementsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(myAdvertisementsJTable);

        EditButton.setText("Edit");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        AdvTabs.addTab("My Advertisements", jPanel3);

        AddButton.setText("Add Advertisement");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AdvTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(AddButton, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AdvTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //When a category filter option is selected from the drop down list
    private void CatFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CatFilterActionPerformed
        //Build an AND statement depending on which category filter was selected
        String AND = "";
        
        switch(CatFilter.getSelectedIndex()){
            //All selected
            case 0:
                break;
            //Cars and Trucks selected
            case 1:
                AND = " AND category_ID = 'CAT'";
                break;
            //Child Care selected
            case 2:
                AND = " AND category_ID = 'CCA'";
                break;
            //Electric selected
            case 3:
                AND = " AND category_ID = 'ELC'";
                break;
            //household selected
            case 4:
                AND = " AND category_ID = 'HOU'";
                break;
            default:
                AND += ";";
        }
        populate_advertisements_table(AND);
    }//GEN-LAST:event_CatFilterActionPerformed
    
    //When a period filter option is selected from the drop down list
    //Form an AND statement that gets the ads within x amount of days
    //DATEDIFF calculates the number of days between now and the ad's posted date
    private void PeriodFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PeriodFilterActionPerformed
        //Build an AND statement depeneding on which period filter was selected
        String AND = "";
        
        switch(PeriodFilter.getSelectedIndex()){
            //All selected
            case 0:
                break;
            //Case for 3 months
            case 1:
                AND = " AND DATEDIFF(NOW(),AdvDateTime) < 90";
                break;
            //case for 6 months
            case 2:
                AND = " AND DATEDIFF(NOW(),AdvDateTime) < 180";
                break;
            //case for 12 months
            case 3:
                AND = " AND DATEDIFF(NOW(),AdvDateTime) < 365";
                break;
            default:
                AND += ";";
        }
        populate_advertisements_table(AND);
    }//GEN-LAST:event_PeriodFilterActionPerformed
    //Submit the search text from the text box to the db
    //Again, form an AND statement with the text from the search box
    //Db will check for substrings in the details and title for each advertisement
    private void GoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoButtonActionPerformed
        String search = SearchTextBox.getText(); 
        String AND = " AND (AdvTitle LIKE '%" + search + "%' OR AdvDetails LIKE '%" + search + "%');";
        populate_advertisements_table(AND);
    }//GEN-LAST:event_GoButtonActionPerformed
    
    //Edit button pressed
    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        /*
               NEED TO LOCK THE ID COLUMN
               NEED TO VALIDATE THE 3 COLUMNS IN CASE THE USER TYPES AN EMPPY STRING
        */
        //Get the id of the row of the listview that is clicked
        int rowClicked = myAdvertisementsJTable.getSelectedRow();
        boolean result = false;
        String toUpdate = "";
        
        //Check to see if a row was clicked at all
        if(rowClicked >= 0){
            //Row clicked, now get the id of the ad that was clicked
            toUpdate = myAdvertisementsJTable.getValueAt(rowClicked,0).toString();
            //Get the updates from AdvTitle,AdvDetails,Price columns ONLY
            String title = myAdvertisementsJTable.getValueAt(rowClicked,1).toString();
            String details = myAdvertisementsJTable.getValueAt(rowClicked,2).toString();
            double price = Double.parseDouble(myAdvertisementsJTable.getValueAt(rowClicked,3).toString());
            //execute the update
            result=helper.updateAdvertisement(toUpdate,title,details,price);
        }
        
        //Show message that the ad was succesfully deleted.
        if(result){
             JOptionPane.showMessageDialog(this,"Advertisement #" + toUpdate +" was succesfully updated.","Confirmation",JOptionPane.INFORMATION_MESSAGE);
        }
        //reload the ads screen
        populate_advertisements_table("");
        populate_myadvertisements_table();
        
    }//GEN-LAST:event_EditButtonActionPerformed
    //Delete button pressed
    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        //Get the id of the row of the listview that is clicked
        int rowClicked = myAdvertisementsJTable.getSelectedRow();
        boolean result = false;
        
        //Check to see if a row was clicked at all
        if(rowClicked >= 0){
            //Row clicked, now get the id of the ad that was clicked
            String toDelete = myAdvertisementsJTable.getValueAt(rowClicked,0).toString();
            //delete it
            result=helper.deleteAdvertisement(toDelete);
        }
        
        //Show message that the ad was succesfully deleted.
        if(result){
             JOptionPane.showMessageDialog(this,"Advertisement was deleted succesfully.","Confirmation",JOptionPane.INFORMATION_MESSAGE);
        }
        //reload the ads screen
        populate_advertisements_table("");
        populate_myadvertisements_table();
    }//GEN-LAST:event_DeleteButtonActionPerformed
    //Add advertisements button clicked
    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        //Go to add advertisement frame
        JFrame new_ad = new InsertAd(helper,this,user);
        new_ad.setVisible(true);
        
        //Reload both screens
        populate_advertisements_table("");
        populate_myadvertisements_table();
    }//GEN-LAST:event_AddButtonActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JTabbedPane AdvTabs;
    private javax.swing.JComboBox CatFilter;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JButton GoButton;
    private javax.swing.JComboBox PeriodFilter;
    private javax.swing.JTextField SearchTextBox;
    private javax.swing.JTable advertisementsJTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable myAdvertisementsJTable;
    // End of variables declaration//GEN-END:variables
}
