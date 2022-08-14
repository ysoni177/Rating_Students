package corejava;

public class input {
	
		public input(String sub, String asCat, int points) {
			super();
			this.sub = sub;
			this.asCat = asCat;
			this.points = points;
		}
		String sub, asCat;
		int points;
		public String getSub() {
			return sub;
		}
		public void setSub(String sub) {
			this.sub = sub;
		}
		public String getAsCat() {
			return asCat;
		}
		public void setAsCat(String asCat) {
			this.asCat = asCat;
		}
		public int getPoints() {
			return points;
		}
		public void setPoints(int points) {
			this.points = points;
		}
		
		
	}
