package com.loribusiness.testesEstudo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    @JsonIgnore /* isso aqui é muito importante pra não dar merda quando faz associação
    pois o user e o orders vão ficar se chamando infinitamente criando uma chamada recursiva
    OBS: só é preciso ter esse comando em um laso da associação,, eu poderia ter colocado em order tbm*/
    @OneToMany(mappedBy = "client") //outro lado da associação indica que é vários orders para um client
    private List<Order> orders = new ArrayList<>();

    public User(){}

    public User(Long id, String name, String emanil, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = emanil;
        this.phone = phone;
        this.password = password;
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

    public String getEmanil() {
        return email;
    }

    public void setEmanil(String emanil) {
        this.email = emanil;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders(){
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
