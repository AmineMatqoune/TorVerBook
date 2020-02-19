package logic.gui.rc;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.controller.AdRCController;
import logic.gui.Homepage;
import logic.gui.popup.InfoPopup;
import javafx.stage.Stage;

public class AdRCScene extends RCHomepage implements Homepage {

	private AdRCController controller = null;
	private Pane componentPane;

	public AdRCScene() {
		super();

		adLabel.setTextFill(Color.YELLOW);

		controller = AdRCController.getInstance();

		componentPane = new Pane();
		componentPane.setLayoutX(25);
		componentPane.setLayoutY(25);
		centralPane.getChildren().add(componentPane);

		controller.showRCAd(componentPane);
	}

	@Override
	public void salut() {
		new InfoPopup("Buongiorno RuleChecker, il tuo turno di lavoro registrato è alle: "
				+ LocalTime.now().format(DateTimeFormatter.ofPattern(("HH: mm"))) + " del giorno: " + LocalDate.now(),
				(Stage) pane.getScene().getWindow());
	}
}