import { deleteParticipant } from "@/api/veranstaltungen";
import { Veranstaltung } from "@/model/veranstaltung";
import { onMounted, ref } from 'vue';

export function delUser() {

    const delParticipant = async (delAusVeranstaltung: Veranstaltung) => {
        try {
            await deleteParticipant(delAusVeranstaltung as Veranstaltung);
        } catch (error) {
            console.log(error);
        }
    }

    onMounted(delUser);

    return {
        delParticipant,
    }
}
