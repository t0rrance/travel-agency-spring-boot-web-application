import {AdditionalItem} from "./additionalItem";
import {Accommodation} from "./accomodation";

export class TravelResponse{
  id:number;
  travelName: string;
  numberOfSeats: number;
  pricePerSeat : number;
  numberOccupiedSeats:number;
  startDate : Date;
  finishDate : Date;
  itemsList: Array<AdditionalItem>;
  accommodationList: Array<Accommodation>;
}
