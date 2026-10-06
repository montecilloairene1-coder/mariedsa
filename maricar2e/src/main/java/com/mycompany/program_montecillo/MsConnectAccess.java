/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.program_montecillo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author CL2-PC
 */
public class MsConnectAccess {
    public static Connection conn() {
        try {
            String url = "jdbc:ucanaccess://C://Users//CL2-PC//Documents//airene_database.accdb";
            Connection conn = DriverManager.getConnection(url);
            return conn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
public class MainFrame extends javax.swing.JFrame {

    // Database credentials
    String url = "jdbc:mysql://localhost:3306/crud_demo";
    String user = "root";
    String password = ""; // replace with your MySQL password

    public MainFrame() {
        initComponents();
        loadTableData(); // Load data into JTable on startup
    }

    // Method to establish database connection
    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database Connection Failed: " + e.getMessage());
        }
        return con;
    }

    // READ: Load data into JTable
    private void loadTableData() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing data

        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM users")) {

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Loading Data: " + e.getMessage());
        }
    }

    // Add button action (CREATE)
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {
        String query = "INSERT INTO users (name, email, phone) VALUES (?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, txtName.getText());
            pst.setString(2, txtEmail.getText());
            pst.setString(3, txtPhone.getText());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Record Inserted Successfully!");
            loadTableData();
            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    // Table click event to populate text fields for update/delete
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        int row = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        // Assuming ID is at column 0, Name at column 1, etc.
        txtName.setText(model.getValueAt(row, 1).toString());
        txtEmail.setText(model.getValueAt(row, 2).toString());
        txtPhone.setText(model.getValueAt(row, 3).toString());
    }

    // Update button action (UPDATE)
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to update.");
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String id = model.getValueAt(row, 0).toString();

        String query = "UPDATE users SET name=?, email=?, phone=? WHERE id=?";
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, txtName.getText());
            pst.setString(2, txtEmail.getText());
            pst.setString(3, txtPhone.getText());
            pst.setString(4, id);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Record Updated Successfully!");
            loadTableData();
            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    // Delete button action (DELETE)
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String id = model.getValueAt(row, 0).toString();

        String query = "DELETE FROM users WHERE id=?";
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, id);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Record Deleted Successfully!");
            loadTableData();
            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void clearFields() {
        txtName.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
    }
    
    // ... NetBeans generated boilerplate code for UI components ...
}

}