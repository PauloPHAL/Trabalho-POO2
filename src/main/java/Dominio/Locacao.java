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
    private int valor;

    public Locacao(LocacaoPK chaveComposta, Date dataLocacao, Date dataLimite, int valor) {
        this.chaveComposta = chaveComposta;
        this.dataLocacao = dataLocacao;
        this.dataLimite = dataLimite;
        this.valor = valor;
    }

    
}
