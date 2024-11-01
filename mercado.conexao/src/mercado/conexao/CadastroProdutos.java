/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mercado.conexao;
import DAO.CategoriaDAO;
import DAO.ProdutoDAO;
import beans.Categoria;
import beans.Produto;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author laboratorio
 */
public class CadastroProdutos extends javax.swing.JFrame {

    /**
     * Creates new form CadastroProdutos
     */
    public CadastroProdutos() {
        initComponents();
        preencherCombobox();
        setSize(450, 400);
        setLocationRelativeTo(null);
    }
    public void preencherCombobox() {
    CategoriaDAO cDAO = new CategoriaDAO();
    List<Categoria> listaCategorias = cDAO.getCategorias();
    
    for (Categoria categoria : listaCategorias) {
        cmbCategoria.addItem(categoria.getNomecat());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblPreço = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        btnCriar = new javax.swing.JButton();
        btnLer = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("CADASTRO PRODUTOS");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 10, 264, 32);

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel2.setText("Categoria:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 80, 80, 16);

        cmbCategoria.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        getContentPane().add(cmbCategoria);
        cmbCategoria.setBounds(130, 80, 170, 25);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel3.setText("Nome:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 120, 60, 16);

        txtNome.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        getContentPane().add(txtNome);
        txtNome.setBounds(130, 110, 170, 30);

        lblPreço.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lblPreço.setText("Preço:");
        getContentPane().add(lblPreço);
        lblPreço.setBounds(80, 160, 60, 16);

        txtPreco.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        getContentPane().add(txtPreco);
        txtPreco.setBounds(130, 152, 170, 30);

        lblQuantidade.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lblQuantidade.setText("Quantidade:");
        getContentPane().add(lblQuantidade);
        lblQuantidade.setBounds(30, 190, 100, 19);

        txtQuantidade.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        txtQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidadeActionPerformed(evt);
            }
        });
        getContentPane().add(txtQuantidade);
        txtQuantidade.setBounds(130, 190, 170, 30);

        btnCriar.setText("Criar");
        btnCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCriar);
        btnCriar.setBounds(130, 290, 72, 23);

        btnLer.setText("Ver");
        btnLer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLerActionPerformed(evt);
            }
        });
        getContentPane().add(btnLer);
        btnLer.setBounds(130, 260, 72, 23);

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizar);
        btnAtualizar.setBounds(220, 260, 80, 23);

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeletar);
        btnDeletar.setBounds(220, 290, 80, 23);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mercado.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(-10, 0, 440, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarActionPerformed
        // TODO add your handling code here:
        String nome = txtNome.getText();
        double preco = Double.parseDouble(txtPreco.getText());
        int quantidade = Integer.parseInt(txtQuantidade.getText());
        String nomeCategoria = (String) cmbCategoria.getSelectedItem();

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categorias = categoriaDAO.getCategorias();

        // Procura a id da categoria selecionada
        int idCategoria = -1;
        for (Categoria categoria : categorias) {
            if (categoria.getNomecat().equals(nomeCategoria)) {
                idCategoria = categoria.getId_cat();
                break;
            }
        }

        if (idCategoria != -1) {
            Produto produto = new Produto();
            produto.setNome(nome);
            produto.setPreco(preco);
            produto.setQuantidade(quantidade);
            produto.setIdCat(idCategoria);

            ProdutoDAO produtoDAO = new ProdutoDAO();
            produtoDAO.inserir(produto);
        } else {
            JOptionPane.showMessageDialog(null, "Categoria não encontrada.");
        }
    
    }//GEN-LAST:event_btnCriarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        // TODO add your handling code here:
    int idProduto = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do produto para deletar:"));
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente deletar o produto?", "Confirmação", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            produtoDAO.deletarProduto(idProduto);
    }//GEN-LAST:event_btnDeletarActionPerformed
 } 
               
    private void btnLerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLerActionPerformed
        // TODO add your handling code here:
         int idProduto = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do produto para buscar:"));
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = produtoDAO.buscarProduto(idProduto);

        if (produto != null) {
            txtNome.setText(produto.getNome());
            txtPreco.setText(String.valueOf(produto.getPreco()));
            txtQuantidade.setText(String.valueOf(produto.getQuantidade()));

            // Seleciona a categoria no ComboBox
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            List<Categoria> categorias = categoriaDAO.getCategorias();
            for (Categoria categoria : categorias) {
                if (categoria.getId_cat() == produto.getIdCat()) {
                    cmbCategoria.setSelectedItem(categoria.getNomecat());
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado.");
        }
    }//GEN-LAST:event_btnLerActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
        int idProduto = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do produto para atualizar:"));
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = produtoDAO.buscarProduto(idProduto);

        if (produto != null) {
            // Atualiza os valores com os campos do formulário
            produto.setNome(txtNome.getText());
            produto.setPreco(Double.parseDouble(txtPreco.getText()));
            produto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));

            // Atualiza a categoria
            String nomeCategoria = (String) cmbCategoria.getSelectedItem();
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            List<Categoria> categorias = categoriaDAO.getCategorias();
            for (Categoria categoria : categorias) {
                if (categoria.getNomecat().equals(nomeCategoria)) {
                    produto.setIdCat(categoria.getId_cat());
                    break;
                }
            }

            produtoDAO.atualizarProduto(produto);
        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado.");
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void txtQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCriar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnLer;
    private javax.swing.JComboBox cmbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblPreço;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
