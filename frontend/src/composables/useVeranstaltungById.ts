import { getAllVeranstaltungenUser } from "@/api/veranstaltungen";
import { Veranstaltung } from "@/model/veranstaltung";
import { ref } from 'vue';
import { getVeranstaltungById } from "@/api/veranstaltungen";

export function useVeranstaltungById() {
    const veranstaltung = ref<Veranstaltung[]>([]);

    const getVeranstaltungId = async (x: any) => {
        console.log(x)
        try {
            veranstaltung.value = await getVeranstaltungById(x);
        } catch (error) {
            console.log(error);
        }
    }

    return {
        veranstaltung,
        getVeranstaltungId
    }
}