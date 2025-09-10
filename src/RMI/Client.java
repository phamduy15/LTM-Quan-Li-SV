package RMI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.rmi.Naming;
import java.util.List;

public class Client extends JFrame {
    private StudentManagement service;
    private DefaultTableModel model;
    private JTable table;
    private JTextField txtId, txtName, txtAge, txtEmail;

    public Client() {
        try {
            service = (StudentManagement) Naming.lookup("rmi://localhost/StudentService");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "❌ Không kết nối được tới Server!");
            System.exit(0);
        }

        setTitle("Quản Lý Sinh Viên");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        model = new DefaultTableModel(new String[]{"ID", "Tên", "Tuổi", "Email"}, 0);
        table = new JTable(model);

        JPanel form = new JPanel(new GridLayout(4, 2, 5, 5));
        form.add(new JLabel("ID:"));
        txtId = new JTextField();
        form.add(txtId);
        form.add(new JLabel("Tên:"));
        txtName = new JTextField();
        form.add(txtName);
        form.add(new JLabel("Tuổi:"));
        txtAge = new JTextField();
        form.add(txtAge);
        form.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        form.add(txtEmail);

        JButton btnAdd = new JButton("Thêm");
        JButton btnUpdate = new JButton("Sửa");
        JButton btnDelete = new JButton("Xóa");
        JPanel buttons = new JPanel();
        buttons.add(btnAdd);
        buttons.add(btnUpdate);
        buttons.add(btnDelete);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(form, BorderLayout.NORTH);
        add(buttons, BorderLayout.SOUTH);

        loadStudents();

        btnAdd.addActionListener(e -> addStudent());
        btnUpdate.addActionListener(e -> updateStudent());
        btnDelete.addActionListener(e -> deleteStudent());

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    txtId.setText(model.getValueAt(row, 0).toString());
                    txtName.setText(model.getValueAt(row, 1).toString());
                    txtAge.setText(model.getValueAt(row, 2).toString());
                    txtEmail.setText(model.getValueAt(row, 3).toString());
                }
            }
        });
    }

    private void loadStudents() {
        try {
            model.setRowCount(0);
            List<Student> list = service.getAllStudents();
            for (Student s : list) {
                model.addRow(new Object[]{s.getId(), s.getName(), s.getAge(), s.getEmail()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addStudent() {
        try {
            Student s = new Student(txtId.getText(), txtName.getText(),
                    Integer.parseInt(txtAge.getText()), txtEmail.getText());
            service.addStudent(s);
            loadStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateStudent() {
        try {
            Student s = new Student(txtId.getText(), txtName.getText(),
                    Integer.parseInt(txtAge.getText()), txtEmail.getText());
            service.updateStudent(s);
            loadStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteStudent() {
        try {
            String id = txtId.getText();
            service.deleteStudent(id);
            loadStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Client().setVisible(true));
    }
}
