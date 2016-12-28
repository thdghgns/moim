package ac.moim.dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.moim.dashboard.entity.Notice;
import ac.moim.dashboard.repository.NoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeRepository noticeRepository;

	public List<Notice> NoticeMainPage() {
		List<Notice> results = null;
		try {
			results = noticeRepository.findAll();
		} catch (Exception ex) {

		}
		return results;
	}

	public Boolean NoticeCreate(Notice notice) {
		noticeRepository.saveAndFlush(notice);
		return true;
	}

}
