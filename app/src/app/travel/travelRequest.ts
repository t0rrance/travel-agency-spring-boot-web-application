import {AdditionalItem} from "./additionalItem";
import {Accommodation} from "./accomodation";

export class TravelRequest {
  travelName: string;
  numberOfSeats: number;
  pricePerSeat : number;
  startDate : Date;
  finishDate : Date;
  itemsList: Array<AdditionalItem>;
  accommodationList: Array<Accommodation>;
}
