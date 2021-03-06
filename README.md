# Đồ án môn học :  ĐIỆN TOÁN ĐÁM MÂY
## Nhóm 2 đề tài 2 sử dụng docker để ảo hóa server Ubuntu </p>
<p>Thành viên</p>
<p>Trần Văn Duy - 19133016</p>
<p>Trần Công Trường - 19133062</p>
<p>Cao Anh Văn - 19133067</p>

## Thực hiện xây dựng website trên eclipse, kiểm tra các chức năng sau đó deloy lên docker trên máy ubuntu ec2
### Các chức năng của đồ án: 
- Một trang web giúp người dùng kết nối tối máy ec2 sau đó thực hiện các chức năng: tạo, thực thi, dừng, xóa, container, tạo image từ container.
- Người dùng có thể đăng kí tài khoản, thực hiện các chức năng của người dùng liên quan đến container, thêm server, xóa server.
- Admin có thể quản lý người dùng, quản lý các container.
- Các container mà nhóm có thể tạo: container ubuntu và container centos.
- Khi người dùng tạo container có thể lựa chọn server, chọn dung lượng ram, số cpu, ...
## Các bước cài đặt 

### Bước 1: Tạo máy ubuntu (cloud9) trên aws, trong đó 1 máy lưu database (bắt buộc) đồng thời làm server, các máy còn lại làm server ( số lượng tùy thích)</p>
  - Trên mỗi máy ubuntu thực hiện lệnh: docker pull sonvo123/os:centos và sonvo123/os:ubuntu ( để thực hiện chức năng tạo container).
  - Nên gán ip cho các máy là elastic ip cho dễ sử dụng. Nếu để private ip thì làm  cho các máy thông nhau.
  - Thông tin các ip được cấu hình trong file config (cần thay đổi cho đúng với EC2 đã tạo).
  - Các máy ubuntu phải dùng chung 1 file .pem.
  ### <img src="src/main/images/config.png">
### Bước 2: Ở một máy Ubuntu vừa tạo, tạo container Sql server để import data. Mỗi lần chạy thì khởi động container sql server lên.</p>
  - Tạo container sql Server.
  - Khởi chạy container.
  - Tạo database trong sql server: database theo cấu trúc data của file usercloud.bacpac.
  - Import dữ liệu vào database: dữ liệu database có thể được import từ file usercloud.bacpac đính kèm.
  ### <img src="src/main/images/database.png">
### Bước 3: Tải project về, thay đổi các thông tin được hướng dẫn theo comment trong file config.java trong package vn.cloud.config<p>
  - Nếu chạy trên máy local thì để đường dẫn file .pem trên máy local.
  - Nếu deloy trên ec 2 thì đổi đường dẫn file .pem trên máy ec2, sau đó build thành file .war.
  - Nếu thực hiện deloy trên máy ec2 thì tạo theo các bước sau:
    1. Tạo thư mục ( tên bất kì trên máy ec2).
    2. Tải file .pem vào thư mục, file .war, và tạo dockerfile.
    3. Cấu hình nội dung dockerfile để deloy: Lưu ý project này chạy trên tomcat 9.
  ### <img src="src/main/images/dockerfile.png">
### Bước 4: Đăng nhập và kiểm tra chức năng
  - Tài khoản admin: admin, 123123.
  - Thực hiện đăng kí để tạo tài khoản user.
  - Một số hình ảnh của giao diện.
  #### Đăng nhập
  ### <img src="src/main/images/dangnhap.png">
  #### Đăng ký
  ### <img src="src/main/images/dangky.png">
  #### Tạo container
  ### <img src="src/main/images/taocontainer.png">
  #### Thêm server
  ### <img src="src/main/images/themserver.png">
  #### Xóa server
  ### <img src="src/main/images/xoaserver.png">
    
