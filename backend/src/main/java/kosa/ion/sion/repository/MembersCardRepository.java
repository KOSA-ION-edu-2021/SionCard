package kosa.ion.sion.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import kosa.ion.sion.dto.MembersCardDto;


@RepositoryRestResource(collectionResourceRel = "memberscarddto", path="memberscarddto")
@CrossOrigin("*")
public interface MembersCardRepository extends JpaRepository<MembersCardDto, Long>{

	List<MembersCardDto> findByMemberId(String member_id);
	
}