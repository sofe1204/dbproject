package com.example.demo.model.Client;

import com.example.demo.model.User;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;

@Table
@Entity
@Data
public class Client{

    @EmbeddedId
    private ClientCompositeKey clientCompositeKey;

    Integer client_id;

    public Client(ClientCompositeKey clientCompositeKey, Integer client_id) {
        this.clientCompositeKey = clientCompositeKey;
        this.client_id = client_id;
    }

    public Client() {

    }

    public ClientCompositeKey getClientCompositeKey() {
        return clientCompositeKey;
    }

    public void setClientCompositeKey(ClientCompositeKey clientCompositeKey) {
        this.clientCompositeKey = clientCompositeKey;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }
}
