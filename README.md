# Baozi Store API 🥟

Este projeto consiste no desenvolvimento de uma API REST simples para controle básico de clientes, produtos e pedidos de uma pequena loja de pães chineses chamada **Baozi Store**. O projeto foi desenvolvido como atividade prática para a disciplina de Desenvolvimento Web Back-End[cite: 1].

## 🚀 Tecnologias Utilizadas

* **Java 17** (ou a versão utilizada por você)
* **Spring Boot 3.x**
* **Spring Data JPA**
* **H2 Database** (Banco de dados relacional em memória para testes rápidos)
* **Maven** (Gerenciador de dependências)
* **Lombok** (Opcional - Redução de código boilerplate)

## 🏗️ Arquitetura do Projeto

O projeto segue o padrão arquitetural **MVC (Model-View-Controller)** exigido, organizado na seguinte estrutura de pacotes:

```text
src/main/java/com/baozistore/api/
├── controller/   # Camada de controle (Endpoints REST)
├── model/        # Camada de modelo (Entidades JPA)
└── repository/   # Camada de persistência (Interfaces JpaRepository)
