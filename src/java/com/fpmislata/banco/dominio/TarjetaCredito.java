
package com.fpmislata.banco.dominio;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author logongas
 */
public class TarjetaCredito {
    
    private int idTarjetaCredito;
    
    @NotBlank
    @Size(min=19, max=19)
    private String numero;
    
    @NotNull
    @Max(12)
    @Min(1)
    private int mesCaducidad;
    
    
    @NotNull
    @Max(2025)
    @Min(2015)
    private int anyoCaducidad;
    
    @NotBlank
    private String nombreTitular;
    
    @NotNull
    private int cvv;
    
    @NotNull
    private int idCuentaBancaria;
    
    @NotNull
    private TipoTarjeta tipoTarjeta;

    /**
     * @return the idTarjetaCredito
     */
    public int getIdTarjetaCredito() {
        return idTarjetaCredito;
    }

    /**
     * @param idTarjetaCredito the idTarjetaCredito to set
     */
    public void setIdTarjetaCredito(int idTarjetaCredito) {
        this.idTarjetaCredito = idTarjetaCredito;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the mesCaducidad
     */
    public int getMesCaducidad() {
        return mesCaducidad;
    }

    /**
     * @param mesCaducidad the mesCaducidad to set
     */
    public void setMesCaducidad(int mesCaducidad) {
        this.mesCaducidad = mesCaducidad;
    }

    /**
     * @return the anyoCaducidad
     */
    public int getAnyoCaducidad() {
        return anyoCaducidad;
    }

    /**
     * @param anyoCaducidad the anyoCaducidad to set
     */
    public void setAnyoCaducidad(int anyoCaducidad) {
        this.anyoCaducidad = anyoCaducidad;
    }

    /**
     * @return the nombreTitular
     */
    public String getNombreTitular() {
        return nombreTitular;
    }

    /**
     * @param nombreTitular the nombreTitular to set
     */
    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    /**
     * @return the cvv
     */
    public int getCvv() {
        return cvv;
    }

    /**
     * @param cvv the cvv to set
     */
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    /**
     * @return the idCuentaBancaria
     */
    public int getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    /**
     * @param idCuentaBancaria the idCuentaBancaria to set
     */
    public void setIdCuentaBancaria(int idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    /**
     * @return the tipoTarjeta
     */
    public TipoTarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }

    /**
     * @param tipoTarjeta the tipoTarjeta to set
     */
    public void setTipoTarjeta(TipoTarjeta tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }
    
}
