package Gerencia;

import Dominio.*;

public class GerenciaDeEdicao {
    private Aeronave aeronaveSelecionada;
    private Modelo modeloSelecionado;
    private Fabricante fabricanteSelecionado;
    private Cliente clienteSelecionado;
    private Locacao locacaoSelecionada;
    
    // padrao Singleton
    private static GerenciaDeEdicao gerenciador; 
    private GerenciaDeEdicao(){
        this.aeronaveSelecionada = null;
        this.clienteSelecionado = null;
        this.fabricanteSelecionado = null;
        this.locacaoSelecionada = null;
        this.modeloSelecionado = null;
    }
    public static GerenciaDeEdicao getConexão(){
        if(gerenciador == null){
            gerenciador = new GerenciaDeEdicao();
        }
        return gerenciador;
    }
    //---------------------------------------------------------
    public Aeronave getAeronaveSelecionada() {
        return aeronaveSelecionada;
    }

    public void setAeronaveSelecionada(Aeronave aeronaveSelecionada) {
        this.aeronaveSelecionada = aeronaveSelecionada;
    }

    public Modelo getModeloSelecionado() {
        return modeloSelecionado;
    }

    public void setModeloSelecionado(Modelo modeloSelecionado) {
        this.modeloSelecionado = modeloSelecionado;
    }

    public Fabricante getFabricanteSelecionado() {
        return fabricanteSelecionado;
    }

    public void setFabricanteSelecionado(Fabricante fabricanteSelecionado) {
        this.fabricanteSelecionado = fabricanteSelecionado;
    }

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }

    public Locacao getLocacaoSelecionada() {
        return locacaoSelecionada;
    }

    public void setLocacaoSelecionada(Locacao locacaoSelecionada) {
        this.locacaoSelecionada = locacaoSelecionada;
    }  
}
