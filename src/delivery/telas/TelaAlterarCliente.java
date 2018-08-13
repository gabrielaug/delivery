/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.telas;

import delivery.basica.Cliente;
import delivery.basica.Config;
import delivery.negocio.RNCliente;
import delivery.repositorio.DAOCliente;
import delivery.repositorio.DAOConfig;
import java.awt.event.KeyEvent;
import delivery.util.BuscarCEP;
import delivery.util.CustomDocument;
import delivery.util.DAOException;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author gaugusto
 */
public class TelaAlterarCliente extends javax.swing.JDialog {

    private Cliente cliente;
    private DAOConfig dao;
    private Config config;
    
    /**
     * Creates new form TelaAlterarCliente
     * @param parent
     * @param modal
     */
    public TelaAlterarCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }

    /**
     * CONSTRUTOR PADRÃO UTILIZADO NO SISTEMA
     * @param cliente 
     */
    public TelaAlterarCliente(Cliente cliente) {
        initComponents();
        caixaMaiuscula();
        
        txtNome.setText(cliente.getNome());
        txtCpf.setText(cliente.getCpf());
        txtTelefone.setText(cliente.getTelefone());
        txtTelefone2.setText(cliente.getTelefone2());
        txtTelefone3.setText(cliente.getTelefone3());
        txtCep.setText(cliente.getCep());
        txtLogradouro.setText(cliente.getLogradouro());
        txtNumero.setText(cliente.getNumero());
        txtComplemento.setText(cliente.getComplemento());
        txtReferencia.setText(cliente.getReferencia());
        
        
        dao = new DAOConfig();
        try {
            this.config = dao.verificarConfig();
        } catch (DAOException | SQLException ex) {
            
        } 
        
    }
    
    /**
     * COLOCA AS CAIXAS DE TEXTO'S MAIUSCULAS
     */
    private void caixaMaiuscula(){ 
        
      this.txtNome.setDocument(new CustomDocument());
      this.txtComplemento.setDocument(new CustomDocument());
      this.txtLogradouro.setDocument(new CustomDocument());
      this.txtNumero.setDocument(new CustomDocument());
      this.txtReferencia.setDocument(new CustomDocument()); 
      
    }

    /**
     * VERIFICA SE O CPF E OBRIGATORIO E COLOCA O INDICADOR DE OBRIGATORIO.
     * @throws DAOException
     * @throws SQLException 
     */
    public void configCpf()throws DAOException, SQLException{
            if(config.getSnCpf().equalsIgnoreCase("N")){
                lblObrigatorio1.setVisible(false);
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

        txtComplemento = new javax.swing.JTextField();
        lblReferencia = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        txtTelefone2 = new javax.swing.JTextField();
        txtTelefone3 = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnAlterar = new javax.swing.JButton();
        lblCpf = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        txtCpf = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        lblObrigatorio = new javax.swing.JLabel();
        lblObrigatorio1 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        lblObrigatorio3 = new javax.swing.JLabel();
        lblTelefone2 = new javax.swing.JLabel();
        lblObrigatorio6 = new javax.swing.JLabel();
        lblTelefone3 = new javax.swing.JLabel();
        lblObrigatorio7 = new javax.swing.JLabel();
        lblLogradouro = new javax.swing.JLabel();
        lblObrigatorio8 = new javax.swing.JLabel();
        txtLogradouro = new javax.swing.JTextField();
        lblCep = new javax.swing.JLabel();
        txtCep = new javax.swing.JTextField();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        lblComplemento = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtComplemento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtComplementoKeyPressed(evt);
            }
        });

        lblReferencia.setText("Referência");

        txtReferencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtReferenciaKeyPressed(evt);
            }
        });

        txtTelefone2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefone2ActionPerformed(evt);
            }
        });
        txtTelefone2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefone2KeyPressed(evt);
            }
        });

        txtTelefone3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefone3ActionPerformed(evt);
            }
        });
        txtTelefone3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefone3KeyPressed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 51, 204));
        lblTitulo.setText("Alterar Cliente");

        lblNome.setText("Nome");

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        btnAlterar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAlterarKeyPressed(evt);
            }
        });

        lblCpf.setText("CPF");

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        txtCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCpfKeyPressed(evt);
            }
        });

        lblTelefone.setText("Telefone");

        lblObrigatorio.setForeground(new java.awt.Color(255, 0, 0));
        lblObrigatorio.setText("*");

        lblObrigatorio1.setForeground(new java.awt.Color(255, 0, 0));
        lblObrigatorio1.setText("*");

        txtTelefone.setEditable(false);
        txtTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefoneFocusLost(evt);
            }
        });
        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });
        txtTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefoneKeyPressed(evt);
            }
        });

        lblObrigatorio3.setForeground(new java.awt.Color(255, 0, 0));
        lblObrigatorio3.setText("*");

        lblTelefone2.setText("Telefone²");

        lblObrigatorio6.setForeground(new java.awt.Color(255, 0, 0));
        lblObrigatorio6.setText("*");

        lblTelefone3.setText("Telefone³");

        lblObrigatorio7.setForeground(new java.awt.Color(255, 0, 0));
        lblObrigatorio7.setText("*");

        lblLogradouro.setText("Logradouro");

        lblObrigatorio8.setForeground(new java.awt.Color(255, 0, 0));
        lblObrigatorio8.setText("*");

        txtLogradouro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLogradouroKeyPressed(evt);
            }
        });

        lblCep.setText("CEP");

        txtCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCepFocusLost(evt);
            }
        });
        txtCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCepKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCepKeyTyped(evt);
            }
        });

        lblNumero.setText("Numero");

        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumeroKeyPressed(evt);
            }
        });

        lblComplemento.setText("Complemento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtReferencia, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtComplemento, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCpf)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblObrigatorio1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTelefone)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblObrigatorio3))
                                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTelefone2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTelefone3)
                                    .addComponent(txtTelefone3)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCep)
                                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblLogradouro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblObrigatorio6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNumero)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblObrigatorio7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblObrigatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblReferencia)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblComplemento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblObrigatorio8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNome)
                                    .addComponent(lblObrigatorio))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblCpf)
                                            .addComponent(lblObrigatorio1))
                                        .addGap(6, 6, 6)
                                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblTelefone)
                                            .addComponent(lblObrigatorio3)
                                            .addComponent(lblTelefone2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblTelefone3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefone3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNumero)
                                    .addComponent(lblObrigatorio7))
                                .addGap(1, 1, 1)
                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblCep)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLogradouro)
                            .addComponent(lblObrigatorio6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblComplemento)
                    .addComponent(lblObrigatorio8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblReferencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtComplementoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComplementoKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtReferencia.grabFocus();
        }

    }//GEN-LAST:event_txtComplementoKeyPressed

    private void txtReferenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReferenciaKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnAlterar.grabFocus();
        }

    }//GEN-LAST:event_txtReferenciaKeyPressed

    private void txtTelefone2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefone2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefone2ActionPerformed

    private void txtTelefone2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefone2KeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtTelefone3.grabFocus();
        }

    }//GEN-LAST:event_txtTelefone2KeyPressed

    private void txtTelefone3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefone3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefone3ActionPerformed

    private void txtTelefone3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefone3KeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtCep.grabFocus();
        }

    }//GEN-LAST:event_txtTelefone3KeyPressed

    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
                
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtCpf.grabFocus();
        }

    }//GEN-LAST:event_txtNomeKeyPressed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        DAOCliente daoCliente =  new DAOCliente();
        cliente =  new Cliente();

        cliente.setNome(txtNome.getText());
        cliente.setCpf(txtCpf.getText());
        cliente.setCep(txtCep.getText());
        cliente.setComplemento(txtComplemento.getText());
        cliente.setLogradouro(txtLogradouro.getText());
        cliente.setNumero(txtNumero.getText());
        cliente.setReferencia(txtReferencia.getText());
        cliente.setTelefone(txtTelefone.getText());
        cliente.setTelefone2(txtTelefone2.getText());
        cliente.setTelefone3(txtTelefone3.getText());

        try {

            if(daoCliente.consultarClienteExistente(cliente)){
              
             int confirma = JOptionPane.showConfirmDialog(this,"Tem certeza que deseja fazer esta alteração?","Confirmação de Alteração",JOptionPane.YES_NO_CANCEL_OPTION);
                if(confirma == JOptionPane.YES_OPTION){
                 alterarCliente(cliente);   
                }else if(confirma == JOptionPane.NO_OPTION){
                    this.dispose();
                }
                
            }else{
                txtTelefone.grabFocus();
                throw new DAOException("Atenção telefone não cadastro, favor cadastre o cliente.");
            }

        } catch (DAOException | SQLException ex) {

        } catch (Exception ex) {

        }

    }//GEN-LAST:event_btnAlterarActionPerformed

    public void alterarCliente(Cliente cliente) throws DAOException, SQLException, Exception{
       
        RNCliente rnCliente = new RNCliente();
        try{
            
            if(config.getSnCpf().equalsIgnoreCase("S")){
                if(txtCpf.getText().equalsIgnoreCase("") || txtCpf.getText().trim().isEmpty()){
                throw new DAOException("CPF é obrigatorio");
                }
                else{
                rnCliente.alterar(cliente);  
                JOptionPane.showMessageDialog(this, "Alterado com Sucesso.","",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                }
            }else{
                rnCliente.alterar(cliente);  
                JOptionPane.showMessageDialog(this, "Alterado com Sucesso.","",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
             
          
        }catch(DAOException ex) {
            
        }        
       
    }
    
    private void btnAlterarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAlterarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnAlterar.doClick();
        }
    }//GEN-LAST:event_btnAlterarKeyPressed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void txtCpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCpfKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtTelefone.grabFocus();
        }

    }//GEN-LAST:event_txtCpfKeyPressed

    private void txtTelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefoneFocusLost

    }//GEN-LAST:event_txtTelefoneFocusLost

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void txtTelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefoneKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtTelefone2.grabFocus();
        }

    }//GEN-LAST:event_txtTelefoneKeyPressed

    private void txtLogradouroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLogradouroKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtNumero.grabFocus();
        }

    }//GEN-LAST:event_txtLogradouroKeyPressed

    private void txtCepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCepFocusLost

        if(txtCep.getText().length() == 8){

            BuscarCEP buscar = new BuscarCEP();

            try {
                txtLogradouro.setText(buscar.getEndereco(txtCep.getText()));
            } catch (IOException ex) {

            }

        }
    }//GEN-LAST:event_txtCepFocusLost

    private void txtCepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCepKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtLogradouro.grabFocus();
        }

    }//GEN-LAST:event_txtCepKeyPressed

    private void txtCepKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCepKeyTyped

        int numero = 8;
        if(txtCep.getText().length() >= numero){
            txtLogradouro.grabFocus();
            evt.consume();
        }

    }//GEN-LAST:event_txtCepKeyTyped

    private void txtNumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtComplemento.grabFocus();
        }

    }//GEN-LAST:event_txtNumeroKeyPressed

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
            java.util.logging.Logger.getLogger(TelaAlterarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAlterarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAlterarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAlterarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaAlterarCliente dialog = new TelaAlterarCliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnSair;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblLogradouro;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblObrigatorio;
    private javax.swing.JLabel lblObrigatorio1;
    private javax.swing.JLabel lblObrigatorio3;
    private javax.swing.JLabel lblObrigatorio6;
    private javax.swing.JLabel lblObrigatorio7;
    private javax.swing.JLabel lblObrigatorio8;
    private javax.swing.JLabel lblReferencia;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTelefone2;
    private javax.swing.JLabel lblTelefone3;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtTelefone2;
    private javax.swing.JTextField txtTelefone3;
    // End of variables declaration//GEN-END:variables
}
