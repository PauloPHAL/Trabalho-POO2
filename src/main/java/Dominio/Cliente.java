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
    private char sexo;
    
    @Column (updatable = false)
    @Temporal (TemporalType.DATE)
    private Date dataNascimento;
    
    @Lob
    private byte[] fotoCliente;
    
    @OneToMany ( mappedBy = "chaveComposta.cliente", fetch = FetchType.LAZY )
    private List<Locacao> locacao;
    
    //hibernate
    public Cliente() {
    }
    
    public Cliente(String nome, String cpf, String email, String celular, char sexo, Date dataNascimento, byte[] fotoCliente) {
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
        int hash = 7;
        hash = 41 * hash + this.idCliente;
        hash = 41 * hash + Objects.hashCode(this.nome);
        hash = 41 * hash + Objects.hashCode(this.cpf);
        hash = 41 * hash + Objects.hashCode(this.email);
        hash = 41 * hash + Objects.hashCode(this.celular);
        hash = 41 * hash + this.sexo;
        hash = 41 * hash + Objects.hashCode(this.dataNascimento);
        hash = 41 * hash + Arrays.hashCode(this.fotoCliente);
        hash = 41 * hash + Objects.hashCode(this.locacao);
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
        if (this.sexo != other.sexo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.celular, other.celular)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (!Arrays.equals(this.fotoCliente, other.fotoCliente)) {
            return false;
        }
        return Objects.equals(this.locacao, other.locacao);
    }
    
    
   
}
