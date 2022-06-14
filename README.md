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

