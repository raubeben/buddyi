package ch.zhaw.sml.iwi.meng.leantodo.boundary;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.sml.iwi.meng.leantodo.controller.ToDoController;
import ch.zhaw.sml.iwi.meng.leantodo.entity.ToDo;

@RestController
public class ToDoEndpoint {

    @Autowired
    private ToDoController toDoController;

    @RequestMapping(path = "/api/todo", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public List<ToDo> toDo(Principal principal) {
        return  toDoController.listAllToDos(principal.getName());        
    }

    @RequestMapping(path = "/api/todo", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public void addToDo(@RequestBody ToDo newToDo, Principal principal) {
        toDoController.persistToDo(newToDo, principal.getName());
    }
    
    @RequestMapping(path = "/api/todo", method = RequestMethod.PUT)
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public void updateToDo(@RequestBody ToDo toDo, Principal principal) {
        toDoController.updateToDo(toDo, principal.getName());
    }
}