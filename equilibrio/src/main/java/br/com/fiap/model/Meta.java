package br.com.fiap.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "GS_META")
public class Meta extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_META")
    public Long idMeta;

    @Column(name = "DESCRICAO")
    public String descricao;

    @Column(name = "HORAS_META")
    public Integer horasMeta;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    public Usuario usuario;

    public Meta(Long idMeta, String descricao, Integer horasMeta, Usuario usuario) {
        this.idMeta = idMeta;
        this.descricao = descricao;
        this.horasMeta = horasMeta;
        this.usuario = usuario;
    }

    public Meta() {
    }

    public Long getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(Long idMeta) {
        this.idMeta = idMeta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getHorasMeta() {
        return horasMeta;
    }

    public void setHorasMeta(Integer horasMeta) {
        this.horasMeta = horasMeta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
