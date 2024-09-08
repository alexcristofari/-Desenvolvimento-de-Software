public class Professor extends Usuario {
    private String matricula;
    private String areaFormacao;
    private String alocacao;

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getAreaFormacao() { return areaFormacao; }
    public void setAreaFormacao(String areaFormacao) { this.areaFormacao = areaFormacao; }

    public String getAlocacao() { return alocacao; }
    public void setAlocacao(String alocacao) { this.alocacao = alocacao; }

    @Override
    public void executaAcao() {
        System.out.println("O professor " + getNomeCompleto() + " foi inserido.");
    }
}
