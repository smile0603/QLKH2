
with nhap as(
	select tb_PhieuNhap.maSP, sum(tb_PhieuNhap.soLuongNhap) as tongNhap
	from tb_PhieuNhap
	where tb_PhieuNhap.ngayNhap between '2024-10-01' and '2024-10-31'
	group by tb_PhieuNhap.maSP
)
,
xuat as(
	select tb_PhieuXuat.maSP, sum(tb_PhieuXuat.soLuongXuat) as tongXuat
	from tb_PhieuXuat
	where tb_PhieuXuat.ngayXuat between '2024-10-01' and '2024-10-31'
	group by tb_PhieuXuat.maSP
)
,
nhaptruocky as(
	select tb_PhieuNhap.maSP, sum(tb_PhieuNhap.soLuongNhap) as tongNhapTK
	from tb_PhieuNhap
	where tb_PhieuNhap.ngayNhap < '2024-10-2'
	group by tb_PhieuNhap.maSP
),
xuattruocky as(
	select tb_PhieuXuat.maSP, sum(tb_PhieuXuat.soLuongXuat) as tongXuatTK
	from tb_PhieuXuat
	where tb_PhieuXuat.ngayXuat < '2024-10-2'
	group by tb_PhieuXuat.maSP
)
,
tonTK as(
	select  tb_SanPham.maSP,nhaptruocky.tongNhapTK,xuattruocky.tongXuatTK,
	coalesce(nhaptruocky.tongNhapTK,0) - coalesce(xuattruocky.tongXuatTK,0) as tongTonTK,tb_SanPham.tenSP
	from tb_SanPham
	left join nhaptruocky on nhaptruocky.maSP = tb_SanPham.maSP
	left join xuattruocky on xuattruocky.maSP = tb_SanPham.maSP
)
,
ton as(
	select  tb_SanPham.maSP,nhap.tongNhap,xuat.tongXuat,
	coalesce(nhap.tongNhap,0) - coalesce(xuat.tongXuat,0) as tongTon,tb_SanPham.tenSP
	from tb_SanPham
	left join nhap on nhap.maSP = tb_SanPham.maSP
	left join xuat on xuat.maSP = tb_SanPham.maSP
)
select ton.*,tonTK.tongTonTK
from ton, tonTK
where ton.maSP = tonTK.maSP

