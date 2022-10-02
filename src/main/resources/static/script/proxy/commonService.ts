import {AXIOS_INSTANCE} from "./axiosInstance";

export class CommonService {
    static getClientKey() {
        return AXIOS_INSTANCE.get("key");
    }
}