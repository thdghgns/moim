package ac.moim.study.repository;

import java.util.List;

import ac.moim.study.entity.Study;
import ac.moim.study.entity.StudyMember;
import ac.moim.study.entity.StudyMemberId;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by SONG_HOHOON on 2016-12-22.
 */
public interface StudyMemberRepository extends JpaRepository<StudyMember, StudyMemberId>, JpaSpecificationExecutor<StudyMember> {
	
	/*@Query(value = "select * from (select * from user) as a where a.id= ?", nativeQuery = true)
	List<StudyMember> findByUserId(String userId, Pageable pageRequest);*/
	
	/*@Query(value = "select * from study where study.id = (select study_member.study_id from study_member where study_member.user_id= ?)", nativeQuery = true)
	List<StudyMember> findByUserId(String userId);*/
	
	@Query(value = "select * from study_member where study_member.user_id= ?", nativeQuery = true)
	List<StudyMember> findByUserId(String userId);
	
	@Query(value = "select * from study_member where study_member.user_id= ? and study_member.classifier=?", nativeQuery = true)
	List<StudyMember> findByUserIdAndClassifier(String userId, String classifier);
}
