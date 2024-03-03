package com.admazsshipping.domain;

import com.admazsshipping.domain.dto.ShipmentDTO;

public class Shipment {

    private String id;
    private String origin;
    private Address destination;
    private String loadDescription;
    private Double weight;
    private Double volume;
    private Double cubage;
    private Customer sender;
    private String receiver;
    private String status;

    public Shipment() {
    }

    public Shipment(String id, String origin, Address destination, String loadDescription, Double weight,
                    Double volume, Double cubage, Customer sender, String receiver, String status) {
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

    public Shipment(ShipmentDTO data){
        this.origin = data.origin();
        this.loadDescription = data.loadDescription();
        this.weight = data.weight();
        this.volume = data.volume();
        this.cubage = data.cubage();
        this.status = data.status();
    }


    public Shipment(String id, String origin, Address destination, Customer sender, String receiver,
                    String status) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.sender = sender;
        this.receiver = receiver;
        this.status = status;
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

    public Address getDestination() {
        return destination;
    }

    public void setDestination(Address destination) {
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

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "id='" + id + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", loadDescription='" + loadDescription + '\'' +
                ", weight=" + weight +
                ", volume=" + volume +
                ", insuredValue=" + cubage +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
