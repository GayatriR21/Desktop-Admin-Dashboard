/*
 * Name: Callum Bass
 * Student ID: w1682693
 * Software Development - Group Project
 */
package graph;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import sql.DatabaseManager;

/**
 *
 * @author Callum Bass <w1682693>
 */
public class BlankGraph {
    
    //At the moment, returns just a PieChart object, you can alter the return type to another type of chart, research JavaFX Charts
    public static PieChart createGraph() {
        
        //Example of how you can use DatabaseManager to open a connection to the database.
        DatabaseManager manager = new DatabaseManager();
        
        /* Connect with specific credentials
        @param url - where is the db stored, if locally use 'localhost'
        @param name - database name
        @param user - database user
        @param pass- database pass
        */
        manager.connectWithCredentials("localhost", "dbname", "user", "pass");
        
        //Query your data here, i built a query method but you'll have to research on how you iterate your graph data
        //ResultSet data = manager.query("SELECT * FROM graph_table");
        
        //Disconnect the manager from the database
        manager.disconnect();
        
        //This creates a pie chart data list
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Grapefruit", 13),
                new PieChart.Data("Oranges", 25),
                new PieChart.Data("Plums", 10),
                new PieChart.Data("Pears", 22),
                new PieChart.Data("Apples", 30));
        
        //PieChart object created and assigned the data
        final PieChart chart = new PieChart(pieChartData);
        
        //Chart is set a title
        chart.setTitle("Callum Example Graph");
        
        //PieChart object is returned and eventually displayed on grid, leave the display part to me, just make sure you return a chart object.
        return chart;
    }
    
}
