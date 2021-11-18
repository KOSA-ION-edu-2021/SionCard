package kosa.ion.sion.repository;

import kosa.ion.sion.dto.CardsDto;
import kosa.ion.sion.getter.KindOfCardGetter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "cardsdto", path="cardsdto")
@CrossOrigin("*")
public interface CardsRepository extends JpaRepository<CardsDto, Long> {
	void deleteById(Long id);


	@Query(value ="SELECT " +
			"        SUM(CARD_CREDIT) as cntCredit, " +
			"        SUM(CARD_CHECK) as cntCheck " +
			"from " +
			"    Cards "
	,nativeQuery = true)
	List<KindOfCardGetter> kindOfCard();
}
