import javax.swing.*;
import dao.ProfessorDAO;
import model.Professor;

public class CadastroProfessor extends javax.swing.JFrame {

    private JTextField campoNome;
    private JTextField campoSexo;
    private JTextField campoIdade;
    private JTextField campoIdioma;

    public CadastroProfessor() {
        initComponents();
    }

    private void initComponents() {
        campoNome = new JTextField(20);
        campoSexo = new JTextField(1);
        campoIdade = new JTextField(3);
        campoIdioma = new JTextField(20);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> adicionarProfessor());

        JPanel panel = new JPanel();
        panel.add(new JLabel("Nome:"));
        panel.add(campoNome);
        panel.add(new JLabel("Sexo:"));
        panel.add(campoSexo);
        panel.add(new JLabel("Idade:"));
        panel.add(campoIdade);
        panel.add(new JLabel("Idioma:"));
        panel.add(campoIdioma);

        add(panel, "Center");
        add(btnSalvar, "South");

        setTitle("Cadastro de Professor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void adicionarProfessor() {
        Professor professor = new Professor();
        professor.setNome(campoNome.getText());
        professor.setSexo(campoSexo.getText());
        professor.setIdade(Integer.parseInt(campoIdade.getText()));
        professor.setIdioma(campoIdioma.getText());

        ProfessorDAO professorDAO = new ProfessorDAO();
        professorDAO.adicionarProfessor(professor);
        JOptionPane.showMessageDialog(this, "Professor adicionado com sucesso!");
    }
}
