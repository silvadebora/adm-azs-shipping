## :postbox: Sistema de Gestão de Informações de Frete
<p align="center">
     <a alt="Java">
        <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
    </a>
  <a alt="Maven">
    <img src="https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white"/>
  </a>
    <a alt="MongoDB">
        <img src="https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white" />
    </a>
    <a alt="Spring">
        <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" />
    </a>
    <a alt="AWS">
        <img src="https://img.shields.io/badge/Amazon_AWS-232F3E?style=for-the-badge&logo=amazon-aws&logoColor=white">
    </a>
</p>

## Installation

1. Gerar imagem adm-azs-shipping:
```bash
docker build -t adm-azs-shipping .
```
2. Baixar imagem mongodb:
```bash
docker pull mongo
```
3. Rodar docker-compose.yml:
```bash
docker-compose -f docker-compose.yml up
```

## API Edpoints
A API possui os seguintes endpoints:

**API CONSUMER**
```markdown
POST /api/consumers - Cria um novo cliente
GET /api/consumers/{id} - Busca cliente por id
```

**BODY**
```json
{
    "name": "Test",
    "documentNumber": "000000",
    "email": "test@gmail.com",
    "phoneNumber": "99999999",
    "address": {
        "street": "teste",
        "number": "50",
        "city": "teste city",
        "zipCode": "00000"
    }
}
```

**API SHIPMENT**
```markdown
POST /api/shipments - Cria um novo frete

GET /api/shipments/{searchTerm}?page={}&size={} - Retorna as informações do frete de acordo com o parâmetro passado

PUT /api/shipments/{id} - Atualiza informações do frete

DELETE /api/shipments/{id} - Deleta frete
```

**BODY**
```json
{
    "origin": "Cidade Teste",
    "destination": {
        "street": "teste rua",
        "number": "50",
        "city": "teste city",
        "zipCode": "00000"
    },
    "sender": "65e26a03bdfd951779a9574e",
    "receiver": "silvadeborafisio@gmail.com",
    "status": "EM_TRANSITO"
}
```

## Database
O projeto utiliza MongoDB como banco de dados devido a sua flexibilidade e capacidade de lidar com 
diferentes conjuntos de propriedades para cada cliente. Por exemplo, enquanto alguns clientes exigem o 
armazenamento de informações como Cubagem do frete, outros podem não considerar o Peso como uma 
propriedade relevante. O MongoDB permite a adaptação dinâmica do esquema de dados para atender as 
necessidades específicas de cada cliente, proporcionando uma abordagem ágil e eficiente para o 
armazenamento e recuperação de informações
