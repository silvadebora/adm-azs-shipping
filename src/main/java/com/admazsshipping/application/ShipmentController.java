package com.admazsshipping.application;

import com.admazsshipping.domain.Shipment;
import com.admazsshipping.domain.dto.ShipmentDTO;
import com.admazsshipping.domain.ports.interfaces.CustomerServicePort;
import com.admazsshipping.domain.ports.interfaces.ShipmentServicePort;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {

    private final ShipmentServicePort shipmentServicePort;

    private final CustomerServicePort customerServicePort;


    public ShipmentController(ShipmentServicePort shipmentServicePort, CustomerServicePort customerServicePort) {
        this.shipmentServicePort = shipmentServicePort;
        this.customerServicePort = customerServicePort;
    }

    @PostMapping
    public ResponseEntity<Shipment> insert(@RequestBody ShipmentDTO shipmentData){
        var customer = this.customerServicePort.findById(shipmentData.sender());
        var shipment = this.shipmentServicePort.insert(shipmentData.toEntity(customer));
        return ResponseEntity.ok().body(shipment);
    }

    @GetMapping("/{searchTerm}")
    public ResponseEntity<Page<Shipment>> findShipment(@PathVariable("searchTerm") String searchTerm,
                                                       @RequestParam(required = false) Integer page,
                                                       @RequestParam(required = false) Integer size){
        Page<Shipment> shipments = this.shipmentServicePort.findShipment(searchTerm, page, size);
        return ResponseEntity.ok().body(shipments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shipment> update(@PathVariable("id") String id, @RequestBody ShipmentDTO shipmentData){
        var customer = this.customerServicePort.findById(shipmentData.sender());
        var shipment = this.shipmentServicePort.update(id, shipmentData.toEntity(customer));
        return ResponseEntity.ok().body(shipment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Shipment> delete(@PathVariable("id") String id){
        this.shipmentServicePort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
