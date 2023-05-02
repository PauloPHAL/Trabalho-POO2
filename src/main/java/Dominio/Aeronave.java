package Dominio;

import java.io.Serializable;
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

    public Aeronave(int idAeronave, String numeroSerie, Date dataCompra, Modelo modelo) {
        this.idAeronave = idAeronave;
        this.numeroSerie = numeroSerie;
        this.dataCompra = dataCompra;
        this.modelo = modelo;
    }

    
    
    
    
}
