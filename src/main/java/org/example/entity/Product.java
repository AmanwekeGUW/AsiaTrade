package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Table(name = "product")
@Entity
public class Product {
    @Getter
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Getter
    @Column(name = "name")
    private String name;
    @Getter
    @Column(name = "price")
    private double price;
    @Column(name = "image")
    private String image;

    @ManyToOne( cascade =CascadeType.ALL ,fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;
}