package Properties;

import java.time.LocalDate;
import java.util.Date;

public class ThucPham extends HangHoa{
	
	public Date timeSanXuat;
	public Date timeHetHan;
	public String nameNhaSX;
	private float VAT = 5;
	
	public ThucPham(long _id, String _name, int _itemCount, String nameNhaSX, Date _timeSanXuat, Date _timeHetHan) {
		super(_id, _name, _itemCount, nameNhaSX);
		timeSanXuat = _timeSanXuat;
		timeHetHan = _timeHetHan;
		status = GetSellable();
	}
	
	
	
	public Boolean GetSellable() {
		//Hàng thực phẩm, nếu vẫn còn tồn kho và bị hết hạn thì đánh giá là khó bán.
		Date timenow = java.sql.Date.valueOf(LocalDate.now());
		if (super.getItemCount() != 0 && timenow.after(timeHetHan))
			return true;
		return false;
	}
	
	public void InTT() {
		super.InTT();
		System.out.println("VAT: "+VAT+"%");
		System.out.println("Thời gian sản xuất: "+timeSanXuat);
		System.out.println("Thời gian hết hạn: "+timeHetHan);
		if (status)
			System.out.println("Đánh giá: Khó bán");
		else
			System.out.println("Đánh giá: Dễ bán");
	}
}
