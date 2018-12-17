package top.lionstudio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.lionstudio.entity.ZwMeetingSign;

@Repository
public interface SigninfoRepo  extends JpaRepository<ZwMeetingSign, Long>{
			
		public ZwMeetingSign findByOpenid(String openid);
}
