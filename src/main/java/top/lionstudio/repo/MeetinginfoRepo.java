package top.lionstudio.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import top.lionstudio.entity.ZwMeetingInfo;


public interface MeetinginfoRepo  extends JpaRepository<ZwMeetingInfo, Long>{
	public ZwMeetingInfo findById(int id);
	

}
