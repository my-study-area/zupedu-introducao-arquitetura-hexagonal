# farmacia-digital

## Anotações
```bash
# envia requisição POST para /categorias
curl -X POST http://localhost:8080/categorias \
-H "Content-Type: application/json" \
-d '{
    "nome": "Categoria1"
}' -v
```
