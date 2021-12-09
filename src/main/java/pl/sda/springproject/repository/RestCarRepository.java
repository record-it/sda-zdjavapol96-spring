package pl.sda.springproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import pl.sda.springproject.model.Car;

@RepositoryRestResource(path = "cars", collectionResourceRel = "cars")
public interface RestCarRepository extends PagingAndSortingRepository<Car, Long> {
    @RestResource(path = "production")
    Page<Car> findCarsByProductionYear(@Param("year") int year, Pageable p);
}
