<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Editar Produto</title>
  <!-- Adicione os arquivos CSS do Bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    /* Estilos adicionais para centralizar os inputs */
    .center-input {
      display: flex;
      flex-direction: column;
      align-items: center;
    }
    /* Estilos para aplicar a borda vermelha */
    .form-control-red {
      border: 1px solid red;
    }
  </style>
</head>
<body>

  <div class="container mt-4">
    <h2>Editar Produto</h2>

    <form action="update" method="post" class="needs-validation" novalidate>
      <!-- Campo oculto para enviar o ID do produto que está sendo editado -->
      <div class="mb-3">
        <label for="id" class="form-label">ID:</label>
        <input type="text" id="id" name="id" value="<%= request.getAttribute("id") %>" class="form-control form-control-red" readonly>
      </div>

      <div class="center-input">
        <div class="mb-3">
          <label for="nome" class="form-label">Nome:</label>
          <input type="text" id="nome" name="nome" value="<%= request.getAttribute("nome") %>" class="form-control" required>
          <div class="invalid-feedback">Por favor, insira um nome.</div>
        </div>

        <div class="mb-3">
          <label for="quantidade" class="form-label">Quantidade:</label>
          <input type="number" id="quantidade" name="quantidade" value="<%= request.getAttribute("quantidade") %>" class="form-control" required>
          <div class="invalid-feedback">Por favor, insira uma quantidade válida.</div>
        </div>

        <div class="mb-3">
          <label for="preco_de_valor" class="form-label">Preço de Venda:</label>
          <input type="number" step="0.01" id="preco_de_valor" name="preco_de_valor" value="<%= request.getAttribute("preco_de_venda") %>" class="form-control" required>
          <div class="invalid-feedback">Por favor, insira um preço válido.</div>
        </div>
      </div>

      <button type="submit" class="btn btn-primary">Atualizar Produto</button>
    </form>
  </div>

  <!-- Adicione os arquivos JS do Bootstrap para funcionalidades como validação de formulário -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  <script>
    // Ative a validação de formulário do Bootstrap
    ;(function () {
      'use strict'

      var forms = document.querySelectorAll('.needs-validation')

      Array.prototype.slice.call(forms).forEach(function (form) {
        form.addEventListener('submit', function (event) {
          if (!form.checkValidity()) {
            event.preventDefault()
            event.stopPropagation()
          }

          form.classList.add('was-validated')
        }, false)
      })
    })()
  </script>
</body>
</html>
