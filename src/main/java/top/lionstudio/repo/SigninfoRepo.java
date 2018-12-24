package top.lionstudio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.lionstudio.entity.MeetingSign;

@Repository
public interface SigninfoRepo  extends JpaRepository<MeetingSign, Long>{
			
		public MeetingSign findByOpenid(String openid);
}
