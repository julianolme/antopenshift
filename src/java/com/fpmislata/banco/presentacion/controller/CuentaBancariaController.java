
package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.dominio.CuentaBancaria;
import com.fpmislata.banco.persistencia.dao.CuentaBancariaDAO;
import com.fpmislata.banco.common.json.JsonTransformer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CuentaBancariaController {

    @Autowired
    CuentaBancariaDAO cuentaBancariaDAO;

    @Autowired
    JsonTransformer jsonTransformer;

    @RequestMapping(value = {"/CuentaBancaria/{idCuentaBancaria}"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idCuentaBancaria") int idCuentaBancaria) throws Exception {
        CuentaBancaria cuentaBancaria = cuentaBancariaDAO.get(idCuentaBancaria);
        String jsonSalida = jsonTransformer.toJson(cuentaBancaria);
        httpServletResponse.getWriter().println(jsonSalida);
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        httpServletResponse.setContentType("application/json; char=UTF-8");

    }

    @RequestMapping(value = {"/CuentaBancaria"}, method = RequestMethod.GET)
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String jsonSalida = jsonTransformer.toJson(cuentaBancariaDAO.findAll());
        httpServletResponse.getWriter().println(jsonSalida);
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        httpServletResponse.setContentType("application/json; char=UTF-8");

    }
}
