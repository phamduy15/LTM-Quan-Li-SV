package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface StudentManagement extends Remote {
    void addStudent(Student s) throws RemoteException;
    void updateStudent(Student s) throws RemoteException;
    void deleteStudent(String id) throws RemoteException;
    List<Student> getAllStudents() throws RemoteException;
}
