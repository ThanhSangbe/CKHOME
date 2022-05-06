package com.pts.ckhome.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pts.ckhome.DTO.MonDTO;
import com.pts.ckhome.Entity.Mon;
import com.pts.ckhome.Repository.MonRepository;
import com.pts.ckhome.Service.CloudinaryService;
import com.pts.ckhome.Service.MonService;
@Service
public class MonServiceImpl implements MonService {
		@Autowired
		private MonRepository monRepository;
		@Autowired
		private ModelMapper modelMapper;
		@Autowired
		private CloudinaryService cloudinaryService;
		@Override
		public Mon save(MonDTO entity) {
			if(!entity.getHinhNenFile().isEmpty())
			{
				entity.setHinhNen(this.cloudinaryService.upload(entity.getHinhNenFile()));
			}
			Mon m = this.modelMapper.map(entity, Mon.class);
			return this.monRepository.save(m);
		}

		@Override
		public List<Mon> findAll() {
			return monRepository.findAll();
		}

		@Override
		public Page<Mon> findAll(Pageable pageable) {
			return monRepository.findAll(pageable);
		}

		@Override
		public List<Mon> findAll(Sort sort) {
			return monRepository.findAll(sort);
		}

		@Override
		public Optional<Mon> findById(Long id) {
			return monRepository.findById(id);
		}

		@Override
		public <S extends Mon> S saveAndFlush(S entity) {
			return monRepository.saveAndFlush(entity);
		}

		@Override
		public void deleteById(Long id) {
			monRepository.deleteById(id);
		}

		@Override
		public void delete(Mon entity) {
			monRepository.delete(entity);
		}

		@Override
		public void deleteAll() {
			monRepository.deleteAll();
		}

		@Override
		public MonDTO getById(Long id) {
			MonDTO m = this.modelMapper.map(monRepository.getById(id), MonDTO.class);
			return m;
		}
		
}
