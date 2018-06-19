/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Model.Desligado;
import java.util.List;

/**
 *
 * @author lcorra
 */
public class DAODesligado extends DAOGenerico<Desligado>{
    
    public DAODesligado() {
        super(Desligado.class);
    }

    @Override
    public List<Desligado> list() {
        return super.list(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Desligado e) {
        super.remover(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Desligado e) {
        super.atualizar(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(Desligado e) {
        super.inserir(e); //To change body of generated methods, choose Tools | Templates.
    }
    
}
