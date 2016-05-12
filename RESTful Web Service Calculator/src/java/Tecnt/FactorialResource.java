/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tecnt;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.Path;

/**
 *
 * @author alexis
 */
@Stateless
@Path("/factorial")
public class FactorialResource {

    @GET
    public String factorial(@QueryParam("numero") long base) {

        return Long.toString($factorial(base));
    }

    long $factorial(long base) {
        if (base >= 1) {
            return $factorial(base - 1) * base;
        }
        return 1;
    }
}
