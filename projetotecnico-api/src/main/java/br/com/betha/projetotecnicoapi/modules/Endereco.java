package br.com.betha.projetotecnicoapi.modules;

import javax.persistence.*;

@Table
@Entity
public class Endereco  {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    private String endereco;

    //bi-directional many-to-one association to Cliente
    @ManyToOne
    private Cliente cliente;

    public Endereco() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}