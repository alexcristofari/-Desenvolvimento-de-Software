import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CadastroUsuario extends JFrame {
    private JTextField nomeField, cpfField, rgField, enderecoField, telefoneField, nomePaiField, nomeMaeField, nacionalidadeField;
    private JComboBox<String> estadoComboBox;
    private JRadioButton professorRadio, alunoRadio;
    private JTextField matriculaField, formacaoField, alocacaoField, cursoField;
    private JTable professorTable, alunoTable;
    private DefaultTableModel professorModel, alunoModel;
    private JLabel messageLabel;
    private ArrayList<Professor> professores = new ArrayList<>();
    private ArrayList<Aluno> alunos = new ArrayList<>();

    public CadastroUsuario() {
        setTitle("Cadastro de Usuários");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());  // Usar GridBagLayout para melhor organização
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Painel de dados comuns
        JPanel panelComum = new JPanel(new GridBagLayout());
        panelComum.setBorder(BorderFactory.createTitledBorder("Dados Gerais"));
        GridBagConstraints gbcComum = new GridBagConstraints();
        gbcComum.fill = GridBagConstraints.HORIZONTAL;
        gbcComum.insets = new Insets(5, 5, 5, 5); // Espaçamento entre os componentes

        // Primeira linha
        gbcComum.gridx = 0;
        gbcComum.gridy = 0;
        panelComum.add(new JLabel("Nome Completo:"), gbcComum);
        gbcComum.gridx = 1;
        panelComum.add(nomeField = new JTextField(), gbcComum);

        gbcComum.gridx = 0;
        gbcComum.gridy = 1;
        panelComum.add(new JLabel("CPF:"), gbcComum);
        gbcComum.gridx = 1;
        panelComum.add(cpfField = new JTextField(), gbcComum);

        // Segunda linha
        gbcComum.gridx = 0;
        gbcComum.gridy = 2;
        panelComum.add(new JLabel("RG:"), gbcComum);
        gbcComum.gridx = 1;
        panelComum.add(rgField = new JTextField(), gbcComum);

        gbcComum.gridx = 0;
        gbcComum.gridy = 3;
        panelComum.add(new JLabel("Telefone:"), gbcComum);
        gbcComum.gridx = 1;
        panelComum.add(telefoneField = new JTextField(), gbcComum);

        // Terceira linha
        gbcComum.gridx = 0;
        gbcComum.gridy = 4;
        panelComum.add(new JLabel("Endereço:"), gbcComum);
        gbcComum.gridx = 1;
        panelComum.add(enderecoField = new JTextField(), gbcComum);

        // Quarta linha
        gbcComum.gridx = 0;
        gbcComum.gridy = 5;
        panelComum.add(new JLabel("Nome do Pai:"), gbcComum);
        gbcComum.gridx = 1;
        panelComum.add(nomePaiField = new JTextField(), gbcComum);

        // Quinta linha
        gbcComum.gridx = 0;
        gbcComum.gridy = 6;
        panelComum.add(new JLabel("Nome da Mãe:"), gbcComum);
        gbcComum.gridx = 1;
        panelComum.add(nomeMaeField = new JTextField(), gbcComum);

        // Sexta linha
        gbcComum.gridx = 0;
        gbcComum.gridy = 7;
        panelComum.add(new JLabel("Nacionalidade:"), gbcComum);
        gbcComum.gridx = 1;
        panelComum.add(nacionalidadeField = new JTextField(), gbcComum);

        // Sétima linha
        gbcComum.gridx = 0;
        gbcComum.gridy = 8;
        panelComum.add(new JLabel("Estado:"), gbcComum);
        gbcComum.gridx = 1;
        panelComum.add(estadoComboBox = new JComboBox<>(new String[]{"SP", "RJ", "MG", "RS", "BA", "PE"}), gbcComum);

        // Adiciona o painel comum no layout principal
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(panelComum, gbc);

        // Painel de seleção de usuário (Professor ou Aluno)
        JPanel panelUsuario = new JPanel(new GridLayout(1, 2));
        panelUsuario.setBorder(BorderFactory.createTitledBorder("Tipo de Usuário"));
        professorRadio = new JRadioButton("Professor");
        alunoRadio = new JRadioButton("Aluno");
        ButtonGroup group = new ButtonGroup();
        group.add(professorRadio);
        group.add(alunoRadio);
        panelUsuario.add(professorRadio);
        panelUsuario.add(alunoRadio);

        // Adiciona o painel de seleção de usuário
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(panelUsuario, gbc);

        // Painel de dados específicos de Professor
        JPanel panelProfessor = new JPanel(new GridLayout(3, 2, 5, 5));
        panelProfessor.setBorder(BorderFactory.createTitledBorder("Dados do Professor"));
        matriculaField = new JTextField();
        formacaoField = new JTextField();
        alocacaoField = new JTextField();
        panelProfessor.add(new JLabel("Matrícula:"));
        panelProfessor.add(matriculaField);
        panelProfessor.add(new JLabel("Formação:"));
        panelProfessor.add(formacaoField);
        panelProfessor.add(new JLabel("Alocação:"));
        panelProfessor.add(alocacaoField);

        // Adiciona o painel do professor
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(panelProfessor, gbc);

        // Painel de dados específicos de Aluno
        JPanel panelAluno = new JPanel(new GridLayout(2, 2, 5, 5));
        panelAluno.setBorder(BorderFactory.createTitledBorder("Dados do Aluno"));
        cursoField = new JTextField();
        matriculaField = new JTextField();
        panelAluno.add(new JLabel("Matrícula:"));
        panelAluno.add(matriculaField);
        panelAluno.add(new JLabel("Curso de Graduação:"));
        panelAluno.add(cursoField);

        // Adiciona o painel do aluno
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(panelAluno, gbc);

        // Botão para inserir
        JButton inserirBtn = new JButton("Inserir");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(inserirBtn, gbc);

        // Tabelas para visualização
        professorModel = new DefaultTableModel(new String[]{"Nome", "Matricula", "Formação", "Alocação"}, 0);
        alunoModel = new DefaultTableModel(new String[]{"Nome", "Matricula", "Curso"}, 0);
        professorTable = new JTable(professorModel);
        alunoTable = new JTable(alunoModel);

        // Painel das tabelas
        JPanel panelTabelas = new JPanel(new GridLayout(1, 2));
        panelTabelas.add(new JScrollPane(professorTable));
        panelTabelas.add(new JScrollPane(alunoTable));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(panelTabelas, gbc);

        // Label para mensagens de inserção
        messageLabel = new JLabel("");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        add(messageLabel, gbc);

        // Lógica de habilitação/desabilitação de campos e inserção nas tabelas
        professorRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Habilitar campos do professor
                matriculaField.setEnabled(true);
                formacaoField.setEnabled(true);
                alocacaoField.setEnabled(true);

                // Desabilitar campos do aluno
                cursoField.setEnabled(false);
            }
        });

        alunoRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Habilitar campos do aluno
                matriculaField.setEnabled(true);
                cursoField.setEnabled(true);

                // Desabilitar campos do professor
                formacaoField.setEnabled(false);
                alocacaoField.setEnabled(false);
            }
        });

        inserirBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (professorRadio.isSelected()) {
                    Professor professor = new Professor();
                    professor.setNomeCompleto(nomeField.getText());
                    professor.setMatricula(matriculaField.getText());
                    professor.setAreaFormacao(formacaoField.getText());
                    professor.setAlocacao(alocacaoField.getText());
                    professores.add(professor);
                    professorModel.addRow(new Object[]{professor.getNomeCompleto(), professor.getMatricula(), professor.getAreaFormacao(), professor.getAlocacao()});
                    messageLabel.setText("O professor " + professor.getNomeCompleto() + " foi inserido.");
                } else if (alunoRadio.isSelected()) {
                    Aluno aluno = new Aluno();
                    aluno.setNomeCompleto(nomeField.getText());
                    aluno.setMatricula(matriculaField.getText());
                    aluno.setCursoGraduacao(cursoField.getText());
                    alunos.add(aluno);
                    alunoModel.addRow(new Object[]{aluno.getNomeCompleto(), aluno.getMatricula(), aluno.getCursoGraduacao()});
                    messageLabel.setText("O aluno " + aluno.getNomeCompleto() + " foi inserido.");
                }
            }
        });

        // Exibir janela
        setVisible(true);
    }

    public static void main(String[] args) {
        CadastroUsuario frame = new CadastroUsuario();
        frame.setVisible(true);
    }
}
