package net.itinajero.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import net.itinajero.model.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante,Integer>{
    
    List<Vacante> findByEstatus(String status);

    List<Vacante> findByEstatusAndDestacado(String estatus, int destacado);
    
    //List<Vacante> findBySalarioBetween(double salario1, double salario2);
    List<Vacante> findBySalarioBetweenOrderBySalarioDesc(double salario1, double salario2);

    List<Vacante> findByEstatusIn(String[] estatus);



}
