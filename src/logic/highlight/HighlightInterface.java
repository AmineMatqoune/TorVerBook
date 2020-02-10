package logic.highlight;

public interface HighlightInterface {
		public boolean isExpired();
		
		public void remove();
		
		public int getPrice(int days);
		
		public void getPeriod();
}
