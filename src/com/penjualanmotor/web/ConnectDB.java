/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmotor.web;

import java.sql.*;

/**
 *
 * @author Irvansfd
 */
public class ConnectDB {
    private Connection connection;
    public int i;
    public Statement statement;
    public ResultSet resultSet;
    public String SQL;
    public String url;
    public String username;
    public String password;
    public String Host;
    public int Port;
 
    public Connection DBConnection() {
        try{
            Class.forName ("com.mysql.jdbc.Driver");
            System.out.println("Connecting");
        }
        catch (ClassNotFoundException ex){
            System.out.println("Gagal Koneksi"+ex);
        }
        url = "jdbc:mysql://localhost/antara_motor";
        username = "root";
        password = "";
        try{
            connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connected to database");
        }
        catch (SQLException ex){
            System.out.println("Gagal Koneksi Database"+ex);
        }
        return connection;
    }
    
  
    
    public java.sql.Connection ClosedDb() throws SQLException {
        connection.close();
        return connection;
    }
    
    public ResultSet executeQuery(String sql) throws SQLException {
        DBConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);      
        System.out.println(resultSet);
        return resultSet;
    }
    
    public String executeUpdate(String sql) throws SQLException {
        DBConnection();
        String result = "";
        System.out.println(sql);
        statement = connection.createStatement();
        statement.executeUpdate(sql);
        return result;
    }
    
    //Overload fungsi untuk eksekusi query select semua kolom dengan order
    public ResultSet querySelectOrder(String nameTable, String condition) throws SQLException {
        SQL = "SELECT * FROM " + nameTable + " ORDER BY " + condition;
        System.out.println(SQL);
        return this.executeQuery(SQL);
    }
    
    //Overload fungsi untuk eksekusi query select semua kolom
    public ResultSet querySelectAll(String nameTable) throws SQLException {
        SQL = "SELECT * FROM " + nameTable;
        System.out.println(SQL);
        return this.executeQuery(SQL);
    }
    
    //Overload fungsi untuk eksekusi query select semua kolom dengan where
    public ResultSet querySelectWith(String nameTable, String condition) throws SQLException {
        SQL = "SELECT * FROM " + nameTable + " WHERE " + condition;
        System.out.println(SQL);
        return this.executeQuery(SQL);
    }
    
    //Fungsi untuk eksekusi query select dengan kolom spesifik
    public ResultSet querySelect(String[] namecolumn, String nameTable) throws SQLException {
        SQL = "SELECT ";
        for (i = 0; i <= namecolumn.length - 1; i++) {
            SQL += namecolumn[i];
            if (i < namecolumn.length - 1) {
                SQL += ",";
            }
        }
        SQL += " FROM " + nameTable;
        return this.executeQuery(SQL);
    }
    
     //Overload fungsi untuk eksekusi query select semua kolom dengan order
    public ResultSet querySelectOrder(String[] column,String[] nameTable, String condition) throws SQLException {
        SQL = "SELECT ";
        for (i = 0; i <= column.length - 1; i++) {
            SQL += column[i];
            if (i < column.length - 1) {
                SQL += ",";
            }
        }
        SQL += " FROM ";
        for (i = 0; i <= nameTable.length - 1; i++) {
            SQL += nameTable[i];
            if (i < nameTable.length - 1) {
                SQL += ",";
            }
        }
        SQL += " ORDER BY " + condition;
        System.out.println(SQL);
        return this.executeQuery(SQL);
    }
    
    //Overload fungsi untuk eksekusi query select dengan kolom spesifik dengan where
    public ResultSet fcSelectCommand(String[] column, String nameTable, String condition) throws SQLException {
        SQL = "SELECT ";
        for (i = 0; i <= column.length - 1; i++) {
            SQL += column[i];
            if (i < column.length - 1) {
                SQL += ",";
            }
        }
        SQL += " FROM " + nameTable + " WHERE " + condition;
        System.out.println(SQL);
        return this.executeQuery(SQL);
    }
    //query select order
    public ResultSet selectOrderBy(String[] column, String nameTable, String condition) throws SQLException {
        SQL = "SELECT ";
        for (i = 0; i <= column.length - 1; i++) {
            SQL += column[i];
            if (i < column.length - 1) {
                SQL += ",";
            }
        }
        SQL += " FROM " + nameTable + " ORDER BY " + condition;
        System.out.println(SQL);
        return this.executeQuery(SQL);
    }
    
    //query select some table
    
    public ResultSet selectSomeTable(String[] column, String[] nameTable, String condition) throws SQLException {
        SQL = "SELECT ";
        for (i = 0; i <= column.length - 1; i++) {
            SQL += column[i];
            if (i < column.length - 1) {
                SQL += ",";
            }
        }
        SQL += " FROM ";
        for (i = 0; i <= nameTable.length - 1; i++) {
            SQL += nameTable[i];
            if (i < nameTable.length - 1) {
                SQL += ",";
            }
        }
        SQL += condition;
        System.out.println(SQL);
        return this.executeQuery(SQL);
    }
    
    //Fungsi eksekusi query insert
    public String queryInsert(String nameTable, String[] namecolumn, String[] value) throws SQLException {
        SQL = "INSERT INTO " + nameTable +" (";
        for (i = 0; i <= namecolumn.length - 1; i++) {
            SQL +=namecolumn[i];
            if (i < namecolumn.length - 1) {
                SQL += ",";
            }
        }
        SQL+=") VALUES(";
        for (i = 0; i <= value.length - 1; i++) {
            SQL += "'" + value[i] + "'";
            
            if (i < value.length - 1) {
                SQL += ",";
            }
        }
        SQL += ")";
        System.out.println(SQL);
        return this.executeUpdate(SQL);
    }
    
     //Fungsi eksekusi query insert dengan null value
    public String queryInsertNull(String nameTable, String[] namecolumn, String[] value) throws SQLException {
        SQL = "INSERT INTO " + nameTable +" (";
        for (i = 0; i <= namecolumn.length - 1; i++) {
            SQL +=namecolumn[i];
            if (i < namecolumn.length - 1) {
                SQL += ",";
            }
        }
        SQL+=") VALUES(";
        for (i = 0; i <= value.length - 1; i++) {
            SQL +=  value[i];
            
            if (i < value.length - 1) {
                SQL += ",";
            }
        }
        SQL += ")";
        return this.executeUpdate(SQL);
    }
    
    //Fungsi eksekusi query update
    public String queryUpdate(String nameTable, String[] namecolumn, String[] value, String condition) throws SQLException {
        SQL = "UPDATE " + nameTable + " SET ";

        for (i = 0; i <= namecolumn.length - 1; i++) {
            SQL += namecolumn[i] + " = '" + value[i] + "'";
            if (i < namecolumn.length - 1) {
                SQL += ",";
            }
        }
        SQL += " WHERE " + condition;
        System.out.println(SQL);
        return this.executeUpdate(SQL);
    }
    
    //Fungsi eksekusi query delete
    public String queryDeleteAll(String nameTable) throws SQLException {
        SQL = "DELETE FROM " + nameTable;
        System.out.println(SQL);
        return this.executeUpdate(SQL);
    }
    
    //Overload fungsi eksekusi query delete dengan where
    public String queryDelete(String nameTable, String condition) throws SQLException {
        SQL = "DELETE FROM " + nameTable + " WHERE " + condition;
        System.out.println(SQL);
        return this.executeUpdate(SQL);
    }
    
    //Fungsi query count
    public ResultSet queryCount(String nameTable) throws SQLException {
        SQL = "SELECT COUNT(*) FROM " + nameTable;
        System.out.println(SQL);
        return this.executeQuery(SQL);
    }
}