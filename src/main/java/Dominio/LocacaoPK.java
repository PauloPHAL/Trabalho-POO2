package Dominio;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class LocacaoPK implements Serializable {
    @ManyToOne ( fetch = FetchType.EAGER )
    @JoinColumn ( name="idAeronave" )
    private Aeronave aeronave;
    
    @ManyToOne ( fetch = FetchType.EAGER )
    @JoinColumn ( name="idCliente" )
    private Cliente cliente;

    public LocacaoPK(Aeronave aeronave, Cliente cliente) {
        this.aeronave = aeronave;
        this.cliente = cliente;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
