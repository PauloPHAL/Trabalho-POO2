package Dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {
    
    private int idCliente;
    private String nome;
    private String cpf;
    private String email;
    private int celular;
    private char sexo;
    private Date dataNascimento;
    private byte[] fotoCliente;
    private List<Locacao> locacao = new ArrayList<>();
    
    
}
