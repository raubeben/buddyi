import { deleteParticipant } from "@/api/veranstaltungen";
import { Veranstaltung } from "@/model/veranstaltung";
import { onMounted, ref } from 'vue';

export function delUser() {

    const delParticipant = async (vid: any) => {
        try {
            await deleteParticipant(vid as any);
        } catch (error) {
            console.log(error);
        }
    }

    onMounted(delUser);

    return {
        delParticipant,
    }
}
