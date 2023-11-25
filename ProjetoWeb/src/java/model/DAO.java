/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author muangala Jr
 */
public class DAO {
    private String  driver = "com.mysql.cj.jdbc.Driver";
    //private String url = "jdbc:mysql://127.0.0.1:3306/loja?";
    private String url = "jdbc:mysql://127.0.0.1:3306/loja?usetimezone=true&serverTimezone=UTC";

    private String user = "root";
    private String password = "";
    
    //Método de Conexão
    private Connection conectar(){
        Connection con = null;
        
        try {
        Class.forName(driver);
        return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        }
    }
    
    //Para inserir os dados
    public void inserirProduto(JavaBeans produto){
        String create = "INSERT INTO produto (nome, quantidade, preco_de_venda) VALUES (?, ?, ?)";
        
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(create);
            
            pst.setString(1, produto.getNome());           
            pst.setString(2, produto.getQuantidade());
            pst.setString(3, produto.getPreco_de_venda());
            
            pst.executeUpdate();
            
            con.close();


        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // Método para listar os produtos
    public List<JavaBeans> listarProdutos() {
        List<JavaBeans> produtos = new ArrayList<>();
        String query = "SELECT * FROM produto";

        try (Connection con = conectar();
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                String id = rs.getString(1);               
                String nome = rs.getString(2);          
                String quantidade = rs.getString(3);                
                String preco_de_venda = rs.getString(4);
                
                //Populando o ArrayList
                produtos.add(new JavaBeans(id,nome,quantidade,preco_de_venda));
            }
            con.close();
            return produtos;

        } catch (Exception e) {
            System.out.println(e);
        }

        return produtos;
    }
    
    //Para selecionar o produto
    public void selecionarProduto(JavaBeans produto) {
         String query = "SELECT * FROM produto WHERE id = ?";
    //JavaBeans produto = null;
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, produto.getId());
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                produto.setId(rs.getString(1));     
                produto.setNome(rs.getString(2));    
                produto.setQuantidade(rs.getString(3));          
                produto.setPreco_de_venda(rs.getString(4));
            }
        con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        
    }
    
    
    // Método para editar um produto
public void editarProduto(JavaBeans produto) {
    String update = "UPDATE produto SET nome = ?, quantidade = ?, preco_de_venda = ? WHERE id = ?";

    try {
        Connection con = conectar();
        PreparedStatement pst = con.prepareStatement(update);

        pst.setString(1, produto.getNome());
        pst.setString(2, produto.getQuantidade());
        pst.setString(3, produto.getPreco_de_venda());
        pst.setString(4, produto.getId());

        pst.executeUpdate();
        con.close();

    } catch (Exception e) {
        System.out.println(e);
    }
}

// Método para excluir um produto
public void excluirProduto(String id) {
    String delete = "DELETE FROM produto WHERE id = ?";

    try {
        Connection con = conectar();
        PreparedStatement pst = con.prepareStatement(delete);

        pst.setString(1, id);

        pst.executeUpdate();
        con.close();

    } catch (Exception e) {
        System.out.println(e);
    }
}
    
    //Teste de Conexão
    /*
    public void testeConexao() throws SQLException{
        
        System.out.println("testeeeeeeeeeee");
       
        
         try {
        Connection con = conectar();
        System.out.println("Conexão estabelecida: " + con);
        con.close();
        } catch (RuntimeException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
    }*/
}
