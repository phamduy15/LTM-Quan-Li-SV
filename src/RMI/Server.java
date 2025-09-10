package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            StudentManagementImpl obj = new StudentManagementImpl();
            Naming.rebind("rmi://localhost/StudentService", obj);
            System.out.println("✅ Server is running at rmi://localhost/StudentService");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
