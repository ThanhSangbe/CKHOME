package com.pts.ckhome.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pts.ckhome.Entity.Mon;
@Repository
public interface MonRepository extends JpaRepository<Mon, Long> {

}
