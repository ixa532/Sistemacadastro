package sistema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evento {

    private String nome;
    private CategoriaEvento categoria;
    private LocalDateTime dataHora;

    public Evento(String nome, CategoriaEvento categoria, LocalDateTime dataHora) {
        this.nome = nome;
        this.categoria = categoria;
        this.dataHora = dataHora;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaEvento getCategoria() {
        return categoria;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public boolean jaAconteceu() {
        return dataHora.isBefore(LocalDateTime.now());
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        String status = jaAconteceu() ? "JÁ ACONTECEU" : "VAI ACONTECER";

        return "Evento: " + nome +
                " | Categoria: " + categoria +
                " | Data: " + dataHora.format(fmt) +
                " | Status: " + status;
    }
}