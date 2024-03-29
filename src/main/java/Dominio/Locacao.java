package Dominio;

import Gerencia.FuncoesUteis;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public String getDataLocacaoFormatada() throws ParseException{
        return FuncoesUteis.dateToStr(this.getDataLocacao());
    }
    
    public String getDataLimiteFormatada() throws ParseException{
        return FuncoesUteis.dateToStr(this.getDataLimite());
    }
    
    @Override
    public String toString(){
        try{
            return this.getDataLocacaoFormatada();
        } catch (ParseException ex) {
            Logger.getLogger(Locacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Object[] toArray() throws ParseException {
        return new Object[] { this, this.getChaveComposta().getCliente(), this.getChaveComposta().getAeronave()};
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.chaveComposta);
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
        final Locacao other = (Locacao) obj;
        if (!Objects.equals(this.chaveComposta, other.chaveComposta)) {
            return false;
        }
        return true;
    }

    
    
}
