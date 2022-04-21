package Properties;

import java.time.LocalDate;

public class DienMay extends HangHoa{
	
	public LocalDate timeBaoHanh;
	public int congXuat;
	private float VAT = 10;
	
	
	public DienMay(long _id, String _name, int _itemCount, int _timeBaoHanh, int _congXuat, String _nameNhaSX) {
		super(_id, _name, _itemCount, _nameNhaSX);
		timeBaoHanh = CalTimeBaoHanh(_timeBaoHanh);
		congXuat = _congXuat;
	}
	
	public void InTT() {
		super.InTT();
		System.out.println("VAT: "+VAT+"%");
		System.out.println("Thời gian bảo hành: "+timeBaoHanh);
		System.out.println("Công xuất: "+congXuat);
	}
	
	//Hàng điện máy, nếu số lượng tồn kho <3 thì được đánh giá là bán được.
	public Boolean GetSellable() {
		if (super.getItemCount() < 3)
			return true;
		return false;
	}
	
	public float GetVAT() {
		return VAT;
	}
	
	private LocalDate CalTimeBaoHanh(int timeBaoHanh) {
		LocalDate timenow = LocalDate.now();
		timenow = timenow.plusMonths(timeBaoHanh);
		return timenow;
	}
}
