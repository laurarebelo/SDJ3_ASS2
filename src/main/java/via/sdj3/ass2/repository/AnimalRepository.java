package via.sdj3.ass2.repository;

import org.springframework.stereotype.Repository;
import via.sdj3.ass2.model.Animal;
import via.sdj3.ass2.model.AnimalDTO;

import java.time.LocalDate;
import java.util.ArrayList;

@Repository
public interface AnimalRepository {
    public Animal createAnimal(AnimalDTO animal);
    public Animal getAnimalById(int id);
    public ArrayList<Animal> getAllAnimals();
    public ArrayList<Animal> getAnimalsByDate(LocalDate date);
    public ArrayList<Animal> getAnimalsByFarm(String farm);
}
