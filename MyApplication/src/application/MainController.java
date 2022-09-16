package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;



public class MainController {
	
	@FXML
	private Label result;
	private long number1 = 0;
	private String operator = "";
	private boolean start = true;
	private Module model = new Module(); 
	
	@FXML
	 public void proccessNumber(ActionEvent event){ 
	 
	if (start) {
		result.setText("");
		start = false;
	}
	String value = ((Button)event.getSource()).getText();
	result.setText(result.getText() + value);
}
	 public void proccessOperator(ActionEvent event) {
		 String value = ((Button)event.getSource()).getText();
		 
		 if (!value.equals("=")) {
			 if (!operator.isEmpty())
				 return;
			 operator = value;
			 number1 = Long.parseLong(result.getText());
			 result.setText("");
		 }else {
			 if (operator.isEmpty())
				 return;
			 long number2 = Long.parseLong(result.getText());
			 float output = Module.calculate(number1, number2, operator);
			 result.setText(String.valueOf(output));
			 operator = "";
			 start = true;
		 }
		 
	 }
}
