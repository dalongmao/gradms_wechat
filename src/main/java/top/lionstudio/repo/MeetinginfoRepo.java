package top.lionstudio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.lionstudio.entity.MeetingInfo;

@Repository
public interface MeetinginfoRepo  extends JpaRepository<MeetingInfo, Long>{
	
	public MeetingInfo findById(int id);
	
	

}
