package drivers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import Properties.DienMay;
import Properties.SanhSu;
import Properties.ThucPham;

public class DanhSach {
	public List<DienMay> listDM = new ArrayList<DienMay>();
	public List<SanhSu> listSS = new ArrayList<SanhSu>();
	public List<ThucPham> listTP = new ArrayList<ThucPham>();
	
	public void AddItemDM(String name, String nameNhaSX, int timeBaoHanh, int congXuat, int itemCount) {
		long id = ThreadLocalRandom.current().nextLong(9999999);
		for (int j = 0; j < listDM.size(); j++) {
			if (listDM.get(j).checkId(id)) {
				id = ThreadLocalRandom.current().nextLong(9999999);
				j = -1;
			}
		}
		listDM.add(new DienMay(id, name, itemCount, timeBaoHanh, congXuat, nameNhaSX));
	}
	
	public void AddItemSS(String name, int itemCount, LocalDate timeSanXuat, String nameNhaSX) {
		long id = ThreadLocalRandom.current().nextLong(9999999);
		for (int j = 0; j < listSS.size(); j++) {
			if (listSS.get(j).checkId(id)) {
				id = ThreadLocalRandom.current().nextLong(9999999);
				j = -1;
			}
		}
		listSS.add(new SanhSu(id, name, itemCount, Date.valueOf(timeSanXuat), nameNhaSX));
	}
		
	
	public void AddItemTP(String name, int itemCount, String nameNhaSX, LocalDate timeSanXuat, LocalDate timeHetHan) {
		long id = ThreadLocalRandom.current().nextLong(9999999);
		for (int j = 0; j < listTP.size(); j++) {
			if (listTP.get(j).checkId(id)) {
				id = ThreadLocalRandom.current().nextLong(9999999);
				j = -1;
			}
		}
		listTP.add(new ThucPham(id, name, itemCount, nameNhaSX, Date.valueOf(timeSanXuat), Date.valueOf(timeHetHan)));
	}
	
	public void DeleteDM(long id) {
		
		List<DienMay> ds = new ArrayList<>();
		for (DienMay dienMay : listDM) {
			if (dienMay.getId() == id) 
				continue;
			
			ds.add(dienMay);
		}
		listDM = ds;
	}
	
	public void DeleteDM(String name) {
		List<DienMay> ds = new ArrayList<>();
		for (DienMay dienMay : listDM) {
			if (dienMay.getName() == name)
				continue;
			
			ds.add(dienMay);
		}
		listDM = ds;
	}
	
	public void DeleteSS(long id) {
		
		List<SanhSu> ds = new ArrayList<>();
		for (SanhSu dienMay : listSS) {
			if (dienMay.getId() == id) 
				continue;
			
			ds.add(dienMay);
		}
		listSS = ds;
	}
	
	public void DeleteSS(String name) {
		List<SanhSu> ds = new ArrayList<>();
		for (SanhSu dienMay : listSS) {
			if (dienMay.getName() == name)
				continue;
			
			ds.add(dienMay);
		}
		listSS = ds;
	}
	
	public void DeleteTP(long id) {
		
		List<ThucPham> ds = new ArrayList<>();
		for (ThucPham dienMay : listTP) {
			if (dienMay.getId() == id) 
				continue;
			
			ds.add(dienMay);
		}
		listTP = ds;
	}
	
	public void DeleteTP(String name) {
		List<ThucPham> ds = new ArrayList<>();
		for (ThucPham dienMay : listTP) {
			if (dienMay.getName() == name)
				continue;
			
			ds.add(dienMay);
		}
		listTP = ds;
	}
	
	public void InTT() {
		int itemCount = 0;
		System.out.println("--------------------------------------Điện máy------------------------------");
		for (DienMay dienMay : listDM) {
			dienMay.InTT();
			System.out.println();
			itemCount++;
		}
		
		System.out.println("--------------------------------------Sành sứ------------------------------");
		for (SanhSu ss : listSS) {
			ss.InTT();
			System.out.println();
			itemCount++;
		}
		
		System.out.println("--------------------------------------Thực phẩm------------------------------");
		for (ThucPham tp : listTP) {
			tp.InTT();
			System.out.println();
			itemCount++;
		}
		
		System.out.println("Tổng hàng trong kho: "+itemCount);
	}
	
	public void InDSDM() {
		System.out.println("--------------------------------------Điện máy------------------------------");
		for (DienMay dienMay : listDM) {
			dienMay.InTT();
			System.out.println();
		}
	}
	
	public void InDSSS() {
		System.out.println("--------------------------------------Sành sứ------------------------------");
		for (SanhSu ss : listSS) {
			ss.InTT();
			System.out.println();
		}
	}
	
	public void InDSTP() {
		System.out.println("--------------------------------------Thực phẩm------------------------------");
		for (ThucPham tp : listTP) {
			tp.InTT();
			System.out.println();
		}
	}
	
	public void ChangeItemInfoDM(long id) {
		DienMay dm = null;
		for (DienMay dienMay : listDM) {
			if (dienMay.getId() == id)
				dm = dienMay;
		}
		Scanner input = new Scanner(System.in);
		
		System.out.print("Tên hàng: "); String name = input.nextLine();
		System.out.print("Nhà suản xuất: "); String nameNhaSX = input.nextLine(); input.nextInt();
		System.out.print("Thời gian bảo hành (tháng): "); int timeBaoHanh = input.nextInt();
		System.out.print("Công xuất máy: "); int congXuat = input.nextInt();
		System.out.print("Số lượng: "); int itemCount = input.nextInt();
		
		dm = new DienMay(dm.getId(), name, itemCount, timeBaoHanh, congXuat, nameNhaSX);
	}
	
	public void ChangeItemInfoSS(long id) {
		DienMay dm = null;
		for (DienMay dienMay : listDM) {
			if (dienMay.getId() == id)
				dm = dienMay;
		}
		Scanner input = new Scanner(System.in);
		
		System.out.print("Tên hàng: "); String name = input.nextLine();
		System.out.print("Nhà suản xuất: "); String nameNhaSX = input.nextLine(); input.nextInt();
		System.out.print("Thời gian bảo hành (tháng): "); int timeBaoHanh = input.nextInt();
		System.out.print("Công xuất máy: "); int congXuat = input.nextInt();
		System.out.print("Số lượng: "); int itemCount = input.nextInt();
		
		dm = new DienMay(dm.getId(), name, itemCount, timeBaoHanh, congXuat, nameNhaSX);
	}
	
	public void ChangeItemInfoTP(long id) {
		SanhSu ss = null;
		for (SanhSu sanhsu : listSS) {
			if (sanhsu.getId() == id)
				ss = sanhsu;
		}
		Scanner input = new Scanner(System.in);
		
		System.out.print("Tên hàng: "); String name = input.nextLine();
		System.out.print("Nhà suản xuất: "); String nameNhaSX = input.nextLine();
		System.out.print("Ngày sản xuất (format: YYYY-MM-YY)"); LocalDate daySS = LocalDate.parse(input.nextLine());input.nextInt();
		input.nextInt();
		System.out.print("Số lượng: "); int itemCount = input.nextInt();
		
		ss = new SanhSu(ss.getId(), name, itemCount, null, nameNhaSX);
	}
}
