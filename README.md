# Shopping System

Um sistema de gerenciamento de shopping center com lojas especializadas, desenvolvido em Java.

## 📋 Descrição do Projeto

O **Shopping System** é uma aplicação orientada a objetos em Java que simula o gerenciamento de um shopping center. O sistema permite criar e gerenciar shopping centers, suas lojas (de diferentes tipos), produtos e seus respectivos endereços.

## 🏗️ Estrutura Arquitetural

### Entidades Principais

#### 1. **Data.java**
Classe responsável por representar e validar datas.
- **Atributos**: dia, mês, ano
- **Funcionalidades principais**:
  - Validação de datas (considerando meses com 30/31 dias e anos bissextos)
  - Verificação de ano bissexto
  - Conversão para string formatada (DD/MM/AAAA)

#### 2. **Endereco.java**
Classe que representa endereços completos.
- **Atributos**: rua, cidade, estado, país, CEP, número, complemento
- **Funcionalidades**: getters/setters para todos os atributos e formatação de endereço completo

#### 3. **Produto.java**
Classe que representa produtos disponíveis nas lojas.
- **Atributos**: nome, preço, data de validade
- **Funcionalidades principais**:
  - Validação de data de validade
  - Verificação se o produto está vencido
  - Conversão para string com informações do produto

#### 4. **Loja.java**
Classe base para todas as lojas do shopping.
- **Atributos**: nome, quantidade de funcionários, salário base, endereço, data de fundação, estoque de produtos
- **Funcionalidades principais**:
  - Cálculo de gastos com salário
  - Classificação do tamanho da loja (P/M/G) baseada em número de funcionários
  - Inserção e remoção de produtos
  - Exibição de produtos em estoque

#### 5. **Alimentacao.java** (extends Loja)
Especialização de loja para comércios de alimentos.
- **Atributo adicional**: data do alvará de funcionamento
- Herda todas as funcionalidades da classe Loja

#### 6. **Cosmetico.java** (extends Loja)
Especialização de loja para comércios de cosméticos.
- **Atributo adicional**: taxa de comercialização
- Herda todas as funcionalidades da classe Loja

#### 7. **Vestuario.java** (extends Loja)
Especialização de loja para comércios de vestuário.
- **Atributo adicional**: indicador de produtos importados (boolean)
- Herda todas as funcionalidades da classe Loja

#### 8. **Shopping.java**
Classe que representa o shopping center como um todo.
- **Atributos**: nome, endereço, array de lojas
- **Funcionalidades principais**:
  - Inserção e remoção de lojas
  - Contagem de lojas por tipo
  - Busca da loja de informática com maior seguro de eletrônicos
  - Normalização de acentuação para comparações

#### 9. **Informatica.java** (extends Loja)
Especialização de loja para comércios de informática (mencionada em Shopping).
- Possui atributo de seguro para eletrônicos

## 💻 Funcionalidades do Sistema

### Principal.java - Menu Interativo

O sistema possui um menu principal que permite:

1. **Criar uma Loja**: 
   - Solicita informações da loja (nome, funcionários, salário)
   - Solicita dados do endereço (rua, cidade, estado, país, CEP, número, complemento)
   - Solicita data de fundação (formato DD/MM/AAAA)
   - Cria instância com estoque para 5 produtos

2. **Criar um Produto**:
   - Solicita nome, preço e data de vencimento
   - Permite adicionar produtos ao estoque da loja

3. **Sair**: Encerra a aplicação

## 🧪 Validação - ValidadorEtapa4.java

Arquivo de teste que valida todas as classes e métodos, verificando:
- Existência de classes (Endereco, Data, etc.)
- Presença de getters e setters
- Funcionalidade dos métodos (`toString()`, validações, cálculos)

## 🎯 Conceitos Orientados a Objetos Utilizados

- **Herança**: Lojas especializadas (Alimentacao, Cosmetico, Vestuario) herdam de Loja
- **Encapsulamento**: Atributos privados/protegidos com métodos públicos de acesso
- **Polimorfismo**: Métodos sobrescritos nas subclasses
- **Abstração**: Conceitos de lojas, produtos e endereços modelados como classes

## 🚀 Como Usar

1. Compile todos os arquivos Java
2. Execute a classe Principal
3. Siga as opções do menu para criar lojas e produtos
4. O sistema validará automaticamente datas e informações

## 📦 Stack de Desenvolvimento

- **Linguagem**: Java 100%
- **Paradigma**: Orientado a Objetos
- **Padrões**: Utiliza construtores, getters/setters e validação de dados

## 📝 Observações

- O sistema utiliza `SimpleDateFormat` para parsing de datas
- Implementa validação robusta de datas (incluindo anos bissextos)
- Suporta múltiplos tipos de lojas com características específicas
- Gerencia estoque de produtos com capacidade limitada por loja
