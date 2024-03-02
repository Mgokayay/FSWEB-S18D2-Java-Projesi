package com.workintech.s18d2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name="vegetable", schema="fsweb")
public class Vegetable extends Plant{
    @Column(name="is_grown_on_tree")
    private boolean isGrownOnTree;

}
