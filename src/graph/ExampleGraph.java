/*
 * Name: Callum Bass
 * Student ID: w1682693
 * Software Development - Group Project
 */
package graph;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

/**
 *
 * @author Callum Bass <w1682693>
 */
public class ExampleGraph {
    
    public static PieChart createGraph() {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Grapefruit", 13),
                new PieChart.Data("Oranges", 25),
                new PieChart.Data("Plums", 10),
                new PieChart.Data("Pears", 22),
                new PieChart.Data("Apples", 30));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Example Graph Title");
        return chart;
    }
    
}
