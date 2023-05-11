package Dominio;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Aeronave implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idAeronave;
    
    @Column (name="numeroSerie", length = 250, nullable = false, updatable = false)
    private String numeroSerie;
    
    @Column (updatable = false)
    @Temporal (TemporalType.DATE)
    private Date dataCompra;
    
    @OneToMany ( mappedBy = "chaveComposta.aeronave", fetch = FetchType.LAZY )
    private List<Locacao> locacao = new ArrayList<>();
    
    @ManyToOne ( fetch = FetchType.EAGER )
    @JoinColumn ( name="idModelo" )
    private Modelo modelo;
    
    //hibernate
    public Aeronave() {
    }

    public Aeronave(String numeroSerie, Date dataCompra, Modelo modelo) {
        this.numeroSerie = numeroSerie;
        this.dataCompra = dataCompra;
        this.modelo = modelo;
    }

    public int getIdAeronave() {
        return idAeronave;
    }

    public void setIdAeronave(int idAeronave) {
        this.idAeronave = idAeronave;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public List<Locacao> getLocacao() {
        return locacao;
    }

    public void setLocacao(List<Locacao> locacao) {
        this.locacao = locacao;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Aeronave:{"+ numeroSerie +'}';
    }

    public Object[] toArray() throws ParseException {
        return new Object[] { this, this.getModelo(),this.getModelo().getFabricante() };
    }
    
   
    
}
