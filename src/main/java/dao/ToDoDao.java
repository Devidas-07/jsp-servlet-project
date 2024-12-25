package dao;

import java.sql.SQLException;
import java.util.List;

import model.ToDo;

public interface ToDoDao {
	void insertTodo(ToDo todo) throws SQLException;

	ToDo selectTodo(long todoId);

	List<ToDo> selectAllTodos();

	boolean deleteTodo(int id) throws SQLException;

	boolean updateTodo(ToDo todo) throws SQLException;

}
