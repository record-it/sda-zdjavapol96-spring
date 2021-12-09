package pl.sda.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.sda.springproject.model.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findCarsByProductionYear(int year);
    int countCarsByBrand(String brand);

    @Query(value = "select c from Car c order by c.productionYear",nativeQuery = false)
    List<Car> findAllCarsOrdered();
}
