import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroAlunos extends JFrame {
    private JTextField nomeField, dataNascimentoField, matriculaField, cursoField, cpfField, enderecoField, telefoneField;
    private JComboBox<String> sexoComboBox, estadoComboBox;
    private JTable alunoTable;
    private DefaultTableModel alunoModel;
    private List<Aluno> listaAlunos = new ArrayList<>();
    private final String arquivoAlunos = "alunos.txt";

    public CadastroAlunos() {
        setTitle("Cadastro de Alunos");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Carregar a lista de alunos do arquivo
        carregarAlunosDoArquivo();

        // Formulário de cadastro
        JPanel panelForm = new JPanel(new GridBagLayout());
        panelForm.setBorder(BorderFactory.createTitledBorder("Cadastro de Aluno"));
        GridBagConstraints gbcForm = new GridBagConstraints();
        gbcForm.fill = GridBagConstraints.HORIZONTAL;
        gbcForm.insets = new Insets(5, 5, 5, 5);

        // Campos de formulário
        gbcForm.gridx = 0;
        gbcForm.gridy = 0;
        panelForm.add(new JLabel("Nome Completo:"), gbcForm);
        gbcForm.gridx = 1;
        panelForm.add(nomeField = new JTextField(20), gbcForm);

        gbcForm.gridx = 0;
        gbcForm.gridy = 1;
        panelForm.add(new JLabel("Data de Nascimento (DD/MM/AAAA):"), gbcForm);
        gbcForm.gridx = 1;
        panelForm.add(dataNascimentoField = new JTextField(10), gbcForm);

        gbcForm.gridx = 0;
        gbcForm.gridy = 2;
        panelForm.add(new JLabel("Sexo:"), gbcForm);
        gbcForm.gridx = 1;
        panelForm.add(sexoComboBox = new JComboBox<>(new String[]{"Masculino", "Feminino"}), gbcForm);

        gbcForm.gridx = 0;
        gbcForm.gridy = 3;
        panelForm.add(new JLabel("Matrícula:"), gbcForm);
        gbcForm.gridx = 1;
        panelForm.add(matriculaField = new JTextField(10), gbcForm);

        gbcForm.gridx = 0;
        gbcForm.gridy = 4;
        panelForm.add(new JLabel("Curso:"), gbcForm);
        gbcForm.gridx = 1;
        panelForm.add(cursoField = new JTextField(20), gbcForm);

        gbcForm.gridx = 0;
        gbcForm.gridy = 5;
        panelForm.add(new JLabel("CPF:"), gbcForm);
        gbcForm.gridx = 1;
        panelForm.add(cpfField = new JTextField(15), gbcForm);

        gbcForm.gridx = 0;
        gbcForm.gridy = 6;
        panelForm.add(new JLabel("Endereço:"), gbcForm);
        gbcForm.gridx = 1;
        panelForm.add(enderecoField = new JTextField(20), gbcForm);

        gbcForm.gridx = 0;
        gbcForm.gridy = 7;
        panelForm.add(new JLabel("Estado:"), gbcForm);
        gbcForm.gridx = 1;
        panelForm.add(estadoComboBox = new JComboBox<>(new String[]{"SP", "RJ", "MG", "RS", "BA", "PE"}), gbcForm);

        gbcForm.gridx = 0;
        gbcForm.gridy = 8;
        panelForm.add(new JLabel("Telefone:"), gbcForm);
        gbcForm.gridx = 1;
        panelForm.add(telefoneField = new JTextField(15), gbcForm);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(panelForm, gbc);

        // Botão para adicionar aluno
        JButton adicionarBtn = new JButton("Adicionar Aluno");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(adicionarBtn, gbc);

        // Tabela para exibir os alunos
        alunoModel = new DefaultTableModel(new String[]{"Nome", "Data de Nascimento", "Sexo", "Matrícula", "Curso", "CPF", "Endereço", "Estado", "Telefone"}, 0);
        alunoTable = new JTable(alunoModel);
        JScrollPane scrollPane = new JScrollPane(alunoTable);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(scrollPane, gbc);

        // Ação do botão adicionar
        adicionarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarAluno();
            }
        });

        // Carregar dados na tabela
        carregarDadosNaTabela();
    }

    // Adicionar aluno à lista e tabela
    private void adicionarAluno() {
        String nome = nomeField.getText();
        String dataNascimento = dataNascimentoField.getText();
        String sexo = (String) sexoComboBox.getSelectedItem();
        String matricula = matriculaField.getText();
        String curso = cursoField.getText();
        String cpf = cpfField.getText();
        String endereco = enderecoField.getText();
        String estado = (String) estadoComboBox.getSelectedItem();
        String telefone = telefoneField.getText();

        Aluno aluno = new Aluno(nome, dataNascimento, sexo, matricula, curso, cpf, endereco, estado, telefone);
        listaAlunos.add(aluno);
        alunoModel.addRow(aluno.toTableRow());

        // Salvar lista no arquivo
        salvarAlunosNoArquivo();
    }

    // Salvar lista de alunos em arquivo
    private void salvarAlunosNoArquivo() {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(arquivoAlunos)))) {
            for (Aluno aluno : listaAlunos) {
                writer.println(aluno.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Carregar alunos do arquivo
    private void carregarAlunosDoArquivo() {
        File arquivo = new File(arquivoAlunos);
        if (arquivo.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(arquivoAlunos))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    Aluno aluno = Aluno.fromString(linha);
                    listaAlunos.add(aluno);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Carregar dados na tabela
    private void carregarDadosNaTabela() {
        for (Aluno aluno : listaAlunos) {
            alunoModel.addRow(aluno.toTableRow());
        }
    }

    public static void main(String[] args) {
        CadastroAlunos frame = new CadastroAlunos();
        frame.setVisible(true);
    }
}
