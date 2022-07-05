import { onMounted, ref } from "vue"
import { getAllVeranstaltungen } from "@/api/eventkatalog";
import { Veranstaltung } from "@/model/veranstaltung";

export function getVeranstaltung() { // eine Funktion pro Composable (Name = Dateiname)

    const veranst = ref<Veranstaltung[]>([]);

    // const newVeranst = ref<Veranstaltung>({}); // Referenz vom Typ ToDo

    const getVeranstaltungList = async () => { // ausgelagerte Funktionen immer mit const 
        try {
            veranst.value = await getAllVeranstaltungen();
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }
    /*
    const finishTodo = async (todo: ToDo) => {
        try {
            todo.done = true;
            updateToDo(todo);
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    const archiveTodo = async (todo: ToDo) => {
        try {
            todo.archived = true;
            await updateToDo(todo);
            getTodos();
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    const addTodo = async () => {
        try {
            // add the new todo and update the list of all todos afterwards
            await addNewToDo(newTodo.value);
            getTodos();
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }
    */
    onMounted(getVeranstaltung);

    return {
        veranst,
        getVeranstaltungList,

    }
}

/*
export function getUserevents() {
    
    const userveranstaltung = ref<any>([])

    const getVeranstaltung = function () {

        userveranstaltung.value = [
            {
                id: "32980475980237450",
                activity: "basketball",
                beschreibung: "teshfkjsdhfkjgsjkdfst",
                ort: "winterthur",
                datum: "262292962"
            },
            {
                id: "2384570982374",
                activity: "fussball",
                beschreibung: "oiwuuhfjshdfjkhsdlkfghsjkdlghkjsdfjh",
                ort: "züri",
                datum: "6662929529"
            },
            {
                id: "3487982374598",
                activity: "handball",
                beschreibung: "wehrrtiwuehrguiwehroiuwh",
                ort: "seen",
                datum: "626262926"
            }

        ]
    }

    onMounted(getVeranstaltung); // einmalig Ausführen beim Aufruf

    return { userveranstaltung, getVeranstaltung}
 
} */