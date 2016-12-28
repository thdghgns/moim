package ac.moim.dashboard.service;

import java.util.List;

import ac.moim.dashboard.entity.Notice;

public interface NoticeService {
	public List<Notice> NoticeMainPage();
	public Boolean NoticeCreate(Notice notice);
}
