# Đồ án Cloud
## Nhóm 2 đề tài 2 sử dụng docker để ảo hóa server Ubuntu </p>
<p>Thành viên</p>
<p>Trần Văn Duy - 19133016</p>
<p>Trần Công Trường - 19133062</p>
<p>Cao Anh Văn - 19133067</p>

## Thực hiện xây dựng website trên eclipse, kiểm tra các chức năng sau đó deloy lên docker trên máy ubuntu ec2
## Các bước cài đặt 
<p>Bước 1: Tạo máy ubuntu (cloud9) trên aws, trong đó 1 máy lưu database(bắt buộc) đồng thời làm server, các máy còn lại làm server ( số lượng tùy thích)</p>
* Trên mỗi máy ubuntu thực hiện lệnh: docker pull sonvo123/os:centos và sonvo123/os:ubuntu
<p>Bước 2: Ở một máy Ubuntu vừa tạo, tạo container Sql server để import data. Mỗi lần chạy thì khởi động container sql server lên.</p>
* Tạo container sql Server
* Khởi chạy container
* Tạo database trong sql server: database theo cấu trúc data của file usercloud.bacpac
* Import dữ liệu vào database: dữ liệu database có thể được import từ file usercloud.bacpac đính kèm
<p>Bước 3: Tải project về, thay đổi các thông tin được hướng dẫn theo comment trong file config.java trong package vn.cloud.config<p>
<p>docker pull sonvo123/os:centos</p>
<p>Bước 1: tạo 1 container sql và import database đính kèm trong github usercloud trên ec2</p>
<p>Bước 2: chạy container sql</p>
<p>Bước 3: trông phần src/main/java</p>
<p>phần vn.cloud.config thay đổi các thông số chúng em đã ghi chú ở file Config.java</p>
<p>(Nếu deploy trên ec2 thì thay đổi bằng ip private và tải file key lên ec2 và thay đổi path của key)</p>
<p>Bước 5: Tạo tài khoản hoặc kiểm tra database để lấy tài khoản (role =1 là quyền quản trị)</p>
<p>Nếu deloy bằng bằng file .war thì trong dockerfile, cấu hình để chạy trên tomcat 9

<p>Thông tin đăng nhập username: congtruong, pass: 123123, người dùng này đăng nhập với vai trò user </p>
