# Jogo da Forca

Implementação simples do Jogo da Forca em Java, o jogo conta com alguns recursos como personalização do nível de dificuldade das palavras, busca de palavras em arquivo externo e ajuste flexível da quantidade de tentativas

## Execução do Jogo fora da IDE

Após realizar o clone do repositório, navegue até a pasta clonada e abra o Git Bash ou qualquer outro terminal instalado em seu sistema. Em seguida, execute o script start.sh. O script inclui um parâmetro opcional, -l, que permite especificar o diretório de instalação do Java. Caso o parâmetro não seja fornecido, o script verificará se o binário do Java está no path do sistema operacional. Se não estiver, será feita uma busca por uma instalação compatível do Java na pasta padrão.

Sem o uso de parâmetros:
```bash
  ./start.sh
```
Com o uso do parâmetro:
```bash
  ./start.sh -l c:/teste/java
```
    
## Melhorias Futuras

1 - Melhorar a lógica de busca de palavras, permitindo escolher o local do arquivo de palavras e persitir essas palavras em um banco.

2 - Aprimorar a configuração implementando uma forma mais robusta de seleção do nível de dificuldade das palavras.

3 - Transferir a estrutura e o design da interface do código Java para arquivos FXML

4 - Adicionar a lib do javaFX ao projeto, para garantir a excecução em diferentes versões do Java.
## Demonstração

<div>
  <img src="https://i.imgur.com/xGCtBiM.png" width="33%;" alt="Tela Inicial"/>
  <img src="https://i.imgur.com/EDbLf20.png" width="33%;" alt="Tela Jogo"/>
  <img src="https://i.imgur.com/izZBzHU.png" width="33%;" alt="Tela Configuração"/>
</div>
