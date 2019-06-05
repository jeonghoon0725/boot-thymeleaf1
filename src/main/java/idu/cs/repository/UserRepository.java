package idu.cs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idu.cs.Entity.UserEntity;

@Repository   //이 인터페이스는 repository라고 지정, spring에게 알려줌
public interface UserRepository 
	extends JpaRepository<UserEntity, Long> {
	//findById, save, delete 는 선언없이도 구현 가능
	
	// 아래 메소드들은 선언해야 JPA 규칙에 의해 구현됨
	// find - select , By - where , OrderBy - order by , ASC DESC를 함께 사용
	
	List<UserEntity> findByName(String name);
	// name은 유일키가 아니므로 list로 해줌
	//List<UserEntity> findByNameOrderByIdDESC(String name);
	List<UserEntity> findByCompany(String company);
	UserEntity findByUserId(String userId); //ByUserId == where userid=''
}
