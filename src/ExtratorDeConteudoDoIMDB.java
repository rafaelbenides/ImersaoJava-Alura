import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoIMDB implements ExtratorDeConteudo {

    public List<Conteudo> extraiConteudos(String json){
        // Extrair os dados de interesse (nome, poster, nota)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        // Populando a lista de conteudos
        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("image");
            //urlImagem = urlImagem.substring(0, urlImagem.indexOf("@") + 1) + ".png";  //Altera url para acessar a imagem de maior resolução. Removendo a parte da url apos o "@"

            var conteudo = new Conteudo(titulo, urlImagem);
            
            conteudos.add(conteudo);
        }

        return conteudos;
    }
}
