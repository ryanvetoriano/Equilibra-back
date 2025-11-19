package br.com.fiap.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "GS_CATEGORIA")
public class Categoria extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CATEGORIA")
    public Long idCategoria;

    @Column(nullable = false)
    public String nome;

    @Column(nullable = false)
    public String tipo; // TRABALHO, PESSOAL, SAUDE

    public Categoria(Long idCategoria, String nome, String tipo) {
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.tipo = tipo;
    }

    public Categoria() {
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
