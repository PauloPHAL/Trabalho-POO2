package Dominio;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Pais implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idPais;
    
    @Column (name="nomePais", length = 50, nullable = false)
    private String nome;

    //Hibernate
    public Pais() {
    }
    
    public Pais(String nome) {
        this.nome = nome;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
}
