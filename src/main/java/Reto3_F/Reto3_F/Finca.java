/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3_F.Reto3_F;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "farm")
public class Finca implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String address;
    private String exension;
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("farm")
    private Categorias category;

     @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "farm")
    @JsonIgnoreProperties({"farm", "client"})
    private List<Mensajes> messages;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "farm")
    @JsonIgnoreProperties({"farm", "client"})
    private List<Reservas> reservations;
    
 
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getExension() {
        return exension;
    }

    public void setExension(String exension) {
        this.exension = exension;
    }

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Categorias getCategory() {
        return category;
    }

    public void setCategory(Categorias category) {
        this.category = category;
    }

    public List<Mensajes> getMessages() {
        return messages;
    }

    public void setMessages(List<Mensajes> messages) {
        this.messages = messages;
    }

    public List<Reservas> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservas> reservations) {
        this.reservations = reservations;
    }
    
}
