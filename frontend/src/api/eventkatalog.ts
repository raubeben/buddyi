import axios from 'axios';
import { API_ROOT } from "@/config/development";
import { Veranstaltung } from "@/model/veranstaltung";

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
/*
export async function addNewToDo(newToDo: ToDo): Promise<any>   {
    const config = {        
        withCredentials: true
    }
    try {
        const response = await axios.post(API_ROOT + '/api/todo', newToDo, config);
        return response.data;
    } catch (error) {
        return error;   
    }
}

export async function updateToDo(toDo: ToDo): Promise<any>   {
    const config = {        
        withCredentials: true
    }
    try {
        const response = await axios.put(API_ROOT + '/api/todo', toDo, config);
        return response.data;
    } catch (error) {
        return error;   
    }
} */