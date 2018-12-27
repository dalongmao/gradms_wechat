package top.lionstudio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.lionstudio.entity.RoomApply;

@Repository
public interface RoomApplyRepo  extends JpaRepository< RoomApply, Long>{

}
