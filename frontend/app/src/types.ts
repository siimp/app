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

export interface RootState {
    API_URL: string;
}
