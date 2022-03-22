package br.exaltagame.backgame.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BrowserGame {
    @Id // chave primária
    @GeneratedValue(strategy = GenerationType.AUTO) // será gerado automaticamente
    private long id;

    @Column(nullable = false) // Atributo nao pode ser null
    private String nome;

    @Column(nullable = false)
    private String url;

    private String urlvideo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String imagem;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getURL() {
        return this.url;
    }

    public void setURL(String url) {
        this.url = url;
    }

    public String getURLVideo() {
        return this.urlvideo;
    }

    public void setURLVideo(String urlvideo) {
        this.urlvideo = urlvideo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return this.imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}