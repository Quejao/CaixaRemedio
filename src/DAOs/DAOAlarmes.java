/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Model.Alarmes;
import java.util.List;

/**
 *
 * @author lcorra
 */
public class DAOAlarmes extends DAOGenerico<Alarmes>{
    
    public DAOAlarmes() {
        super(Alarmes.class);
    }

    @Override
    public List<Alarmes> list() {
        return super.list(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Alarmes e) {
        super.remover(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Alarmes e) {
        super.atualizar(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(Alarmes e) {
        super.inserir(e); //To change body of generated methods, choose Tools | Templates.
    }
    
}
