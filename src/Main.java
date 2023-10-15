import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String inCPF;

        // Entra em um loop infinito, permitindo que o usuário insira o CPF até que seja válido
        while (true) {
            System.out.print("Digite o CPF: ");
            inCPF = in.nextLine();

            inCPF = removeFormat(inCPF); // Remove qualquer formatação do CPF

            if (!checkSize(inCPF)) {
                System.out.println("CPF inválido!. O CPF deve conter 11 números.");
            } else {
                break; // Sai do loop se o CPF tiver 11 dígitos e não houver caracteres não numéricos

            }
        }
        if (isCPFValid(inCPF)) {
            System.out.println("O CPF: "+cpfFormat(inCPF)+ " é Válido");
        } else {
            System.out.println("O CPF: "+cpfFormat(inCPF)+ " é Inválido");
        }
    }
    // Verifica se o tamanho do CPF é 11 dígitos
    public static boolean checkSize(String cpf){
        return cpf.length() == 11;
    }
    // Remove qualquer formatação do CPF
    public static String removeFormat(String cpf){
        cpf = cpf.replaceAll("[^0-9]", "");
        return cpf;
    }
    // Formata o CPF no padrão XXX.XXX.XXX-XX
    public static String cpfFormat(String cpf){
        cpf = cpf.replaceAll("^(\\d{3})(\\d{3})(\\d{3})(\\d{2})$", "$1.$2.$3-$4");
        return cpf;
    }
    // Verifica a validade do CPF
    public static boolean isCPFValid(String cpf) {
        // Obtém os primeiros nove dígitos do CPF
        String numerosCPF = cpf.substring(0, 9);

        // Calcula o primeiro dígito verificador
        int primeiroDigito = calcularDigitoVerificador(numerosCPF, 10);

        // Cria uma nova string com o primeiro dígito calculado
        String numerosCPFdigito1 = numerosCPF + primeiroDigito;

        // Remove o primeiro dígito do início da string
        numerosCPFdigito1 = numerosCPFdigito1.substring(1,10);

        // Calcula o segundo dígito verificador
        int segundoDigito = calcularDigitoVerificador(numerosCPFdigito1, 10);

        // Verifica se os dígitos calculados correspondem aos dígitos reais
        return cpf.endsWith(String.valueOf(primeiroDigito) + String.valueOf(segundoDigito));
    }
    // Calcula o dígito verificador
    public static int calcularDigitoVerificador(String numerosCPF, int multiplicador) {
        int total = 0;
        // Itera sobre os dígitos do CPF
        for (int i = 0; i < numerosCPF.length(); i++) {
            // Soma o dígito multiplicado pelo valor do multiplicador
            int digito = Character.getNumericValue(numerosCPF.charAt(i));
            total += digito * multiplicador;
            multiplicador--;
        }
        // Calcula o resto da divisão do total por 11
        int resto = total % 11;
        // Se o resto for menor que 2, o dígito verificador é 0, caso contrário é 11 menos o resto
        return (resto < 2) ? 0 : (11 - resto);
    }
}