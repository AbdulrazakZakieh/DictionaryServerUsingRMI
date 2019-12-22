
package ServerInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Dictionary extends Remote {
    public String findDefinition(String word) throws RemoteException;
    public static final String LOOKUPNAME = "DictionaryService";
}
