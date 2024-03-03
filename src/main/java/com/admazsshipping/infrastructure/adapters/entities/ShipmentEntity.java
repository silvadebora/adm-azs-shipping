package com.admazsshipping.infrastructure.adapters.entities;

import com.admazsshipping.domain.Shipment;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "shipments")
public class ShipmentEntity {

    @Id
    private String id;
    private String origin;
    private AddressEntity destination;
    private String loadDescription;
    private Double weight;
    private Double volume;
    private Double cubage;
    private CustomerEntity sender;
    private String receiver;
    @Field("status")
    private ShipmentStatus status;

    public ShipmentEntity() {
    }

    public ShipmentEntity(String id, String origin, AddressEntity destination,
                          String loadDescription, Double weight,
                          Double volume, Double cubage,
                          CustomerEntity sender, String receiver, ShipmentStatus status) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.loadDescription = loadDescription;
        this.weight = weight;
        this.volume = volume;
        this.cubage = cubage;
        this.sender = sender;
        this.receiver = receiver;
        this.status = status;
    }

    public Shipment toShipment(){

        return new Shipment(this.id, this.origin, this.destination.toAddress(), this.loadDescription, this.weight, this.volume,
                this.cubage, this.sender.toCustomer(), this.receiver, this.status.toString());
    }
    public Shipment toShipmentWith(AddressEntity address){
        return new Shipment(this.id, this.origin, address.toAddress(), this.loadDescription, this.weight, this.volume,
                this.cubage, this.sender.toCustomer(), this.receiver, this.status.toString());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public AddressEntity getDestination() {
        return destination;
    }

    public void setDestination(AddressEntity destination) {
        this.destination = destination;
    }

    public String getLoadDescription() {
        return loadDescription;
    }

    public void setLoadDescription(String loadDescription) {
        this.loadDescription = loadDescription;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getCubage() {
        return cubage;
    }

    public void setCubage(Double cubage) {
        this.cubage = cubage;
    }

    public CustomerEntity getSender() {
        return sender;
    }

    public void setSender(CustomerEntity sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public ShipmentStatus getStatus() {
        return status;
    }

    public void setStatus(ShipmentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ShipmentEntity{" +
                "id='" + id + '\'' +
                ", origin='" + origin + '\'' +
                ", destination=" + destination +
                ", loadDescription='" + loadDescription + '\'' +
                ", weight=" + weight +
                ", volume=" + volume +
                ", cubage=" + cubage +
                ", sender=" + sender +
                ", receiver='" + receiver + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
