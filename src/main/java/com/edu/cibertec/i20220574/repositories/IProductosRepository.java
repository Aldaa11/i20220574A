package com.edu.cibertec.i20220574.repositories;
import com.edu.cibertec.i20220574.models.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IProductosRepository extends JpaRepository<Productos, Long> {
}