package ac.moim.dashboard.service;

import java.util.HashMap;

import ac.moim.dashboard.dto.NoticeDto;
import ac.moim.dashboard.entity.Notice;

public interface NoticeService {
	public HashMap<String, Object> NoticeMainPage(Integer pageNum, String searchText);
	public Notice NoticeDetailPage(Integer indexNum) throws Exception;
	public Boolean NoticeCreate(Notice notice) throws Exception;
	public Boolean NoticeUpdate(Notice notice) throws Exception ;
	public Boolean NoticeDelete(Integer id, String userName);
}
