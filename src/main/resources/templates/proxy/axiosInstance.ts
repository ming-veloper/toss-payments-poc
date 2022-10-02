import axios from "../../static/node_modules/axios";

export const AXIOS_INSTANCE = axios.create({
    timeout: 1_000,
    headers: {
        'Content-Type': 'application/json',
    }
});