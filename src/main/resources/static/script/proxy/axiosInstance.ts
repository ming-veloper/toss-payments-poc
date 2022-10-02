import axios from "axios";

export const AXIOS_INSTANCE = axios.create({
    timeout: 1_000,
    headers: {
        'Content-Type': 'application/json',
    }
});