package reto_2.reto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "chocolates")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chocolate {

    @Id
    private String reference;
    private String category;
    private String description;
    private boolean availability = true;
    private double price;
    private int quantity;
    private String photography;

}
