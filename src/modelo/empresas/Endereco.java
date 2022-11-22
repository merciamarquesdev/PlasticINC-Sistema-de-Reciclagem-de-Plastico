package modelo.empresas;

public class Endereco {
    private String rua;
    private String numero;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco(String rua, String numero, String cep, String bairro, String cidade, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String  getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return (" " + rua + ", " + numero + ", " + "CEP: " + cep + ", " + bairro + ", " + cidade + " - " + estado);
    }

}
