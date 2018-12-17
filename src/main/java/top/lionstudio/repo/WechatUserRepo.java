package top.lionstudio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.lionstudio.entity.ZwWechatUser;

@Repository
public interface WechatUserRepo  extends JpaRepository<ZwWechatUser, Long>{
	
	public ZwWechatUser findByOpenid(String openid);
	

	
//	
//	public List<WechatActivityMember> findByIdActivity(int id);
//	
//	public WechatActivityMember findByIdActivityAndPersonId(int acid,int personId);
//	
//	public List<WechatActivityMember> findByPersonId(int id);
//	
//	@Modifying
//	@Transactional
//	@Query("delete from WechatActivityMember wm where wm.idActivity = ?1")
//	public int deleteByIdActivity(int idActivity);
}
