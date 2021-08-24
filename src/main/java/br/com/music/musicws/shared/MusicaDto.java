package br.com.music.musicws.shared;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class MusicaDto {

    private String id;
    @NotBlank(message = "Atenção! O nome do titulo da musica deve ser preenchido, por favor corrija")
    private String titulo;
    @NotBlank(message = "Atenção! O genero deve ser preenchido, por favor corrija")
    private String genero;
    @NotBlank(message = "Atenção! O nome do artista deve ser preenchido, por favor corrija")
    private String artista;
    @Positive(message = "Atenção! O ano não pode estar em branco")
    private Integer anolancamento;
    @NotBlank(message = "Atenção! O nome do album deve ser preenchido, por favor corrija")
    private String album;
    @NotBlank(message = "Atenção! O nome do compositor deve ser preenchido, por favor corrija")
    private String compositor;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public Integer getAnolancamento() {
        return anolancamento;
    }
    public void setAnolancamento(Integer anolancamento) {
        this.anolancamento = anolancamento;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public String getCompositor() {
        return compositor;
    }
    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }


    

    
    


    
}
