package top.lionstudio.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import top.lionstudio.entity.VoteItem;

public interface VoteItemRepo  extends JpaRepository<VoteItem, Long>{

}
