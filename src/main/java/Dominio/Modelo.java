package Dominio;

import java.io.Serializable;
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
    private List<Aeronave> aeronave = new ArrayList<>();
       
    @ManyToOne ( fetch = FetchType.EAGER )
    @JoinColumn ( name="idFabricante" )
    private Fabricante fabricante;

    
    
    
}
