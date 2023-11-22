/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmotor.web;

/**
 *
 * @author Irvansfd
 */
public class UserID {
     private static String code;
    
    public static void setUserLogin(String code_) {
        code = code_;
    }
    
    public static String getUserLogin(){
        return code;
    }
}
