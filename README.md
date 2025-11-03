# ⚡ GEF – Gestão Inteligente de Pátios

O GEF (Gestão Inteligente de Pátios) é uma plataforma moderna para gerenciamento de pátios de motos, criada para substituir processos manuais por uma solução digital integrada, rápida e inteligente.

Sua proposta é facilitar o controle, a movimentação e o rastreamento de motos dentro de pátios, garantindo precisão, produtividade e redução de erros operacionais.

## 🏍️ Sobre o Sistema

O GEF transforma a gestão de pátios com recursos como:

### ✅ Mapeamento em Tempo Real
Localização instantânea e organizada de cada moto.

### ✅ Controle Automatizado de Status
A moto pode estar como: **Em Pátio**, **Em Manutenção**, **Liberada**, **Retirada**, etc. — tudo com atualização centralizada.

### ✅ Relatórios e Métricas
Painéis e dados gerados automaticamente para apoiar decisões operacionais e estratégicas..

### ✅ Integração com QR Codes / IoT
Rastreabilidade completa e segura para cada moto.

## ✨ Benefícios

| Benefício | Impacto |
| :--- | :--- |
| **Eficiência Operacional** | Reduz buscas manuais e organiza o fluxo interno. |
| **Agilidade no Atendimento** | Localização rápida das motos acelera processos. |
| **Redução de Erros** | Registros centralizados e automáticos evitam falhas humanas. |
| **Base de Dados Confiável** | Métricas precisas para tomada de decisões. |

## 📦 Estrutura do Projeto

O projeto segue uma arquitetura limpa e bem organizada, conforme a estrutura de pacotes `com.projectMottu.gef`:

```
com.projectMottu.gef/
├── controller
│   ├── MotoController
│   ├── PatioController
│   └── UsuarioController
│
├── dto
│   ├── MotoRequest
│   ├── MotoResponse
│   ├── PatioRequest
│   ├── PatioResponse
│   ├── UsuarioRequest
│   └── UsuarioResponse
│
├── exception
│   └── ValidationExceptionHandler
│
├── mapper
│   ├── MotoMapper
│   ├── PatioMapper
│   └── UsuarioMapper
│
├── model
│   ├── Cargo
│   ├── Modelo
│   ├── Moto
│   ├── Patio
│   ├── Status
│   └── Usuario
│
├── repository
│   ├── MotoRepository
│   ├── PatioRepository
│   └── UsuarioRepository
│
├── service
│   ├── MotoService
│   ├── PatioService
│   └── UsuarioService
│
└── validation
    ├── AnoValido
    └── AnoValidoValidator
```

## 🚀 Como Executar Localmente

Para iniciar o sistema localmente, siga os passos abaixo:

### 1. Clone o Repositório
```bash
git clone https://github.com/EduNagado/Mottu-Challenge.git
cd Mottu-Challenge
```

### 2. Build do Projeto com Gradle
```bash
./gradlew clean build -x test
```

### 3. Executar a Aplicação
O Dockerfile indica que o artefato final é `app.jar`. Use o seguinte comando para executar:
```bash
java -jar build/libs/app.jar
```

### 4. Swagger Local
A documentação da API (Swagger/OpenAPI) estará disponível em:
```http
http://localhost:8080/swagger-ui/index.html
```

## ☁️ Executando com Docker

Para uma execução rápida e isolada via container, utilize o Docker.

### 1. Build da Imagem Docker
A partir da raiz do projeto, execute o comando para construir a imagem:
```bash
docker build -t gef-mottu .
```

### 2. Rodar o Container
```bash
# O comando mapeia a porta 8080 do container para a porta 8080 da sua máquina
docker run -p 8080:8080 gef-mottu
```

## 📊 Endpoints da API (Swagger)

A documentação completa da API está disponível em: [https://gefmottu-api.azurewebsites.net/swagger-ui/index.html](https://gefmottu-api.azurewebsites.net/swagger-ui/index.html)

Os principais endpoints para a gestão do pátio incluem:

### 🔹 Módulo: Usuário

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/usuarios/{id}` | Retorna um usuário por ID |
| `PUT` | `/usuarios/{id}` | Atualiza um usuário existente |
| `DELETE` | `/usuarios/{id}` | Exclui um usuário por ID |
| `GET` | `/usuarios` | Lista todos os usuários |
| `POST` | `/usuarios` | Cria um novo usuário |

### 🔹 Módulo: Pátio

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/patios/{id}` | Retorna um pátio por ID |
| `PUT` | `/patios/{id}` | Atualiza um pátio existente |
| `DELETE` | `/patios/{id}` | Exclui um pátio |
| `GET` | `/patios` | Lista todos os pátios |
| `POST` | `/patios` | Cria um novo pátio |

### 🔹 Módulo: Moto

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/motos/{id}` | Retorna uma moto por ID |
| `PUT` | `/motos/{id}` | Atualiza uma moto existente |
| `DELETE` | `/motos/{id}` | Remove uma moto |
| `GET` | `/motos` | Lista todas as motos |
| `POST` | `/motos` | Cria uma nova moto |

## 🌟 Funcionalidades Futuras

- [ ] Automação com câmeras para entrada/saída
- [ ] Machine Learning para prever fluxo e reorganizar o pátio
- [ ] App Mobile com scanner QR
- [ ] Notificações automáticas por tempo parado

## 📞 Contato

**Equipe do Projeto:**

| Nome | RM |
| :--- | :--- |
| Eduardo Nagado | RM 558158 |
| Gustavo Lazzuri | RM 556772 |
| Felipe Silva | RM 555307 |

**Repositório do Projeto**: [https://github.com/EduNagado/Mottu-Challenge.git](https://github.com/EduNagado/Mottu-Challenge.git)

---

⚡ **GEF - Transformando a gestão de pátios com inteligência e agilidade.** ⚡
