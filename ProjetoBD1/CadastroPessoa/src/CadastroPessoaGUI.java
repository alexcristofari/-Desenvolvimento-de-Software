import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroPessoaGUI extends JFrame {
    private JTextField nomeField;
    private JRadioButton masculinoRadio;
    private JRadioButton femininoRadio;
    private JComboBox<String> idiomaCombo;
    private JButton salvarButton;

    public CadastroPessoaGUI() {
        // Configurações básicas da janela
        setTitle("Cadastro de Pessoa");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Criando o painel principal com GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Margens entre os componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Campo Nome
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Nome:"), gbc);

        nomeField = new JTextField(15);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(nomeField, gbc);

        // Botões de rádio para Sexo
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Sexo:"), gbc);

        JPanel sexoPanel = new JPanel();
        masculinoRadio = new JRadioButton("Masculino");
        femininoRadio = new JRadioButton("Feminino");
        sexoPanel.add(masculinoRadio);
        sexoPanel.add(femininoRadio);
        ButtonGroup sexoGroup = new ButtonGroup();
        sexoGroup.add(masculinoRadio);
        sexoGroup.add(femininoRadio);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(sexoPanel, gbc);

        // ComboBox para Idioma
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Idioma:"), gbc);

        idiomaCombo = new JComboBox<>(new String[]{"Português", "Inglês", "Espanhol"});
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(idiomaCombo, gbc);

        // Botão Salvar
        salvarButton = new JButton("Salvar");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(salvarButton, gbc);

        // Adicionando o painel à janela
        add(panel);

        // Ação do botão salvar
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarPessoa();
            }
        });

        // Tornando a janela visível
        setVisible(true);
    }

    private void salvarPessoa() {
        String nome = nomeField.getText();
        String sexo = masculinoRadio.isSelected() ? "M" : "F";
        String idioma = idiomaCombo.getSelectedItem().toString();

        Pessoa p = new Pessoa();
        p.setNome(nome);
        p.setSexo(sexo);
        p.setIdioma(idioma);

        PessoaDAO pDAO = new PessoaDAO();
        pDAO.inserir(p);

        JOptionPane.showMessageDialog(this, "Pessoa cadastrada com sucesso!");
    }

    // Método principal para iniciar a aplicação
    public static void main(String[] args) {
        // Iniciando a interface gráfica
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadastroPessoaGUI();
            }
        });
    }
}
