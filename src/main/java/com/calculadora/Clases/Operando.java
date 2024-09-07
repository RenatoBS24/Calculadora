package com.calculadora.Clases;

public class Operando {
    private String valor = "";
    private int precedencia = 0;

    public Operando(String valor) {
        this.valor = valor;
    }
    public Operando(String valor, int precedencia) {
        this.valor = valor;
        this.precedencia = precedencia;
    }
    public Operando(){

    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getPrecedencia() {
        return precedencia;
    }

    public void setPrecedencia(int precedencia) {
        this.precedencia = precedencia;
    }

    @Override
    public String toString() {
        return valor;
    }
}
