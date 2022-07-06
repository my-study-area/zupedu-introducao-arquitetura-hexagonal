# farmacia-digital

## Anotações
```bash
# envia requisição POST para /categorias
curl -X POST http://localhost:8080/categorias \
-H "Content-Type: application/json" \
-d '{
    "nome": "Categoria1"
}' -v

curl -X POST http://localhost:8080/remedios \
-H "Content-Type: application/json" \
-d '{
"nome": "Remedio 1",
"farmaceutica": "farmaceutica1",
"dataFabricacao": "2022-07-01",
"dataValidade": "2023-07-01",
"categoriaId": 1}' -v

```
