package idu.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idu.cs.Entity.QuestionEntity;

@Repository   //이 인터페이스는 repository라고 지정, spring에게 알려줌
public interface QuestionsRepository 
	extends JpaRepository<QuestionEntity, Long> {
	//findById, save, delete 는 선언없이도 구현 가능
	
	// 아래 메소드들은 선언해야 JPA 규칙에 의해 구현됨
	// find - select , By - where , OrderBy - order by , ASC DESC를 함께 사용
	
	QuestionEntity findByWriter(String writer); //ByUserId == where userid=''
}
