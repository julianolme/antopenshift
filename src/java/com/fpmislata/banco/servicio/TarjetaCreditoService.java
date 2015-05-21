package com.fpmislata.banco.servicio;

import com.fpmislata.banco.dominio.TarjetaCredito;
import com.fpmislata.banco.persistencia.dao.BussinessException;

public interface TarjetaCreditoService {
    
    public TarjetaCredito insert(TarjetaCredito tarjetaCredito) throws BussinessException;
    
}
