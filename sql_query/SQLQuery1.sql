use csdl_qlk
select tb_PhieuNhap.maSP,tb_SanPham.tenSP, tb_PhieuNhap.maNCC,tb_NCC.tenNCC, tb_PhieuNhap.ngayNhap,tb_PhieuNhap.soLuongNhap,tb_PhieuNhap.donGia,tb_PhieuNhap.chietKhau
	from tb_PhieuNhap,tb_SanPham,tb_NCC

	where tb_PhieuNhap.maSP like 'SP002'