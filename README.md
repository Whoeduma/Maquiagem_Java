<h1 align="center"> 💄CRUD de Maquiagens com Java e MySQL</h1>

## Objetivo
Esta é uma atualização do projeto acadêmico simples desenvolvido em Java puro, com conexão a banco de dados MySQL, cujo objetivo é implementar um sistema de cadastro, leitura, atualização e exclusão de maquiagens. O projeto busca exercitar os conceitos de lógica de programação, orientação a objetos (POO) e manipulação de banco de dados com JDBC.

## 🧠 Funcionalidades

- ✅ Cadastrar nova maquiagem
- 📄 Listar todas as maquiagens
- ✏️ Atualizar uma maquiagem existente
- 🗑️ Deletar maquiagem por ID

Cada maquiagem contém os seguintes atributos:

- `id` (int) – Identificador único
- `marca` (String)
- `tipo` (String)
- `cor` (String)

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **MySQL** 
- **JDBC (Java Database Connectivity)**
- **Eclipse** 

## 📌 Atualizações Recentes
- Implementada conexão com MySQL via JDBC
- Corrigido bug na atualização de maquiagens (parâmetros duplicados no PreparedStatement)
- Estrutura de código organizada em classes: Maquiagem, Conexao, MaquiagemDAO, Main
