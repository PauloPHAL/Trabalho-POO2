package Dominio;


import java.io.Serializable;
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
    
    @Column (name="nomePais", length = 250, nullable = false)
    private String pais;
    
    @Column (updatable = false)
    @Temporal (TemporalType.DATE)
    private Date dataFundacao;
    
    @Lob
    private byte[] logo;
    
    @OneToMany (mappedBy = "fabricante",fetch = FetchType.LAZY)
    private List<Modelo> modelo;

    public Fabricante(String nome, String pais, Date dataFundacao, byte[] logo, List<Modelo> modelo) {
        this.nome = nome;
        this.pais = pais;
        this.dataFundacao = dataFundacao;
        this.logo = logo;
        this.modelo = modelo;
    }
    
    
    
    
}
