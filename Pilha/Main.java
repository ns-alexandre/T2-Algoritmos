import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a capacidade máxima da pilha de reimpressão: ");
        int capacidade = Integer.parseInt(sc.nextLine());

        Reimpressora reimpressora = new Reimpressora(capacidade);

        int op;
        do {
            System.out.println("\n1) Solicitar Reimpressão");
            System.out.println("2) Executar Reimpressão");
            System.out.println("3) Consultar Documento");
            System.out.println("4) Mostrar Pilha de Reimpressão");
            System.out.println("0) Sair");
            System.out.print("Escolha: ");

            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    System.out.print("Nome do Arquivo: ");
                    String nome = sc.nextLine();
                    System.out.print("Nome do Usuário: ");
                    String usuario = sc.nextLine();
                    if (reimpressora.solicitarReimpressao(nome, usuario)) {
                        System.out.println("Solicitação de reimpressão adicionada.");
                    } else {
                        System.out.println("Pilha cheia! Não foi possível adicionar.");
                    }
                    break;
                case 2:
                    Documento doc = reimpressora.executarReimpressao();
                    if (doc != null) {
                        long diff = TimeUnit.SECONDS.convert(
                            doc.getHorarioImpressao().getTime() - doc.getHorarioSolicitacao().getTime(),
                            TimeUnit.MILLISECONDS);
                        System.out.println("Documento reimpresso: " + doc);
                        System.out.println("Tempo desde a solicitação: " + formatarDiferenca(diff));
                    } else {
                        System.out.println("Nenhum documento na pilha.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o nome do arquivo: ");
                    String busca = sc.nextLine();
                    System.out.println(reimpressora.consultarDocumento(busca));
                    break;
                case 4:
                    System.out.println(reimpressora.mostrarPilha());
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (op != 0);

        sc.close();
    }

    private static String formatarDiferenca(long segundos) {
        long horas = segundos / 3600;
        long minutos = (segundos % 3600) / 60;
        segundos = segundos % 60;
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }
}
