package Dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Cliente implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idCliente;
    
    @Column (name="nomeCliente", length = 100, nullable = false)
    private String nome;
    
    @Column (name = "cpfCliente", unique = true, updatable = false, length = 14)
    private String cpf;
    
    @Column (name="emailCliente", length = 50, nullable = false)
    private String email;
    
    @Column
    private int celular;
    
    @Column (length = 1)
    private char sexo;
    
    @Column (updatable = false)
    @Temporal (TemporalType.DATE)
    private Date dataNascimento;
    
    @Lob
    private byte[] fotoCliente;
    
    @OneToMany ( mappedBy = "chaveComposta.cliente", fetch = FetchType.LAZY )
    private List<Locacao> locacao = new ArrayList<>();

    public Cliente(int idCliente, String nome, String cpf, String email, int celular, char sexo, Date dataNascimento, byte[] fotoCliente) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.celular = celular;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.fotoCliente = fotoCliente;
    }
    
   
}
