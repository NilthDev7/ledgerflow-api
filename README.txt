LedgerFlow API

LedgerFlow is a REST API built with Java and Spring Boot that simulates a simple financial ledger system.
The goal of this project is to practice backend architecture, financial transaction logic and REST API design.
This project focuses on applying layered architecture principles and clean backend design using Spring Boot.
The system currently supports:
- Client registration
- User account creation
- Deposits
- Transfers between users
- Transaction control

⚠️ Work in Progress
The Empresa and Produto modules are currently under development and are not fully available yet.
These modules will introduce company management and inventory control features in future versions of the system.

Technologies
Technology	Purpose:
- Java 17	Main programming language
- Spring Boot	3 Backend framework
- Spring Data JPA	Database access
- Hibernate	ORM
- Mysql
- Maven	Dependency management
- REST API	Communication layer

Project Structure
ledgerflow-api
│
├── WebCardApplication
├── controller
│   ├── ClienteController
│   ├── EmpresaController
│   ├── ProdutoController
│   ├── TransactionController
│   └── UsuarioController
│
├── dto
│   ├── ClienteCriacaoDTO
│   ├── ClienteRetornoDTO
│   ├── DepositoDTO
│   ├── EmpresaDTO
│   ├── TransactionDTO
│   ├── UsuarioCriacaoDTO
│   └── UsuarioRetornoDTO
│
├── entity
│   ├── Cliente
│   ├── Empresa
│   ├── Produto
│   ├── Transaction
│   └── Usuario
│
├── enums
│   ├── StatusTransacao
│   └── TipoTransacao
│
├── mapper
│   ├── ClienteMapper
│   ├── EmpresaMapper
│   └── UsuarioMapper
│
├── repository
│   ├── ClienteRepository
│   ├── EmpresaRepository
│   ├── ProdutoRepository
│   ├── TransactionRepository
│   └── UsuarioRepository
│
├── service
│   ├── ClienteService
│   ├── EmpresaService
│   ├── ProdutoService
│   ├── TransactionService
│   └── UsuarioService
│
└── resources
    ├── application.properties
    └── static

Layered architecture used in the project:

Controller → Service → Repository → Database
                ↓
               DTO
                ↓
              Mapper
API Endpoints
Clients
Method	Endpoint	Description
POST	/clientes/cadCliente Create a new client
GET	/clientes/all List all clients
GET	/clientes/{id}	Get client by ID
GET	/clientes/nome/{name} Find client by name
Create Client
Request Body
{
  "nome": "João Silva",
  "cpf": "12345678900"
}

Users
Method	Endpoint	Description
POST	/usuarios/cadUser Create a new user
GET	/usuarios/all List all users
GET	/usuarios/{id} Get user by ID
GET /usuarios/{nome} Find cliente by name;
Create User
Request Body
{
  "nome": "Maria",
  "login": "maria123",
  "senha": "123456"
}

Transactions
Method	Endpoint	Description
POST	/transactions/deposito	Deposit money into an account
POST	/transactions/transferencia Transfer money between users
Deposit
Request Body
{
  "idUsuario": 1,
  "valor": 100
}

Transfer
Request Body
{
  "emitente_id": 1,
  "remetente_id": 2,
  "valor": 50
}

Running the Project:
Clone the repository
git clone https://github.com/NilthDev7/ledgerflow-api.git
API base URL
http://localhost:8080

Future Improvements
Planned improvements for the project:
Feature	Description
- Global Exception Handler	Centralized error handling
- Spring Security	Authentication and authorization
- JWT Authentication	Secure API access
- Swagger / OpenAPI	Automatic API documentation
- Unit Tests	Service layer tests
- Integration Tests	Endpoint tests
- Docker	Containerized application
- Inventory Management System	Product stock control integrated with financial transactions

The inventory module will allow:
- product registration
- stock quantity control
- stock entry and exit
- integration with financial transactions

Author: Nilth
GitHub: https://github.com/NilthDev7
