package sistema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    static List<Evento> eventos = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static Pessoa usuario;

    public static void main(String[] args) {

        eventos = ArquivoUtil.carregarEventos();

        cadastrarUsuario();

        int opcao;

        do {

            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar evento");
            System.out.println("2 - Listar eventos");
            System.out.println("3 - Participar de evento");
            System.out.println("4 - Cancelar participação");
            System.out.println("0 - Sair");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {

                case 1 -> cadastrarEvento();
                case 2 -> listarEventos();
                case 3 -> participarEvento();
                case 4 -> cancelarParticipacao();
            }

        } while (opcao != 0);

        ArquivoUtil.salvarEventos(new ArrayList<>(eventos));

        System.out.println("Sistema encerrado.");
    }

    static void cadastrarUsuario() {

        System.out.println("=== Cadastro de usuário ===");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();

        usuario = new Pessoa(nome, email, cidade);
    }

    static void cadastrarEvento() {

        System.out.print("Nome do evento: ");
        String nome = scanner.nextLine();

        System.out.println("1 FESTA");
        System.out.println("2 ESPORTIVO");
        System.out.println("3 SHOW");
        System.out.println("4 CULTURAL");

        int op = Integer.parseInt(scanner.nextLine());

        CategoriaEvento categoria = switch (op) {
            case 1 -> CategoriaEvento.FESTA;
            case 2 -> CategoriaEvento.ESPORTIVO;
            case 3 -> CategoriaEvento.SHOW;
            default -> CategoriaEvento.CULTURAL;
        };

        System.out.print("Data (dd/MM/yyyy HH:mm): ");
        String data = scanner.nextLine();

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDateTime dataHora = LocalDateTime.parse(data, fmt);

        Evento evento = new Evento(nome, categoria, dataHora);

        eventos.add(evento);

        ArquivoUtil.salvarEventos(new ArrayList<>(eventos));

        System.out.println("Evento cadastrado.");
    }

    static void listarEventos() {

        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento.");
            return;
        }

        eventos.sort(Comparator.comparing(Evento::getDataHora));

        int i = 1;

        for (Evento e : eventos) {

            if (e.getDataHora().isBefore(LocalDateTime.now())) {
                System.out.println("(JÁ OCORREU)");
            }

            System.out.println(i + " - " + e);
            i++;
        }
    }

    static void participarEvento() {

        listarEventos();

        System.out.print("Escolha o evento: ");
        int escolha = Integer.parseInt(scanner.nextLine());

        Evento evento = eventos.get(escolha - 1);

        evento.adicionarParticipante(usuario);

        System.out.println("Participação confirmada.");
    }

    static void cancelarParticipacao() {

        listarEventos();

        System.out.print("Escolha o evento: ");
        int escolha = Integer.parseInt(scanner.nextLine());

        Evento evento = eventos.get(escolha - 1);

        evento.removerParticipante(usuario);

        System.out.println("Participação cancelada.");
    }
}