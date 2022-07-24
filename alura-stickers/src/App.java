import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        //String url = "https://api.mocki.io/v2/549a5d8b";    //url da api
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

        //String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&count=3";
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        String url = "http://localhost:8080/linguagens";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDeLinguagens();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        System.out.println(json);

        List<Conteudo> conteudos = extrator.extraiConteudos(json); 

        GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < 3; i++) {
            Conteudo conteudo = conteudos.get(i);
 
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeDoArquivo = "saida/" + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeDoArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }
}
