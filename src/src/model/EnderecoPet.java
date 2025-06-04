package model;

import java.util.IllegalFormatCodePointException;

public class EnderecoPet {
    private String numeroDaCasa;
    private String cidadeEncontrada;
    private String ruaEncontrada;


    public String getNumeroDaCasa() {
        return numeroDaCasa;
    }

    public String setNumeroDaCasa(String numeroDaCasa) {

        this.numeroDaCasa = numeroDaCasa;
        return this.numeroDaCasa;
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

    public String setRuaEncontrada(String ruaEncontrada) {
        this.ruaEncontrada = ruaEncontrada;
        return ruaEncontrada;
    }

}
