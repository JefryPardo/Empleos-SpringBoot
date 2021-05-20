package net.itinajero.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import net.itinajero.model.Categoria;
import net.itinajero.repository.CategoriasRepository;
import net.itinajero.service.ICategoriasService;

@Service
@Primary    
public class CategoriaServiceJpa implements ICategoriasService{

    @Autowired
    private CategoriasRepository categoriaRepo;

     
    public void guardar(Categoria categoria) {
        categoriaRepo.save(categoria);
    }

    public List<Categoria> buscarTodas() {
        return categoriaRepo.findAll();
    }

    
    public Categoria buscarPorId(Integer idCategoria) {
       Optional<Categoria> optional = categoriaRepo.findById(idCategoria);
       if (optional.isPresent()) {
           return optional.get();
       }else{
            return null;
       }       
    }
    
}
