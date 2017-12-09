import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NearyByShopsComponent } from './neary-by-shops/neary-by-shops.component';
import { PreferredShopsComponent } from './preferred-shops/preferred-shops.component';
import {Routes, RouterModule} from "@angular/router";
import {HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";
import {ProduitsService} from "../service/produits.service";
const appRoutes:Routes=[
  {path:'preferred',component:PreferredShopsComponent},
  {path:'nearby',component:NearyByShopsComponent},
  {path:'',redirectTo:'/nearby',pathMatch:"full"}
];
@NgModule({
  declarations: [
    AppComponent,
    NearyByShopsComponent,
    PreferredShopsComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    HttpModule
  ],
  providers: [ProduitsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
