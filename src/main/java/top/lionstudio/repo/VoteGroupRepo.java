package top.lionstudio.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import top.lionstudio.entity.VoteGroup;

public interface VoteGroupRepo extends JpaRepository<VoteGroup, Long>{
	
	public VoteGroup findById(int id);

}
