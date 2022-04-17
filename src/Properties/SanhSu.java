package Properties;

import java.util.Date;

public class SanhSu extends HangHoa{
	
	public Date timeSanXuat;
	private float VAT =  10;
	//Hàng sành sứ, nếu số lượng tồn kho >50 và thời gian lưu kho >10 ngày thì đánh giá là bán chậm.
	

	
	public SanhSu(long _id, String _name, int _itemCount, Date _timeSanXuat, String _nameNhaSX) {
		super(_id, _name, _itemCount, _nameNhaSX);
		timeSanXuat = _timeSanXuat;
	}
	
	public void InTT() {
		super.InTT();
		System.out.println("VAT: "+VAT+"%");
		System.out.println("Thời gian sản xuất: "+timeSanXuat);
	}
	
	public float GetVAT() {
		return VAT;
	}
}
