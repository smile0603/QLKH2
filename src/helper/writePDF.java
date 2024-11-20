package helper;

import DAO.NhaCungCapDAO;
import DAO.PhieuNhapDAO;
import DAO.PhieuXuatDAO;
import DAO.ThongKeDAO;
import com.itextpdf.text.Chunk;
import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entity.PhieuNhap;
import entity.PhieuXuat;
import entity.ThongKeNgay;
import java.sql.Date;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class writePDF {
    Locale locale = new Locale("vi","VN");
    NumberFormat format = NumberFormat.getCurrencyInstance(locale);

    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");
    Document document = new Document();
    FileOutputStream file;
    JFrame jf = new JFrame();
    FileDialog fd = new FileDialog(jf, "Xuất pdf", FileDialog.SAVE);
    Font fontNormal10;
    Font fontBold10;
    Font fontBold15;
    Font fontBold25;
    Font fontBoldItalic15;
    PhieuNhapDAO phieuNhapDAO = new PhieuNhapDAO();
    ThongKeDAO thongKeDAO = new ThongKeDAO();
    PhieuXuatDAO phieuXuatDAO = new PhieuXuatDAO();
    public writePDF() {
        try {
            fontNormal10 = new Font(BaseFont.createFont("font/TimesNewRoman/SVN-Times New Roman.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 12, Font.NORMAL);
            fontBold25 = new Font(BaseFont.createFont("font/TimesNewRoman/SVN-Times New Roman Bold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 25, Font.NORMAL);
            fontBold15 = new Font(BaseFont.createFont("font/TimesNewRoman/SVN-Times New Roman Bold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 15, Font.NORMAL);
            fontBold10 = new Font(BaseFont.createFont("font/TimesNewRoman/SVN-Times New Roman Bold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 12, Font.NORMAL);
            fontBoldItalic15 = new Font(BaseFont.createFont("font/TimesNewRoman/SVN-Times New Roman Bold Italic.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 15, Font.NORMAL);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(writePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void chooseURL(String url) {
        try {
            document.close();
            document = new Document();
            file = new FileOutputStream(url);
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Khong tim thay duong dan file " + url);
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Khong goi duoc document !");
        }
    }

    public void setTitle(String title) {
        try {
            Paragraph pdfTitle = new Paragraph(new Phrase(title, fontBold25));
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(pdfTitle);
            document.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }

    private String getFile(String name) {
        fd.pack();
        fd.setSize(800, 600);
        fd.validate();
        Rectangle rect = jf.getContentPane().getBounds();
        double width = fd.getBounds().getWidth();
        double height = fd.getBounds().getHeight();
        double x = rect.getCenterX() - (width / 2);
        double y = rect.getCenterY() - (height / 2);
        Point leftCorner = new Point();
        leftCorner.setLocation(x, y);
        fd.setLocation(leftCorner);
        fd.setFile(name);
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("null")) {
            return null;
        }
        return url;
    }

    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static Chunk createWhiteSpace(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(" ");
        }
        return new Chunk(builder.toString());
    }

    public void writeThongKe(Date dateFrom, Date dateTo) {
        String url = "";
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String tuNgay = dateFrom == null ? "" : df.format(dateFrom);
        String denNgay = dateTo == null ? "" : df.format(dateTo);
        try {
            fd.setTitle("In thống kê");
            fd.setLocationRelativeTo(null);
            url = getFile("thongke" + tuNgay + "den" + denNgay);
            if (url.equals("nullnull")) {
                return;
            }
            url = url + ".pdf";
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();

            Paragraph company = new Paragraph("THÔNG TIN PHIẾU THỐNG KÊ", fontBold15);
            company.add(new Chunk(createWhiteSpace(20)));
            Date today = new Date(System.currentTimeMillis());
            company.add(new Chunk("Thời gian in phiếu: " + formatDate.format(today), fontNormal10));
            company.setAlignment(Element.ALIGN_LEFT);
            document.add(company);
            // Thêm tên công ty vào file PDF
            document.add(Chunk.NEWLINE);
            Paragraph header = new Paragraph("Thống kê từ ngày: " + tuNgay + " đến " + denNgay, fontBoldItalic15);
            header.setAlignment(Element.ALIGN_LEFT);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(header);

            // Thêm table 7 cột vào file PDF
            PdfPTable table = new PdfPTable(7);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{25f, 25f, 25f, 15f, 20f, 20f, 15f});
            PdfPCell cell;
            document.add(Chunk.NEWLINE);
            table.addCell(new PdfPCell(new Phrase("Mã SP", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Tên SP", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Tồn đầu kì", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("SL Nhập", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("SL Xuất", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Tồn trong kì", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Tổng tồn", fontBold15)));
            for (int i = 0; i < 7; i++) {
                cell = new PdfPCell(new Phrase(""));
                table.addCell(cell);
            }
            //Truyen thong tin tung chi tiet vao table
            List<ThongKeNgay> listTK = thongKeDAO.getThongKeTuNgay(dateFrom, dateTo);

            for (ThongKeNgay tk : listTK) {
                String maSP = tk.getSanPham().getMaSP();
                String tenSP = tk.getSanPham().getTenSP();
                int tonDauKy = tk.getTonDauKy();
                int tonCuoiKy = tk.getTonCuoiKy();
                int slNhap = tk.getTongNhap();
                int slXuat = tk.getTongXuat();
                int tongTon = tk.getTongTon();
                table.addCell(new PdfPCell(new Phrase(maSP, fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(tenSP, fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(Integer.toString(tonDauKy), fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(Integer.toString(slNhap), fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(Integer.toString(slXuat), fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(Integer.toString(tonCuoiKy), fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(Integer.toString(tongTon), fontNormal10)));

            }
            document.add(table);
            document.add(Chunk.NEWLINE);

            Paragraph paragraph = new Paragraph();
            paragraph.setIndentationLeft(22);
            paragraph.add(new Chunk("Người lập phiếu", fontBoldItalic15));
            Paragraph sign = new Paragraph();
            sign.setIndentationLeft(23);
            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
            document.add(paragraph);
            document.add(sign);
            document.close();
            writer.close();
            openFile(url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        }

    }

    public void writePhieuNhap(int ma) {
        String url = "";
        try {
            fd.setTitle("In phiếu nhập");
            fd.setLocationRelativeTo(null);
            url = getFile("phieunhap" + ma);
            if (url.equals("nullnull")) {
                return;
            }
            url = url + ".pdf";
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();

            Paragraph company = new Paragraph("THÔNG TIN PHIẾU NHẬP", fontBold15);
            company.add(new Chunk(createWhiteSpace(20)));
            Date today = new Date(System.currentTimeMillis());
            company.add(new Chunk("Thời gian in phiếu: " + formatDate.format(today), fontNormal10));
            company.setAlignment(Element.ALIGN_LEFT);
            document.add(company);
            // Thêm tên công ty vào file PDF
            document.add(Chunk.NEWLINE);

            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);

            
            PhieuNhap pn = phieuNhapDAO.getPhieuNhapTheoMa(ma);
            // Thêm dòng Paragraph vào file PDF
            Paragraph paragraph1 = new Paragraph("Mã phiếu: PN-" + pn.getMaPN(), fontNormal10);
            Paragraph paragraph2 = new Paragraph("Mã SP: " + pn.getSanPham().getMaSP(), fontNormal10);
            Paragraph paragraph3 = new Paragraph("Nhà cung cấp: " + pn.getNhaCungCap().getTenNCC(), fontNormal10);
            paragraph3.add(new Chunk(createWhiteSpace(5)));
            paragraph3.add(new Chunk(createWhiteSpace(5)));
            paragraph3.add(new Chunk("Địa chỉ NCC: " + pn.getNhaCungCap().getDiaChi(), fontNormal10));

            Paragraph paragraph4 = new Paragraph("Người thực hiện: " + pn.getNhanVien().getTenNV(), fontNormal10);
            paragraph4.add(new Chunk(createWhiteSpace(5)));

            document.add(paragraph1);
            document.add(paragraph2);
            document.add(paragraph3);
            document.add(paragraph4);
            document.add(Chunk.NEWLINE);
            // Thêm table 10 cột vào file PDF
            PdfPTable table = new PdfPTable(8);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{20f, 25f, 30f, 25f, 30f, 20f, 40f, 20f});
            PdfPCell cell;
            document.add(Chunk.NEWLINE);
            table.addCell(new PdfPCell(new Phrase("Mã PN", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Tên SP", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Ngày nhập", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Số lượng", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Đơn giá", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Chiết khấu", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Thành tiền", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Ghi chú", fontBold15)));

            for (int i = 0; i < 8; i++) {
                cell = new PdfPCell(new Phrase(""));
                table.addCell(cell);
            }
            //Truyen thong tin tung chi tiet vao table

                int maPN = pn.getMaPN();
                String tenPN = pn.getSanPham().getTenSP();
                Date ngayNhap = pn.getNgayNhap();
                int soLuong = pn.getSoLuong();
                double donGia = pn.getDonGia();
                double chietKhau = pn.getChietKhau();
                double thanhTien = pn.getThanhTien();
                String ghiChu = pn.getGhiChu();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String strNgayNhap = ngayNhap == null ? "" : df.format(ngayNhap);
                table.addCell(new PdfPCell(new Phrase(Integer.toString(maPN), fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(tenPN, fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(strNgayNhap, fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(Integer.toString(soLuong), fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(format.format(donGia) + " vnd", fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(Double.toString(chietKhau)+" %", fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(format.format(thanhTien) +" vnd", fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(ghiChu, fontNormal10)));
            
            document.add(table);
            document.add(Chunk.NEWLINE);

            Paragraph paragraph = new Paragraph();
            paragraph.setIndentationLeft(22);
            paragraph.add(new Chunk("Người lập phiếu", fontBoldItalic15));
            paragraph.add(new Chunk(createWhiteSpace(30)));
            paragraph.add(new Chunk("Nhân viên nhận", fontBoldItalic15));
            paragraph.add(new Chunk(createWhiteSpace(30)));
            paragraph.add(new Chunk("Nhà cung cấp", fontBoldItalic15));
            Paragraph sign = new Paragraph();
            sign.setIndentationLeft(23);
            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
            sign.add(new Chunk(createWhiteSpace(30)));
            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
            sign.add(new Chunk(createWhiteSpace(28)));
            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
            document.add(paragraph);
            document.add(sign);
            document.close();
            writer.close();
            openFile(url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        }

    }
    public void writePhieuXuat(int ma) {
        String url = "";
        try {
            fd.setTitle("In phiếu xuất");
            fd.setLocationRelativeTo(null);
            url = getFile("phieuxuat" + ma);
            if (url.equals("nullnull")) {
                return;
            }
            url = url + ".pdf";
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();

            Paragraph company = new Paragraph("THÔNG TIN PHIẾU XUẤT", fontBold15);
            company.add(new Chunk(createWhiteSpace(20)));
            Date today = new Date(System.currentTimeMillis());
            company.add(new Chunk("Thời gian in phiếu: " + formatDate.format(today), fontNormal10));
            company.setAlignment(Element.ALIGN_LEFT);
            document.add(company);
            // Thêm tên công ty vào file PDF
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            
            PhieuXuat px = phieuXuatDAO.getPhieuXuatTheoMa(ma);
            // Thêm dòng Paragraph vào file PDF
            Paragraph paragraph1 = new Paragraph("Mã phiếu: PX-" + px.getMaPX(), fontNormal10);
            Paragraph paragraph2 = new Paragraph("Mã sản phẩm: " + px.getSanPham().getMaSP(), fontNormal10);
            Paragraph paragraph3 = new Paragraph("Nhà cung cấp: " + px.getNhaCungCap().getTenNCC(), fontNormal10);
            paragraph3.add(new Chunk(createWhiteSpace(5)));
            paragraph3.add(new Chunk(createWhiteSpace(5)));
            paragraph3.add(new Chunk("Địa chỉ NCC: " + px.getNhaCungCap().getDiaChi(), fontNormal10));
            Paragraph paragraph4 = new Paragraph("Người thực hiện: " + px.getNhanVien().getTenNV(), fontNormal10);
            Paragraph paragraph5 = new Paragraph("Khách hàng: " + px.getKhachHang().getTenKH(),fontNormal10);
            
            paragraph4.add(new Chunk(createWhiteSpace(5)));
            document.add(paragraph1);
            document.add(paragraph2);
            document.add(paragraph3);
            document.add(paragraph4);
            document.add(paragraph5);
            document.add(Chunk.NEWLINE);
            // Thêm table 10 cột vào file PDF
            PdfPTable table = new PdfPTable(8);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{20f, 25f, 30f, 25f, 30f, 20f, 40f, 20f});
            PdfPCell cell;
            document.add(Chunk.NEWLINE);
            table.addCell(new PdfPCell(new Phrase("Mã PX", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Tên SP", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Ngày nhập", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Số lượng", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Đơn giá", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Chiết khấu", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Thành tiền", fontBold15)));
            table.addCell(new PdfPCell(new Phrase("Ghi chú", fontBold15)));
            
            
            for (int i = 0; i < 8; i++) {
                cell = new PdfPCell(new Phrase(""));
                table.addCell(cell);
            }
            //Truyen thong tin tung chi tiet vao table
            

            
                int maPX = px.getMaPX();
                String tenSP = px.getSanPham().getTenSP();
                Date ngayXuat = px.getNgayXuat();
                int soLuong = px.getSoLuong();
                double donGia = px.getDonGia();
                double chietKhau = px.getChietKhau();
                double thanhTien = px.getThanhTien();
                String ghiChu = px.getGhiChu();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String strNgayXuat = ngayXuat == null ? "" : df.format(ngayXuat);
                table.addCell(new PdfPCell(new Phrase(Integer.toString(maPX), fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(tenSP, fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(strNgayXuat, fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(Integer.toString(soLuong), fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(format.format(donGia) + " vnd", fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(Double.toString(chietKhau)+" %", fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(format.format(thanhTien) +" vnd", fontNormal10)));
                table.addCell(new PdfPCell(new Phrase(ghiChu, fontNormal10)));
            
            document.add(table);
            document.add(Chunk.NEWLINE);

            Paragraph paragraph = new Paragraph();
            paragraph.setIndentationLeft(22);
            paragraph.add(new Chunk("Người lập phiếu", fontBoldItalic15));
            paragraph.add(new Chunk(createWhiteSpace(30)));
            paragraph.add(new Chunk("Nhân viên nhận", fontBoldItalic15));
            paragraph.add(new Chunk(createWhiteSpace(30)));
            paragraph.add(new Chunk("Khách hàng", fontBoldItalic15));
            Paragraph sign = new Paragraph();
            sign.setIndentationLeft(23);
            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
            sign.add(new Chunk(createWhiteSpace(30)));
            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
            sign.add(new Chunk(createWhiteSpace(28)));
            sign.add(new Chunk("(Ký và ghi rõ họ tên)", fontNormal10));
            document.add(paragraph);
            document.add(sign);
            document.close();
            writer.close();
            openFile(url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        }

    }

}
