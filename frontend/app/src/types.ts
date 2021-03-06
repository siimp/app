export interface User {
    id: number;
    username: string;
}

export interface Client {
    id: number;
    version: number;
    firstName: string;
    lastName: string;
    username: string;
}

export interface ClientAddForm {
    firstName: string;
    lastName: string;
    username: string;
    email: string;
    address: string;
    country: number;
}

export interface ClientEditForm extends ClientAddForm {
    version: number;
}

export interface Country {
    id: number;
    name: string;
}
