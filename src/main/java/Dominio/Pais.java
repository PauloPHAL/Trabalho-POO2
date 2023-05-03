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

    public Pais(int idPais, String nome) {
        this.idPais = idPais;
        this.nome = nome;
    }
  
}
