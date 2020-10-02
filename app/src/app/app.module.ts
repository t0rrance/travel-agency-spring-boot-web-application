import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {CreateTravelComponent} from './travel/create-travel/create-travel.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from "@angular/common/http";

import {LoginComponent} from "./auth/login/login.component";
import {RegisterComponent} from "./auth/register/register.component";
import {ProfileComponent} from "./auth/profile/profile.component";
import { CreateOrderComponent } from './order/create-order/create-order.component';
import { CreateOrderDetailsComponent } from './order/create-order-details/create-order-details.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateTravelComponent,
    LoginComponent,
    RegisterComponent,
    ProfileComponent,
    CreateOrderComponent,
    CreateOrderDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule {
}
