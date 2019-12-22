package server;
import ServerInterface.Dictionary;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Dictionary_Imp extends UnicastRemoteObject implements Dictionary{
    String driverPath="org.sqlite.JDBC";
    String url="jdbc:sqlite:DefinitionsDictionary.db";
    Connection con;
    Statement st;
    //--------------------------------------------------------------------------
    public Dictionary_Imp() throws RemoteException,
                                   ClassNotFoundException, SQLException{
        super();
        Class.forName(driverPath);
        con=DriverManager.getConnection(url);
        st=con.createStatement();
    }
    //--------------------------------------------------------------------------
    @Override
    public String findDefinition (String wantedWord) throws RemoteException {
           try { 
            ResultSet rs;
            String s="SELECT * FROM words WHERE word='"+wantedWord+"'";
            String readRecord;
            String Definition="";
            //....................
            
            rs=st.executeQuery(s);
            //Result Table may contain Multi Definitions(Records)
            while(rs.next())
            {
                readRecord=rs.getString("word")+"["+rs.getString("type")+"]: "
                            +rs.getString("defn")+"\n";
               Definition+=readRecord;
            }
            //...Decision Making and Replay...
            if(Definition.equals(""))
                return ("");
            else
                return Definition;
        } catch (SQLException ex) {
            Logger.getLogger(Dictionary_Imp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Data Base Access Error");
            return("");
        } 
    }
    //--------------------------------------------------------------------------
}           
//*****************************************************************************       
        
        

