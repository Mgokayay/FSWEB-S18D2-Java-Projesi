package com.workintech.s18d2.service;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.FruitRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FruitServiceImpl implements FruitService{

    private final FruitRepository fruitRepository;

    @Override
    public Fruit getById(long id) {
        Optional<Fruit> fruitOptional = fruitRepository.findById(id);

        return fruitOptional.orElseThrow(
                ()-> new PlantException("Fruit with given id is not found!", HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Fruit> getByPriceAsc() {

        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> getByPriceDesc() {

        return fruitRepository.getByPriceDesc();
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit delete(long id) {
        Fruit fruit = getById(id);
        fruitRepository.delete(fruit);
        return fruit;
    }

    @Override
    public List<Fruit> searchByName(String name) {

        return fruitRepository.searchByName(name);
    }
}
