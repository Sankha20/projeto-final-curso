package utils;

import javax.swing.JOptionPane;

/**
 * Classe com métodos estáticos de utilidade geral
 * @author Victor Pontes
 */
public class Ferramentas {
    
    /**
     * Abre caixa de diálogo pedindo confirmação.
     * @param msg A mensagem a ser exibida
     * @return <code>boolean</code>
     * Se foi confirmado ou não
     */
    public static boolean confirma(String msg) {
        int response;
        response = JOptionPane.showConfirmDialog(null, msg, "Confirmar", JOptionPane.YES_NO_OPTION);

        return (response == 0);
    }

    /**
     * Abre caixa de alerta
     * @param msg A mensagem a ser exibida
     */
    public static void alerta(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Alerta!", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Abre caixa de erro
     * @param msg A mensagem a ser exibida
     */
    public static void erro(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Erro!", JOptionPane.ERROR_MESSAGE);
    }
    
}
