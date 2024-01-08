
# Utilizando Redis com Docker e Docker Compose

O Docker Compose abaixo efine dois serviços: "redis" (usando a imagem do Redis) e "redis_insight" (usando a imagem do RedisInsight). 

Ambos os serviços têm volumes associados para persistência de dados e estão configurados para reiniciar automaticamente em caso de falha. 

As portas do host são mapeadas para as portas dos contêineres, permitindo a comunicação externa. 

Os volumes "redis_volume_data" e "redis_insight_volume_data" são definidos separadamente para armazenar dados persistidos pelos respectivos serviços.


```hcl
# Define a versão da especificação do Docker Compose.
version: "3.3"

# Define os serviços disponíveis no ambiente Docker.
services:
  # Configuração do serviço Redis.
  redis:
    # Usa a imagem Redis versão 6.0.7 do Docker Hub.
    image: redis:6.0.7
    # Define o nome do contêiner como "redis".
    container_name: redis
    # Configura o contêiner para reiniciar automaticamente em caso de falha.
    restart: always
    # Cria um volume chamado "redis_volume_data" e o monta no diretório "/data" dentro do contêiner.
    volumes:
      - redis_volume_data:/data
    # Mapeia a porta 6379 do host para a porta 6379 do contêiner.
    ports:
      - 6379:6379

  # Configuração do serviço Redis Insight.
  redis_insight:
    # Usa a imagem mais recente do RedisInsight do Docker Hub.
    image: redislabs/redisinsight:latest
    # Define o nome do contêiner como "redis_insight".
    container_name: redis_insight
    # Configura o contêiner para reiniciar automaticamente em caso de falha.
    restart: always
    # Mapeia a porta 8001 do host para a porta 8001 do contêiner.
    ports:
      - 8001:8001
    # Cria um volume chamado "redis_insight_volume_data" e o monta no diretório "/db" dentro do contêiner.
    volumes:
      - redis_insight_volume_data:/db

# Define os volumes a serem utilizados pelos serviços.
volumes:
  # Define o volume "redis_volume_data".
  redis_volume_data:
  # Define o volume "redis_insight_volume_data".
  redis_insight_volume_data:
```

- O Redis será exposto na porta 6379 e os dados serão armazenados em no volume redis_volume_data.
- O RedisInsight será exposto na porta 8001 e os dados serão armazenados no volume redis_insight_volume_data.

## Iniciando os Recursos

- Comando para inciar os serviços em primeiro plano:

```hcl
docker-compose -f redis-docker-compose.yml up
```

- Comando para inciar os serviços em segundo plano:

```hcl
docker-compose -f redis-docker-compose.yml up -d
```

## Acessando a Interface do RedisInsight

```hcl

curl http://localhost:8001/

```

## Adicionando um Banco de Dados

1. Pressione **ADD REDIS DATABASE**.
2. Dê um nome para o banco de dados.
3. Preencha o endereço IP da máquina o Redis foi instalado, neste caso localhost.
4. Preencha a porta como 6379.

**Referência:** (http://selftuts.in/install-redis-using-docker-compose/)