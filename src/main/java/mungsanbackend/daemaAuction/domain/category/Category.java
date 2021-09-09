package mungsanbackend.daemaAuction.domain.category;

<<<<<<< HEAD
import lombok.Getter;
import mungsanbackend.daemaAuction.domain.category.subCateogory.SubCateogory;
=======
import com.sun.istack.NotNull;
import mungsanbackend.daemaAuction.domain.category.subCategory.SubCategory;
>>>>>>> 92d0fe3a500c62f87728ba28c4ae8f4e3e3804ee

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
    private List<SubCategory> categories = new ArrayList<>();

}
