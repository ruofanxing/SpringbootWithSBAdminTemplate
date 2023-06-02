
package com.itgenius.repository;


import com.itgenius.beans.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

public interface ProductDao extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

}
