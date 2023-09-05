# Docker

To Do

## Docker Registry

Tratam-se dos repositórios para armazenamento e compartilhamento de imagens Docker, e o mais popular é o Docker Hub.

https://hub.docker.com/


## Instalação do Docker

Passos para instalação do Docker no ambiente Linux Ubuntu:

- Comando de instalação:

```hcl

sudo apt install docker-ce

```

- Comando para verificar o status da instalação:

```hcl

sudo systemctl status docker

```

## Comandos Básicos do Docker

- Comando para lançar o clássico e acadêmico container **Hello World**: 

Este container será executado baseado na imagem *hello-world*, que apenas imprime as instruções de utilização do Docker e logo em seguida é encerrado:

```hcl

docker contaner run hello-world

```

- Lançando o container Hello World nomeando-o:

```hcl

docker container run --name meucontainer hello-world

```

- Comando para listar apenas os conteiners que estão em execução:

```hcl

docker container ls

```

- Comando para listar todos os conteiners tanto em execução quanto os encerrados:

```hcl

docker container ls -a

```

- Comando para remover um container em execução pelo nome do container ou nome da imagem:

```hcl

docker container rm nomedocontainer

```

- Comando para listar os logs de um container:

```hcl

docker logs nomedocontainer

```

- Comandos para parar e remover um container:

```hcl

docker container stop nomedocontainer

docker container rm nomedocontainer

```

- Comando para remover um container sem a necessidade de pará-los antes:

```hcl

docker container rm -f nomedocontainer

```

- Comando para remover todos os containers em execução de uma só vez via sub comando:

```hcl

docker container rm -f $(docker container ls -a q)

```

### Modo Interativo

Trata-se da execução de um container acessando o seu terminal de forma que seja possível realizar outras operações como em um sistema operacional.

- Lançando um container *Ubuntu* acessando seu terminal via bash:

```hcl

docker container run -it ubuntu /bin/bash

```

Após a execução do container *Ubuntu* no modo interativo, será possível realizar instalações como *apt get update && apt install curl* como sendo um sistema operacional.

- Lançando um container *nginx* 

```hcl

docker container run nginx

```

Após a execução do container *nginx*, o terminal seguirá travado pelo fato de que o nginx é um servidor de execução contínua.

Para evitar o travamento do terminal conforme citado acima, será necessário executar o container em modo *backgound (Deamon)* conforme comnado abaixo:

```hcl

docker container run -d nginx

```

- Comando para operar um container nginx já em execução em modo interativo:

```hcl

docker container exec -it nomedocontainer /bin/bash

```

Após a execução do container nginx em modo interativo, executando o comando **curl localhost/80** será apresentada o *HTML* da página inicial do NGINX.

### Port Bind

Trata-se do recurso que permite associar a porta de um container com a porta da máquina local, permitindo acesso externo ao container.

- Comando para associar a porta 8080 da máquina local com a porta 80 do container NGINX, permitindo acesso via navegador:

```hcl

docker container run -d -p 8080:80 nginx

```

## Docker Compose

Docker Compose permite executar ambientes de aplicativos com vários contêineres com base nas definições definidas em um arquivo YAML.

## Instalação do Docker Compose

Passos para instalação do Docker Compose no ambiente Linux Ubuntu:

- Comando para donwload do executável em **/usr/local/bin/docker-compose**, tornando-o acessível de forma global na máquina local como **docker-compose**:

```hcl

sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose

```

- Comando para definir as permissões para que o **docker-compose** seja executável:

```hcl

sudo chmod +x /usr/local/bin/docker-compose

```

- Comando para verificar se a instalação do **docker-compose** foi bem sucedida:

```hcl

docker-compose --version

```

- Saída (Output) esperada:

```hcl

docker-compose version 1.29.2, build 5becea4c

```

O arquivo Docker Compose abaixo provisiona um container para o servidor Redis e outro para o Redis Insight:

- Comando para criar o arquivo *redis-docker-compose.yml*:

```hcl

touch redis-docker-compose.yml

```

- Configure os componentes conforme abaixo:

```hcl

version: "3.3"
services:
  redis:
    image: redis:6.0.7
    container_name: redis
    restart: always
    volumes:
      - redis_volume_data:/data
    ports:
      - 6379:6379
  redis_insight:
    image: redislabs/redisinsight:latest
    container_name: redis_insight
    restart: always
    ports:
      - 8001:8001
    volumes:
      - redis_insight_volume_data:/db
volumes:
  redis_volume_data:
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
