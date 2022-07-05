import { getUsrInformation } from '@/api/usrinfo';
import { onMounted, ref } from 'vue';
import { UsrInfoResponse } from "@/model/usrInfoResponse";

export function useUserinformationen() {
    const usrinform = ref<UsrInfoResponse[]>([]);

    const getUserinform = async () => {
        try {
            usrinform.value = await getUsrInformation();
        } catch (error) {
            console.log(error);
        }
    }

    onMounted(getUserinform);

    return {
        usrinform,
        getUserinform 
    }
}