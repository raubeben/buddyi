import { getAllVeranstaltungenUser } from "@/api/veranstaltungen";
import { Veranstaltung } from "@/model/veranstaltung";
import { onMounted, ref } from 'vue';

export function useVeranstaltungenUser() {
    const veranstaltungen = ref<Veranstaltung[]>([]);

    const getVeranstaltungen = async () => {
        try {
            veranstaltungen.value = await getAllVeranstaltungenUser();
        } catch (error) {
            console.log(error);
        }
    }

    onMounted(getVeranstaltungen);

    return {
        veranstaltungen,
        getVeranstaltungen
    }
}