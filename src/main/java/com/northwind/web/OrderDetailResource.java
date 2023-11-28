package com.northwind.web;

import com.northwind.service.OrderDetailService;
import com.northwind.web.dto.OrderDetailDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/orderdetail")
@Tag(name = "order", description = "All the order detail methods")
public class OrderDetailResource {
    @Inject
    private OrderDetailService orderDetailService;

    @GET
    public List<OrderDetailDto> findAll(){
        return this.orderDetailService.findAll(1L);
    }


}
