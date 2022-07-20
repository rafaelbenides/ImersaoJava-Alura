import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");

        // Fazer uma solicitação HTTP e buscar os dados dos 250 filmes
        String url = "https://api.mocki.io/v2/549a5d8b";    //url da api
        URI endereco = URI.create(url);                     //Cria uri a partir da url

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        //System.out.println(body);

        // Extrair os dados de interesse (nome, poster, nota)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        //System.out.println(listaDeFilmes.size());
        //System.out.println(listaDeFilmes.get(0));

        // Manipular e exibir os dados
        /* for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
        } */

        GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < 3; i++) {
            var filme = listaDeFilmes.get(i);
            String urlImagem = filme.get("image");
            String titulo = filme.get("title");

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeDoArquivo = "saida/" + titulo + ".png";

            geradora.cria(inputStream, nomeDoArquivo);

            System.out.println(filme.get("title"));
            System.out.println();
        }

    }
}
