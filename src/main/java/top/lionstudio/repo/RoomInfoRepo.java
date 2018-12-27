package top.lionstudio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.lionstudio.entity.RoomInfo;

@Repository
public interface RoomInfoRepo  extends JpaRepository< RoomInfo, Long>{

}
