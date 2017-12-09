package org.com.controllers;

import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TimeZone;

import org.bson.types.ObjectId;
import org.com.models.Point;
import org.com.models.Shop;
import org.com.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ShopController {
	@Autowired
	ShopRepository shopRepository;
	@RequestMapping(value="/Shops",method=RequestMethod.GET)
    public List<Shop> product() {
		List <Shop> l1=shopRepository.findAlldisLiked();
		for (Shop shop : l1) {
			Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
			
			long time = cal.getTimeInMillis();
			System.out.println(time+" "+shop.getTimeDislike());
			if(shop.getTimeDislike()<=time){
				shop.setLiked(0);
				shop.setTimeDislike(new Long(0));
				shopRepository.save(shop);
			}
		}
		
		List <Shop> l=shopRepository.findAllnoLiked();
		Collections.sort(l, new Comparator<Shop>()
		{
		    public int compare(Shop p1, Shop p2)
		    {
		        //Euclidean distance from 0,0
		        
		        return Double.compare(p1.getLocation().calcDistance(), p2.getLocation().calcDistance());
		    }
		});
		
        return l;
    }
	
	@RequestMapping(value="/MyShops",method=RequestMethod.GET)
    public List<Shop> getShops2(){
   	 
   	 return shopRepository.findAllLiked();
    }
	
	@RequestMapping(value="/Shops/{id}", method=RequestMethod.DELETE)
	public boolean deleteShop(@PathVariable ObjectId id){
	 
		shopRepository.delete(id);
	 
		 return true;
 }
	
	@RequestMapping(value="/Shops/like", method=RequestMethod.PUT)
	public List<Shop> updateShop(@RequestBody ObjectId id){
		Shop sh=shopRepository.findOne(id);
		sh.setLiked(1);
		shopRepository.save(sh);
		 return  shopRepository.findAllnoLiked();
 }
	
	@RequestMapping(value="/Shops/dislike", method=RequestMethod.PUT)
	public List<Shop> updateShop2(@RequestBody ObjectId id){
		Shop sh=shopRepository.findOne(id);
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		cal.add(cal.MINUTE, 120);
		long time = cal.getTimeInMillis();
		sh.setTimeDislike(time);
		sh.setLiked(-1);
		shopRepository.save(sh);
		 return  shopRepository.findAllnoLiked();
 }
	
	@RequestMapping(value="/Shops/nolike", method=RequestMethod.PUT)
	public List<Shop> updateShop3(@RequestBody ObjectId id){
		Shop sh=shopRepository.findOne(id);
		sh.setLiked(0);
		shopRepository.save(sh);
		 return  shopRepository.findAllLiked();
 }
}
