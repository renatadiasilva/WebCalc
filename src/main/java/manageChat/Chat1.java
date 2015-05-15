package manageChat;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
 
@ManagedBean
@ViewScoped
public class Chat1 implements Serializable {
 
 	private static final long serialVersionUID = -8938358674314410115L;

 	@EJB
    MessageManagerLocal mm;
 
    private final List<Message> messages;
    private Date lastUpdate;

    private Message message;
 
    public Chat1() {
        messages = Collections.synchronizedList(new LinkedList<Message>());
        lastUpdate = new Date(0);
        message = new Message();
    }
 
    public Date getLastUpdate() {
        return lastUpdate;
    }
 
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
 
    public Message getMessage() {
        return message;
    }
 
    public void setMessage(Message message) {
        this.message = message;
    }
 
    public void sendMessage(ActionEvent evt) {
        mm.sendMessage(message);
    }
 
    public void firstUnreadMessage(ActionEvent evt) {
       RequestContext ctx = RequestContext.getCurrentInstance();
 
       Message m = mm.getFirstAfter(lastUpdate);
       ctx.addCallbackParam("ok", m!=null);
       
       if(m==null)
           return;
 
       lastUpdate = m.getDate();
 
       ctx.addCallbackParam("user", m.getUser());
       ctx.addCallbackParam("date", m.getDate().toString());
       ctx.addCallbackParam("message", m.getMessage());
 
    }

	public List<Message> getMessages() {
		return messages;
	}

}