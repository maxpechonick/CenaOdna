package com.cena.odna.dao.model.entities.category;

import com.cena.odna.dao.model.core.ModelObject;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by Admin on 11.12.2016.
 */

@Entity
@Table(name = "CATEGORY")
public class Category implements ModelObject<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    @SequenceGenerator(name = "category_seq",
            sequenceName = "CATEGORY_SEQ",
            allocationSize = 1
    )
    @Column(name = "CATEGORY_ID")
    private Long id;

    @Column(name = "CATEGORY_NAME")
    private String name;

    @Column(name = "CATEGORY_IMAGE")
    private String image;

    @JoinColumn(name = "PARENT_CATEGORY")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Category.class)
    private Set<Category> childCategories;

    public Set<Category> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(Set<Category> childCategories) {
        this.childCategories = childCategories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
