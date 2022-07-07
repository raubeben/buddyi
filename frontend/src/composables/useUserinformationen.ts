import { getUsrInformation , getAlmostAllUser } from '@/api/usrinfo';
import { onMounted, ref } from 'vue';
import { UsrInfoResponse } from "@/model/usrInfoResponse";

export function useUserinformationen() {
    const usrinform = ref<UsrInfoResponse[]>([]);
    const almostalluser = ref<UsrInfoResponse[]>([]);

    const getUserinform = async () => {
        try {
            usrinform.value = await getUsrInformation();
        } catch (error) {
            console.log(error);
        }
    }

    const getUserAlmostAll = async () => {
        try {
            almostalluser.value = await getAlmostAllUser();
            console.log(almostalluser)
        } catch (error) {
            console.log(error);
        }
    }

    onMounted(getUserinform);
    onMounted(getUserAlmostAll);

    return {
        usrinform,
        almostalluser,
        getUserinform ,
        getUserAlmostAll,
        
    }
}