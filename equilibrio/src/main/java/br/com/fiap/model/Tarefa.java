package br.com.fiap.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "GS_TAREFA")
public class Tarefa extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREFA")
    public Long idTarefa;

    @Column(name = "TITULO", nullable = false)
    public String titulo;

    @Lob
    @Column(name = "DESCRICAO")
    public String descricao;

    @Column(name = "DURACAO_MIN", nullable = false)
    public Integer duracaoMin;

    @Column(name = "DATA_TAREFA", nullable = false)
    public LocalDate dataTarefa;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    public Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA", nullable = false)
    public Categoria categoria;

    public Tarefa(Long idTarefa, String titulo, String descricao, Integer duracaoMin, LocalDate dataTarefa, Usuario usuario, Categoria categoria) {
        this.idTarefa = idTarefa;
        this.titulo = titulo;
        this.descricao = descricao;
        this.duracaoMin = duracaoMin;
        this.dataTarefa = dataTarefa;
        this.usuario = usuario;
        this.categoria = categoria;
    }

    public Tarefa() {
    }

    public Long getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(Long idTarefa) {
        this.idTarefa = idTarefa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getDuracaoMin() {
        return duracaoMin;
    }

    public void setDuracaoMin(Integer duracaoMin) {
        this.duracaoMin = duracaoMin;
    }

    public LocalDate getDataTarefa() {
        return dataTarefa;
    }

    public void setDataTarefa(LocalDate dataTarefa) {
        this.dataTarefa = dataTarefa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
