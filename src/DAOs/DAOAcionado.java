/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Model.Acionado;
import java.util.List;

/**
 *
 * @author lcorra
 */
public class DAOAcionado extends DAOGenerico<Acionado> {
    
    public DAOAcionado() {
        super(Acionado.class);
    }

    @Override
    public List<Acionado> list() {
        return super.list(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(Acionado e) {
        super.inserir(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Acionado e) {
        super.remover(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Acionado e) {
        super.atualizar(e); //To change body of generated methods, choose Tools | Templates.
    }
    
}
