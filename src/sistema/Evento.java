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

    public boolean jaAconteceu() {
        return dataHora.isBefore(LocalDateTime.now());
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Nome: " + nome +
               " | Categoria: " + categoria +
               " | Data: " + dataHora.format(fmt) +
               (jaAconteceu() ? " | STATUS: JÁ ACONTECEU" : " | STATUS: VAI ACONTECER");
    }
}