import { getAllToDos, updateToDo/* ,addNewToDo */ } from '@/api/todos';
import { ToDo } from '@/model/todo';
import { onMounted, ref } from 'vue';

export function useTodos() {

    const todos = ref<ToDo[]>([]);

    const getTodos = async () => {
        try {
            todos.value = await getAllToDos();
        } catch (error) {
            console.log(error); // FIXME
        }
    }

    const finishTodo = async (todo: ToDo) => {
        todo.done = true;
        updateToDo(todo);
    }


    const addTodo = async () => {
        console.log("addTodo: To be implemented")
    }

    onMounted(getTodos);

    return {
        todos,
        getTodos,
        addTodo,
        finishTodo
    }
}