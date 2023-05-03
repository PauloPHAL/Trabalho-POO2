package Dominio;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Fabricante implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idFabricante;
    
    @Column (name="nomeFabricante", length = 250, nullable = false)
    private String nome;
    
    @ManyToOne
    @JoinColumn (name = "idPais")
    private Pais pais;
    
    @Column (updatable = false)
    @Temporal (TemporalType.DATE)
    private Date dataFundacao;
    
    @Lob
    private byte[] logo;
    
    @OneToMany ( mappedBy = "fabricante", fetch = FetchType.LAZY )
    private List<Modelo> modelo = new ArrayList<>();

    public Fabricante(int idFabricante, String nome, Pais pais, Date dataFundacao, byte[] logo) {
        this.idFabricante = idFabricante;
        this.nome = nome;
        this.pais = pais;
        this.dataFundacao = dataFundacao;
        this.logo = logo;
    }

    
    
    
    
    
}
