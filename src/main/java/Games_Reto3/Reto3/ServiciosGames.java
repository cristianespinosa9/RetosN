/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Games_Reto3.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosGames {
     @Autowired
    private RepositorioGames metodosCrud;

    public List<Games> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Games> getGames(int gamesId) {
        return metodosCrud.getGames(gamesId);
    }

    public Games save(Games games){
        if(games.getId()==null){
            return metodosCrud.save(games);
        }else{
            Optional<Games> e=metodosCrud.getGames(games.getId());
            if(e.isEmpty()){
                return metodosCrud.save(games);
            }else{
                return games;
            }
        }
    }

    public Games update(Games games){
        if(games.getId()!=null){
            Optional<Games> e=metodosCrud.getGames(games.getId());
            if(!e.isEmpty()){
                if(games.getName()!=null){
                    e.get().setName(games.getName());
                }
                if(games.getDeveloper()!=null){
                    e.get().setDeveloper(games.getDeveloper());
                }
                if(games.getYear()!=null){
                    e.get().setYear(games.getYear());
                }
                if(games.getName()!=null){
                    e.get().setName(games.getDescription());
                }
                if(games.getDescription()!=null){
                    e.get().setDescription(games.getDescription());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return games;
            }
        }else{
            return games;
        }
    }


    public boolean deleteGames(int gamesId) {
        Boolean aBoolean = getGames(gamesId).map(games -> {
            metodosCrud.delete(games);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
