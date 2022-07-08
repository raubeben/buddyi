import { getAllVeranstaltungen, addNewVeranstaltung, updateVeranstaltungParticipant } from "@/api/veranstaltungen";
import { Veranstaltung } from "@/model/veranstaltung";
import { onUpdated, ref } from 'vue';

export function useVeranstaltungen() {
    const veranstaltungen = ref<Veranstaltung[]>([]);
    const newVeranstaltung = ref<Veranstaltung>({});

    const getVeranstaltungen = async () => { 
        try {
            veranstaltungen.value = await getAllVeranstaltungen();
        } catch (error) {
            console.log(error); 
        }
    }

    const addVeranstaltung = async () => {
        try {
            await addNewVeranstaltung(newVeranstaltung.value);
            getVeranstaltungen();
        } catch (error) {
            console.log(error);
        }
    }

    const updateParticipant = async (updateVeranstaltung: Veranstaltung) => {
        try {
            await updateVeranstaltungParticipant(updateVeranstaltung as Veranstaltung);
            getVeranstaltungen();
        } catch (error) {
            console.log(error);
        }
    }

    onUpdated(getVeranstaltungen);

    return {
        newVeranstaltung,
        veranstaltungen,
        getVeranstaltungen,
        addVeranstaltung,
        updateParticipant,
        
    }
}   