/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package depro.dao;

import depro.modelo.Usuario;
import java.util.List;


/**
 *
 * @author jhunior
 */
public class UsuarioDAOImpl extends HibernateDAOImpl<Usuario, Integer> {
    public UsuarioDAOImpl(){
        super(Usuario.class);
    }
    
    public void limpiarTabla(){
        getCurrentSession().createSQLQuery("TRUNCATE 'usuario'").executeUpdate();
    }
    
    public Usuario buscarPorNombreUsuario(String nombreUsuario){
        String hql = "FROM Usuario WHERE nombreUsuario = '"+nombreUsuario+"'";
        return (Usuario) getCurrentSession().createQuery(hql).uniqueResult();
    }
    
    public Usuario buscarPorNombreUsuarioYContrasena(String nombreUsuario, String pass){
        String hql = "FROM Usuario WHERE nombreUsuario = '"+nombreUsuario+"' AND pass = '"+pass+"'";
        return (Usuario) getCurrentSession().createQuery(hql).uniqueResult();
    }

    public List<String> listarNombreUsuarios() {
        return getCurrentSession().createSQLQuery("select distinct nombreUsuario from Usuario").list();
    }
}
