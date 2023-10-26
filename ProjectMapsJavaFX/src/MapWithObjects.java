import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MapWithObjects extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Load the background image
        Image backgroundImage = new Image("file:/Users/muhammadazhar/Downloads/SidoarjoMaps.png"); // Replace the image path

        // Create an ImageView to display the background image
        ImageView imageView = new ImageView(backgroundImage);

        // Create a group to hold the image, rectangles, and object information
        Group group = new Group(imageView);

        // Create a rectangle for hovering
        Rectangle hoverRectangle = new Rectangle(1250, 350, 250, 250); // Adjust position and size as needed
        hoverRectangle.setFill(Color.TRANSPARENT);
        hoverRectangle.setStroke(Color.TRANSPARENT);
        hoverRectangle.setStrokeWidth(2);

        // Create text to display object information
        Text objectInfo = new Text(" ");
        objectInfo.setFont(Font.font("Calibri", 25));
        objectInfo.setFill(Color.WHITE); // Set the text color
        objectInfo.setX(1200);
        objectInfo.setY(500);

        // Add a hover effect to the rectangle
        hoverRectangle.setOnMouseEntered(event -> {
            hoverRectangle.setFill(Color.TRANSPARENT); // Change the color on hover
            objectInfo.setText("Object Info: Gelora Delta Stadium"); // Replace the object information
        });
        hoverRectangle.setOnMouseExited(event -> {
            hoverRectangle.setFill(Color.TRANSPARENT); // Reset color on exit
            objectInfo.setText(" ");
        });

        // Add the hover rectangle and object information to the group
        group.getChildren().addAll(hoverRectangle, objectInfo);

        // Create the scene
        Scene scene = new Scene(group);

        primaryStage.setTitle("Map with Objects and Object Information");
        primaryStage.setScene(scene);
        primaryStage.setWidth(backgroundImage.getWidth()); // Set the window width to match the image width
        primaryStage.setHeight(backgroundImage.getHeight()); // Set the window height to match the image height
        primaryStage.show();
    }
}
