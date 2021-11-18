package kosa.ion.sion.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kosa.ion.sion.dto.MemberUseDto;
import kosa.ion.sion.getter.SumUseGetter;

public interface MemberUseRepository extends JpaRepository<MemberUseDto, Long>{

	List<MemberUseDto> findTop5ByMemberIdOrderByUseDateDesc(String id);

	@Query(value = "SELECT m.memberId as memberId, SUM(m.usePrice) as sumPrice, SUM(m.useDiscount) as sumDiscount"
		                                      + ", SUM(m.useStack) as sumStack, SUM(m.usePoint) as sumPoint, SUM(m.useMileage) as sumMileage "
			+ "from MemberUseDto m "
			+ "where m.memberId = ?1 "
			+ "group by m.memberId ")
	List<SumUseGetter> sumUseByMemberId(String id);
	
	@Query(value = "SELECT m.memberId as memberId, SUM(m.usePrice) as sumPrice, SUM(m.useDiscount) as sumDiscount"
            + ", SUM(m.useStack) as sumStack, SUM(m.usePoint) as sumPoint, SUM(m.useMileage) as sumMileage "
			+ "from MemberUseDto m "
			+ "where m.memberId = ?1 AND m.useDate Between ?2 AND ?3 "
			+ "group by m.memberId ")
	List<SumUseGetter> sumUseByMemberId(String id, LocalDateTime start_date, LocalDateTime end_date);
}
