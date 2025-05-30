package utils;

import com.mailosaur.MailosaurClient;
import com.mailosaur.models.Message;
import com.mailosaur.models.SearchCriteria;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailosaurUtil {
    static String apiKey = "GDLoJZxFU7vQCKYwbS6jx0rnaFq0AWNT";
    static String serverId = "r4nngech";
    static String domain = serverId + ".mailosaur.net";
    static MailosaurClient client = new MailosaurClient(apiKey);

    public static String getTestEmail() {
        return "anything@" + domain;
    }

    public static String fetchVerificationLink() throws Exception {
    	MailosaurClient client = new MailosaurClient(apiKey);

        SearchCriteria criteria = new SearchCriteria();
        criteria.withSentTo(getTestEmail());

        Message message = client.messages().get(serverId, criteria);

        // Extract link from email body
        String body = message.html().body();
        String regex = "https://thecloudcard\\.com/appApi/email-verify\\?token=[^\"']+";
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile(regex).matcher(body);
        
        if (matcher.find()) {
            return matcher.group(0);
        } else {
            throw new Exception("Verification link not found in email.");
        }
    }
}
