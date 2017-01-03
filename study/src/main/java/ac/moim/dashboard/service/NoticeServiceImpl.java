package ac.moim.dashboard.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import ac.moim.dashboard.entity.Notice;
import ac.moim.dashboard.repository.NoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeRepository noticeRepository;
	
	public HashMap<String, Object> NoticeMainPage(Integer pageNum) {
		HashMap<String, Object> results = new HashMap<String, Object>();
		Page<Notice> page = null;
		try {
			page = (Page<Notice>) noticeRepository.findAll(new PageRequest(pageNum-1, 10, new Sort(Direction.DESC, "id")));
			results.put("TotalPage", page.getTotalPages());
			results.put("NoticeList", page.getContent());
		} catch (Exception ex) {
			throw ex;
		}
		return results;
	}
	
	public Notice NoticeDetailPage(Integer indexNum){
		Notice result = new Notice();
		try {
			result = noticeRepository.findOne(indexNum);
			result.setHit(result.getHit() + 1);
			NoticeCreateOrUpdate(result);
		} catch (Exception ex) {
			throw ex;
		}
		return result;
	}

	public Boolean NoticeCreateOrUpdate(Notice notice) {
		try{
			noticeRepository.saveAndFlush(notice);
		}catch (Exception ex){
			throw ex;
		}
		return true;
	}

}
