public class Main {
    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        p.setNome("Ricardo");
        p.setSexo("M");
        p.setIdioma("PORTUGUÊS");

        PessoaDAO pDAO = new PessoaDAO();
        pDAO.inserir(p);
    }
}
