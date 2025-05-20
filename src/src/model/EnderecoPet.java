package model;

public class EnderecoPet {
    private Integer numeroDaCasa;
    private String cidadeEncontrada;
    private String ruaEncontrada;

    public EnderecoPet(Integer numeroDaCasa, String cidadeEncontrada, String ruaEncontrada) {
        this.numeroDaCasa = numeroDaCasa;
        this.cidadeEncontrada = cidadeEncontrada;
        this.ruaEncontrada = ruaEncontrada;
    }

    public Integer getNumeroDaCasa() {
        return numeroDaCasa;
    }

    public void setNumeroDaCasa(Integer numeroDaCasa) {
        this.numeroDaCasa = numeroDaCasa;
    }

    public String getCidadeEncontrada() {
        return cidadeEncontrada;
    }

    public void setCidadeEncontrada(String cidadeEncontrada) {
        this.cidadeEncontrada = cidadeEncontrada;
    }

    public String getRuaEncontrada() {
        return ruaEncontrada;
    }

    public void setRuaEncontrada(String ruaEncontrada) {
        this.ruaEncontrada = ruaEncontrada;
    }
}
