package ac.moim.dashboard.service;

import java.util.HashMap;

import ac.moim.dashboard.entity.Notice;

public interface NoticeService {
	public HashMap<String, Object> NoticeMainPage(Integer pageNum);
	public Notice NoticeDetailPage(Integer indexNum);
	public Boolean NoticeCreateOrUpdate(Notice notice);
}
