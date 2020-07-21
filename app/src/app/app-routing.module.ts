import { NgModule } from '@angular/core';
import {Routes, RouterModule, Router} from '@angular/router';
import {CreateTravelComponent} from "./travel/create-travel/create-travel.component";


const routes: Routes = [
 {path:'', redirectTo:'travels', pathMatch:'full'},
  {path:'create', component: CreateTravelComponent}
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
