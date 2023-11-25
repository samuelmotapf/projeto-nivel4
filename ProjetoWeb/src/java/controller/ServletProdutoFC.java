/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

/**
 *
 * @author muangala Jr
 */
@WebServlet(name = "ServletProdutoFC", urlPatterns = {"/ServletProdutoFC","/main","/insert","/select","/update","/delete"})
public class ServletProdutoFC extends HttpServlet {

    
    DAO dao = new DAO();
    
    JavaBeans produto = new JavaBeans();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String action = request.getServletPath();
            System.out.println(action);
            if (action.equals("/main")) {
                produtos(request, response);
            }else if(action.equals("/insert")){
                novoProduto(request, response);
            }else if(action.equals("/select")){
                listarProduto(request, response);
            }else if(action.equals("/update")){
                editarProduto(request, response);
            }else if (action.equals("/delete")) {
                excluirProduto(request, response);
            }else {
                response.sendRedirect("index.html");
            }
           
            
        }
    }
    
    protected void produtos(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException {
        ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) dao.listarProdutos();
        request.setAttribute("produtos", lista);
        RequestDispatcher rd = request.getRequestDispatcher("/ProdutoLista.jsp");
        rd.forward(request, response);
    //response.sendRedirect(request.getContextPath() + "/ProdutoLista.jsp");
}
    
    protected void novoProduto(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException {
    //Teste de recebimento
        System.out.println(request.getParameter("nome"));        
        System.out.println(request.getParameter("quantidade"));       
        System.out.println(request.getParameter("preco_de_valor"));
        
        //Setar as variaveis do JavaBeans
        produto.setNome(request.getParameter("nome"));        
        produto.setQuantidade(request.getParameter("quantidade"));     
        produto.setPreco_de_venda(request.getParameter("preco_de_valor"));
        
        //Chamando o método de inserir os dados 
        dao.inserirProduto(produto);
        
        response.sendRedirect("main");
}
    
     protected void listarProduto(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException {
         String id = request.getParameter("id");
         produto.setId(id);
         
         dao.selecionarProduto(produto);
         
         request.setAttribute("id", produto.getId());    
         request.setAttribute("nome", produto.getNome());     
         request.setAttribute("quantidade", produto.getQuantidade());       
         request.setAttribute("preco_de_venda", produto.getPreco_de_venda());
         
         RequestDispatcher rd = request.getRequestDispatcher("formEditar.jsp");
         rd.forward(request, response);
     }
     
     protected void editarProduto(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException {
         produto.setId(request.getParameter("id"));    
         produto.setNome(request.getParameter("nome"));      
         produto.setQuantidade(request.getParameter("quantidade"));     
         produto.setPreco_de_venda(request.getParameter("preco_de_venda"));
         
         dao.editarProduto(produto);
         
         response.sendRedirect("main");
     }
     
     
     protected void excluirProduto(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException {
    String id = request.getParameter("id");
    
    // Chama o método no DAO para excluir o produto com o ID especificado
    dao.excluirProduto(id);
    
    // Redireciona de volta para a página principal após a exclusão
    response.sendRedirect("main");
}
    
    
 
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletProdutoFC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletProdutoFC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
