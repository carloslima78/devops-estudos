
# Aplicação Demonstrativa Java e Spring Boot 

Esta aplicação foi desenvolvida com o objetivo de fornecer um ambiente de teste para explorar as práticas DevOps, incluindo o uso de tecnologias como Docker, Kubernetes, entre outras. 

O código fonte está escrito em **Java**, e a aplicação foi projetada para ser facilmente implantada e escalada em ambientes de contêiner.

## Descrição

Trata-se de um exemplo de um controlador REST API com **Spring Boot**, que a princípio expõe informações sobre o host em que a aplicação está sendo executada. Aqui estão alguns pontos-chave:

1. **@RestController** e **@RequestMapping("/hostinfo")**: Essas anotações do Spring Boot indicam que esta classe é um controlador REST e que as solicitações para /hostinfo serão manipuladas por este controlador.

2. **@GetMapping("/")**: Esta anotação mapeia o método get() para lidar com solicitações HTTP GET para o caminho /hostinfo/.

3. **Método get()**: Este método obtém o endereço IP e o nome do host da máquina de execução usando InetAddress. Em caso de exceção (UnknownHostException), uma pilha de rastreamento é impressa.

4. StringBuilder para construir a resposta: O método constrói uma mensagem contendo informações sobre o endereço IP e o nome do host da máquina de execução.

5. Retorno como String: A mensagem construída é retornada como uma String. Geralmente, isso seria convertido automaticamente para JSON quando consumido por um cliente que aceita JSON.

A aplicação retorna informações sobre a máquina de execução da aplicação quando uma solicitação GET é feita para /hostinfo/. Essa funcionalidade pode ser útil em um ambiente DevOps para verificar rapidamente as propriedades da máquina onde a aplicação está sendo executada.

## Pré Requisitos

1. Certifique-se da compatibilidade se seu ambiente, neste cenário trata-se do **Ubuntu 20.04**.

Comando para verificar a versão do Ubuntu:

```hcl
lsb_release -a

No LSB modules are available.
Distributor ID:	Ubuntu
Description:	Ubuntu 22.04.3 LTS
Release:	22.04
Codename:	jammy
```

2. Garanta que o JDK está instalado e é compatível com o projeto que está iniciando, neste cenário trata-se do **Java 17**.

Comando para verificar a versão do Java instalado.

```hcl
java --version

openjdk 17.0.9 2023-10-17
OpenJDK Runtime Environment (build 17.0.9+9-Ubuntu-122.04)
OpenJDK 64-Bit Server VM (build 17.0.9+9-Ubuntu-122.04, mixed mode, sharing)

```


Arquivo **pom.xml** tageando a versão 17 do Java.

![imagem](imagens/pomxml.png)


Configurações de debug da aplicação.

![imagem](imagens/debug-configurations.png)


Estrutura do projeto.

![imagem](imagens/debug-configurations.png)
