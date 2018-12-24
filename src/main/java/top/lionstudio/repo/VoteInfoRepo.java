package top.lionstudio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.lionstudio.entity.VoteInfo;

@Repository
public interface VoteInfoRepo  extends JpaRepository<VoteInfo, Long>{
	
	

	
	
}
