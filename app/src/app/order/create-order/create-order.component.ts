import { Component, OnInit } from '@angular/core';
import {TravelRequest} from "../../travel/travelRequest";
import {AdditionalItem} from "../../travel/additionalItem";
import {Client} from "./client";
import {AdminService} from "../../service/admin.service";
import {Accommodation} from "../../travel/accomodation";
import {TravelResponse} from "../../travel/travelResponse";
import {error} from "util";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-order',
  templateUrl: './create-order.component.html',
  styleUrls: ['./create-order.component.css']
})
export class CreateOrderComponent implements OnInit {

  travelsList: TravelResponse [] = [];

  additionalItem: AdditionalItem = new AdditionalItem();
  additionalOrderItemList: AdditionalItem [] = [];
  clientOrder: Client = new Client();
  clientAttendance: Client = new Client();
  attendanceList: Client [] = [];

  constructor(private adminService : AdminService, private router: Router) { }

  ngOnInit() {
    this.adminService.getAllTravels()
      .subscribe(data => {console.log(data);
      this.travelsList = data; }, error => console.log(error));
  }

  save() {

  }

  onSubmit() {
    this.save();
  }

  addAdditonalItemToList() {
    this.additionalOrderItemList.push(this.additionalItem);
    this.additionalItem = new AdditionalItem();
  }

  addClientAttendanceToList() {
    this.attendanceList.push(this.clientAttendance);
    this.clientAttendance = new Client();
  }

  orderTravel(id: number) {
    this.router.navigate(["orders/details",id]);
  }

}
