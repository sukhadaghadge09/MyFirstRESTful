package org.sukhada.practice.messenger.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sukhada.practice.messenger.model.Message;
import org.sukhada.practice.messenger.service.MessageService;

@Path("/messages")
/*You can remove from all the method and put it over class
 * @Consumes(MediaType.APPLICATION_JSON)//what it accepts
@Produces(MediaType.APPLICATION_JSON) //Gives output in XML format
*/public class MessageResource {
	MessageService messageService=new MessageService();
	
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages()
	{
		return messageService.getAllMessages();	
	}

	@GET 
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessages1()
	{
		StringBuilder text=new StringBuilder();
		for(Message message: messageService.getAllMessages())
		{
			text.append(message.toString());
		}
		return text.toString();	
	}
	
	//id here is coming as a string but jersey is converting it into Long
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("id") Long messageID )
	{
		return messageService.getMessage(messageID);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)//what it accepts
	@Produces(MediaType.APPLICATION_JSON) //Gives output in XML format
	public Message postMessage(Message message)
	{
		return messageService.addMessage(message);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void remove(@PathParam("id") Long id)
	{
		 messageService.removeMessage(id);
		 
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message update(@PathParam("id") Long id,Message message)
	{
		message.setId(id);
		return messageService.updateMessage(message);
	}
}

