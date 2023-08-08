package mysakan;

public class Photos {
		private String photoName;
		private String photoURL;
		public String getPhotoName() {
			return photoName;
		}
		public void setPhotoName(String photoName) {
			this.photoName = photoName;
		}
		public String getPhotoURL() {
			return photoURL;
		}
		public void setPhotoURL(String photoURL) {
			this.photoURL = photoURL;
		}
		public Photos(String photoName, String photoURL) {
			super();
			this.photoName = photoName;
			this.photoURL = photoURL;
		}
		
}
