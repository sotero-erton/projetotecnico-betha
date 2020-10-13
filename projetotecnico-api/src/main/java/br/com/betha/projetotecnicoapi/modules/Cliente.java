package br.com.betha.projetotecnicoapi.modules;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;

import java.util.List;

@Table
@Entity
public class Cliente {

    @Id
    private Integer id;

    private String cpfcnpj;

    private String nome;

    //bi-directional many-to-one association to Endereco
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos;

    //bi-directional many-to-one association to Telefone
    @OneToMany(mappedBy = "cliente")
    private List<Telefone> telefones;

    public Cliente() {
    }

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpfcnpj() {
        return this.cpfcnpj;
    }

    public void setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Endereco> getEnderecos() {
        return this.enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Endereco addEndereco(Endereco endereco) {
        getEnderecos().add(endereco);
        endereco.setCliente(this);

        return endereco;
    }

    public Endereco removeEndereco(Endereco endereco) {
        getEnderecos().remove(endereco);
        endereco.setCliente(null);

        return endereco;
    }

    public List<Telefone> getTelefones() {
        return this.telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Telefone addTelefone(Telefone telefone) {
        getTelefones().add(telefone);
        telefone.setCliente(this);

        return telefone;
    }

    public Telefone removeTelefone(Telefone telefone) {
        getTelefones().remove(telefone);
        telefone.setCliente(null);

        return telefone;
    }

}