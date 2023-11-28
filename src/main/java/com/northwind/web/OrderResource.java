package com.northwind.web;

import com.northwind.service.OrderService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/order")
@Tag(name = "order", description = "All the order methods")
public class OrderResource {
    @Inject
    private OrderService orderService;

/*    @GET
    public List<OrderDto> findAll(){
        return this.orderService.findAll();
    }*/


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrders(){
        return Response.ok(this.orderService.findAll()).build();
    }



}
