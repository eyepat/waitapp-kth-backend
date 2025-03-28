package se.kth.ki.waitapp.core.model.recipe;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import se.kth.ki.waitapp.core.model.IBaseModel;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Recipe extends PanacheEntity implements IBaseModel {
    private Long id;
    @Column(length = 1024)
    private String URL;
    private String title;
    private String description;
    @Column(length = 1024)
    private String imageURL;
    private Integer cookingTime;
}