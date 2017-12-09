import { Component, OnInit } from '@angular/core';
import {ProduitsService} from "../../service/produits.service";
import {Http} from "@angular/http";
import {Router} from "@angular/router";
import {Shop} from "../../model/shop";

@Component({
  selector: 'app-neary-by-shops',
  templateUrl: './neary-by-shops.component.html',
  styleUrls: ['./neary-by-shops.component.css']
})
export class NearyByShopsComponent implements OnInit {
  produits:any;
  constructor(public http:Http,public service:ProduitsService,public router:Router) {
    this.getAll();
  }




  ngOnInit() {
  }

  getAll(){
    this.service.getShops().subscribe(data=> {
      this.produits= data;
      console.log(this.produits);
    }, err=> {
      console.log(err);
    })
  }
  buttonLike(id:any){
    this.service.LikeShop(id).subscribe(data=> {
      this.produits= data;
      console.log(data);
    }, err=> {
      console.log(err);
    })
  }

  buttonDislike(id:any){
    this.service.DislikeShop(id).subscribe(data=> {
      this.produits= data;
      console.log(data);
    }, err=> {
      console.log(err);
    })
  }
}
