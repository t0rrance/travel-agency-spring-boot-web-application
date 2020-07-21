import {Component} from '@angular/core';
import {TravelRequest} from "../travelRequest";
import {UserService} from "../../service/user.service";
import {TravelResponse} from "../travelResponse";
import {AdditionalItem} from "../additionalItem";
import {Accommodation} from "../accomodation";

@Component({
  selector: 'app-create-travel',
  templateUrl: './create-travel.component.html',
  styleUrls: ['./create-travel.component.css']
})
export class CreateTravelComponent {

  travelRequest: TravelRequest = new TravelRequest();
  travelResponse: TravelResponse = new TravelResponse();
  additionalItem: AdditionalItem = new AdditionalItem();
  additionalItemList: AdditionalItem [] = [];
  submitted = false;
  tempItemListResponse: AdditionalItem [] = [];
  accommodationList : Accommodation [] = [];
  accommodation: Accommodation = new Accommodation();

  constructor(private userService: UserService) {
  }

  save() {
    this.travelRequest.itemsList = this.additionalItemList;
    this.travelRequest.accommodationList = this.accommodationList;
    this.userService.createTeam(this.travelRequest)
      .subscribe(data => {
        console.log(data);
        this.travelResponse = data;
      }, error => console.log(error));
    this.tempItemListResponse = this.travelResponse.itemsList;
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  addAdditonalItemToList() {
    this.additionalItemList.push(this.additionalItem);
    this.additionalItem = new AdditionalItem();
  }

  addAccommodationToList() {
    this.accommodationList.push(this.accommodation);
    this.accommodation = new Accommodation();
  }

}
