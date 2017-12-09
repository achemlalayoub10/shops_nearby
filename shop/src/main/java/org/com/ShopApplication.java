package org.com;

import java.util.Comparator;

import org.bson.types.ObjectId;
import org.com.models.Point;
import org.com.models.Shop;
import org.com.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ShopApplication implements CommandLineRunner{
	@Autowired
	ShopRepository shopRepository;
	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		/*Shop sh=shopRepository.findOne(new ObjectId("5a0c6711fb3aac66aafe26c4"));
		sh.setLiked(1);
		shopRepository.save(sh);
		sh=shopRepository.findOne(new ObjectId("5a0c6711fb3aac66aafe26c5"));
		sh.setLiked(-1);
		shopRepository.save(sh);
		sh=shopRepository.findOne(new ObjectId("5a0c6711fb3aac66aafe26c6"));
		sh.setLiked(1);
		shopRepository.save(sh);*/
		for (Shop shop : shopRepository.findAllnoLiked()) {
			System.out.println(shop.getName()+" "+shop.getLiked());
		}
	}
	
	
	
	
}
