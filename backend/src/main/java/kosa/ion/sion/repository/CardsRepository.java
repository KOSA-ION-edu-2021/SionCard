package kosa.ion.sion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import kosa.ion.sion.dto.CardsDto;

@RepositoryRestResource(collectionResourceRel = "cardsdto", path="cardsdto")
@CrossOrigin("*")
public interface CardsRepository extends JpaRepository<CardsDto, Long>{
	
}
