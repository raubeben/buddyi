import { onMounted, ref } from "vue"

export function getUserevents() {

    const userveranstaltung = ref<any>([])

    const getVeranstaltung = function () {

        userveranstaltung.value = [
            {
                id: "32980475980237450",
                activity: "basketball",
                beschreibung: "teshfkjsdhfkjgsjkdfst",
                ort: "winterthur",
                datum: "262292962"
            },
            {
                id: "2384570982374",
                activity: "fussball",
                beschreibung: "oiwuuhfjshdfjkhsdlkfghsjkdlghkjsdfjh",
                ort: "züri",
                datum: "6662929529"
            },
            {
                id: "3487982374598",
                activity: "handball",
                beschreibung: "wehrrtiwuehrguiwehroiuwh",
                ort: "seen",
                datum: "626262926"
            }

        ]
    }

    onMounted(getVeranstaltung); // einmalig Ausführen beim Aufruf

    return { userveranstaltung, getVeranstaltung }

}