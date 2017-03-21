package ac.moim.common.service;

import java.util.List;

public interface GmailService {
	public void send(List<String> toMail, String fromMail, String message, String title, String gmail, String id, String pwd) throws Exception;
}
