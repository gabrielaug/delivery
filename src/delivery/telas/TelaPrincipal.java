/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.telas;


import delivery.basica.Login;
import delivery.repositorio.DAOConfig;
import delivery.util.DAOException;
import java.awt.Dimension;
import java.sql.SQLException;

/**
 *
 * @author Gabriel Augusto
 */
public class TelaPrincipal extends javax.swing.JFrame {
    
    Login login;
    DAOConfig config;
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
    }
    
    public TelaPrincipal(Login login){
     initComponents();
     setExtendedState(MAXIMIZED_BOTH);
     this.login = new Login();
     this.login.setNome(login.getNome());
     this.login.setUsuario(login.getUsuario());
     this.login.setNvAcesso(login.getNvAcesso());
     config = new DAOConfig();
     inicio();
     
    }
       
     public void inicio(){
        
        try {
            if(config.verificarConfig().getSnTelaPedido().equalsIgnoreCase("N")){
             menuPainelPedido.setEnabled(false);
            }
        } catch (DAOException | SQLException ex) {
            
        }      
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        menuBarra = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        menuAtendimento = new javax.swing.JMenuItem();
        menuPainelPedido = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuCadastrarCliente = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        btnEmpresa = new javax.swing.JMenu();
        menuFuncionamento = new javax.swing.JMenuItem();
        menuEmpresa = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 955, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 594, Short.MAX_VALUE)
        );

        jMenu5.setText("Menu");

        menuAtendimento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        menuAtendimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delivery/util/imagens/Atendimento.png"))); // NOI18N
        menuAtendimento.setText("Atendimento");
        menuAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAtendimentoActionPerformed(evt);
            }
        });
        jMenu5.add(menuAtendimento);

        menuPainelPedido.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        menuPainelPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delivery/util/imagens/Tela.png"))); // NOI18N
        menuPainelPedido.setText("Painel de Pedido");
        jMenu5.add(menuPainelPedido);

        menuBarra.add(jMenu5);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delivery/util/imagens/Cliente.png"))); // NOI18N
        jMenu2.setText("Cliente");

        menuCadastrarCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        menuCadastrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delivery/util/imagens/CadCliente.png"))); // NOI18N
        menuCadastrarCliente.setText("Cadastrar Cliente");
        jMenu2.add(menuCadastrarCliente);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delivery/util/imagens/PesquisarCliente.png"))); // NOI18N
        jMenuItem3.setText("Pesquisar Cliente");
        jMenu2.add(jMenuItem3);

        menuBarra.add(jMenu2);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delivery/util/imagens/Produto.png"))); // NOI18N
        jMenu1.setText("Produto");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delivery/util/imagens/AdicionarProduto.png"))); // NOI18N
        jMenuItem1.setText("Cadastro de Produto");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delivery/util/imagens/ListarProdutos.png"))); // NOI18N
        jMenuItem2.setText("Pesquisar Produtos");
        jMenu1.add(jMenuItem2);

        menuBarra.add(jMenu1);

        btnEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delivery/util/imagens/Configuracao.png"))); // NOI18N
        btnEmpresa.setText("Configuração");
        btnEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpresaActionPerformed(evt);
            }
        });

        menuFuncionamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delivery/util/imagens/ConfigFuncionamento.png"))); // NOI18N
        menuFuncionamento.setText("Funcionamento");
        menuFuncionamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFuncionamentoActionPerformed(evt);
            }
        });
        btnEmpresa.add(menuFuncionamento);

        menuEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delivery/util/imagens/Empresa.png"))); // NOI18N
        menuEmpresa.setText("Empresa");
        menuEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEmpresaActionPerformed(evt);
            }
        });
        btnEmpresa.add(menuEmpresa);

        menuBarra.add(btnEmpresa);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delivery/util/imagens/Relatorios.png"))); // NOI18N
        jMenu8.setText("Relatório");

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delivery/util/imagens/PedidoPorCliente.png"))); // NOI18N
        jMenuItem8.setText("Pedido por Cliente");
        jMenu8.add(jMenuItem8);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delivery/util/imagens/RelatorioProdutos.png"))); // NOI18N
        jMenuItem4.setText("Produtos Cadastrados");
        jMenu8.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delivery/util/imagens/VendasPorPeriodo.png"))); // NOI18N
        jMenuItem5.setText("Vendas por Periodo");
        jMenu8.add(jMenuItem5);

        menuBarra.add(jMenu8);

        setJMenuBar(menuBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );

        setSize(new java.awt.Dimension(971, 665));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuFuncionamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFuncionamentoActionPerformed
        
        TelaConfig config = new TelaConfig();
        desktop.removeAll();
        desktop.add(config);
        config.setPosicao();
        try {
            config.verificar();
        } catch (DAOException | SQLException ex) {
            
        }
        config.setVisible(true);
    }//GEN-LAST:event_menuFuncionamentoActionPerformed

    private void btnEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpresaActionPerformed

    
        
    }//GEN-LAST:event_btnEmpresaActionPerformed

    private void menuEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEmpresaActionPerformed
        
        TelaEmpresa telaEmpresa = new TelaEmpresa();
        desktop.add(telaEmpresa);
        telaEmpresa.setPosicao();
        telaEmpresa.setVisible(true);
        
        
    }//GEN-LAST:event_menuEmpresaActionPerformed

    private void menuAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAtendimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuAtendimentoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnEmpresa;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem menuAtendimento;
    private javax.swing.JMenuBar menuBarra;
    private javax.swing.JMenuItem menuCadastrarCliente;
    private javax.swing.JMenuItem menuEmpresa;
    private javax.swing.JMenuItem menuFuncionamento;
    private javax.swing.JMenuItem menuPainelPedido;
    // End of variables declaration//GEN-END:variables
}
