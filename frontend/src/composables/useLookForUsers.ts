import { ref } from 'vue';

export function useLookForUsers() {

    const selectedUser = ref("");


    return {
        selectedUser
    }

}