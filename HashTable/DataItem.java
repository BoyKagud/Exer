package exer6;

//You may add other methods here...

public class DataItem {
		
	private int iData;
        private String strFrm;
		
	public DataItem(int i, String strForm) {
		iData = i;
                strFrm = strForm;
	}
		
	public int getKey() {
		return iData;
	}
        
        public String getStrFrm() {
            return strFrm;
        }
        
}