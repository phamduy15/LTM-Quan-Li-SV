package RMI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;

public class Client extends JFrame {
    private StudentManagement service;
    private DefaultTableModel model;
    private JTable table;
    private JTextField txtId, txtName, txtAge, txtEmail;
    private JButton btnSave;

    public Client() {
        try {
            service = (StudentManagement) Naming.lookup("rmi://localhost/StudentService");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "❌ Không kết nối được tới Server!");
            System.exit(0);
        }

        setTitle("Quản Lý Sinh Viên");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setFont(new Font("Arial", Font.PLAIN, 14));

        model = new DefaultTableModel(new String[]{"ID", "Tên", "Tuổi", "Email"}, 0);
        table = new JTable(model);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.setSelectionBackground(new Color(173, 216, 230));
        table.setSelectionForeground(Color.BLACK);

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        formPanel.setBackground(new Color(245, 245, 245));
        formPanel.add(createLabel("ID:"));
        txtId = createTextField();
        formPanel.add(txtId);
        formPanel.add(createLabel("Tên:"));
        txtName = createTextField();
        formPanel.add(txtName);
        formPanel.add(createLabel("Tuổi:"));
        txtAge = createTextField();
        formPanel.add(txtAge);
        formPanel.add(createLabel("Email:"));
        txtEmail = createTextField();
        formPanel.add(txtEmail);

        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.add(formPanel, BorderLayout.CENTER);

        JButton btnAdd = createButton("Thêm");
        JButton btnUpdate = createButton("Sửa");
        JButton btnDelete = createButton("Xóa");
        JButton btnSearch = createButton("Tìm kiếm");
        btnSave = createButton("Lưu");
        btnSave.setVisible(false);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttons.setBackground(new Color(245, 245, 245));
        buttons.add(btnAdd);
        buttons.add(btnUpdate);
        buttons.add(btnDelete);
        buttons.add(btnSearch);
        buttons.add(btnSave);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(Color.WHITE);

        add(scrollPane, BorderLayout.CENTER);
        add(northPanel, BorderLayout.NORTH);
        add(buttons, BorderLayout.SOUTH);

        loadStudents();
btnAdd.addActionListener(e -> addStudent());
        btnUpdate.addActionListener(e -> startEdit());
        btnDelete.addActionListener(e -> deleteStudent());
        btnSearch.addActionListener(e -> openSearchDialog());
        btnSave.addActionListener(e -> saveUpdate());

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    fillStudentInfo(row);
                }
            }
        });
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        return label;
    }

    private JTextField createTextField() {
        JTextField field = new JTextField();
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createLineBorder(new Color(169, 169, 169)));
        return field;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setPreferredSize(new Dimension(100, 35));
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        return button;
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
            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm sinh viên: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void startEdit() {
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên để sửa!");
            return;
        }
        fillStudentInfo(row);
        btnSave.setVisible(true);
    }

    private void saveUpdate() {
        try {
            Student s = new Student(txtId.getText(), txtName.getText(),
                    Integer.parseInt(txtAge.getText()), txtEmail.getText());
            service.updateStudent(s);
            loadStudents();
            clearFields();
            btnSave.setVisible(false);
        } catch (Exception e) {
JOptionPane.showMessageDialog(this, "Lỗi khi sửa sinh viên: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void deleteStudent() {
        try {
            int row = table.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên để xóa!");
                return;
            }
            String id = model.getValueAt(row, 0).toString();
            service.deleteStudent(id);
            loadStudents();
            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi xóa sinh viên: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void openSearchDialog() {
        JDialog searchDialog = new JDialog(this, "Tìm Kiếm Sinh Viên", true);
        searchDialog.setSize(600, 150); // Giảm chiều cao do chỉ có 2 trường
        searchDialog.setLocationRelativeTo(this);

        JPanel searchForm = new JPanel(new GridLayout(2, 2, 10, 10)); // Chỉ cần 2 hàng
        searchForm.setBorder(new EmptyBorder(10, 10, 10, 10));
        searchForm.add(createLabel("ID:"));
        JTextField searchId = createTextField();
        searchForm.add(searchId);
        searchForm.add(createLabel("Tên:"));
        JTextField searchName = createTextField();
        searchForm.add(searchName);

        JButton btnPerformSearch = createButton("Tìm");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(btnPerformSearch);

        searchDialog.add(searchForm, BorderLayout.CENTER);
        searchDialog.add(buttonPanel, BorderLayout.SOUTH);

        btnPerformSearch.addActionListener(e -> {
            searchDialog.dispose();
            performSearchAndShowResults(searchId.getText(), searchName.getText());
        });

        searchDialog.setVisible(true);
    }

    private void performSearchAndShowResults(String id, String name) {
        try {
            List<Student> allStudents = service.getAllStudents();
            List<Student> filtered = new ArrayList<>();
            String lowerId = id.trim().toLowerCase();
            String lowerName = name.trim().toLowerCase();

            for (Student s : allStudents) {
                boolean matches = true;
                if (!lowerId.isEmpty() && !s.getId().toLowerCase().contains(lowerId)) matches = false;
                if (!lowerName.isEmpty() && !s.getName().toLowerCase().contains(lowerName)) matches = false;
                if (matches) filtered.add(s);
            }

            if (filtered.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy sinh viên phù hợp!");
                return;
            }

            JDialog resultsDialog = new JDialog(this, "Kết Quả Tìm Kiếm", true);
            resultsDialog.setSize(600, 400);
            resultsDialog.setLocationRelativeTo(this);
DefaultTableModel resultsModel = new DefaultTableModel(new String[]{"ID", "Tên", "Tuổi", "Email"}, 0);
            JTable resultsTable = new JTable(resultsModel);
            resultsTable.setFont(new Font("Arial", Font.PLAIN, 14));
            resultsTable.setRowHeight(25);
            resultsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

            for (Student s : filtered) {
                resultsModel.addRow(new Object[]{s.getId(), s.getName(), s.getAge(), s.getEmail()});
            }

            JScrollPane scrollPane = new JScrollPane(resultsTable);
            resultsDialog.add(scrollPane, BorderLayout.CENTER);

            JButton btnClose = createButton("Đóng");
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.add(btnClose);
            resultsDialog.add(buttonPanel, BorderLayout.SOUTH);

            btnClose.addActionListener(e -> resultsDialog.dispose());

            resultsDialog.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tìm kiếm: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void fillStudentInfo(int row) {
        txtId.setText(model.getValueAt(row, 0).toString());
        txtName.setText(model.getValueAt(row, 1).toString());
        txtAge.setText(model.getValueAt(row, 2).toString());
        txtEmail.setText(model.getValueAt(row, 3).toString());
    }

    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtAge.setText("");
        txtEmail.setText("");
        table.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Client().setVisible(true));
    }
}
