package Dominio;


import Gerencia.FuncoesUteis;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
    
    @OneToMany ( mappedBy = "fabricante", fetch = FetchType.EAGER )
    private List<Modelo> modelo;
    
    //Hibernate
    public Fabricante() {
    }
    
    public Fabricante(String nome, Date dataFundacao, byte[] logo, Pais pais) {
        this.nome = nome;
        this.pais = pais;
        this.dataFundacao = dataFundacao;
        this.logo = logo;
        this.modelo = new ArrayList<>();
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
    
    public String getDataFundacaoFormatada() throws ParseException{
        return FuncoesUteis.dateToStr(this.getDataFundacao());
    }

    @Override
    public String toString() {
        return nome;
    }

    public Object[] toArray() throws ParseException {
        return new Object[] { this, this.getPais()};
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idFabricante;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.pais);
        hash = 97 * hash + Objects.hashCode(this.dataFundacao);
        hash = 97 * hash + Arrays.hashCode(this.logo);
        hash = 97 * hash + Objects.hashCode(this.modelo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fabricante other = (Fabricante) obj;
        if (this.idFabricante != other.idFabricante) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.pais, other.pais)) {
            return false;
        }
        if (!Objects.equals(this.dataFundacao, other.dataFundacao)) {
            return false;
        }
        if (!Arrays.equals(this.logo, other.logo)) {
            return false;
        }
        return Objects.equals(this.modelo, other.modelo);
    }
    
    
    
    
}
