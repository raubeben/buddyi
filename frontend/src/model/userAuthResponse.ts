export interface UserAuthResponse {
    loginName: string;
    roles:  string[];
    expiresAt: Date;
}