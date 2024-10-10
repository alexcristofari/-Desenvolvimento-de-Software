import javax.swing.*;

public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();
    }

    private void initComponents() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuListagem = new JMenu("Listagem");

        // Criar itens de menu para Cadastro
        JMenuItem menuItemCadastroPessoa = new JMenuItem("Cadastro de Pessoa");
        menuItemCadastroPessoa.addActionListener(e -> new CadastroPessoa().setVisible(true));

        JMenuItem menuItemCadastroAluno = new JMenuItem("Cadastro de Aluno");
        menuItemCadastroAluno.addActionListener(e -> new CadastroAluno().setVisible(true));

        JMenuItem menuItemCadastroProfessor = new JMenuItem("Cadastro de Professor");
        menuItemCadastroProfessor.addActionListener(e -> new CadastroProfessor().setVisible(true));

        JMenuItem menuItemCadastroVeiculo = new JMenuItem("Cadastro de Veículo");
        menuItemCadastroVeiculo.addActionListener(e -> new CadastroVeiculo().setVisible(true));

        // Adicionar os itens de menu para o Menu Cadastro
        menuCadastro.add(menuItemCadastroPessoa);
        menuCadastro.add(menuItemCadastroAluno);
        menuCadastro.add(menuItemCadastroProfessor);
        menuCadastro.add(menuItemCadastroVeiculo);

        // Criar itens de menu para Listagem
        JMenuItem menuItemListagemPessoa = new JMenuItem("Listar Pessoas");
        menuItemListagemPessoa.addActionListener(e -> {
            // Implementar listagem de pessoas aqui
            JOptionPane.showMessageDialog(this, "Listagem de Pessoas - Em breve");
        });

        menuListagem.add(menuItemListagemPessoa);
        // Aqui você pode adicionar outros itens de listagem (Aluno, Professor, etc.)

        // Adicionar os menus à barra de menu
        menuBar.add(menuCadastro);
        menuBar.add(menuListagem);

        setJMenuBar(menuBar);

        setTitle("Menu Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new MenuPrincipal().setVisible(true));
    }
}
