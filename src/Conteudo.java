public class Conteudo {
    
    private final String titulo;    //Titulo da imagem
    private final String urlImagem;

    public Conteudo(String titulo, String urlImagem) {
        this.titulo = titulo;
        this.urlImagem = urlImagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrlImagem() {
        return urlImagem;
    }
}
