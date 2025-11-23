<h2 align="center">
    <a href="https://dainam.edu.vn/vi/khoa-cong-nghe-thong-tin">
    🎓 Faculty of Information Technology (DaiNam University)
    </a>
</h2>
<h2 align="center">
   QUẢN LÍ SINH VIÊN BẰNG RMI
</h2>
<div align="center">
    <p align="center">
        <img src="docs/aiotlab_logo.png" alt="AIoTLab Logo" width="170"/>
        <img src="docs/fitdnu_logo.png" alt="AIoTLab Logo" width="180"/>
        <img src="docs/dnu_logo.png" alt="DaiNam University Logo" width="200"/>
    </p>

[![AIoTLab](https://img.shields.io/badge/AIoTLab-green?style=for-the-badge)](https://www.facebook.com/DNUAIoTLab)
[![Faculty of Information Technology](https://img.shields.io/badge/Faculty%20of%20Information%20Technology-blue?style=for-the-badge)](https://dainam.edu.vn/vi/khoa-cong-nghe-thong-tin)
[![DaiNam University](https://img.shields.io/badge/DaiNam%20University-orange?style=for-the-badge)](https://dainam.edu.vn)

</div>

## 📖 1. Giới thiệu
Đề tài “Quản lý sinh viên bằng RMI” được xây dựng nhằm áp dụng công nghệ Java RMI (Remote Method Invocation) trong lập trình phân tán. Hệ thống hoạt động theo mô hình Client–Server, trong đó server quản lý dữ liệu sinh viên và cung cấp các chức năng thêm, sửa, xóa, tìm kiếm; còn client kết nối từ xa để gọi các phương thức thông qua giao thức JRMP trên TCP/IP. Đề tài giúp hiểu rõ cách truyền đối tượng qua mạng bằng RMI, đồng thời rèn luyện kỹ năng lập trình hướng đối tượng và xây dựng ứng dụng quản lý đơn giản nhưng mang tính phân tán.
## 🔧 2. Công nghệ sử dụng
- Java  
- Java RMI (Remote Method Invocation)  
- Giao diện Client viết bằng Java Swing  
- Dữ liệu lưu trữ tạm thời bằng danh sách (List), có thể mở rộng sang File/Database  

## 🚀 3. Chức năng chính
- **Thêm sinh viên mới**

  <img width="1350" height="782" alt="image" src="https://github.com/user-attachments/assets/4d843450-c146-402d-bb89-0b430a0c94e3" />

- **Cập nhật thông tin sinh viên**

  <img width="562" height="433" alt="image" src="https://github.com/user-attachments/assets/c45699d8-b804-4870-a158-dedec1b089c7" />

- **Chi tiết thông tin sinh viên**

  <img width="1020" height="677" alt="image" src="https://github.com/user-attachments/assets/36220ea8-1af3-47d4-b5e3-290873384271" />

- **Học phần, thêm học phần**

  <img width="1352" height="772" alt="image" src="https://github.com/user-attachments/assets/5562239e-e35c-483f-b40f-6934245d6b03" />

- **Điểm học phần**

  <img width="1349" height="777" alt="image" src="https://github.com/user-attachments/assets/f11f8801-2654-4b41-9d33-1d51ad454c5b" />

- **Chuyên cần**

  <img width="1349" height="778" alt="image" src="https://github.com/user-attachments/assets/7e2bce50-e851-467f-b3d3-1e90f168c7c7" />


## 🏗️ 4. Kiến trúc hệ thống
- **Server**: cung cấp dịch vụ quản lý sinh viên qua RMI  
- **Client**: ứng dụng giao diện Swing gọi phương thức từ xa trên server  
- **Student**: lớp đối tượng mô tả thông tin sinh viên (id, name, age, email)  
- **StudentManagement**: interface định nghĩa các phương thức RMI  
- **StudentManagementImpl**: cài đặt interface, xử lý dữ liệu

<img width="300" height="200" alt="image" src="https://github.com/user-attachments/assets/2413a339-7d32-4e7b-95d6-4b4da9952089" />

## 🎯 5. Mục tiêu học tập
- Hiểu và triển khai mô hình Client/Server với RMI  
- Biết cách đăng ký và sử dụng dịch vụ trong RMI Registry  
- Thực hành gọi phương thức từ xa và xử lý lỗi trong ứng dụng phân tán  

## 📝 6. License
Tài liệu và mã nguồn thuộc bản quyền của **AIoTLab, Khoa Công nghệ Thông tin, Đại học Đại Nam (DaiNam University)**.  

Người học được phép:
- Sử dụng mã nguồn cho mục đích học tập và nghiên cứu.  
- Chỉnh sửa và mở rộng để phục vụ bài tập, đồ án, hoặc nghiên cứu cá nhân.

## Thông tin cá nhân
**Họ tên**: Phạm Văn Duy.  
**Lớp**: CNTT 16-03.  
**Email**: phamvanduy150104@gmail.com.

  
© 2025 AIoTLab, Faculty of Information Technology, DaiNam University.
