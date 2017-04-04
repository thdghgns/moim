package ac.moim.dashboard.service;

import java.util.HashMap;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import ac.moim.dashboard.entity.Notice;
import ac.moim.dashboard.repository.NoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeRepository noticeRepository;
	
	public HashMap<String, Object> NoticeMainPage(Integer pageNum, String searchText) {
		HashMap<String, Object> results = new HashMap<String, Object>();
		Page<Notice> page = null;
		try {
			Notice notice = new Notice();
			notice.setContent(searchText);
			Specifications<Notice> spec = Specifications.where(NoticeServiceImpl.titleLike(searchText));		
			page = (Page<Notice>) noticeRepository.findAll(spec, new PageRequest(pageNum-1, 10, new Sort(Direction.DESC, "id")));
			results.put("TotalPage", page.getTotalPages());
			results.put("NoticeList", page.getContent());
		} catch (Exception ex) {
			throw ex;
		}
		return results;
	}
	
	public Notice NoticeDetailPage(Integer indexNum) throws Exception{
		Notice notice = new Notice();
		try {
			notice = noticeRepository.findOne(indexNum);
			notice.setHit(notice.getHit() + 1);
			noticeRepository.saveAndFlush(notice);
		} catch (Exception ex) {
			throw ex;
		}
		return notice;
	}

	public Boolean NoticeCreate(Notice notice) throws Exception{
		try{
			noticeRepository.saveAndFlush(notice);
		}catch (Exception ex){
			throw ex;
		}
		return true;
	}
	
	public Boolean NoticeUpdate(Notice notice) throws Exception {
		try{
			if(!notice.getModifyUser().equals(noticeRepository.findOne(notice.getId()).getInputUser())){
				return false;
			}
			notice.setHit(notice.getHit() + 1);
			noticeRepository.saveAndFlush(notice);
		}catch (Exception ex){
			throw ex;
		}
		return true;
	}
	
	public Boolean NoticeDelete(Integer id, String userName){
		try{
			if(!userName.equals(noticeRepository.findOne(id).getInputUser())){
				return false;
			}
			noticeRepository.delete(id);
		}catch (Exception ex){
			throw ex;
		}
		return true;
	}
	
	/* Specification */
	private static Specification<Notice> titleLike(final String keyword){
		return new Specification<Notice>(){
			@Override
            public Predicate toPredicate(Root<Notice> root, 
                    CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(root.<String>get("title"), "%" + keyword + "%");
            } 
		};
	}

}

