package org.com.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.com.models.Shop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ShopRepository extends MongoRepository<Shop, ObjectId>, ShopRepositoryCustom{
	@Query("{ 'liked' : { $nin: [ 1, -1 ]} }")
	List<Shop> findAllnoLiked();
	
	@Query("{ 'liked' : { $nin: [ 0, -1 ]} }")
	List<Shop> findAllLiked();
	
	@Query("{ 'liked' : { $nin: [ 0, 1 ]} }")
	List<Shop> findAlldisLiked();
}
