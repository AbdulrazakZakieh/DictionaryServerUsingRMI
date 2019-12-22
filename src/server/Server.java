package server;

import ServerInterface.Dictionary;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Server {
static int port=Registry.REGISTRY_PORT;
 public static void main(String[] args) throws RemoteException ,
                    AlreadyBoundException, ClassNotFoundException, SQLException{
   Registry reg = LocateRegistry.createRegistry(port); 
   Dictionary_Imp  dictionary= new Dictionary_Imp();
   reg.bind(Dictionary.LOOKUPNAME, dictionary);
   JOptionPane.showMessageDialog(null, "Dictionary Server has started");
  }
}
