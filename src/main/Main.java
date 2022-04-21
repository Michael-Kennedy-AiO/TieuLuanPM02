package main;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;
import drivers.DanhSach;

public class Main {
	static Random rdLong = new Random();
	static Random rdInt = new Random();
	static Scanner input = new Scanner(System.in);
	static DanhSach list = new DanhSach();
	
	public static void main(String[] args) {
		String[] listTenDM = {"Máy xay sinh tố","Máy cạo râu","Máy ép hoa quả","Máy bơm nước","Quạt máy"};
		String[] listTenNhaSXDM = {"Điện máy xanh", "Co.op Mart", "Điện máy Chợ Lớn", "Điện máy Nguyễn Kim"};
		
		String[] listTenTP = {"Canh Chua", "Thịt Kho", "Cá Chiên", "Bún đậu mắm tôm", "Chả cá"};
		String[] listTenNhaSXTP = {"Quán ăn cô hai", "Cơm tam kỳ", "Quán ăn một nhà", "Quán ăn sinh viên"};
		
		String[] listTenSS = {"Chậu sứ", "Chén sứ", "Tô sứ", "Muỗng sứ", "Đĩa sứ"};
		String[] listTenNhaSXSS = {"Co.op Mart", "E-Mart", "Sành Sứ Đông Nam", "Cửa hành sành sứ"};
		
		
		
		for (int i = 0; i < 5; i++) {
			String year = "";
			String month = "";
			String day = "";
			int dayInt;
			int monthInt;
			
			list.AddItemDM(listTenDM[rdInt.nextInt(listTenDM.length)], listTenNhaSXDM[rdInt.nextInt(listTenNhaSXDM.length)], rdInt.nextInt(35)+1, rdInt.nextInt(100)+rdInt.nextInt(100)+50, rdInt.nextInt(5));
			
			year = Integer.toString(rdInt.nextInt(3)+2019);
			monthInt = rdInt.nextInt(11)+1;
			month = Integer.toString(monthInt);
			if (month.length() == 1)
				month = "0"+month;
			
			dayInt = rdInt.nextInt(30)+1;
		 	if (monthInt == 2 && dayInt > 28) 
		 		dayInt = dayInt - rdInt.nextInt(5)+2;
		 	day = Integer.toString(dayInt);
		 	if (day.length() == 1)
		 		day = "0"+day;
		 	String value = year+"-"+month+"-"+day;
			LocalDate timeSanXuat = LocalDate.parse(value);
			
			list.AddItemSS(listTenSS[rdInt.nextInt(listTenSS.length)], rdInt.nextInt(100), timeSanXuat, listTenNhaSXSS[rdInt.nextInt(listTenNhaSXSS.length)]);
			
//			public Date timeSanXuat;
			LocalDate timeHetHan;
//			public String nameNhaSX;
			
			year = Integer.toString(rdInt.nextInt(10)+2010);
			monthInt = rdInt.nextInt(11)+1;
			month = Integer.toString(monthInt);
			if (month.length() == 1)
				month = "0"+month;
			
			dayInt = rdInt.nextInt(30)+1;
		 	if (monthInt == 2 && dayInt > 28) 
		 		dayInt = dayInt - rdInt.nextInt(5)+2;
		 	day = Integer.toString(dayInt);
		 	if (day.length() == 1)
		 		day = "0"+day;
		 	value = year+"-"+month+"-"+day;
			timeSanXuat = LocalDate.parse(value);
		 	timeHetHan = timeSanXuat.plusDays(rdInt.nextInt(3)+1);
			
			list.AddItemTP(listTenTP[rdInt.nextInt(listTenTP.length)], rdInt.nextInt(5), listTenNhaSXTP[rdInt.nextInt(listTenNhaSXTP.length)], timeSanXuat, timeHetHan);
		}
		
		
		
		while (true) {
			System.out.println("-------------Hãy lựa chọn chức năng:-------");
			System.out.println("1: Thêm hàng hóa");
			System.out.println("2: Xóa hàng");
			System.out.println("3: Sửa thông tin hàng");
			System.out.println("4: In danh sách kho hàng");
			
			int luachon = input.nextInt();
			
			switch (luachon) {
			case 1:
				ThemHang(); break;
				
			case 2:
				XoaHang(); break;
				
			case 3:
				SuaTTHang(); break;
				
			case 4:
				InTT(); break;
			default:
				break;
			}
			
		}
		
		
		
		
	}
	
