#  LedgerFlow

Projeto de estudo desenvolvido para aprofundar conhecimentos em desenvolvimento backend com Java e Spring Boot.
A aplicação simula um sistema simples de carteira digital e estoque de produtos, permitindo a criação de usuários
e realização de transações entre eles, com controle de saldo e consistência de dados.
Algumas funções serão implementadas em breve, ainda está sendo testada e aprimorada, pois começou como um simples "campo" de treino para novos aprendizados,
mas veio a se tornar uma ótima experiência, a qual manterei atualizada, implementando novas funcionalidades e em breve criando uma interface web ao mesmo.


---

# Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven
- MySQL
- REST API
- DTO Pattern
- JPA Transactions
- Optimistic Lock (@Version)

---

# Conceitos aplicados

Durante o desenvolvimento deste projeto foram praticados diversos conceitos importantes de backend:

- Arquitetura em camadas (Controller, Service, Repository)
- Separação entre Entity e DTO
- Persistência com JPA/Hibernate
- Relacionamentos entre entidades
- Controle de concorrência com `@Version`
- Transações com `@Transactional`
- Manipulação segura de valores monetários com `BigDecimal`
- Validações de regras de negócio no Service

---

# Funcionalidades

- Cadastro de usuários
- Consulta de usuários
- Transferência de saldo entre usuários
- Registro de transações
- Controle de concorrência para evitar inconsistências no saldo

---

# Aprendizados

Além do conteúdo de cursos, grande parte do aprendizado veio da prática e experimentação.

A cada aula, dediquei tempo extra para:

- testar diferentes abordagens
- implementar melhorias
- refatorar o código
- explorar conceitos mais avançados da stack
- criar mini projetos

Esse processo me ajudou a consolidar o entendimento de como aplicações backend reais são estruturadas, e entender melhor o dia a dia de um Dev.

---

