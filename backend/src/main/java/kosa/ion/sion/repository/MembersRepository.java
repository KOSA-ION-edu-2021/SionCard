package kosa.ion.sion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kosa.ion.sion.dto.MembersDto;

public interface MembersRepository extends JpaRepository<MembersDto, Long>{
	Optional<MembersDto> findByMemberId(String username);
	Optional<MembersDto> findByPassword(String password);
	Optional<MembersDto> findByNameAndEmail(String name,String email);
	Optional<MembersDto> findByNameAndEmailAndMemberId(String name,String email,String id);
	Boolean existsByMemberId(String MemberId);
	void deleteByMemberId(String MemberId);
	Optional<MembersDto> findByEmailAndPassword(String email, String password);
}
