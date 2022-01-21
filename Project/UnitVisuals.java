import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import java.awt.*;
import javax.xml.soap.*;
import java.io.*;

public class UnitVisuals extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) throws FileNotFoundException, ClassNotFoundException{
		
			TestUnit actualUnit = new TestUnit();
			try(
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("Unit.dat"));
		){
			while(true){
			TestUnit newUnit = (TestUnit)(input.readObject());
			actualUnit = newUnit;
			}
		}
		catch(EOFException ex){
			System.out.println("End reached");
		}
		catch(IOException ex){
			System.out.println("no");
		}
		
		
		StackPane pane = new StackPane();
		MyPolygon polygon = new MyPolygon();
		
		//Get the text for all the stats
		Text unitHealth = new Text("Health: " + String.valueOf(actualUnit.health));
		Text attack = new Text("Attack: " + String.valueOf(actualUnit.attack));
		Text rangedArmor = new Text("Ranged Armor: " + String.valueOf(actualUnit.rangedArmor));
		Text meleeArmor = new Text("Melee Armor: " + String.valueOf(actualUnit.meleeArmor));
		Text foodCost = new Text("Food Cost: " + String.valueOf(actualUnit.foodCost));
		Text woodCost = new Text("Wood Cost: " + String.valueOf(actualUnit.woodCost));
		Text goldCost = new Text("Gold Cost: " + String.valueOf(actualUnit.goldCost));
		Text unitName = new Text(actualUnit.name);
		
		HBox hbox1 = new HBox();
		HBox hbox2 = new HBox();
		HBox hbox3 = new HBox();
		hbox1.setAlignment(Pos.TOP_LEFT);
		hbox2.setAlignment(Pos.TOP_CENTER);
		hbox3.setAlignment(Pos.TOP_RIGHT);
		hbox1.getChildren().addAll(unitHealth, attack);
		hbox2.getChildren().addAll(rangedArmor, meleeArmor);
		hbox3.getChildren().addAll(foodCost, woodCost, goldCost);
		pane.getChildren().addAll(hbox1, hbox2, hbox3);
		Scene scene = new Scene(pane, 1000, 1000);
		primaryStage.setTitle("Unit Visuals"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	class UnitInfo extends Unit{
		public void GetUnitInfo(TestUnit newUnit) throws FileNotFoundException, ClassNotFoundException{
//			TestUnit actualUnit;
//				try(
//				ObjectInputStream input = new ObjectInputStream(new FileInputStream("Unit.dat"));
//			){
//				while(true){
//					newUnit = (TestUnit)(input.readObject());
//					actualUnit = newUnit;
//				}
//			}
//			catch(EOFException ex){
//				System.out.println("End reached");
//			}
//			catch(IOException ex){
//				System.out.println("no");
//			}
		}
	}
}




class MyPolygon extends Pane {
	private void paint() {
		// Create a polygon and place polygon to pane
		Polygon polygon = new Polygon();
		polygon.setFill(Color.RED);
		polygon.setStroke(Color.BLACK);
		ObservableList<Double> list = polygon.getPoints();
		
		double centerX = getWidth() / 2, centerY = getHeight() / 2;
		double radius = Math.min(getWidth(), getHeight()) * 0.4;
		
		// s represents the number of sides of the shape
		// Make sure to update this number when necessary
		int s = 8;
		// Add points to the polygon list
		for (int i = 0; i < s; i++) {
			list.add(centerX + radius * Math.cos(2 * i * Math.PI / s)); 
			list.add(centerY - radius * Math.sin(2 * i * Math.PI / s));
		}     
		
		getChildren().clear();
		getChildren().add(polygon); 
		
	}
	
	@Override
	public void setWidth(double width) {
		super.setWidth(width);
		paint();
	}
	
	@Override
	public void setHeight(double height) {
		super.setHeight(height);
		paint();
	}
}