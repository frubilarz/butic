/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boaboa.org.butic.gui;

import boaboa.org.butic.model.Cliente;
import boaboa.org.butic.model.Usuario;
import boaboa.org.butic.servicio.ServicioDB;
import boaboa.org.butic.utils.SecurityUtils;
import javax.swing.JOptionPane;

/**
 *
 * @author frubilar
 */
public class Main {

    public static void main(String[] args) {

        ServicioDB servicio = new ServicioDB();
        Cliente cliente = new Cliente();
        
        cliente.setDireccion("matucana");
        cliente.setEmail("frubilar@icci.cl");
        cliente.setFono(1234567);
        cliente.setNombre("Fernando Rubilar");
        cliente.setRut(12345678);
        Usuario usuario = new Usuario();
        usuario.setNombre("Fernando rubilar");
        usuario.setRut(17708487);
        String pass = SecurityUtils.sha256("password");
        usuario.setClave(pass);
        
        boolean salida = servicio.guardar(usuario);
        if(salida){
            JOptionPane.showMessageDialog(null, cliente.getNombre());
        }else{
            JOptionPane.showMessageDialog(null, "Revisa la wea de logs");
        }
    }

}
