package sistema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Evento> eventos = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar evento");
            System.out.println("2 - Listar eventos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> cadastrarEvento();
                case 2 -> listarEventos();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private static void cadastrarEvento() {

        System.out.print("Nome do evento: ");
        String nome = scanner.nextLine();

        System.out.println("Categoria:");
        System.out.println("1 - Festa");
        System.out.println("2 - Esportivo");
        System.out.println("3 - Show");
        System.out.println("4 - Outros");
        System.out.print("Escolha: ");

        int cat = Integer.parseInt(scanner.nextLine());

        CategoriaEvento categoria;

        switch (cat) {
            case 1 -> categoria = CategoriaEvento.FESTA;
            case 2 -> categoria = CategoriaEvento.ESPORTIVO;
            case 3 -> categoria = CategoriaEvento.SHOW;
            default -> categoria = CategoriaEvento.OUTROS;
        }

        System.out.print("Data e hora (dd/MM/yyyy HH:mm): ");
        String dataStr = scanner.nextLine();

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dataHora = LocalDateTime.parse(dataStr, fmt);

        Evento evento = new Evento(nome, categoria, dataHora);
        eventos.add(evento);

        System.out.println("✅ Evento cadastrado com sucesso!");
    }

    private static void listarEventos() {

        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
            return;
        }

        System.out.println("\n=== EVENTOS ===");
        for (Evento e : eventos) {
            System.out.println(e);
        }
    }
}