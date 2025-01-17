package br.exaltagame.backgame.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "avaliacao")
public class Avaliacao {
    @Id // chave primária
    @GeneratedValue(strategy = GenerationType.AUTO) // será gerado automaticamente
    private long id;

    @Column(nullable = false) // Atributo nao pode ser null
    private long estrelas;

    @Column(nullable = false)
    private long quantidadeLikes;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String texto;

    @Column(nullable = false)
    private String data;

    public Avaliacao() {

    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEstrelas() {
        return this.estrelas;
    }

    public void setEstrelas(long estrelas) {
        this.estrelas = estrelas;
    }

    public long getLikes() {
        return this.quantidadeLikes;
    }

    public void setLikes(long quantidadeLikes) {
        this.quantidadeLikes = quantidadeLikes;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }
}