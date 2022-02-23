package com.example.week02.relations;

import javax.persistence.*;
import java.util.List;

@NamedEntityGraph(
        name = "customer-entity-graph",
        attributeNodes = {
                @NamedAttributeNode("name"),
                @NamedAttributeNode("addresses"),
        }
)
@NamedEntityGraph(
        name = "customer-entity-graph-with-address-customer",
        attributeNodes = {
                @NamedAttributeNode("name"),
                @NamedAttributeNode(value = "addresses", subgraph = "customer-subgraph"),
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "customer-subgraph",
                        attributeNodes = {
                                @NamedAttributeNode("customer")
                        }
                )
        }
)

@Entity
public class Customer {
    @Id
    private int id;
    private String name;

//    @OneToMany(mappedBy = "customer")
//    private List<Address> addresses;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Address> addresses;

    public Customer() {
    }

    public Customer(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
