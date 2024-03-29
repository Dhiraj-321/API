package com.nimai.ucm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.nimai.ucm.entity.NimaiCustomer;
import com.nimai.ucm.entity.Refer;

@Repository
public interface ReferRepository extends JpaRepository<Refer, String> {

	@Query("select re from Refer re where re.userid.userid= (:userId)")
	List<Refer> findReferByUserId(@Param("userId") String userId);

	void existsByEmailAddress(String emailAddress);

	@Query("select re from Refer re where re.referrer_Email_Id= (:emailId)")
	List<Refer> findRegisterUserByReferrerEmail(@Param("emailId")String emailId);
	
	
	@Query("select re from Refer re where re.referrer_Email_Id= (:emailId)")
	List<Refer> findRegisterUserByReferByEmail(@Param("emailId")String emailId);

	@Query(value="SELECT system_config_entity_value from nimai_system_config where system_config_entity='referrer_earnings'", nativeQuery = true )
	String getReferEarningsPercent();
}
