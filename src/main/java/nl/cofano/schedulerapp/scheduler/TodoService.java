package nl.cofano.schedulerapp.scheduler;

import nl.cofano.schedulerapp.exceptions.TodoCreateException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.http.HTTPBinding;


/**
 * The service used for creating new items in the todo-app
 */
@Service
public class TodoService {
    private final String serverURL = "http://localhost:8081";
    @Autowired
    RestTemplate restTemplate;

    public void createTodo(String description, Integer assignee) throws TodoCreateException{
        String url = serverURL+"/todo";

        // Add an webservice call for creating an item to the todo-app
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        TODOItem todoItem = new TODOItem(description,assignee,false);
        HttpEntity<TODOItem> entity = new HttpEntity<>(todoItem);
        restTemplate.postForObject(url,entity,TODOItem.class);
    }

    public void deleteTodo(Integer id){
        String url = serverURL+"/todo/"+id;
        restTemplate.delete(url);
    }
}
