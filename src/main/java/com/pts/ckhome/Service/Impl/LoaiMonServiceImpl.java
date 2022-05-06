package com.pts.ckhome.Service.Impl;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pts.ckhome.DTO.LoaiMonDTO;
import com.pts.ckhome.Entity.LoaiMon;
import com.pts.ckhome.Repository.LoaiMonRepository;
import com.pts.ckhome.Service.LoaiMonService;
@Service
public class LoaiMonServiceImpl implements LoaiMonService {
	@Autowired 
	private ModelMapper modelMapper;
	@Autowired
	private LoaiMonRepository loaiMonRepository;

	@Override
	public <S extends LoaiMon> S save(S entity) {
		return loaiMonRepository.save(entity);
	}

	@Override
	public List<LoaiMon> findAll() {
		return this.loaiMonRepository.findAll();
	}

	@Override
	public Page<LoaiMon> findAll(Pageable pageable) {
		return loaiMonRepository.findAll(pageable);
	}

	@Override
	public List<LoaiMon> findAll(Sort sort) {
		return loaiMonRepository.findAll(sort);
	}

	@Override
	public Optional<LoaiMon> findById(Integer id) {
		return loaiMonRepository.findById(id);
	}

	@Override
	public <S extends LoaiMon> S saveAndFlush(S entity) {
		return loaiMonRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return loaiMonRepository.existsById(id);
	}

	@Override
	public long count() {
		return loaiMonRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		loaiMonRepository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		loaiMonRepository.deleteAll();
	}

	@Override
	public LoaiMon getById(Integer id) {
		return loaiMonRepository.getById(id);
	}
}
