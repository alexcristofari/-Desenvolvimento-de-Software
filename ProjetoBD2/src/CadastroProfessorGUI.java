import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroProfessorGUI extends JFrame {
    private JTextField nomeField;
    private JTextField idadeField;
    private JTextField disciplinaField;
    private JButton salvarButton;

    public CadastroProfessorGUI() {
        setTitle("Cadastro de Professor");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        // Campo Nome
        panel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        panel.add(nomeField);

        // Campo Idade
        panel.add(new JLabel("Idade:"));
        idadeField = new JTextField();
        panel.add(idadeField);

        // Campo Disciplina
        panel.add(new JLabel("Disciplina:"));
        disciplinaField = new JTextField();
        panel.add(disciplinaField);

        // Botão Salvar
        salvarButton = new JButton("Salvar");
        panel.add(salvarButton);

        add(panel);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarProfessor();
            }
        });

        setVisible(true);
    }

    private void salvarProfessor() {
        String nome = nomeField.getText();
        int idade = Integer.parseInt(idadeField.getText());
        String disciplina = disciplinaField.getText();

        Professor professor = new Professor();
        professor.setNome(nome);
        professor.setIdade(idade);
        professor.setDisciplina(disciplina);

        ProfessorDAO professorDAO = new ProfessorDAO();
        professorDAO.inserir(professor);

        JOptionPane.showMessageDialog(this, "Professor cadastrado com sucesso!");
    }

    public static void main(String[] args) {
        new CadastroProfessorGUI();
    }
}
