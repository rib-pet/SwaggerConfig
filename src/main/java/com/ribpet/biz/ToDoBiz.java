//package com.ribpet.demo.biz;
//
//import com.ribpet.demo.model.ToDo;
//import com.ribpet.demo.repository.TodoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.transaction.Transactional;
//import java.beans.Transient;
//import java.util.List;
//
//public class ToDoBiz {
//    @Autowired
//    private TodoRepository todoRepository;
//
//    @Transactional
//    public void AddTestTodo(List<ToDo> toDoList){
//        toDoList.forEach(v -> todoRepository.save(v));
//    }
//
//    @Transactional
//    public void addToDo(ToDo todo){
//        todoRepository.save(todo);
//    }
//}
