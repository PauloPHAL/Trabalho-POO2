package Dominio;

import Gerencia.FuncoesUteis;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Aeronave implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idAeronave;
    
    @Column (name="nomeAeronave", length = 250, nullable = false, updatable = false)
    private String nome;
    
    @Column (name="numeroSerie", length = 250, nullable = false, updatable = false)
    private String numeroSerie;
    
    @Column (updatable = false)
    @Temporal (TemporalType.DATE)
    private Date dataCompra;
    
    @OneToMany ( mappedBy = "chaveComposta.aeronave", fetch = FetchType.EAGER )
    private List<Locacao> locacao;
    
    @ManyToOne ( fetch = FetchType.EAGER )
    @JoinColumn ( name="idModelo" )
    private Modelo modelo;
    
    //hibernate
    public Aeronave() {
    }

    public Aeronave(String nome,String numeroSerie, Date dataCompra, Modelo modelo) {
        this.numeroSerie = numeroSerie;
        this.dataCompra = dataCompra;
        this.modelo = modelo;
        this.nome = nome;
        this.locacao = new ArrayList<>();
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDataCompraFormatada() throws ParseException{
        return FuncoesUteis.dateToStr(this.getDataCompra());
    }

    @Override
    public String toString() {
        return  nome;
    }

    public Object[] toArray() throws ParseException {
        return new Object[] { this,this.getNumeroSerie() ,this.getModelo(),this.getModelo().getFabricante(),this.getDataCompraFormatada()};
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.idAeronave;
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.numeroSerie);
        hash = 83 * hash + Objects.hashCode(this.dataCompra);
        hash = 83 * hash + Objects.hashCode(this.locacao);
        hash = 83 * hash + Objects.hashCode(this.modelo);
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
        final Aeronave other = (Aeronave) obj;
        if (this.idAeronave != other.idAeronave) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.numeroSerie, other.numeroSerie)) {
            return false;
        }
        if (!Objects.equals(this.dataCompra, other.dataCompra)) {
            return false;
        }
        if (!Objects.equals(this.locacao, other.locacao)) {
            return false;
        }
        return Objects.equals(this.modelo, other.modelo);
    }
    
   
    
}
