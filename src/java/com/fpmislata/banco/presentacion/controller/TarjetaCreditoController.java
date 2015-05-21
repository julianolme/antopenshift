package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.json.JsonTransformer;
import com.fpmislata.banco.dominio.TarjetaCredito;
import com.fpmislata.banco.persistencia.dao.BussinessException;
import com.fpmislata.banco.servicio.TarjetaCreditoService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TarjetaCreditoController {

    @Autowired
    JsonTransformer jsonTransformer;
    @Autowired
    TarjetaCreditoService tarjetaCreditoService;

    @RequestMapping(value = "/tarjetacredito", method = RequestMethod.POST)
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {

        try {

            TarjetaCredito tarjetaCredito = (TarjetaCredito) jsonTransformer.fromJson(jsonEntrada, TarjetaCredito.class);
            TarjetaCredito tarjetaCreditoSalida = tarjetaCreditoService.insert(tarjetaCredito);

            String jsonSalida = jsonTransformer.toJson(tarjetaCreditoSalida);
            httpServletResponse.getWriter().println(jsonSalida);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; char=UTF-8");

        } catch (BussinessException ex) {
            try {
                
                String jsonSalida = jsonTransformer.toJson(ex.getBussinessMessageList());
                httpServletResponse.getWriter().println(jsonSalida);
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                httpServletResponse.setContentType("application/json; char=UTF-8");
            
            } catch (IOException ex1) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }

        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

    }

}
