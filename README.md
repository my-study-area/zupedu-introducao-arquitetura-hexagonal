# zupedu-introducao-arquitetura-hexagonal
Treinamento da Zup Edu sobre a Introdução a Arquitetura Hexagonal

## 1. Começando com a Arquitetura Hexagonal
### 1.1 Aprenda a criar um cadastro utilizando a Arquitetura Hexagonal
- Vídeo: [S01] Implementando um cadastro de autores com Arquitetura Hexagonal - Conteúdo Técnico

### Teorias
**1. MVC e Arquitetura em Camadas**

- Vídeo: [S01] MVC e Arquitetura em Camadas - Conteúdo Técnico

Tópicos:

    00:10 - introdução com a visão geral do conteúdo    
    00:45 - arquitetura de código    
    06:00 - revisão dos objetivos da arquitetura de código    
    07:01 - arquitetura MVC    
    11:40 - modelando o MVC no Excalidraw    
    12:50 - organizando os arquivos em camadas no MVC    
    15:35 - outros tipos de design de código, Simon Brown (C4 Model)     
    16:30 - organizando os arquivos utilizando package by layer    
    17:40 - organizando os arquivos utilizando package by feature    
    21:20 - organizando os arquivos utilizando package by component    
    23:10 - visão geral da arquitetura

Objetivos de um padrão de arquitetura:
  1. ter um modelo mental de como padronizar o projeto. Trazer o modelo mental para um modelo digital da computação
  2. facilitar as mudanças de negócios
  3. previnir que mudanças de `"infraestrutura"` (banco de dados, frameworks, meios de comunicação como http e GRPC, libs e etc) afetem/minimizem as mudanças no negócio; evitar mudanças de agentes externos comprometam ao negócio

Ao se falar de arquitetura de software é interessante ter em mente a diferença entre arquitetura e a organização de arquivos de um projeto. Por exemplo, no MVC temos 3 componentes: view, controller e model, sem criar uma relação de pacotes e pastas, mas pensando nas camadas de forma abastrata é possível identificar uma dependência/hierarquia entre os três componetes, onde a `view` depende do `controller` e o `controller` depende do `model`, seguindo uma ordem hierarquica que garante que a `view` não tenha um acesso direto ao `model` e vice-versa . Se liga no fluxo abaixo:

![Imagem com fundo branco exibindo o fluxo de dependência entre a view, controller e model representados com um retângulo, conectados por setas que representam a dependência na sequência de view depende do controller e o controller depende do model](./img/arquitetura-mvc.png)

Ainda pensando na arquitetura MVC é possível organizar os componentes `model`, `view` e `controller` usando pacotes e pastas como o `Package by layer`, `Package by feature` e `Package by component` utilizando a mesma arquitetura, no caso, MVC.


Observe o `Package by layer` com uma representação de fatias horizontais, conforme a imagem abaixo:

![Imagem com fundo branco exibindo a organização de pacotes/pastas utilizando o Package by layer](./img/package-by-layer.png)


Agora o observe o `Package by feature` com uma representação de pasta/pacotes com fatias verticais:

![Imagem com fundo branco exibindo a organização de pacotes/pastas utilizando o Package by feature](./img/package-by-feature.png)

Agora um exemplo do `Package by component`:

