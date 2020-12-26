package com.ribpet.controller;

//import com.ribpet.demo.biz.ToDoBiz;
import com.ribpet.model.ToDo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoApi {

//    @Autowired
//    private ToDoBiz toDoBiz;

    @GetMapping("/ok")
    public String ok(){
        return "ok";
    }

    @GetMapping("/list")
    public List<ToDo> getToDoList(){
        List<ToDo> list =  new ArrayList<>();

        list.add(new ToDo(1, "2", "3"));
        list.add(new ToDo(2, "4", "6"));
        return list;
    }
//
//    @GetMapping("/test/add/todos")
//    public String getTestTodoList(){
//        List<ToDo> toDos =  new ArrayList<>();
//        toDos.add(new ToDo(null, "one", ""));
//        toDos.add(new ToDo(null, "two", ""));
//
//        toDoBiz.AddTestTodo(toDos);
//
//        return "ok";
//    }
//
//    @PostMapping("/todo")
//    public String doTodo(@RequestBody ToDo toDo){
//        toDoBiz.addToDo(toDo);
//        return "ok";
//    }
}
