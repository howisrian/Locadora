package br.com.locadora.locadora.controller.veiculo;
import javax.validation.constraints.NotBlank;
import javax.xml.crypto.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Veiculo {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String modelo;
    @NotBlank
    private String marca;
    @NotBlank
    private String motor;
    @NotBlank
    private Integer lugares;
    @NotBlank
    private String cor;
    @NotBlank
    private boolean disponivel;
    @NotBlank
    private Data ano;
    @NotBlank
    private String placa;
    
    
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getMotor() {
        return motor;
    }
    public void setMotor(String motor) {
        this.motor = motor;
    }
    public Integer getLugares() {
        return lugares;
    }
    public void setLugares(Integer lugares) {
        this.lugares = lugares;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public boolean isDisponivel() {
        return disponivel;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }   
    public Data getAno() {
        return ano;
    }
    public void setAno(Data ano) {
        this.ano = ano;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
