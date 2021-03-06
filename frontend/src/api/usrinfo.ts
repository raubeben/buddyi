import axios from 'axios';
import { API_ROOT } from "@/config/development";
import { UsrInfoResponse } from '@/model/usrInfoResponse';

export async function getUsrInformation(): Promise<UsrInfoResponse[]> {
    const config = {
        withCredentials: true
    }
    try {
        const response = await axios.get(API_ROOT + '/api/me', config);
        return response.data;
    } catch (error) {
        return <any>error;
    }
}

export async function getOtherUsrInformation(user: any): Promise<UsrInfoResponse[]> {
    const config = {
        withCredentials: true
    }
    try {
        const response = await axios.get(API_ROOT + '/api/' + user, config);
        return response.data;
    } catch (error) {
        return <any>error;
    }
}

export async function getAlmostAllUser(): Promise<UsrInfoResponse[]> {
    const config = {
        withCredentials: true
    }
    try {
        const response = await axios.get(API_ROOT + '/api/users/almostall', config);
        return response.data;
    } catch (error) {
        return <any>error;
    }
}