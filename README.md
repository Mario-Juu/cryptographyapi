###  Projeto PicPay Simplificado API
## Descrição
Uma aplicação web com foco em criptografia de dados sensíveis feita em Spring no padrão MVC, o projeto conta com uma estrutura CRUD persistidos em MySql e criptografia por meio da classe BCryptPasswordEncoder do Spring Security. 

## Tecnologias
- Java
- Spring
- Spring Boot
- MySql
- Spring Data
- Jakarta
- Spring Security

## Como usar
1. Abra sua IDE Java de preferência
2. Clone o repositório
   ```sh
   git clone https://github.com/Mario-Juu/picpayapi.git
   ```
3. Altere as configurações do banco de dados para a sua e crie o schema
```sh
spring.datasource.url=jdbc:mysql://
spring.datasource.username=
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
4. Dê run na aplicação
5. Faça as requisições via Postman ou Insomnia.

## Objetivo 
Afim de manter os dados sensíveis criptografados, a aplicação funciona aplicando uma criptografia nos dados userDocument e creditCardToken. Segue abaixo o funcionamento.

O usuário envia uma requisição que seria salva no banco de dados assim (sem criptografia):
| id | userDocument     | creditCardToken | value |
|:---|:-----------------|:----------------|:------|
| 1  | 10 | 100      | 5999  |

Mas com a criptografia ficaria assim:
| id | userDocument     | creditCardToken | value |
|:---|:-----------------|:----------------|:------|
| 1  | $2a$10$3xMk1lAz2cODIBGtxIHnV.ZBZ7JAKLiK7F3VU6WiVza5ylzS6orm6 | $10$QivM.PYJNmyhXmbEy1lTsugCFfMWWxPsrfxduSV5kPjOveScI/HLm        | 5999  |


## Moldes das principais requisições
**POST** CreateUser (http://localhost:8080/user/)
```sh

	{
	"userDocument":"10",
	"creditCardToken":"555",
	"value":10
}
```
**GET** AllUsers (http://localhost:8080/user/)



 
