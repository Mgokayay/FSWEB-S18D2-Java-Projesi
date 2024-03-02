package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable,Long> {
    @Query(value="SELECT v.id,v.name,v.price,v.is_grown_tree  from fsweb.vegetable as v ORDER BY v.price DESC",nativeQuery = true)
    List<Vegetable> getByPriceDesc();

    @Query(value="SELECT v.id,v.name,v.price,v.vegetable_type from fsweb.vegetable as f ORDER BY v.price ASC",nativeQuery = true)
    List<Vegetable> getByPriceASC();

    @Query("SELECT v FROM Vegetable v where ILIKE %:name%")
    List<Vegetable>  searchByName(String name);
}
