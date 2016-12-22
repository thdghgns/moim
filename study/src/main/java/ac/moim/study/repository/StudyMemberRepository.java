package ac.moim.study.repository;

import ac.moim.study.entity.StudyMember;
import ac.moim.study.entity.StudyMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by SONG_HOHOON on 2016-12-22.
 */
public interface StudyMemberRepository extends JpaRepository<StudyMember, StudyMemberId>, JpaSpecificationExecutor<StudyMember> {
}
