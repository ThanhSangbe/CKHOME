package com.pts.ckhome.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.pts.ckhome.DTO.MonDTO;
import com.pts.ckhome.Entity.Mon;

public interface MonService {

	MonDTO getById(Long id);

	void deleteAll();

	void delete(Mon entity);

	void deleteById(Long id);

	<S extends Mon> S saveAndFlush(S entity);

	Optional<Mon> findById(Long id);

	List<Mon> findAll(Sort sort);

	Page<Mon> findAll(Pageable pageable);

	List<Mon> findAll();

	Mon save(MonDTO entity);

}
