package sistema;

import java.io.*;
import java.util.ArrayList;

public class ArquivoUtil {

    private static final String ARQUIVO = "events.data";

    public static ArrayList<Evento> carregarEventos() {

        ArrayList<Evento> eventos = new ArrayList<>();

        try {

            File file = new File(ARQUIVO);

            if (!file.exists()) {
                return eventos;
            }

            BufferedReader br = new BufferedReader(new FileReader(file));

            String linha;

            while ((linha = br.readLine()) != null) {
                eventos.add(Evento.fromFileString(linha));
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Erro ao carregar eventos.");
        }

        return eventos;
    }

    public static void salvarEventos(ArrayList<Evento> eventos) {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO));

            for (Evento e : eventos) {
                bw.write(e.toFileString());
                bw.newLine();
            }

            bw.close();

        } catch (Exception e) {
            System.out.println("Erro ao salvar eventos.");
        }
    }
}