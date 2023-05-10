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
    
    //hibernate
    public Cliente() {
    }
    
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public byte[] getFotoCliente() {
        return fotoCliente;
    }

    public void setFotoCliente(byte[] fotoCliente) {
        this.fotoCliente = fotoCliente;
    }

    public List<Locacao> getLocacao() {
        return locacao;
    }

    public void setLocacao(List<Locacao> locacao) {
        this.locacao = locacao;
    }

    @Override
    public String toString() {
        return nome;
    }

    
    
   
}
