package mungsanbackend.daemaAuction.domain.category;

import lombok.Getter;
import mungsanbackend.daemaAuction.domain.category.subCateogory.SubCateogory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "category")
    private List<SubCateogory> cateogories = new ArrayList<>();

}
