# bancodigital

## Anotações
```bash
# inicia container postgres
docker-compose up -d

# acessa o postgres na linha de comando
docker-compose exec db psql -h localhost -U user -d bancodigital

# realiza a consulta no postgres a cada 1 segundo
select * from proposta; \watch 1

# envia uma requisição POST com o corpo vazio para /propostas
curl -X POST http://localhost:8080/propostas \
-H "Content-Type: application/json"  -d '{}' -v
```
