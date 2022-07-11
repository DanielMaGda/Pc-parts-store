package com.danmag.pcpartsstore.service.repository;

import com.danmag.pcpartsstore.service.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
