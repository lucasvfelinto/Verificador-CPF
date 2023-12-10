# Documentação do Projeto

## Validador de CPF

Este é um simples programa Java que valida números de CPF (Cadastro de Pessoas Físicas) inseridos pelo usuário. O programa permite ao usuário verificar a validade de um CPF e continuar verificando outros CPFs, se desejar.

## Como Utilizar

1. Clone o repositório para o seu ambiente local:

    ```bash
    git clone https://github.com/lucasvfelinto/Verificador-CPF.git
    ```

2. Compile o programa:

    ```bash
    javac Main.java
    ```

3. Execute o programa:

    ```bash
    java Main
    ```

4. Siga as instruções no console para inserir o CPF desejado.

## Funcionamento do Programa

O programa entra em um loop infinito, permitindo que o usuário insira CPFs até que um CPF válido seja fornecido. Após a inserção de um CPF, o programa verifica a validade do mesmo e fornece mensagens de feedback ao usuário.

- Se o CPF inserido tiver menos ou mais de 11 dígitos, o programa informará que o CPF deve ter 11 dígitos.
- Se o CPF consistir em dígitos repetidos, o programa informará que o CPF não pode consistir em dígitos repetidos.
- Se o CPF for válido, o programa informará que o CPF é válido.
- Se o CPF for inválido, o programa informará que o CPF é inválido.

Após a verificação de um CPF, o programa perguntará ao usuário se deseja verificar outro CPF. Se a resposta for afirmativa, o programa reiniciará o processo; caso contrário, o programa será encerrado.

## Funções do Programa

### `checkCPF(String cpf)`

Esta função é responsável por verificar a validade do CPF. Ela utiliza outras funções auxiliares para realizar as verificações necessárias.

### `hasRepeatedDigits(String cpf)`

Verifica se o CPF possui dígitos repetidos.

### `checkSize(String cpf)`

Verifica se o CPF possui 11 dígitos.

### `removeFormat(String cpf)`

Remove qualquer formatação (pontuações) do CPF.

### `cpfFormat(String cpf)`

Formata o CPF no padrão XXX.XXX.XXX-XX.

### `isCPFValid(String cpf)`

Verifica se o CPF é válido, utilizando o cálculo dos dígitos verificadores.

### `calcularDigitoVerificador(String numerosCPF, int multiplicador)`

Calcula o dígito verificador do CPF.

## Contribuições

Contribuições são bem-vindas. Sinta-se à vontade para abrir uma _issue_ para relatar problemas ou sugerir melhorias. Se desejar contribuir diretamente, faça um _fork_ do repositório, faça suas alterações e abra um _pull request_.

## Licença

Este projeto é licenciado sob a [Licença MIT](LICENSE).
