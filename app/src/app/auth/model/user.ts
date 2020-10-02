import {Role} from './role';

export class User {
  id: number;
  userName;
  firstName: string;
  lastName: string;
  password: string;
  role: Role;
  token: string;
}
