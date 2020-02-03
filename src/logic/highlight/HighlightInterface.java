package logic.highlight;

import logic.ad.Ad;

public interface HighlightInterface {
		public boolean isExpired();
		
		public void remove();
		
		public int getPrice(int days);
		
		public void getPeriod();
}
