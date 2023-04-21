package Dominio;

import java.io.Serializable;
import java.util.Date;
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
    
    @ManyToOne
    @JoinColumn (name="idModelo")
    private Modelo modelo;

    public Aeronave(String numeroSerie, Date dataCompra, Modelo modelo) {
        this.numeroSerie = numeroSerie;
        this.dataCompra = dataCompra;
        this.modelo = modelo;
    }
    
    
    
}
