package kosa.ion.sion.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import kosa.ion.sion.dto.MemberUseDto;

public interface MemberUseRepository extends JpaRepository<MemberUseDto, Long>{

	List<MemberUseDto> findTop5ByMemberIdOrderByUseDateDesc(String id);
	
}
