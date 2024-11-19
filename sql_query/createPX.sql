USE CSDL_QLK;
CREATE TABLE tb_PhieuXuat(
maPX int IDENTITY(1, 1) PRIMARY KEY, 
maSP nvarchar(50),
maNCC int,
maNV nvarchar(50),
ngayXuat Date,
soLuong int,
donGia float,
chietKhau float,
thanhTien float,
ghiChu nvarchar(50)
);