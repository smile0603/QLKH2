use csdl_qlk
with nhap as(
	select tb_PhieuNhap.maSP, sum(tb_PhieuNhap.soLuongNhap) as tongNhap
	from tb_PhieuNhap
	where tb_PhieuNhap.maSP like 'SP002'
	group by tb_PhieuNhap.maSP
)
,
xuat as(
	select tb_PhieuXuat.maSP, sum(tb_PhieuXuat.soLuongXuat) as tongXuat
	from tb_PhieuXuat
	where tb_PhieuXuat.maSP like 'SP002'
	group by tb_PhieuXuat.maSP
)
,
ngaynhap as(
	select tb_PhieuNhap.ngayNhap
	from tb_PhieuNhap
	where tb_PhieuNhap.maSP like 'SP002'
)
,
ngayxuat as(
	select tb_PhieuXuat.ngayXuat
	from tb_PhieuXuat
	where tb_PhieuXuat.maSP like 'SP002'
)
,
ton as(
	select  tb_SanPham.maSP,nhap.tongNhap,xuat.tongXuat,
	coalesce(nhap.tongNhap,0) - coalesce(xuat.tongXuat,0) as tongTon,tb_SanPham.tenSP
	from tb_SanPham
	left join nhap on nhap.maSP = tb_SanPham.maSP
	left join xuat on xuat.maSP = tb_SanPham.maSP
)
select ton.*
from ton
where ton.maSP like 'SP002'