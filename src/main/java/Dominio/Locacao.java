package Dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Locacao implements Serializable{
    @EmbeddedId
    private LocacaoPK chaveComposta;
    
    @Column (updatable = false)
    @Temporal (TemporalType.DATE)
    private Date dataLocacao;
    
    @Temporal (TemporalType.DATE)
    private Date dataLimite;
    
    @Column
    private double valor;
    
    //hibernate
    public Locacao() {
    }

    public Locacao(Cliente cliente, Aeronave aeronave, Date dataLocacao, Date dataLimite, double valor) {
        this.chaveComposta = new LocacaoPK(aeronave,cliente);
        this.dataLocacao = dataLocacao;
        this.dataLimite = dataLimite;
        this.valor = valor;
    }

    public LocacaoPK getChaveComposta() {
        return chaveComposta;
    }

    public void setChaveComposta(LocacaoPK chaveComposta) {
        this.chaveComposta = chaveComposta;
    }

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public Date getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(Date dataLimite) {
        this.dataLimite = dataLimite;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    
    
}
