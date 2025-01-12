package com.exemplu.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.exemplu.entity.Masina;

import jakarta.transaction.Transactional;

public interface MasinaSpringDataJpaRepository extends JpaRepository<Masina, Long> {
	
	 List<Masina> findByAnulGreaterThan(int anul);
	 
	 long countByKilometriLessThan(long kilometri);
	 long countByMarca(String marca);

	 Masina findByNr(String nr);
	 
	 @Transactional
	 List<Masina>  deleteByNr(String nr);
	
}
