package kosa.ion.sion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosa.ion.sion.dto.MemberUseDto;

public interface MemberUseRepository extends JpaRepository<MemberUseDto, Long>{
	
}
