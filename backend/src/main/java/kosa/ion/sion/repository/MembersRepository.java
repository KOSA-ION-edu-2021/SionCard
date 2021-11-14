package kosa.ion.sion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kosa.ion.sion.dto.MembersDto;

public interface MembersRepository extends JpaRepository<MembersDto, Long>{
	Optional<MembersDto> findByMemberId(String username);
	Optional<MembersDto> findByPassword(String password);
}
