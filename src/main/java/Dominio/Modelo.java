package Dominio;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    
    @OneToMany ( mappedBy = "modelo", fetch = FetchType.LAZY )
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

    @Override
    public String toString() {
        return nome;
    }

    public Object[] toArray() throws ParseException {
        return new Object[] { this,this.getFabricante() };
    }
    
    
    
}
