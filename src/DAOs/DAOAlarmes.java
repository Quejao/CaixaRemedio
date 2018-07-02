/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Model.Alarme;
import java.util.List;

/**
 *
 * @author lcorra
 */
public class DAOAlarmes extends DAOGenerico<Alarme>{
    
    public DAOAlarmes() {
        super(Alarme.class);
    }

    @Override
    public List<Alarme> list() {
        return super.list(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Alarme e) {
        super.remover(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Alarme e) {
        super.atualizar(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(Alarme e) {
        super.inserir(e); //To change body of generated methods, choose Tools | Templates.
    }
    
}
