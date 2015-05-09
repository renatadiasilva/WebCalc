package manageChat;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class MessageManager implements MessageManagerLocal {
 
    private final List<Message> messages =
            Collections.synchronizedList(new LinkedList<Message>());;
 
    @Override
    public void sendMessage(Message msg) {
        messages.add(msg);
        msg.setDate(new Date());
    }
 
    @Override
    public Message getFirstAfter(Date after) {
        if(messages.isEmpty())
            return null;
        if(after == null)
            return messages.get(0);
        for(Message m : messages) {
            if(m.getDate().after(after))
                return m;
        }
        return null;
    }
 
}