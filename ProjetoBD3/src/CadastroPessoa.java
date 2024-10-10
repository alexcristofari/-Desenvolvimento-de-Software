import javax.swing.*;
import dao.PessoaDAO;
import model.Pessoa;

public class CadastroPessoa extends javax.swing.JFrame {

    private JTextField campoNome;
    private JTextField campoSexo;
    private JTextField campoIdade;

    public CadastroPessoa() {
        initComponents();
    }

    private void initComponents() {
        campoNome = new JTextField(20);
        campoSexo = new JTextField(1);
        campoIdade = new JTextField(3);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> adicionarPessoa());

        JPanel panel = new JPanel();
        panel.add(new JLabel("Nome:"));
        panel.add(campoNome);
        panel.add(new JLabel("Sexo:"));
        panel.add(campoSexo);
        panel.add(new JLabel("Idade:"));
        panel.add(campoIdade);

        add(panel, "Center");
        add(btnSalvar, "South");

        setTitle("Cadastro de Pessoa");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void adicionarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(campoNome.getText());
        pessoa.setSexo(campoSexo.getText());
        pessoa.setIdade(Integer.parseInt(campoIdade.getText()));

        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.adicionarPessoa(pessoa);
        JOptionPane.showMessageDialog(this, "Pessoa adicionada com sucesso!");
    }
}
