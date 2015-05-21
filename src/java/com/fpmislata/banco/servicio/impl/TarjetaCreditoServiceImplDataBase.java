package com.fpmislata.banco.servicio.impl;

import com.fpmislata.banco.dominio.CuentaBancaria;
import com.fpmislata.banco.dominio.TarjetaCredito;
import com.fpmislata.banco.dominio.TipoTarjeta;
import com.fpmislata.banco.persistencia.dao.BussinessException;
import com.fpmislata.banco.persistencia.dao.CuentaBancariaDAO;
import com.fpmislata.banco.persistencia.dao.TarjetaCreditoDAO;
import com.fpmislata.banco.servicio.TarjetaCreditoService;
import org.springframework.beans.factory.annotation.Autowired;

public class TarjetaCreditoServiceImplDataBase implements TarjetaCreditoService {

    @Autowired
    TarjetaCreditoDAO tarjetaCreditoDAO;
    @Autowired
    CuentaBancariaDAO cuentaBancariaDAO;

    @Override
    public TarjetaCredito insert(TarjetaCredito tarjetaCredito) throws BussinessException {

        TarjetaCredito tarjetaCreditoSalida;
        
        CuentaBancaria cuentaBancaria = cuentaBancariaDAO.get(tarjetaCredito.getIdCuentaBancaria());

        if (tarjetaCredito.getTipoTarjeta() == null) {
            throw new BussinessException("tipoTarjeta", "Es obligatorio indicar el tipo de tarjeta.");
        }

        if (tarjetaCredito.getTipoTarjeta().equals(TipoTarjeta.GOLD) && cuentaBancaria.getSaldoCuentaBancaria() < 100000) {
            throw new BussinessException("minSaldoGOLD", "El saldo minimo de la cuenta asociada a una tarjeta GOLD debe ser de 100.000 euros o superior.");
        }

        if (tarjetaCredito.getTipoTarjeta().equals(TipoTarjeta.CLASSIC) && cuentaBancaria.getSaldoCuentaBancaria() <= 0) {
            throw new BussinessException("minSaldoCLASSIC", "El saldo minimo de la cuenta asociada a una tarjeta CLASSIC debe ser positivo.");
        }

        tarjetaCreditoSalida = tarjetaCreditoDAO.insert(tarjetaCredito);

        return tarjetaCreditoSalida;
    }

}
