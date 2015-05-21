package com.fpmislata.banco.dominio;

public class CuentaBancaria {

    int idCuentaBancaria;
    

    String numeroCuentaBancaria;

    
    double saldoCuentaBancaria;
    

    public CuentaBancaria() {
    }
    
    public CuentaBancaria(int idCuentaBancaria, String numeroCuentaBancaria, int idEntidadBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
        this.numeroCuentaBancaria = numeroCuentaBancaria;
    }
    
    public int getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    public void setIdCuentaBancaria(int idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    public String getNumeroCuentaBancaria() {
        return numeroCuentaBancaria;
    }

    public void setNumeroCuentaBancaria(String numeroCuentaBancaria) {
        this.numeroCuentaBancaria = numeroCuentaBancaria;
    }

    public double getSaldoCuentaBancaria() {
        return saldoCuentaBancaria;
    }

    public void setSaldoCuentaBancaria(double saldoCuentaBancaria) {
        this.saldoCuentaBancaria = saldoCuentaBancaria;
    }

}
