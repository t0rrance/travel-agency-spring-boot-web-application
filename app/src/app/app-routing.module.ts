import {NgModule} from '@angular/core';
import {Router, RouterModule, Routes} from '@angular/router';
import {CreateTravelComponent} from "./travel/create-travel/create-travel.component";
import {LoginComponent} from "./auth/login/login.component";
import {RegisterComponent} from "./auth/register/register.component";
import {Role} from "./auth/model/role";
import {AuthGuard} from "./auth/guards/auth.guard";
import {ProfileComponent} from "./auth/profile/profile.component";
import {CreateOrderComponent} from "./order/create-order/create-order.component";
import {CreateOrderDetailsComponent} from "./order/create-order-details/create-order-details.component";

const routes: Routes = [
  //public pages
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  //user+admin
  {path:'profile',
    component: ProfileComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.USER, Role.ADMIN]}
  },
  // {path:'detail/:id',
  //   component:DetailComponent,
  //   canActivate: [AuthGuard],
  //   data: {roles: [Role.ADMIN]}
  // },

  {
    path: 'travels',
    component: CreateTravelComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.ADMIN, Role.USER]}
  },
  {
    path: 'orders',
    component: CreateOrderComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.ADMIN, Role.USER]}
  },
  {
    path: 'orders/details',
    component: CreateOrderDetailsComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.ADMIN, Role.USER]}
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {
  constructor(private router: Router) {
    //For unkhown pages
    this.router.errorHandler = (error: any) => {
      this.router.navigate(['/404']);
    }
  }
}

