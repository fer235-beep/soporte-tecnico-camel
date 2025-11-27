package com.ferni.consultas_camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TicketRoutes extends RouteBuilder {

    @Override
    public void configure() {

        from("direct:nuevo-ticket")
                .routeId("ruta-nuevo-ticket")
                .log("Se creó un nuevo ticket de soporte: ${body}");

        from("direct:cierre-ticket")
                .routeId("ruta-cierre-ticket")
                .log("Se cerró un ticket de soporte: ${body}");
    }
}
