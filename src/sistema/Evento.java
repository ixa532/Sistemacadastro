package sistema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Evento {

    private String nome;
    private CategoriaEvento categoria;
    private LocalDateTime dataHora;
    private List<Pessoa> participantes;

    public Evento(String nome, CategoriaEvento categoria, LocalDateTime dataHora) {
        this.nome = nome;
        this.categoria = categoria;
        this.dataHora = dataHora;
        this.participantes = new ArrayList<>();
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

    public void adicionarParticipante(Pessoa p) {
        participantes.add(p);
    }

    public void removerParticipante(Pessoa p) {
        participantes.remove(p);
    }

    public List<Pessoa> getParticipantes() {
        return participantes;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return nome + " | " + categoria + " | " + dataHora.format(fmt) + " | Participantes: " + participantes.size();
    }

    public String toFileString() {
        return nome + ";" + categoria + ";" + dataHora;
    }

    public static Evento fromFileString(String linha) {

        String[] partes = linha.split(";");

        String nome = partes[0];
        CategoriaEvento categoria = CategoriaEvento.valueOf(partes[1]);
        LocalDateTime data = LocalDateTime.parse(partes[2]);

        return new Evento(nome, categoria, data);
    }
}