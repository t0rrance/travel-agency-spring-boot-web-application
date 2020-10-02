import {AdditionalItem} from "../../travel/additionalItem";
import {Client} from "./client";

export class TravelOrderResponse {
  id: number;
  travelId: number;
  clientOrder : Client;
  numberOfSeats : number;
  orderDate : Date;
  paymentDate : Date;
  attendanceList: Array<Client>;
  additionalOrderItemList: Array<AdditionalItem>;
}
