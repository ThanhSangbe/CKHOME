package com.pts.ckhome.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pts.ckhome.Entity.LoaiMon;
@Repository
public interface LoaiMonRepository extends JpaRepository<LoaiMon, Integer> {

}
