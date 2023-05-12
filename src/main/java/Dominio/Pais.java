package Dominio;

import java.io.Serializable;
import java.util.Objects;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idPais;
        hash = 79 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pais other = (Pais) obj;
        if (this.idPais != other.idPais) {
            return false;
        }
        return Objects.equals(this.nome, other.nome);
    }
    
    
}
