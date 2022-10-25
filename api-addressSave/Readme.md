# Projeto Teste Prático

## Inicialização do projeto.

Ao fazer o clone do projeto e abrir no intellij (Ou outro programa de sua preferência), abrir a classe "application.properties" e adicionar as seguintes nformações:

* spring.datasource.url: jdbc:mysql://localhost:3306/{nome-do-database}
* spring.datasource.username:{login-root-mySQL} 
* spring.datasource.password:{senha do mySQL}

Em seguida, abrir a classe "ApiAddressSaveApplication" e clicar em "Run ( Shift + F10) e aguardar sua aplicação iniciar.

Em seguida, ao utilizar o "Postman" poderá realizar as consultas nas APIs.



```java

{
	"info": {
		"_postman_id": "37236183-d888-4b5c-88ad-6d40b93ec3bf",
		"name": "API-CEP",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "Todos Endereços",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/servicos/enderecos",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"servicos",
						"enderecos"
					]
				}
			},
			"response": []
		},
		{
			"name": "buscarCEP",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/servicos/cep/80730360",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"servicos",
						"cep",
						"80730360"
					]
				}
			},
			"response": []
		},
		{
			"name": "BuscarEnderecosPorEmail",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/servicos/enderecos/usuario01@gmail.com",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"servicos",
						"enderecos",
						"usuario01@gmail.com"
					]
				}
			},
			"response": []
		},
		{
			"name": "NovoEndereco RequestBody",
			"request": {
				"method": "POST",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/servicos/endereco",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"servicos",
						"endereco"
					]
				}
			},
			"response": []
		},
		{
			"name": "NovoEndereco CEP Email",
			"request": {
				"method": "POST",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/servicos/cep/80730360/usuario01@gmail.com",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"servicos",
						"cep",
						"80730360",
						"usuario01@gmail.com"
					]
				}
			},
			"response": []
		},
		{
			"name": "DeletarEndereco",
			"request": {
				"method": "DELETE",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/servicos/endereco/17",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"servicos",
						"endereco",
						"17"
					]
				}
			},
			"response": []
		},
		{
			"name": "EditarEndereco",
			"request": {
				"method": "PUT",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n        \r\n        \"cep\": \"Editado\",\r\n        \"logradouro\": \"Editado\",\r\n        \"complemento\": \"Editado\",\r\n        \"bairro\": \"Editado\",\r\n        \"localidade\": \"Editado\",\r\n        \"uf\": \"Editado\",\r\n        \"ibge\": \"Editado\",\r\n        \"gia\": \"Editado\",\r\n        \"ddd\": \"Editado\",\r\n        \"siafi\": \"Editado\",\r\n        \"email\": \"Editado@gmail.com\"\r\n    }",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/servicos/endereco/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"servicos",
						"endereco",
						"1"
					]
				}
			},
			"response": []
		}
	]
}

```