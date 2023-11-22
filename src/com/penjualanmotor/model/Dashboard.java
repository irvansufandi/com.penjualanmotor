/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmotor.model;

import com.penjualanmotor.service.AddCustomer;
import com.penjualanmotor.service.LoginPage;
import com.penjualanmotor.web.ConnectDB;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author Irvansfd
 */
public class Dashboard extends javax.swing.JFrame {
    private ConnectDB Con;
    private ResultSet Res;
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        Con = new com.penjualanmotor.web.ConnectDB();
        initComponents();
        setButton();
        setUI();
        supplier();
        customer();
        stok();
        sell();
    }
    
    private void supplier(){
        try{
            Res = Con.queryCount("supplier");
            
            while (Res.next()){
                int supplier = Res.getInt(1);
                jumlahUser.setText(Integer.toString(supplier));
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Data gagal dipanggil! "+e);
        }
    }
    
    private void customer(){
        try{
            Res = Con.queryCount("customer");
            
            while (Res.next()){
                int supplier = Res.getInt(1);
                jumlahCustomer.setText(Integer.toString(supplier));
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Data gagal dipanggil! "+e);
        }
    }
    
    private void stok(){
        try{
            Res = Con.queryCount("stok");
            
            while (Res.next()){
                int supplier = Res.getInt(1);
                jumlahStok.setText(Integer.toString(supplier));
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Data gagal dipanggil! "+e);
        }
    }
    
    private void sell(){
        try{
            Res = Con.queryCount("transaksi");
            
            while (Res.next()){
                int supplier = Res.getInt(1);
                jumlahTransaksi.setText(Integer.toString(supplier));
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Data gagal dipanggil! "+e);
        }
    }
    
    private void setButton() {
         closeTab.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
        minimazeTab.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setExtendedState(LoginPage.ICONIFIED);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }
    
    private void setUI() {
        dashboardPanel.setBackground(new Color(68, 80, 105));
        dashboardPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                dashboardPanel.setBackground(new Color(91, 154, 139));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                dashboardPanel.setBackground(new Color(68, 80, 105));
            }
        });
        customerPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 new CustomerPage().setVisible(true);
                 dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                customerPanel.setBackground(new Color(91, 154, 139));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                customerPanel.setBackground(new Color(37, 30, 72));
            }
        });
        supplierPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new SupplierPage().setVisible(true);
                dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                supplierPanel.setBackground(new Color(91, 154, 139));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                supplierPanel.setBackground(new Color(37, 30, 72));
            }
        });
        stokPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new StokPage().setVisible(true);
                dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                stokPanel.setBackground(new Color(91, 154, 139));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                stokPanel.setBackground(new Color(37, 30, 72));
            }
        });
        sellPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new SellPage().setVisible(true);
                dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                sellPanel.setBackground(new Color(91, 154, 139));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                sellPanel.setBackground(new Color(37, 30, 72));
            }
        }); 
        
        sendPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new SendPage().setVisible(true);
                dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                sendPanel.setBackground(new Color(91, 154, 139));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                sendPanel.setBackground(new Color(37, 30, 72));
            }
        });
        logoutPanel.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new LoginPage().setVisible(true);
                dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                logoutPanel.setBackground(new Color(91, 154, 139));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                logoutPanel.setBackground(new Color(37, 30, 72));
            }

            @Override
            public void mouseDragged(MouseEvent e) {}

            @Override
            public void mouseMoved(MouseEvent e) {}
        });
   }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dashboardPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        customerPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        supplierPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        stokPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        sellPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        sendPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        logoutPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tabPanel = new javax.swing.JPanel();
        minimazeTab = new javax.swing.JLabel();
        closeTab = new javax.swing.JLabel();
        suppDashPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jumlahUser = new javax.swing.JLabel();
        customerDashPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jumlahCustomer = new javax.swing.JLabel();
        stokDashPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jumlahStok = new javax.swing.JLabel();
        sellDashPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jumlahTransaksi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(750, 530));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(37, 43, 72));
        jPanel1.setPreferredSize(new java.awt.Dimension(60, 530));

        dashboardPanel.setBackground(new java.awt.Color(37, 30, 72));
        dashboardPanel.setPreferredSize(new java.awt.Dimension(200, 60));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N

        javax.swing.GroupLayout dashboardPanelLayout = new javax.swing.GroupLayout(dashboardPanel);
        dashboardPanel.setLayout(dashboardPanelLayout);
        dashboardPanelLayout.setHorizontalGroup(
            dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );
        dashboardPanelLayout.setVerticalGroup(
            dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        customerPanel.setBackground(new java.awt.Color(37, 30, 72));
        customerPanel.setPreferredSize(new java.awt.Dimension(200, 60));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customer_26px.png"))); // NOI18N

        javax.swing.GroupLayout customerPanelLayout = new javax.swing.GroupLayout(customerPanel);
        customerPanel.setLayout(customerPanelLayout);
        customerPanelLayout.setHorizontalGroup(
            customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );
        customerPanelLayout.setVerticalGroup(
            customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        supplierPanel.setBackground(new java.awt.Color(37, 30, 72));
        supplierPanel.setPreferredSize(new java.awt.Dimension(200, 60));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/installing_updates_24px.png"))); // NOI18N

        javax.swing.GroupLayout supplierPanelLayout = new javax.swing.GroupLayout(supplierPanel);
        supplierPanel.setLayout(supplierPanelLayout);
        supplierPanelLayout.setHorizontalGroup(
            supplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );
        supplierPanelLayout.setVerticalGroup(
            supplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        stokPanel.setBackground(new java.awt.Color(37, 30, 72));
        stokPanel.setPreferredSize(new java.awt.Dimension(200, 60));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/list_26px.png"))); // NOI18N

        javax.swing.GroupLayout stokPanelLayout = new javax.swing.GroupLayout(stokPanel);
        stokPanel.setLayout(stokPanelLayout);
        stokPanelLayout.setHorizontalGroup(
            stokPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );
        stokPanelLayout.setVerticalGroup(
            stokPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        sellPanel.setBackground(new java.awt.Color(37, 30, 72));
        sellPanel.setPreferredSize(new java.awt.Dimension(200, 60));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shopping_cart_30px.png"))); // NOI18N

        javax.swing.GroupLayout sellPanelLayout = new javax.swing.GroupLayout(sellPanel);
        sellPanel.setLayout(sellPanelLayout);
        sellPanelLayout.setHorizontalGroup(
            sellPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );
        sellPanelLayout.setVerticalGroup(
            sellPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        sendPanel.setBackground(new java.awt.Color(37, 30, 72));
        sendPanel.setPreferredSize(new java.awt.Dimension(200, 60));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/in_transit_50px (Custom).png"))); // NOI18N

        javax.swing.GroupLayout sendPanelLayout = new javax.swing.GroupLayout(sendPanel);
        sendPanel.setLayout(sendPanelLayout);
        sendPanelLayout.setHorizontalGroup(
            sendPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );
        sendPanelLayout.setVerticalGroup(
            sendPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        logoutPanel.setBackground(new java.awt.Color(37, 30, 72));
        logoutPanel.setPreferredSize(new java.awt.Dimension(200, 60));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout_26px.png"))); // NOI18N

        javax.swing.GroupLayout logoutPanelLayout = new javax.swing.GroupLayout(logoutPanel);
        logoutPanel.setLayout(logoutPanelLayout);
        logoutPanelLayout.setHorizontalGroup(
            logoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );
        logoutPanelLayout.setVerticalGroup(
            logoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dashboardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supplierPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stokPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sellPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashboardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(customerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(supplierPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stokPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sellPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sendPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logoutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 530));

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("DASHBOARD");

        tabPanel.setBackground(new java.awt.Color(250, 250, 250));

        minimazeTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-minimize-window-24.png"))); // NOI18N
        minimazeTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        closeTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        closeTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout tabPanelLayout = new javax.swing.GroupLayout(tabPanel);
        tabPanel.setLayout(tabPanelLayout);
        tabPanelLayout.setHorizontalGroup(
            tabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPanelLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(minimazeTab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeTab))
        );
        tabPanelLayout.setVerticalGroup(
            tabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPanelLayout.createSequentialGroup()
                .addGroup(tabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(closeTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minimazeTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        suppDashPanel.setBackground(new java.awt.Color(37, 43, 72));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Jumlah Supplier");

        jumlahUser.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jumlahUser.setForeground(new java.awt.Color(255, 255, 255));
        jumlahUser.setText("0");

        javax.swing.GroupLayout suppDashPanelLayout = new javax.swing.GroupLayout(suppDashPanel);
        suppDashPanel.setLayout(suppDashPanelLayout);
        suppDashPanelLayout.setHorizontalGroup(
            suppDashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suppDashPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(suppDashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jumlahUser)
                    .addComponent(jLabel2))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        suppDashPanelLayout.setVerticalGroup(
            suppDashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suppDashPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jumlahUser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        customerDashPanel.setBackground(new java.awt.Color(37, 43, 72));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Jumlah Customer");

        jumlahCustomer.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jumlahCustomer.setForeground(new java.awt.Color(255, 255, 255));
        jumlahCustomer.setText("0");

        javax.swing.GroupLayout customerDashPanelLayout = new javax.swing.GroupLayout(customerDashPanel);
        customerDashPanel.setLayout(customerDashPanelLayout);
        customerDashPanelLayout.setHorizontalGroup(
            customerDashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerDashPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(customerDashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jumlahCustomer)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        customerDashPanelLayout.setVerticalGroup(
            customerDashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerDashPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jumlahCustomer)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        stokDashPanel.setBackground(new java.awt.Color(37, 43, 72));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jumlah Stok");

        jumlahStok.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jumlahStok.setForeground(new java.awt.Color(255, 255, 255));
        jumlahStok.setText("0");

        javax.swing.GroupLayout stokDashPanelLayout = new javax.swing.GroupLayout(stokDashPanel);
        stokDashPanel.setLayout(stokDashPanelLayout);
        stokDashPanelLayout.setHorizontalGroup(
            stokDashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stokDashPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(stokDashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jumlahStok)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        stokDashPanelLayout.setVerticalGroup(
            stokDashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stokDashPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jumlahStok)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        sellDashPanel.setBackground(new java.awt.Color(37, 43, 72));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Jumlah Transaksi");

        jumlahTransaksi.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jumlahTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        jumlahTransaksi.setText("0");

        javax.swing.GroupLayout sellDashPanelLayout = new javax.swing.GroupLayout(sellDashPanel);
        sellDashPanel.setLayout(sellDashPanelLayout);
        sellDashPanelLayout.setHorizontalGroup(
            sellDashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sellDashPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(sellDashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jumlahTransaksi)
                    .addComponent(jLabel12))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        sellDashPanelLayout.setVerticalGroup(
            sellDashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sellDashPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jumlahTransaksi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(suppDashPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stokDashPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(customerDashPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sellDashPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(customerDashPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(suppDashPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(99, 99, 99)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(stokDashPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sellDashPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 690, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel closeTab;
    private javax.swing.JPanel customerDashPanel;
    private javax.swing.JPanel customerPanel;
    private javax.swing.JPanel dashboardPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jumlahCustomer;
    private javax.swing.JLabel jumlahStok;
    private javax.swing.JLabel jumlahTransaksi;
    private javax.swing.JLabel jumlahUser;
    private javax.swing.JPanel logoutPanel;
    private javax.swing.JLabel minimazeTab;
    private javax.swing.JPanel sellDashPanel;
    private javax.swing.JPanel sellPanel;
    private javax.swing.JPanel sendPanel;
    private javax.swing.JPanel stokDashPanel;
    private javax.swing.JPanel stokPanel;
    private javax.swing.JPanel suppDashPanel;
    private javax.swing.JPanel supplierPanel;
    private javax.swing.JPanel tabPanel;
    // End of variables declaration//GEN-END:variables
}
