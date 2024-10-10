import javax.swing.*;
import dao.AlunoDAO;
import model.Aluno;

public class CadastroAluno extends javax.swing.JFrame {

    private JTextField campoNome;
    private JTextField campoSexo;
    private JTextField campoIdade;

    public CadastroAluno() {
        initComponents();
    }

    private void initComponents() {
        campoNome = new JTextField(20);
        campoSexo = new JTextField(1);
        campoIdade = new JTextField(3);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> adicionarAluno());

        JPanel panel = new JPanel();
        panel.add(new JLabel("Nome:"));
        panel.add(campoNome);
        panel.add(new JLabel("Sexo:"));
        panel.add(campoSexo);
        panel.add(new JLabel("Idade:"));
        panel.add(campoIdade);

        add(panel, "Center");
        add(btnSalvar, "South");

        setTitle("Cadastro de Aluno");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void adicionarAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome(campoNome.getText());
        aluno.setSexo(campoSexo.getText());
        aluno.setIdade(Integer.parseInt(campoIdade.getText()));

        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.adicionarAluno(aluno);
        JOptionPane.showMessageDialog(this, "Aluno adicionado com sucesso!");
    }
}
