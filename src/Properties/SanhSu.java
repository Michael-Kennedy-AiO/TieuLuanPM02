package Properties;

import java.time.LocalDate;
//import java.util.Date;
import java.sql.Date;


public class SanhSu extends HangHoa{
	
	public Date timeSanXuat;
	private float VAT =  10;
	//Hàng sành sứ, nếu số lượng tồn kho >50 và thời gian lưu kho >10 ngày thì đánh giá là bán chậm.
	

	
	public SanhSu(long _id, String _name, int _itemCount, LocalDate _timeSanXuat, String _nameNhaSX) {
		super(_id, _name, _itemCount, _nameNhaSX);
		timeSanXuat = Date.valueOf(_timeSanXuat);
		status = GetSellable(_timeSanXuat);
	}
	
	private boolean GetSellable(LocalDate _timeSanXuat) {
		boolean check = false;
		if (_timeSanXuat.plusDays(10).isBefore(LocalDate.now()))
			check = true;
		if (super.getItemCount() > 50 && check)
			return true;
		return false;
	}
	
	public void InTT() {
		super.InTT();
		System.out.println("VAT: "+VAT+"%");
		System.out.println("Thời gian sản xuất: "+timeSanXuat);
		if (status)
			System.out.println("Đánh giá: bán chậm");
		else
			System.out.println("Đánh giá: bán nhanh");
	}
	
	public float GetVAT() {
		return VAT;
	}
}
