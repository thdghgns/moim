package ac.moim.common.service;

import java.util.List;

public interface GmailService {
	public void send(String title, String message, List<String> toMail) throws Exception;
}
