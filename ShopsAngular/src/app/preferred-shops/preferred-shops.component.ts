import { Component, OnInit } from '@angular/core';
import {ProduitsService} from "../../service/produits.service";
import {Http} from "@angular/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-preferred-shops',
  templateUrl: './preferred-shops.component.html',
  styleUrls: ['./preferred-shops.component.css']
})
export class PreferredShopsComponent implements OnInit {
produits:any;
  constructor(public http:Http,public service:ProduitsService,public router:Router) {
    this.getAll();
  }

  ngOnInit() {

  }

  getAll(){
    this.service.getLikedShops().subscribe(data=> {
      this.produits= data;
      console.log(this.produits);
    }, err=> {
      console.log(err);
    })
  }
  buttonRemove(id:any){
  this.service.NolikeShop(id).subscribe(data=> {
    this.produits= data;
    console.log(data);
}, err=> {
  console.log(err);
})
}



}
