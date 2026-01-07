# Controle-Estoque-POO
Projeto focado na minha evolução em Java e Orientação a Objetos.

## 📅 Histórico de Evolução

- **08/Dez/2025:** Criação do projeto. Lógica simples, gerenciava apenas 1 produto.
- **12/Dez/2025:** Atualização importante!
   * Focando em aprender `ArrayList`.
   * Implementação de validações de segurança (evitando erros de indice).
     Código refatorado para Inglês Técnico.
 - **14/Dez/2025:**  Mudanças importantes!.
    * Adicionada busca e filtro por **Categoria**.
    * Implementada remoção de produtos pelo **Nome**.
    * Inclusão de **Tratamento de Exceções (try-catch)** para evitar erros na digitação.
  * **25/Dez/2025:** Limpando o metodo main🧹
    * Implementei a função de UPDATE: Antes não existia porque eu não sabia usar Setters na classe Produto. Agora aprendi e apliquei (agora dá pra editar nome, preço e categoria de verdade).
    * **Limpando a God Class:** Tirei toda a lógica de dentro da `main`. Agora ela só serve pra iniciar o programa, o resto tá organizado em métodos separados.
    * **Switch Case:** Troquei aquele monte de `if/else` por `switch`, ja que as opções do menu são unicas e tb o fator de ajudar na legibilidade.
  * **30/Dez/2025:** Criando o Sistema de Login e Blindando o Código 🔐 🛡️
    * **Tela de Login Funcional:** Agora o sistema cadastra usuários, exige senha e só libera o menu da loja se a **autenticação** for aprovada.
    * Hoje o foco não foi criar função nova, mas impedir que o programa quebre.
    * **O "Scanner Buffado":** entendi q nextInt() trava se digitar letra. Criei um método com **try-catch e Integer.parseInt** que evita isso.
    * **Regex no CPF:** Em vez de fazer 10 if/else como eu estava acostumado, **usei matches("[0-9.-]+")** para validar o CPF.
    * **Lógica de Acesso:** Usei variáveis booleanas **(flags)** para validar login e só liberar o menu da loja se a senha bater.
  * **02/Jan/2026:** Persistência em CSV e Otimização de Performance 💾⚡
  *  **Persistência de Dados:** Criei o saveProducts pra mandar tudo pro **CSV**. Agora os dados ficam gravados no disco e não somem mais quando o programa fecha.
  *  **Código Limpo (DRY):** Dei uma limpada no uso dos loops com metodos pra não repetir código à toa. Centralizei a listagem e o salvamento, o que deixa o código bem mais fácil de realizar manutenções dps.
    **07/Jan/2026:** Organização em **Camadas** e Especialização de Produtos 🏗️💻
     **Separação por tipo:** Agora o sistema entende que um Livro, uma Comida e um Eletrônico são diferentes. Cada um tem seus próprios detalhes (como autor ou validade), **mas todos herdam o básico da classe Produto**.
     **Produto virou uma "regra":** Agora a classe produto é **abstrata**. Isso significa que ninguém consegue criar um produto genérico, agora é obrigatório escolher um tipo real para cadastrar.
     **Cada um com sua função:** Comecei a separar quem manda na lógica (Managers) de quem só cuida de ler e gravar o arquivo CSV (Repositories). **Com cada classe cuidando da sua parte, o código fica bem mais fácil fazer a manutenção**.
