package br.com.betha.projetotecnicoapi.modules;

import javax.persistence.*;

@Entity
public class Telefone {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    private String telefone;

    //bi-directional many-to-one association to Cliente
    @ManyToOne
    private Cliente cliente;

    public Telefone() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}