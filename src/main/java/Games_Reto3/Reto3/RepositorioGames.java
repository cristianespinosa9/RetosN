/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Games_Reto3.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class RepositorioGames {
    
    @Autowired
    private InterfaceGames crud;

    public List<Games> getAll(){
        return (List<Games>) crud.findAll();
    }

    public Optional<Games> getGames(int id){
        return crud.findById(id);
    }

    public Games save(Games games){
        return crud.save(games);
    }
    public void delete(Games games){
        crud.delete(games);
    }
    
}
