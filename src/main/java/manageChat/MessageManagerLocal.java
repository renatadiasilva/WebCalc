package manageChat;

import java.util.Date;
import javax.ejb.Local;
 
@Local
public interface MessageManagerLocal {
 
    void sendMessage(Message msg);
 
    Message getFirstAfter(Date after);
 
}