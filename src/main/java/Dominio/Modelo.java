package Dominio;

import java.io.Serializable;
import java.util.Date;
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
    
    @OneToOne (mappedBy = "modelo" )
    @MapsId
    @JoinColumn ( name= "idModelo" )
    private Aeronave aeronave;
    
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name="idFabricante")
    private Fabricante fabricante;

    
    
    
}
