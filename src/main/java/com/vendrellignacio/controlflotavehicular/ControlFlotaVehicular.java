

package com.vendrellignacio.controlflotavehicular;

import com.vendrellignacio.controlflotavehicular.igu.MenuFlota;




public class ControlFlotaVehicular {

    public static void main(String[] args) {
        //Correspondiente a la pantalla principal, es decir, "Principal.java": 
        MenuFlota menu = new MenuFlota();
        //Lo hacemos visible:
        menu.setVisible(true);
        //Lo centramos
        menu.setLocationRelativeTo(null);
    }
}
