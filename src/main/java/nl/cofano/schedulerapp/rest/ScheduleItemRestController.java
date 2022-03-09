package nl.cofano.schedulerapp.rest;

import io.swagger.models.auth.In;
import nl.cofano.schedulerapp.exceptions.TodoCreateException;
import nl.cofano.schedulerapp.scheduler.ScheduleItem;
import nl.cofano.schedulerapp.scheduler.ScheduleItemService;
import nl.cofano.schedulerapp.scheduler.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import org.slf4j.Logger;

@RestController
public class ScheduleItemRestController {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(TodoService.class);

    @Autowired private ScheduleItemService service;
    @Autowired private TodoService todoService;

    @RequestMapping(
        path="/item/{id}",
        method = RequestMethod.GET
    )
    public ScheduleItem getItem(@PathVariable Integer id){
        return service.getItem(id);
    }

    @RequestMapping(
        path="/item",
        method = RequestMethod.GET
    )
    public Collection<ScheduleItem> getAll(){
        return service.getItems();
    }

    @PostMapping("/item")
    public ScheduleItem addTODO(@RequestBody ScheduleItem item) throws TodoCreateException {
        todoService.createTodo(item.getDescription(), item.getAssignee());
        return item;
    }

    @DeleteMapping(
        path= "/item/{id}"
    )
    public void deleteTODO(@PathVariable Integer id){
        todoService.deleteTodo(id);
    }
}
