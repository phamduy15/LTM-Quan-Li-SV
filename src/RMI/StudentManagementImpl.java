package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;
import java.util.*;

public class StudentManagementImpl extends UnicastRemoteObject implements StudentManagement {
    private List<Student> students = new ArrayList<>();
    private final String FILE_NAME = "students.txt";

    public StudentManagementImpl() throws RemoteException {
        super();
        loadFromFile();
    }

    @Override
    public void addStudent(Student s) throws RemoteException {
        students.add(s);
        saveToFile();
    }

    @Override
    public void updateStudent(Student s) throws RemoteException {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(s.getId())) {
                students.set(i, s);
                break;
            }
        }
        saveToFile();
    }

    @Override
    public void deleteStudent(String id) throws RemoteException {
        students.removeIf(s -> s.getId().equals(id));
        saveToFile();
    }

    @Override
    public List<Student> getAllStudents() throws RemoteException {
        return students;
    }

    private void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                pw.println(s.toFileString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        File f = new File(FILE_NAME);
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                students.add(Student.fromString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
