import axios from 'axios';
import { API_ROOT } from "@/config/development";
import { UserAuthResponse } from '@/model/userAuthResponse';

export async function getToken(username: string, password: string): Promise<UserAuthResponse> {

    const config = {
        headers: {
            'Authorization': 'BASIC ' + btoa(username + ":" + password)
        },
        withCredentials: true
    }
    try {
        const response = await axios.get(API_ROOT + '/auth/token', config);
        return response.data;
    } catch (error) {
        return error;
    }
}