package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Properties.DienMay;
import Properties.SanhSu;
import Properties.ThucPham;

public class Main {
	
	static List<DienMay> listDM = new ArrayList<DienMay>();
	static List<SanhSu> listSS = new ArrayList<SanhSu>();
	static List<ThucPham> listTP = new ArrayList<ThucPham>();
	
	static Random rd = new Random();
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		String[] listTenDM = {"Máy xay sinh tố","Máy cạo râu","Máy ép hoa quả","Máy bơm nước","Quạt máy"};
		String[] listTenNhaSXDM = {"Điện máy xanh", "Co.op Mart", "Điện máy Chợ Lớn", "Điện máy Nguyễn Kim"};
		
		String[] listTenTP = {"Canh Chua", "Thịt Kho", "Cá Chiên", "Bún đậu mắm tôm", "Chả cá"};
		String[] listTenNhaSXTP = {"Quán ăn cô hai", "Cơm tam kỳ", "Quán ăn một nhà", "Quán ăn sinh viên"};
		
		String[] listTenSS = {"Chậu sứ", "Chén sứ", "Tô sứ", "Muỗng sứ", "Đĩa sứ"};
		String[] listTenNhaSXSS = {"Co.op Mart", "E-Mart", "Sành Sứ Đông Nam", "Cửa hành sành sứ"};
		
//		LocalDate date = LocalDate.parse("2020-05-03");
//		date = date.plusMonths(36);
//		System.out.println(date);
		LocalDate date;
		for (int i = 0; i < 10; i++) {
			int year = rd.nextInt();
			int month = rd.nextInt();
			int day = rd.nextInt();
			if (month == 2 && day > 28) 
				day -= rd.nextInt(26)+1;
			date = LocalDate.parse(Integer.toString(year)+"-"+Integer.toString(month)+"-"+Integer.toString(day));
			
			long id = rd.nextLong();
			for (int j = 0; j < listDM.size(); j++) {
				if (id == listDM.get(j).getId()) {
					id = rd.nextLong();
					j = -1;
				}
			}
			
			
			
			year = rd.nextInt();
			month = rd.nextInt();
			day = rd.nextInt();
			if (month == 2 && day > 28) 
				day -= rd.nextInt(26)+1;
			date = LocalDate.parse(Integer.toString(year)+"-"+Integer.toString(month)+"-"+Integer.toString(day));
			
			
			
			year = rd.nextInt();
			month = rd.nextInt();
			day = rd.nextInt();
			if (month == 2 && day > 28) 
				day -= rd.nextInt(26)+1;
			date = LocalDate.parse(Integer.toString(year)+"-"+Integer.toString(month)+"-"+Integer.toString(day));
		}
		
		
		
		while (true) {
			System.out.println("-------------Hãy lựa chọn chức năng:-------");
			System.out.println("1: Thêm hàng hóa");
			System.out.println("2: Xóa hàng");
			System.out.println("3: Sửa thông tin hàng");
			System.out.println("4: Tính trung bình thành tiền các hóa đơn thuê phòng trong tháng 9/2013");
			
			int luachon = input.nextInt();
			
			switch (luachon) {
			case 1:
				ThemHang(); break;
				
			case 2:
				XoaHang(); break;
				
			case 3:
				XuaTTHang(); break;
			default:
				break;
			}
			
		}
		
		
		
		
	}
	
	static void ThemHang() {
		System.out.print("Chọn loại hàng muốn thêm	1: Điện máy	2: Sành sứ	3: Thực phẩm: "); int luachon = input.nextInt();
		long id = rd.nextLong();
		if (luachon == 1) {
			for (int i = 0; i < listDM.size(); i++) {
				if (id == listDM.get(i).getId()) {
					id = rd.nextLong();
					i = -1;
				}
			}
			
			System.out.print("Tên hàng: "); String name = input.nextLine();
			System.out.println("Nhà suản xuất: "); String nameNhaSX = input.nextLine();
			System.out.println("Thời gian bảo hành (tháng): "); int timeBaoHanh = input.nextInt();
			System.out.println("Công xuất máy: "); int congXuat = input.nextInt();
			System.out.print("Số lượng: "); int itemCount = input.nextInt();
			DienMay a = new DienMay(id, name, itemCount, timeBaoHanh, congXuat, nameNhaSX);
			listDM.add(a);
		}else if (luachon == 2) {
			
		}else if (luachon == 3) {
			
		}
	}
	
	static void XoaHang() {
		listDM = null;
	}
	
	static void XuaTTHang() {
		
	}
}
