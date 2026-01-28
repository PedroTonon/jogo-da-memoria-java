# Jogo da Memória

Projeto de jogo da memória desenvolvido em Java 8 utilizando JavaFX e pensado para execução direta no BlueJ.

---

## Objetivo
Desenvolver um jogo da memória com interface gráfica utilizando JavaFX, aplicando conceitos de programação orientada a objetos, estruturas de dados e lógica de eventos.

---

## Tecnologias Utilizadas
- Java 8
- JavaFX (incluso no Java 8)
- BlueJ

---

## Aprendizados
- Desenvolvimento de interfaces gráficas utilizando JavaFX.
- Organização de projetos Java em múltiplas classes com responsabilidades bem definidas.
- Uso de estruturas de dados (lista duplamente encadeada) para controle das cartas do jogo.
- Implementação de lógica de jogo baseada em eventos.
- Controle de estado e bloqueio de interações durante animações.
- Estilização de interfaces gráficas utilizando CSS no JavaFX.

---

## Funcionalidades
- Menu inicial com opções de Iniciar e Sair
- Exibição inicial de todas as cartas por alguns segundos
- Animação de virar cartas em 3D
- Verificação automática de pares
- Um par válido é formado por duas cartas com o mesmo naipe e o mesmo valor
- Bloqueio de interação durante animações
- Tela de vitória ao completar todos os pares
- Embaralhamento aleatório das cartas a cada partida

---

## Como Executar o Projeto

### Requisitos
- Java 8
- BlueJ

### Passos para Execução
1. Clone o repositório:
   ```bash
   git clone https://github.com/PedroTonon/jogo-da-memoria-java
   ```

2. Abra o Bluej

3. Em Project -> Open Project, selecione a pasta do projeto

4. Execute a classe Jogo, que contém o método main e inicia a aplicação JavaFX

---

## Estrutura do Projeto
 - Jogo - classe principal responsável pela interface gráfica e navegação do sistema
 - Classes auxiliares (Cartinhas, ListaDuplamenteLigada, No) responsáveis pela representação das cartas, estrutura de dados e controle do tabuleiro
 - estilo.css - arquivo responsável pela estilização da interface gráfica

---

## Status do Projeto
- Finalizado

---

## Autores
- Enzo Marasca Soranz Saragiotto
- João Pedro Pedott Rocha
- Pedro Paulo Martins de Oliveira Tonon
- Vinícius Queiroz e Silva Soares
