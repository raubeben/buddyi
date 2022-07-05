import { ListenerCallback } from "@capacitor/core";

export interface Veranstaltung {
    id?: number;
    beschreibung?: string;
    ort?: boolean;
    activity?: boolean;
    datum?: Date;
    users?: [];
}