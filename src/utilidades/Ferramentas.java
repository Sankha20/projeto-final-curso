/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import javax.swing.JOptionPane;


public class Ferramentas {
    
    public static boolean confirma(String msg) {
        int response;
        response = JOptionPane.showConfirmDialog(null, msg, "Confirmar", JOptionPane.YES_NO_OPTION);

        return (response == 0);
    }

    public static void alerta(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Então...", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void erro(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Ops...", JOptionPane.ERROR_MESSAGE);
    }

}
