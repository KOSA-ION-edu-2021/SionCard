package kosa.ion.sion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import kosa.ion.sion.dto.UsersDto;

@RepositoryRestResource(collectionResourceRel = "usersdto", path="usersdto")
@CrossOrigin("*")
public interface UserRepository extends JpaRepository<UsersDto, Long>{
	Optional<UsersDto> findById(String id);
}
