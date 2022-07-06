import { getAllVeranstaltungen, addNewVeranstaltung } from "@/api/veranstaltungen";
import { Veranstaltung } from "@/model/veranstaltung";
import { onMounted, ref } from 'vue';

export function useVeranstaltungen() {
    const veranstaltungen = ref<Veranstaltung[]>([]);

    const newVeranstaltung = ref<Veranstaltung>({}); // Referenz vom Typ ToDo

    const getVeranstaltungen = async () => { // ausgelagerte Funktionen immer mit const 
        try {
            veranstaltungen.value = await getAllVeranstaltungen();
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    const addVeranstaltung = async () => {
        try {
            // add the new todo and update the list of all todos afterwards
            await addNewVeranstaltung(newVeranstaltung.value);
            getVeranstaltungen();
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    onMounted(getVeranstaltungen);

    return {
        newVeranstaltung,
        veranstaltungen,
        getVeranstaltungen,
        addVeranstaltung
    }
}
    