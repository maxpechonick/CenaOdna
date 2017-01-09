import {AbstractEntity} from "./abstractentity";
export class User extends AbstractEntity{
  login :string;
  enables: boolean;
  password: string;
  firstName: string;
  lastName: string;
}
