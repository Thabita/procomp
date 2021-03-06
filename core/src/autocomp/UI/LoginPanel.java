/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomp.UI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logica.Grupos;
import logica.Login;

/**
 *
 * @author adriano
 */
public class LoginPanel extends javax.swing.JPanel {

    /**
     * Creates new form LoginPanel
     */
    public LoginPanel() {
        initComponents();
        login = new Login();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ProjetoLabel = new javax.swing.JLabel();
        UserLabel = new javax.swing.JLabel();
        PassLabel = new javax.swing.JLabel();
        UserField = new javax.swing.JTextField();
        PassField = new javax.swing.JPasswordField();
        ConectButton = new javax.swing.JButton();
        LogoLabel = new javax.swing.JLabel();

        ProjetoLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        ProjetoLabel.setText("AutoComp");

        UserLabel.setText("Usuário");

        PassLabel.setText("Senha");

        ConectButton.setText("Conectar");
        ConectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConectButtonActionPerformed(evt);
            }
        });

        LogoLabel.setText("PreguiSoft© ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ProjetoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(UserField)
                            .addComponent(PassField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(PassLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(UserLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(ConectButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LogoLabel)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(ProjetoLabel)
                .addGap(36, 36, 36)
                .addComponent(UserLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UserField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PassLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ConectButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(LogoLabel))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ConectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConectButtonActionPerformed
        String user, senha; 
        user = UserField.getText();
        senha = new String(PassField.getPassword());
        if(login.autenticar(user, senha)){
            JOptionPane.showMessageDialog(this, "Bem vindo!", "Login Bem Sucedido", JOptionPane.DEFAULT_OPTION);      
            MenuPanel menuPanel = new MenuPanel(Grupos.permissoes(login.pesquisar(user).getGrupo()));
            JFrame jf = (JFrame) this.getTopLevelAncestor();
            jf.getContentPane().removeAll();
            jf.getContentPane().add(menuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, menuPanel.getPreferredSize().height));
            jf.setMinimumSize(menuPanel.getPreferredSize());
            jf.pack();
        }
        else JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos", "Erro", JOptionPane.ERROR_MESSAGE); 
    }//GEN-LAST:event_ConectButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConectButton;
    private javax.swing.JLabel LogoLabel;
    private javax.swing.JPasswordField PassField;
    private javax.swing.JLabel PassLabel;
    private javax.swing.JLabel ProjetoLabel;
    private javax.swing.JTextField UserField;
    private javax.swing.JLabel UserLabel;
    // End of variables declaration//GEN-END:variables
    private Login login;
}
