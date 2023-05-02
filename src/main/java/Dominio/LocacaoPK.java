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
    
    
}
