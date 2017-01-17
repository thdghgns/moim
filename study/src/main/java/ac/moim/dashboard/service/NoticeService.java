package ac.moim.dashboard.service;

import java.util.HashMap;

import ac.moim.dashboard.dto.NoticeDto;
import ac.moim.dashboard.entity.Notice;

public interface NoticeService {
	public HashMap<String, Object> NoticeMainPage(Integer pageNum, String searchText);
	public Notice NoticeDetailPage(Integer indexNum);
	public Boolean NoticeCreate(Notice notice);
	public Boolean NoticeUpdate(Notice notice);
	public Boolean NoticeDelete(Integer id);
}
