import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroAlunoGUI extends JFrame {
    private JTextField nomeField;
    private JTextField idadeField;
    private JTextField cursoField;
    private JButton salvarButton;

    public CadastroAlunoGUI() {
        setTitle("Cadastro de Aluno");
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

        // Campo Curso
        panel.add(new JLabel("Curso:"));
        cursoField = new JTextField();
        panel.add(cursoField);

        // Botão Salvar
        salvarButton = new JButton("Salvar");
        panel.add(salvarButton);

        add(panel);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarAluno();
            }
        });

        setVisible(true);
    }

    private void salvarAluno() {
        String nome = nomeField.getText();
        int idade = Integer.parseInt(idadeField.getText());
        String curso = cursoField.getText();

        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setIdade(idade);
        aluno.setCurso(curso);

        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.inserir(aluno);

        JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");
    }

    public static void main(String[] args) {
        new CadastroAlunoGUI();
    }
}
