package br.com.umc.model;

public class Mercadoria {

    private int id;
    private String tipo;
    private String nome;
    private int quantidade;
    private double preco;
    private String tiponegocio;

    public Mercadoria() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTiponegocio() {
        return tiponegocio;
    }

    public void setTiponegocio(String tiponegocio) {
        this.tiponegocio = tiponegocio;
    }

    public Mercadoria(int id, String tipo, String nome, int quantidade, double preco, String tiponegocio) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.tiponegocio = tiponegocio;
    }


    
   
}