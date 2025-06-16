/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.jdc.codigo;

import edu.jdc.clases.Permiso;
import edu.jdc.daos.DaoPermiso;
import java.util.Scanner;

public class Principal {
    public static void main (String []args){
        Scanner miTeclado = new Scanner (System.in);
        Permiso objPermiso = new Permiso ();
        
        System.out.println("El software para crear permisos");
        System.out.println("Ingrese el nombre del permiso");
        objPermiso.setNombrePermiso(miTeclado.nextLine());
        
        System.out.println("Ingrese la funcionalidad del permiso");
        objPermiso.setFuncionalidadPermiso(miTeclado.nextLine());
        
        DaoPermiso objDao = new DaoPermiso();
        boolean funciono = objDao.registrar(objPermiso);
        if (funciono){
            System.err.println("El permiso esta en la BD");
        }
        else {
            System.out.println("No te funciona esa BD");
        }
    }
}
