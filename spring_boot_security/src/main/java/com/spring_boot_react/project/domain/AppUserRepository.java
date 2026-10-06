package com.spring_boot_react.project.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//아래 레포지토리 리소스에 대한 RestAPI 엔드포인트 비활성화
@RepositoryRestResource(exported=false) //Rest에서 특정 리소스를 외부로 노출하지 않도록 구성
public interface AppUserRepository extends CrudRepository<AppUser, Long>{
	Optional<AppUser> findByUsername(String username);
}
