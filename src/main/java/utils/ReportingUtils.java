package utils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class ReportingUtils {
	
	private ReportingUtils() {
		
	}
	
    public static void generateJVMReport(){

        File reportOutputDirectory = new File("test-reports");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber.json");


        String buildNumber = "1";
        String projectName = "cucumberProject";
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        
        // optional configuration - check javadoc for details
        configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
        
        // do not make scenario failed when step has status SKIPPED
        configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
        configuration.setBuildNumber(buildNumber);
        
        // addidtional metadata presented on main page
        configuration.addClassifications("Platform", "Windows");
        configuration.addClassifications("Browser", "Firefox");
        configuration.addClassifications("Branch", "release/1.0");
        configuration.setSortingMethod(SortingMethod.NATURAL);
        configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
        configuration.addPresentationModes(PresentationMode.PARALLEL_TESTING);

        /* optionally add metadata presented on main page via properties file
        List<String> classificationFiles = new ArrayList<>();
        classificationFiles.add("properties-1.properties");
        classificationFiles.add("properties-2.properties");
        configuration.addClassificationFiles(classificationFiles); 
        */
        
        configuration.setTagsToExcludeFromChart("InvalidCredentials", "FaceBookLink");
        
        // points to the demo trends which is not used for other tests
        configuration.setTrendsStatsFile(new File("target/trends-cucumber.json"));

        //configuration.addClassificationFiles(Collections.singletonList("src/test/resources/css/stackoverflow-light.min.css"));
        //configuration.addClassificationFiles(Arrays.asList("src/test/resources/js/enable-highlighting.js", "src/test/resources/js/highlight.min.js"));
        
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();
        
       // and here validate 'result' to decide what to do if report has failed
    }
}
