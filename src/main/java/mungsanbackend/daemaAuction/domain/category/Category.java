package mungsanbackend.daemaAuction.domain.category;

import com.sun.istack.NotNull;
import mungsanbackend.daemaAuction.domain.category.subCateogory.SubCateogory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "category")
    private List<SubCateogory> cateogories = new ArrayList<>();

}
