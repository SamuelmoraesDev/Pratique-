 import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Evento {
    private String nome;
    private String cidade;
    private String horario;
    private boolean participando;

    public Evento(String nome, String cidade, String horario) {
        this.nome = nome;
        this.cidade = cidade;
        this.horario = horario;
        this.participando = false;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getHorario() {
        return horario;
    }

    public boolean isParticipando() {
        return participando;
    }

    public void participar() {
        this.participando = true;
    }

    public void cancelar() {
        this.participando = false;
    }

    @Override
    public String toString() {
        return nome + " - " + cidade + " - " + horario + (participando ? " [Participando]" : "");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Evento> eventos = new ArrayList<>();

        int opcao;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar evento");
            System.out.println("2 - Listar eventos");
            System.out.println("3 - Participar de evento");
            System.out.println("4 - Cancelar participação");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do evento: ");
                    String nome = sc.nextLine();
                    System.out.print("Cidade: ");
                    String cidade = sc.nextLine();
                    System.out.print("Horário: ");
                    String horario = sc.nextLine();
                    eventos.add(new Evento(nome, cidade, horario));
                    System.out.println("Evento cadastrado!");
                    break;

                case 2:
                    if (eventos.isEmpty()) {
                        System.out.println("Nenhum evento cadastrado.");
                    } else {
                        System.out.println("\n--- Eventos ---");
                        for (int i = 0; i < eventos.size(); i++) {
                            System.out.println((i + 1) + ". " + eventos.get(i));
                        }
                    }
                    break;

                case 3:
                    if (eventos.isEmpty()) {
                        System.out.println("Nenhum evento para participar.");
                    } else {
                        System.out.print("Digite o número do evento: ");
                        int num = sc.nextInt();
                        if (num > 0 && num <= eventos.size()) {
                            eventos.get(num - 1).participar();
                            System.out.println("Você agora está participando do evento!");
                        } else {
                            System.out.println("Evento inválido.");
                        }
                    }
                    break;

                case 4:
                    if (eventos.isEmpty()) {
                        System.out.println("Nenhum evento para cancelar.");
                    } else {
                        System.out.print("Digite o número do evento: ");
                        int num = sc.nextInt();
                        if (num > 0 && num <= eventos.size()) {
                            eventos.get(num - 1).cancelar();
                            System.out.println("Você cancelou a participação.");
                        } else {
                            System.out.println("Evento inválido.");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}
