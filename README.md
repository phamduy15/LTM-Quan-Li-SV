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
  
<img width="600" height="300" alt="image" src="https://github.com/user-attachments/assets/3d3c5524-df8f-463f-8268-d3da2fd65928" />


- **Cập nhật thông tin sinh viên**
  
<img width="600" height="300" alt="image" src="https://github.com/user-attachments/assets/8ceae136-2ef4-4da0-ad41-0cbf5bf04154" />


- **Tìm kiếm sinh viên theo ID và tên**
  
<img width="600" height="300" alt="image" src="https://github.com/user-attachments/assets/9db424e3-1c97-432a-bd11-833abfe1cec8" />


- Hiển thị danh sách sinh viên  

## 🏗️ 4. Kiến trúc hệ thống
- **Server**: cung cấp dịch vụ quản lý sinh viên qua RMI  
- **Client**: ứng dụng giao diện Swing gọi phương thức từ xa trên server  
- **Student**: lớp đối tượng mô tả thông tin sinh viên (id, name, age, email)  
- **StudentManagement**: interface định nghĩa các phương thức RMI  
- **StudentManagementImpl**: cài đặt interface, xử lý dữ liệu  

## 🎯 5. Mục tiêu học tập
- Hiểu và triển khai mô hình Client/Server với RMI  
- Biết cách đăng ký và sử dụng dịch vụ trong RMI Registry  
- Thực hành gọi phương thức từ xa và xử lý lỗi trong ứng dụng phân tán  

## 📝 6. License
Tài liệu và mã nguồn thuộc bản quyền của **AIoTLab, Khoa Công nghệ Thông tin, Đại học Đại Nam (DaiNam University)**.  

Người học được phép:
- Sử dụng mã nguồn cho mục đích học tập và nghiên cứu.  
- Chỉnh sửa và mở rộng để phục vụ bài tập, đồ án, hoặc nghiên cứu cá nhân.
  
© 2025 AIoTLab, Faculty of Information Technology, DaiNam University.
