package net.itinajero.repository;
import net.itinajero.model.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

//public interface CategoriasRepository extends CrudRepository<Categoria,Integer>{}
public interface CategoriasRepository extends JpaRepository<Categoria,Integer>{}