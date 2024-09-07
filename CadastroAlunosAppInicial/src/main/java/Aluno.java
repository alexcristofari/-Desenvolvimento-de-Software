public class Aluno {
    private String nomeCompleto;
    private String dataNascimento;
    private String sexo;
    private String matricula;
    private String curso;
    private String cpf;
    private String endereco;
    private String estado;
    private String telefone;

    // Construtor
    public Aluno(String nomeCompleto, String dataNascimento, String sexo, String matricula, String curso, String cpf, String endereco, String estado, String telefone) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.matricula = matricula;
        this.curso = curso;
        this.cpf = cpf;
        this.endereco = endereco;
        this.estado = estado;
        this.telefone = telefone;
    }

    // Converte o objeto Aluno em um array de Strings para adicionar à tabela
    public String[] toTableRow() {
        return new String[]{nomeCompleto, dataNascimento, sexo, matricula, curso, cpf, endereco, estado, telefone};
    }

    // Formatação para salvar no arquivo
    @Override
    public String toString() {
        return nomeCompleto + "," + dataNascimento + "," + sexo + "," + matricula + "," + curso + "," + cpf + "," + endereco + "," + estado + "," + telefone;
    }

    // Converte uma linha lida de um arquivo para um objeto Aluno
    public static Aluno fromString(String linha) {
        String[] dados = linha.split(",");
        return new Aluno(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], dados[7], dados[8]);
    }
}