![Imagem com fundo branco exibindo a organização de pacotes/pastas utilizando o Package by component](./img/package-by-component.png)

  - Links:    
    - [MVC XEROX PARC 1978-79](https://folk.universitetetioslo.no/trygver/themes/mvc/mvc-index.html)
    - [Package by component and architecturally-aligned testing](http://www.codingthearchitecture.com/2015/03/08/package_by_component_and_architecturally_aligned_testing.html)
    - [c4 Model - Simon Brown](https://c4model.com/)

**2. Introdução sobre Arquitetura Hexagonal**
- Video: Introdução sobre Arquitetura Hexagonal

Tópicos
```
02:50 Motivação 
07:03 Entendendo hexagonal vs portas e adaptadores
16:42 Desenho da arquitetura hexagonal
```

**Motivação:**

Os problemas das lógicas de negócios junto com os códigos de interface do usuário (camada de visualização)
- difícil de ser testada de forma isolada em aplicações que tem a lógica de negócio embutida na camada de visualização
- pela mesma razão é difícil trocar a interface com o usuário, por exemplo, mudando de uma interface web para uma api, smartphone, sistema batch ou até nos casos de troca de protocolos de comunicação como HTTP para GRPC
- pela mesma razão se torna difícil a troca de `"infraestrutura"` da aplicação como a troca de banco de dados, frameworks e bibliotecas

**Conceito de portas e adaptadores**

- as portas são as nossas interfaces, por exemplo, podemos ter uma porta de `notificação` e uma porta de `banco de dados`
- os adaptadores são as classes que implementam as nossas portas; podemos ter diversos adaptadores de uma mesma porta, por exemplo, podemos ter um adaptador para o `postgres`, outro para o `mysql` e outro para um `mock` e todos implementam a porta `banco de dados`

Podemos utilizar os diversos tipos de organização de pacotes na implementação da Arquitetura Hexagonal.

Links:
- [Hexagonal architecture](https://alistair.cockburn.us/hexagonal-architecture/)

**3. Criando um projeto Java seguindo a arquitetura hexagonal**
- Vídeo: Criando um Projeto Java seguindo a Arquitetura Hexagonal - Conteúdo Técnico

### Aprenda a criar um cadastro utilizando a Arquitetura Hexagonal
- Vídeo: Implementando um cadastro de autores com Arquitetura Hexagonal - Conteúdo Técnico
- [Link do código gerado no vídeo](https://github.com/zup-academy/livraria/tree/hexagonal-tc1-lt1/src/main/java/com/zupedu/livraria)

Diagrama de sequência do projeto livraria

![bancodigital](./img/diagrama-sequencia-livraria.png)

**Questionário**

A arquitetura em camadas é uma forma de organização de arquivos em um projeto?

`R:` Sim,  Arquitetura em camadas é uma forma de organização de arquivos em um projeto de software.
Caso você queira continuar aprendendo mais sobre o assunto recomendamos a leitura do artigo: "[Layered Architecture" da Baeldung](https://www.baeldung.com/cs/layered-architecture)".

A arquitetura em camadas define um modelo de dependência entre as camadas. Assim, as camadas mais externas podem depender das camadas internas, mas a camada interna não pode depender da externa

`R:` Sim, caso você queira continuar aprendendo mais sobre o assunto, recomendamos o post "[The Pattern: Ports and Adapters ("Object Structural")](https://alistair.cockburn.us/hexagonal-architecture/)" do Alistair Cockburn

Na Arquitetura Hexagonal, podemos ter apenas 6 portas e 6 adaptadores

`R:` Não, Caso você queira continuar aprendendo mais sobre o assunto recomendamos. Além do post sobre Arquitetura Hexagonal do Cockburn, recomendamos olhar o conceito de DIP do SOLID.


**Recomendações:**

Caso você queira continuar aprendendo mais sobre o assunto recomendamos a leitura do artigo do Alistair Cockburn e revisitar o conceito de DIP do SOLID. Além disso, pensando em linguagens orientadas a objetos, estudar polimorfismo ajuda na compreensão desses tipos arquiteturais.

### Atividades obrigatórias

#### **Implemente o cadastro de interesse para a abertura de uma conta digital**

Implemente o cadastro da nova Proposta para abertura da conta seguindo as restrições a seguir:

Quando uma pessoa tem o interesse em abrir uma conta digital, ela envia uma proposta contendo algumas informações pessoais.
- Baixe ou clone este repositório com o [projeto do banco digital](https://github.com/zup-academy/bancodigital)
- Deve-se informar o nome completo;
- É necessário informar um CPF;
- É preciso infomar um email que esteja em um formato válido
- A pessoa deve que informar um endereço contendo o CEP, o logradouro, número e um complemento, caso exista.
- Para sua API REST:
  - Se o cadastro ocorrer com sucesso, deve-se retornar o status HTTP 201;
  - Se existe algum erro de validação, deve-se retornar o status HTTP 400;

- [Minha resposta](https://gist.github.com/adrianoavelinozup/d53345e1e262324674947847650682fe)
- [Resposta do especialista](https://gist.github.com/yurioliveirazup/30cf9af1417a320e43dab1330dc40123#file-novapropostacontroller-java)

É interessante que você revise os conteúdos vistos durante este programação de formação e caso você queira continuar aprendendo mais sobre o assunto recomendamos a leitura do artigo de arquitetura hexagonal do Cockburn e revisitar os conceitos de SOLID. Principalmente sobre o DIP (Princípio de Inversão de Dependência)

Caso você queira continuar aprendendo mais sobre o assunto recomendamos a revisão do artigo de arquitetura hexagonal do Cockburn e revisitar os conceitos de SOLID. Além disso, olhar os posts do Bob Martin sobre SOLID e sobre arquitetura limpa (Clean Architecture) principalmente na parte que é citado sobre a regra de dependência pode ampliar os seus horizontes.

Diagrama de sequência da abertura de uma conta digital desenvolvida na atividade:

![Diagrama de sequência da abertura de uma conta digital desenvolvida na atividade](./img/cadastrar-abertura-conta-digital.png)

#### **Implementando o cadastro de remédios para uma farmácia digital**
Nessa atividade, vamos construir o cadastro de remédios em uma sistema para uma farmácia. Para isso, siga os passos a seguir:
- Baixe ou clone este [repositório com o projeto da farmácia digital](https://github.com/zup-academy/farmacia-digital/);
- Siga o README do projeto;
- Implemente o cadastro de baseado nas informações a seguir.
- Todo remédio tem um nome obrigatório
- Todo remédio é fabricado por uma farmacêutica;
- Todo remédio pertence a uma categoria (antibiótico, antipirético, analgésicos, entre outros)
- Todo remédio deve conter uma data de fabricação
- Todo remédio precisa ter uma data de validade
- Para sua API REST:
  - Se o cadastro ocorrer com sucesso, deve-se retornar o status HTTP 201;
  - Se existe algum erro de validação, deve-se retornar o status HTTP 400;

A implementação da atividade está disponível em [./farmacia-digital](./farmacia-digital)

Cadastrar categoria de remédio:
![Diagrama de sequência do cadastro de categorias dos remédios](./img/cadastrar-categoria-remedio.png)

Cadastrar remédio:
![Diagrama de sequência do cadastro de remédios](./img/cadastrar-remedio.png)

**Respostas**

Crio a classe controller anotada com `@RequestMapping` informando o path e `@RestController`. Adiciono o método cadastrar anotado com `@PostMapping` que recebe os dados da request anotado com `@Valid` e `@RequestBody` e um segundo parâmetro utilizando um `URIComponentBuilder`. No corpo do método, converto os dados de request numa classe de domínio, persisto no banco de dados utilizando um service que utiliza uma implementação de repository port, injetada via construtor, para armazenar as  informações no banco de dados. Retorno um `ReponseEntity` utilizando o método create, passando uma URI gerada utilizando o parâmetro do método, URIComponentBuilder, para gerar uma status 201 com o location.

**Service**

Crio um classe de service anotada com `@Service` e adiciono o método salvar que recebe uma classe de domínio como parâmetro. No corpo do método, utilizo um port de repository injetado via construtor para persistir no banco de dados.

**Adaptador de persistência da aplicação**

Crio uma classe anotada com @Component e que implementa a porta responsável pela persistência dos dados. Implemento os métodos necessários e utilizo um repository do Spring, injetado via construtor, para persistir os dados. 

## Links
- [MVC XEROX PARC 1978-79](https://folk.universitetetioslo.no/trygver/themes/mvc/mvc-index.html)
- [Package by component and architecturally-aligned testing](http://www.codingthearchitecture.com/2015/03/08/package_by_component_and_architecturally_aligned_testing.html)
- [c4 Model - Simon Brown](https://c4model.com/)
- [Excalidraw](https://excalidraw.com/)
- [Hexagonal architecture](https://alistair.cockburn.us/hexagonal-architecture/)
- [Link do código gerado no vídeo Implementando um cadastro de autores com Arquitetura Hexagonal - Conteúdo Técnico](https://github.com/zup-academy/livraria/tree/hexagonal-tc1-lt1/src/main/java/com/zupedu/livraria)
- [Layered Architecture" da Baeldung](https://www.baeldung.com/cs/layered-architecture)
