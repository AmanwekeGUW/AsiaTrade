package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Getter
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Getter
    @Column(name = "name")
    private String name;

    public void setName(String name) {
        this.name = name;
    }
    public List<Product> getProductlist() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    public void setId(long id) {
        this.id = id;
    }
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private  List<Product> productList;

}