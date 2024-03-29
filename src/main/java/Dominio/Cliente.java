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
    
    @Column (name="celularCliente", length = 50, nullable = false)
    private String celular;
    
    @Column (length = 1)
    private String sexo;
    
    @Column (updatable = false)
    @Temporal (TemporalType.DATE)
    private Date dataNascimento;
    
    @Lob
    private byte[] fotoCliente;
    
    @OneToMany ( mappedBy = "chaveComposta.cliente", fetch = FetchType.EAGER )
    private List<Locacao> locacao;
    
    //hibernate
    public Cliente() {
    }
    
    public Cliente(String nome, String cpf, String email, String celular, String sexo, Date dataNascimento, byte[] fotoCliente) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.celular = celular;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.fotoCliente = fotoCliente;
        this.locacao = new ArrayList<>();
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
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
    
    public String getDataNascimentoFormatada() throws ParseException{
        return FuncoesUteis.dateToStr(this.getDataNascimento());
    }

    @Override
    public String toString() {
        return nome;
    }

    public Object[] toArray() throws ParseException {
        return new Object[] { this, this.getDataNascimentoFormatada(), this.getSexo(), this.getFotoCliente()};
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.idCliente;
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
        final Cliente other = (Cliente) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        return true;
    }

    
    
   
}
