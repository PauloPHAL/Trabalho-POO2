package Dominio;


import java.io.Serializable;
import java.text.ParseException;
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
    
    //Hibernate
    public Fabricante() {
    }
    
    public Fabricante(String nome, Date dataFundacao, byte[] logo, Pais pais) {
        this.nome = nome;
        this.pais = pais;
        this.dataFundacao = dataFundacao;
        this.logo = logo;
    }

    public int getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(int idFabricante) {
        this.idFabricante = idFabricante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public List<Modelo> getModelo() {
        return modelo;
    }

    public void setModelo(List<Modelo> modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return nome;
    }

    public Object[] toArray() throws ParseException {
        return new Object[] { this, this.getPais()};
    }
    
    
    
    
}
