/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author muangala Jr
 */
public class JavaBeans {
    private String id;
    private String nome;
    private String quantidade;
    private String preco_de_venda;

    public JavaBeans() {
        super();
    }

    public JavaBeans(String id, String nome, String quantidade, String preco_de_venda) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco_de_venda = preco_de_venda;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getPreco_de_venda() {
        return preco_de_venda;
    }

    public void setPreco_de_venda(String preco_de_venda) {
        this.preco_de_venda = preco_de_venda;
    }
    
    

    
    
   
    
}
