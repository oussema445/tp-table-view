module tp_table_view {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	requires javafx.graphics;
	requires javafx.base;
	
	opens application to javafx.graphics,javafx.base, javafx.fxml;
}
