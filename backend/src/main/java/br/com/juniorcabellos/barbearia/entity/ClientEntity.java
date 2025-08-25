package br.com.juniorcabellos.barbearia.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(schema = "barberia", name = "tb_clients")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public ClientEntity() {
    }

    public ClientEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity ClientEntity = (ClientEntity) o;
        return Objects.equals(name, ClientEntity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}