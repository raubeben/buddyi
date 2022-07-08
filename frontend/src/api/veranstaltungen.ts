import axios from 'axios';
import { API_ROOT } from "@/config/development";
import { Veranstaltung } from '@/model/veranstaltung';

export async function getAllVeranstaltungen(): Promise<Veranstaltung[]> {
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

export async function getAllVeranstaltungenUser(): Promise<Veranstaltung[]> {
    const config = {
        withCredentials: true
    }
    try {
        const response = await axios.get(API_ROOT + '/api/veranstaltungen/user', config);
        return response.data;
    } catch (error) {
        return <any>error;
    }
}

export async function addNewVeranstaltung(newVeranstaltung: Veranstaltung) {
    const config = {
        withCredentials: true
    }
    try {
        const response = await axios.post(API_ROOT + '/api/veranstaltungen/create', newVeranstaltung, config);
        return response.data;
    } catch (error) {
        return error;
    }

}

export async function getVeranstaltungById(veranstaltungsId: any): Promise<Veranstaltung[]> {
    const config = {
        withCredentials: true
    }
    try {
        const response = await axios.get(API_ROOT + '/api/veranstaltungen/' + veranstaltungsId, config);
        return response.data;
    } catch (error) {
        return <any>error;
    }
}

export async function updateVeranstaltungParticipant(updateVeranstaltung: Veranstaltung) {
    const config = {
        withCredentials: true
    }
    try {
        const response = await axios.put(API_ROOT + '/api/veranstaltung/addparticipant', updateVeranstaltung, config);
        return response.data;
    } catch (error) {
        return error;
    }

}

export async function deleteParticipant(veranstaltungsId: any) {
    const config = {
        withCredentials: true,
    }
    try {
        const response = await axios.delete(API_ROOT + '/api/veranstaltungen/'+ veranstaltungsId +'/delete', config);
        return response.data;
    } catch (error) {
        return error;
    }

}