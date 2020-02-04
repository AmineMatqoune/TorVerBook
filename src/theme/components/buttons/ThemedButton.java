package theme.components.buttons;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public abstract class ThemedButton extends Button {

	protected Font font;
	protected Color backgroundColor;
	protected Color onClickBackgroundColor;
	
	
	protected ThemedButton() {
		this.setFont();
	}
	
}
