package Properties;

public class HangHoa {
	private long id;
	private String name;
	private int itemCount;
	private String nameNhaSX;
	
	protected HangHoa(long _id, String _name, int _itemCount, String _nameNhaSX) {
		id = _id;
		name = _name;
		itemCount = _itemCount;
		nameNhaSX = _nameNhaSX;
	}
	
	protected void InTT() {
		System.out.println("Tên Hàng: "+name);
		System.out.println("Nhà sản xuất: "+nameNhaSX);
		System.out.println("Id: "+id);
		System.out.println("Hàng tồn kho: "+itemCount);
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getItemCount() {
		return itemCount;
	}
	
	public void setName(String _name) {
		name = _name;
	}
	
	public void setItemCount(int _itemCount) {
		itemCount = _itemCount;
	}
	
	public Boolean checkId(long _id) {
		if (_id == id)
			return true;
		return false;
	}
}
