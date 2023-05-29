package Dominio;

import Gerencia.FuncoesUteis;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Modelo implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idModelo;
    
    @Column (name="nomeModelo", length = 250, nullable = false)
    private String nome;
    
    @Column (name="tipoModelo", length = 50, nullable = false)
    private String tipo;
    
    @Column
    private int capacidade;
    
    @Column (updatable = false)
    @Temporal (TemporalType.DATE)
    private Date dataModelo;
    
    @Lob
    private byte[] fotoModelo;
    
    @OneToMany ( mappedBy = "modelo", fetch = FetchType.EAGER )
    private List<Aeronave> aeronave;
       
    @ManyToOne ( fetch = FetchType.EAGER )
    @JoinColumn ( name="idFabricante" )
    private Fabricante fabricante;

    //Hibernate
    public Modelo() {
    }
 
    public Modelo(String nome, String tipo, int capacidade, Date dataModelo, byte[] fotoModelo, Fabricante fabricante) {
        this.nome = nome;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.dataModelo = dataModelo;
        this.fotoModelo = fotoModelo;
        this.fabricante = fabricante;
        this.aeronave = new ArrayList<>();
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Date getDataModelo() {
        return dataModelo;
    }

    public void setDataModelo(Date dataModelo) {
        this.dataModelo = dataModelo;
    }

    public byte[] getFotoModelo() {
        return fotoModelo;
    }

    public void setFotoModelo(byte[] fotoModelo) {
        this.fotoModelo = fotoModelo;
    }

    public List<Aeronave> getAeronave() {
        return aeronave;
    }

    public void setAeronave(List<Aeronave> aeronave) {
        this.aeronave = aeronave;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
    
    public String getDataModeloFormatada() throws ParseException{
        return FuncoesUteis.dateToStr(this.getDataModelo());
    }

    @Override
    public String toString() {
        return nome;
    }

    public Object[] toArray() throws ParseException {
        return new Object[] { this,this.getDataModeloFormatada(),this.getFabricante(),this.capacidade };
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idModelo;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.tipo);
        hash = 97 * hash + this.capacidade;
        hash = 97 * hash + Objects.hashCode(this.dataModelo);
        hash = 97 * hash + Arrays.hashCode(this.fotoModelo);
        hash = 97 * hash + Objects.hashCode(this.aeronave);
        hash = 97 * hash + Objects.hashCode(this.fabricante);
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
        final Modelo other = (Modelo) obj;
        if (this.idModelo != other.idModelo) {
            return false;
        }
        if (this.capacidade != other.capacidade) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.dataModelo, other.dataModelo)) {
            return false;
        }
        if (!Arrays.equals(this.fotoModelo, other.fotoModelo)) {
            return false;
        }
        if (!Objects.equals(this.aeronave, other.aeronave)) {
            return false;
        }
        return Objects.equals(this.fabricante, other.fabricante);
    }
    
    
    
}
