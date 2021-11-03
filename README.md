# Quick Payment - Challenge SAP & CIENCI - FIAP
Aplicação feita para o Challenge SAP & CIENCI pela FIAP.

## Sobre a aplicação
Aplicação que implementa diversas novas funcionalidades para resolver os atuais problemas no processo de pagamento manual ou via VAN.

![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/GabrielFDuarte/poc-sap-fiap)

## Endpoint
A API desenvolvida provê os seguintes endpoints:


### Pagamento
- Envio de Pagamento: `POST/envioPagamento`

### Comprovante
- Comprovante de Pagamento (Webhook): `POST/webhookDevolucao`

### Consulta
- Consulta Comprovante de Pagamento: `POST/consultaComprovante`

### Extrato
- Extrato de Pagamentos: `POST/extratoPagamentos`


## Detalhes
Exemplos de requisições para os endpoints listados anteriormente:

`POST/envioPagamento`

**Body:**
```json
{
    "cnpjOrigem": "74.099.431/6391-18",
    "cnpjDestino": "15.703.306/4386-90",
    "codBanco": "101",
    "agencia": "1",
    "conta": "70445",
    "empresa": "Innotype",
    "tipoPagamento": "2",
    "dataVencimento": "31/05/2021",
    "moeda": "REA",
    "valor": "5110.4"
}
```
Realiza o envio de um novo pagamento a ser realizado.


`POST/webhookDevolucao`

Webhook de retorno do banco após a realização de um pagamento.


`POST/consultaComprovante`

**Body:**
```json
{
    "idAutenticacao": "11248361276882915492205735513884001859286865258817"
}
```
Consulta um extrato de pagamento realizado através de seu ID.


`POST/extratoPagamentos`

**Body:**
```json
{
    "cnpj": "79.622.428/3034-88",
    "dataInicio": "01/01/21",
    "dataLimite": "31/12/21"
}
```
Realiza uma busca a partir do CNPJ de origem e um intervalo de tempo para identificação de pagamentos realizados.


## Tecnologias
Projeto desenvolvido com as seguintes tecnologias:
- Java 8
- Spring Boot
- Maven
- Thymeleaf
- HTML
- CSS

## Package
A aplicação foi desenvolvida para ser executada a partir de um jar. Para que o jar seja gerado, o seguinte comando pode ser executado na pasta do projeto:
```bash
mvn package
```

## Execução
Para executar a API, o jar pode ser executado normalmente ou com o seguinte comando na pasta do projeto:
```bash
mvn spring-boot:run
```
