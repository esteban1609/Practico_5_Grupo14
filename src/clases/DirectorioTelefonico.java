/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Leandro Naranjo
 */
public class DirectorioTelefonico {
    
 /*Una clase Directorio telefónico posee una lista de Contactos de los que interesa conocer
su DNI, nombre, apellido, Ciudad y dirección. El Directorio, cuenta con un TreeMap de un teléfono
tipo Long(Key),se empareja con un Contacto(valor).*/
    TreeMap<Long, Contacto> cliente=new TreeMap<>();
    

    public DirectorioTelefonico() {
    }

    public TreeMap<Long, Contacto> getCliente() {
        return cliente;
    }

    public void setCliente(TreeMap<Long, Contacto> cliente) {
        this.cliente = cliente;
    }
    
   /*A. agregarContacto() que permite registrar un nuevo contacto con su respectivo nro. de
teléfono. Siendo el nro. del teléfono la clave del mismo.
B. buscarContacto() que en base al nro. de teléfono retorna el Contacto asociado al mismo.
C. buscarTeléfono() que en base a un apellido nos devuelve un Set<Long> con los números
de teléfono asociados a dicho apellido.
D. buscarContactos() que en base a una ciudad nos devuelve un ArrayList con los
Contactos asociados a dicha ciudad.
E. borrarContacto() que en base al número de teléfono elimina el contacto del directorio.*/
    public void agregarContacto(Long numTel, Contacto contact){
        cliente.put(numTel, contact);
    }
    public Contacto buscarContacto(Long num){
          return cliente.get(num);
    }
   /* C. buscarTeléfono() que en base a un apellido nos devuelve un Set<Long> con los números
de teléfono asociados a dicho apellido. */
    public Set buscarTelefono(String apellido){
        Set<Long> tele=new HashSet<>();
        for (Map.Entry<Long, Contacto> entry: cliente.entrySet()) {
            if (entry.getValue().getApellido().equalsIgnoreCase(apellido)) {
                tele.add(entry.getKey());
            }
        }
        return tele;
    }
    /*D. buscarContactos() que en base a una ciudad nos devuelve un ArrayList con los
Contactos asociados a dicha ciudad.*/
    public List buscarContactos(String ciudad){
        ArrayList ciu=new ArrayList<>();
        for (Map.Entry<Long, Contacto> entry : cliente.entrySet()) {
            if (entry.getValue().getCiudad().equalsIgnoreCase(ciudad)) {
                ciu.add(entry.getKey());
            }
        }
        return ciu;
    }
    /*E. borrarContacto() que en base al número de teléfono elimina el contacto del directorio.*/
    public void borrarContacto(Long telefono){
        for (Map.Entry<Long, Contacto> entry : cliente.entrySet()) {
            if (entry.getKey().equals(telefono)) {
                cliente.remove(entry.getKey());
            }
        }
    }
}
