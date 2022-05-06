package com.pts.ckhome.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.pts.ckhome.DTO.LoaiMonDTO;
import com.pts.ckhome.Entity.LoaiMon;

public interface LoaiMonService {

	LoaiMon getById(Integer id);

	void deleteAll();

	void deleteById(Integer id);

	long count();

	boolean existsById(Integer id);

	<S extends LoaiMon> S saveAndFlush(S entity);

	Optional<LoaiMon> findById(Integer id);

	List<LoaiMon> findAll(Sort sort);

	Page<LoaiMon> findAll(Pageable pageable);

	List<LoaiMon> findAll();

	<S extends LoaiMon> S save(S entity);

}
