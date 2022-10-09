package via.sdj3.ass2.service;

import org.springframework.stereotype.Service;
import via.sdj3.ass2.model.Animal;
import via.sdj3.ass2.model.AnimalDTO;
import via.sdj3.ass2.repository.AnimalRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImp implements AnimalService {

    AnimalRepository animalRepository;

    public AnimalServiceImp(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }
    @Override
    public Animal create(AnimalDTO animal) {
        return animalRepository.createAnimal(animal);
    }

    @Override
    public List<Animal> findAll() {
        return animalRepository.getAllAnimals();
    }

    @Override
    public Optional<Animal> findById(int id) {
        return Optional.of(animalRepository.getAnimalById(id));
    }

    @Override
    public List<Animal> findByDate(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);// new date object with day month year
        return animalRepository.getAnimalsByDate(date);
    }

    @Override
    public List<Animal> findByFarm(String farm) {
        return animalRepository.getAnimalsByFarm(farm);
    }

}
