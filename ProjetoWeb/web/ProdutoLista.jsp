<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.JavaBeans" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista de Produtos</title>
    <!-- Adicione o link para o Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h1>Lista de Produtos</h1>

        <a class="btn btn-primary mb-3" href="formIncluir.html">Novo Produto</a>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Quantidade</th>
                    <th>Preço de Venda</th>
                    <th>Opções</th>
                </tr>
            </thead>
            <tbody>
                <% List<JavaBeans> lista = (List<JavaBeans>) request.getAttribute("produtos");
                   if (lista != null && !lista.isEmpty()) {
                       for (JavaBeans produto : lista) { %>
                           <tr>
                               <td><%= produto.getId() %></td>
                               <td><%= produto.getNome() %></td>
                               <td><%= produto.getQuantidade() %></td>
                               <td><%= produto.getPreco_de_venda() %></td>
                               <td>
                                   <a class="btn btn-sm btn-warning" href="select?id=<%=produto.getId()%>">Alterar</a>
                                   <a class="btn btn-sm btn-danger" href="ServletProdutoFC?action=delete&id=<%=produto.getId()%>">Excluir</a>
                               </td>
                           </tr>
                       <% }
                   } else { %>
                       <tr>
                           <td colspan="5">Não há produtos cadastrados.</td>
                       </tr>
                   <% } %>
            </tbody>
        </table>
    </div>

    <!-- Adicione o link para o Bootstrap JS e o pacote popper.js, caso seja necessário para alguns recursos do Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
