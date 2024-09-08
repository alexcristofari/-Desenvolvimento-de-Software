public class Aluno extends Usuario {
    private String matricula;
    private String cursoGraduacao;

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getCursoGraduacao() { return cursoGraduacao; }
    public void setCursoGraduacao(String cursoGraduacao) { this.cursoGraduacao = cursoGraduacao; }

    @Override
    public void executaAcao() {
        System.out.println("O aluno " + getNomeCompleto() + " foi inserido.");
    }
}
