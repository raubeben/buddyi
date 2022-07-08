import { deleteParticipant } from "@/api/veranstaltungen";
import { onMounted } from 'vue';

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
