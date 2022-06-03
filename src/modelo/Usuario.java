package modelo;

public class Usuario {

    private String id;
    private String carta;
    private String edicao;
    private String idioma;
    private String foil;
    private String valor;
    private String qud;
    private String[] colunas = new String[]{"ID", "CARTA", "EDICAO", "IDIOMA", "FOIL","VALOR","QUD"};

    public Usuario() {
    }

    public Usuario(String id) {
        this.id = id;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarta() {
        return carta;
    }

    public void setCarta(String carta) {
        this.carta = carta;
    }

    public String getFoil() {
        return foil;
    }

    public void setFoil(String foil) {
        this.foil = foil;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] Colunas) {
        this.colunas = Colunas;
    }
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;

    }
    public String getQud() {
        return qud;
    }

    public void setQud(String qud) {
        this.qud = qud;

    }

    public void setEdi(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setIdi(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setCpf(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setNome(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getCpf() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
