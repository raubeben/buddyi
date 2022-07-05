import axios from 'axios';
import { API_ROOT } from "@/config/development";
import { Veranstaltung } from '@/model/veranstaltung';

export async function getAllVeranstaltungen(): Promise<Veranstaltung[]>   { 
    const config = {        
        withCredentials: true
    }
    try {
        const response = await axios.get(API_ROOT + '/api/veranstaltungen/all', config);
        return response.data;
    } catch (error) {
        return <any>error;   
    }
}

