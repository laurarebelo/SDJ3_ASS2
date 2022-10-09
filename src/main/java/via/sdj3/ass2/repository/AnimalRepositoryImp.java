package via.sdj3.ass2.repository;

import org.springframework.stereotype.Repository;
import via.sdj3.ass2.model.Animal;
import via.sdj3.ass2.model.AnimalDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AnimalRepositoryImp implements AnimalRepository {

    private static final Map<Integer, Animal> animalMap = new HashMap<>();

    static {
        initDataSource();
    }

    private static void initDataSource() {
        Animal a1 = new Animal("pig", 1, "Vejle", 200.0);
        Animal a2 = new Animal("cow", 2, "Horsens", 500.0);
        Animal a3 = new Animal("chicken", 3, "Aarhus", 20.0);

        animalMap.put(a1.getRegNum(), a1);
        animalMap.put(a2.getRegNum(), a2);
        animalMap.put(a3.getRegNum(), a3);
    }

    @Override
    public Animal createAnimal(AnimalDTO animal) {
        int newKey = animalMap.size() + 1;
        Animal newAnimal = new Animal(animal.getAnimalType(), newKey, animal.getFarm(), animal.getWeight());
        animalMap.put(animalMap.size() + 1, newAnimal);
        return newAnimal;
    }

    @Override
    public Animal getAnimalById(int id) {
        return animalMap.get(id);
    }

    @Override
    public ArrayList<Animal> getAllAnimals() {
        return new ArrayList<>(animalMap.values());
    }

    @Override
    public ArrayList<Animal> getAnimalsByDate(LocalDate date) {
        ArrayList<Animal> allAnimals = new ArrayList<Animal>(animalMap.values());
        ArrayList<Animal> animalsFromThisDate = new ArrayList<>();
        for (Animal animal : allAnimals
        ) {
            if (animal.getDateTime().toLocalDate().equals(date)) {
                animalsFromThisDate.add(animal);
            }
        }
        return animalsFromThisDate;
    }

    @Override
    public ArrayList<Animal> getAnimalsByFarm(String farm) {
        ArrayList<Animal> allAnimals = new ArrayList<Animal>(animalMap.values());
        ArrayList<Animal> animalsFromThisFarm = new ArrayList<>();
        for (Animal animal : allAnimals
        ) {
            if (animal.getFarm().equalsIgnoreCase(farm)) {
                animalsFromThisFarm.add(animal);
            }
        }
        return animalsFromThisFarm;
    }

}
