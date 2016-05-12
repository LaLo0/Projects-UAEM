/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import javax.jws.WebService;
import java.sql.*;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alexis
 */
@WebService(serviceName = "usuarios")
public class usuarios {

    @WebMethod
    public String insertarUsuario(String no,String ap,String am,String fn,String dr) {

        String conexionBD = "jdbc:mysql://127.0.0.1/Sistema_Empleados";
        Connection conexion = null;
        String funciono = null;
        String con;

        try {
            // JOptionPane.showMessageDialog(null,"entro");
            Class.forName("com.mysql.jdbc.Driver");//el driver de mysql
            conexion = DriverManager.getConnection(conexionBD, "root", "");//conexion a la base de datos
            Statement s = conexion.createStatement();
            // JOptionPane.showMessageDialog(null,no+" "+ap);
            con = "INSERT INTO USUARIOS VALUES (NULL,'" + no + "','" + ap + "','" + am + "','" + fn + "','" + dr + "')";
            s.executeUpdate(con);

            funciono = "Insercion de Datos Exitosa";
        } catch (Exception e) {
            funciono = "Error de Conexion";
        }

        return funciono;
    }

    /**
     * Web service operation
     */
    public String idUsername;
    public String name;
    public String lastf;
    public String lastm;
    public String birth;
    public String address;

    @WebMethod(operationName = "buscarUsuario")
    public String buscarUsuario(@WebParam(name = "idUsuario") String idUser) {
        //TODO write your implementation code here:
        String conexionBD = "jdbc:mysql://127.0.0.1/Sistema_Empleados";
        Connection conexion = null;
        String respuesta = "Consulta NO exitosa";
        String con;
        ResultSet rs;

        try {
            Class.forName("com.mysql.jdbc.Driver");//el driver de mysql
            conexion = DriverManager.getConnection(conexionBD, "root", "");//conexion a la base de datos
            Statement s = conexion.createStatement();
            // JOptionPane.showMessageDialog(null,no+" "+ap);
            con = "SELECT * FROM USUARIOS WHERE id = '" + idUser + "' ";

            rs = s.executeQuery(con);
            {
                while (rs.next()) {
                    idUsername = rs.getString("id");
                    name = rs.getString("nombre_usuario");
                    lastf = rs.getString("apellidop_usuario");
                    lastm = rs.getString("apellidom_usuario");

                    birth = rs.getString("nacimiento_usuario");
                    address = rs.getString("direccion_usuario");
                    respuesta = "Consulta Exitosa";

                    MostrarNombre();
                    MostrarApellidoP();
                    MostrarApellidoM();
                    MostrarNacimiento();
                    MostrarDireccion();
                    break;
                    //JOptionPane.showMessageDialog(null, "si");
                }
            }
        } catch (Exception e) {
            
        }
        return respuesta;
    }

    @WebMethod
    public String MostrarNombre() {
        String nomb;
        nomb = "";
        nomb = name;
        return nomb;

    }
    @WebMethod
  public String MostrarApellidoP(){
      String apellp;
      apellp="";
      apellp=lastf;
      return apellp;

    }

   @WebMethod
     public String MostrarApellidoM(){
      String apellm;
      apellm="";
      apellm=lastm;
      return apellm;

    }

  @WebMethod
  public String MostrarNacimiento(){
      String bir;
      bir="";
      bir=birth;
      return bir;
    }


  @WebMethod
  public String MostrarDireccion(){
      String add;
      add="";
      add=address;
      return add;
    }
}