	static void ThemHang() {
		System.out.print("Chọn loại hàng muốn thêm	1: Điện máy	2: Sành sứ	3: Thực phẩm: "); int luachon = input.nextInt();
		input.nextLine();
		if (luachon == 1) {
			System.out.print("Tên hàng: "); String name = input.nextLine();
			System.out.print("Nhà suản xuất: "); String nameNhaSX = input.nextLine();
			System.out.print("Thời gian bảo hành (tháng): "); int timeBaoHanh = input.nextInt();
			System.out.print("Công xuất máy: "); int congXuat = input.nextInt();
			System.out.print("Số lượng: "); int itemCount = input.nextInt();
			list.AddItemDM(name, nameNhaSX, timeBaoHanh, congXuat, itemCount);
		}else if (luachon == 2) {
			System.out.print("Tên hàng: "); String name = input.nextLine();
			System.out.print("Nhà suản xuất: "); String nameNhaSX = input.nextLine();
			System.out.print("Ngày sản xuất (format: YYYY-MM-YY)"); LocalDate daySS = LocalDate.parse(input.nextLine());
			System.out.print("Số lượng: "); int itemCount = input.nextInt();
			list.AddItemSS(name, itemCount, daySS, nameNhaSX);
		}else if (luachon == 3) {
			System.out.print("Tên hàng: "); String name = input.nextLine();
			System.out.print("Nhà suản xuất: "); String nameNhaSX = input.nextLine();
			System.out.print("Ngày sản xuất (format: YYYY-MM-YY)"); LocalDate daySS = LocalDate.parse(input.nextLine());
			System.out.print("Ngày hết hạn (ngày)"); int dayHH = input.nextInt();
			System.out.print("Số lượng: "); int itemCount = input.nextInt();
			list.AddItemTP(name, itemCount, nameNhaSX, daySS, daySS.plusDays(dayHH));
		}
	}
	
	static void XoaHang() {
		System.out.print("Chọn loại hàng muốn xóa	1: Điện máy	2: Sành sứ	3: Thực phẩm: "); int luachon = input.nextInt();
		if (luachon != 1 || luachon != 2 || luachon != 3) {
			System.out.println("Chọn sai vui lòng chọn lại\n\n");
			return;
		}
			
		System.out.print("Chọn cách xóa	1: id	2: Tên	"); int deleteWay = input.nextInt();
		if (luachon == 1) {
			if (deleteWay == 1) {
				System.out.print("Nhập id bạn muốn xóa: "); long id = input.nextLong();
				list.DeleteDM(id);
			}else {
				System.out.print("Nhập tên hàng muốn xóa: "); String name = input.nextLine();
				list.DeleteDM(name);
			}
		}else if (luachon == 2) {
			if (deleteWay == 1) {
				System.out.print("Nhập id bạn muốn xóa: "); long id = input.nextLong();
				list.DeleteSS(id);
			}else {
				System.out.print("Nhập tên hàng muốn xóa: "); String name = input.nextLine();
				list.DeleteSS(name);
			}
		}else if (luachon == 3) {
			if (deleteWay == 1) {
				System.out.print("Nhập id bạn muốn xóa: "); long id = input.nextLong();
				list.DeleteTP(id);
			}else {
				System.out.print("Nhập tên hàng muốn xóa: "); String name = input.nextLine();
				list.DeleteTP(name);
			}
		}
	}
	
	static void InTT() {
		System.out.print("Chọn loại hàng in	1: Điện máy	2: Sành sứ	3: Thực phẩm	4: Cả kho"); int luachon = input.nextInt();
		if (luachon == 1)
			list.InDSDM();
		else if (luachon == 2)
			list.InDSSS();
		else if (luachon == 3)
			list.InDSTP();
		else if (luachon == 4)
			list.InTT();
		else
			System.out.println("Chọn sai vui lòng chọn lại\n\n");
	}
	
	static void SuaTTHang() {
		System.out.print("Chọn loại hàng muốn sửa	1: Điện máy	2: Sành sứ	3: Thực phẩm: "); int luachon = input.nextInt();
		if (luachon > 3) {
			System.out.println("Chọn sai vui lòng chọn lại\n\n");
			return;
		}
		System.out.print("Nhập id muốn xóa"); int id = input.nextInt();
		
		switch (luachon) {
		case 1:
			list.ChangeItemInfoDM(id);
			break;
		case 2:
			list.ChangeItemInfoSS(id);
			break;
		case 3:
			list.ChangeItemInfoTP(id);
			break;

		default:
			System.out.println("Chọn sai vui lòng chọn lại\n\n");
			break;
		}
	}
}
