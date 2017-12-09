import {Injectable} from "@angular/core";
import {Http, Headers, RequestOptions} from "@angular/http";
import "rxjs/add/operator/map";
import 'rxjs/Rx';

@Injectable()
export class ProduitsService {
  constructor(public http: Http) {
  }

  getShops(){
    return this.http.get("http://localhost:8080/Shops")
      .map(resp=>resp.json());
  }

  LikeShop(id:any){
    return this.http.put("http://localhost:8080/Shops/like",id)
      .map(resp=>resp.json());
  }

  DislikeShop(id:any){
    return this.http.put("http://localhost:8080/Shops/dislike",id)
      .map(resp=>resp.json());
  }

  NolikeShop(id:any){
    return this.http.put("http://localhost:8080/Shops/nolike",id)
      .map(resp=>resp.json());
  }

  getLikedShops(){
    return this.http.get("http://localhost:8080/MyShops")
      .map(resp=>resp.json());
  }
}
