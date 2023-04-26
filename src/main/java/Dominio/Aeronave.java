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
    
    private List<Locacao> locacao = new ArrayList<>();
    
    private Modelo modelo;

    
    
    
    
}
