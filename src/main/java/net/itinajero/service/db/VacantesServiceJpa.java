package net.itinajero.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import net.itinajero.model.Vacante;
import net.itinajero.repository.VacantesRepository;
import net.itinajero.service.IVacantesService;

@Service
@Primary
public class VacantesServiceJpa implements IVacantesService {

    @Autowired
    private VacantesRepository vacanteRepo;

    @Override
    public List<Vacante> buscarTodas() {
        return vacanteRepo.findAll();
    }

    @Override
    public Vacante buscarPorId(int idVAcante) {
        Optional<Vacante> v = vacanteRepo.findById(idVAcante);
        if(v.isPresent()){
            return v.get();
        }
        return null;
    }

    @Override
    public void guardar(Vacante vacante) {
        vacanteRepo.save(vacante);
    }

    @Override
    public List<Vacante> buscarDestacadas() {        
        return vacanteRepo.findByEstatusAndDestacado("Aprobada",1);
    }

}
