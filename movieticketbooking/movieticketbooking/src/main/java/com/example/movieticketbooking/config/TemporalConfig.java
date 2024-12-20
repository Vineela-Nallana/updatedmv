package com.example.movieticketbooking.config;

import com.example.movieticketbooking.activities.MovieTicketActivities;
import com.example.movieticketbooking.activities.MovieTicketActivitiesImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowClientOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemporalConfig {

    private static final String TASK_QUEUE = "MovieTicketTaskQueue";

    /**
     * Create WorkflowServiceStubs for connecting to Temporal Service.
     */
    @Bean
    public WorkflowServiceStubs workflowServiceStubs() {
        return WorkflowServiceStubs.newLocalServiceStubs();
    }

    /**
     * Create a WorkflowClient to communicate with Temporal Service.
     */
    @Bean
    public WorkflowClient workflowClient(WorkflowServiceStubs serviceStubs) {
        return WorkflowClient.newInstance(
                serviceStubs,
                WorkflowClientOptions.newBuilder()
                        .setNamespace("default") // Default namespace
                        .build()
        );
    }

    /**
     * Register WorkerFactory and Worker with Temporal and Spring Bean for activities.
     */
    @Bean
    public WorkerFactory workerFactory(WorkflowClient workflowClient, MovieTicketActivitiesImpl movieTicketActivities) {
        WorkerFactory factory = WorkerFactory.newInstance(workflowClient);
        Worker worker = factory.newWorker(TASK_QUEUE);

        // Register the activities implementation
        worker.registerActivitiesImplementations(movieTicketActivities);

        return factory;
    }

    /**
     * Register MovieTicketActivitiesImpl implementation as a Spring bean.
     */
    @Bean
    public MovieTicketActivitiesImpl movieTicketActivities() {
        return new MovieTicketActivitiesImpl(); // Spring will manage dependencies for this bean
    }
}


//package com.example.movieticketbooking.config;
//
//import com.example.movieticketbooking.activities.MovieTicketActivitiesImpl;
//import com.example.movieticketbooking.workflow.MovieTicketWorkflowImpl;
//import io.temporal.client.WorkflowClient;
//import io.temporal.serviceclient.WorkflowServiceStubs;
//import io.temporal.worker.Worker;
//import io.temporal.worker.WorkerFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class TemporalConfig {
//
//    private final ApplicationContext applicationContext;
//
//
//    public TemporalConfig(ApplicationContext applicationContext) {
//        this.applicationContext = applicationContext;
//    }
//    @Bean
//    public WorkflowClient workflowClient() {
//        // Connect to the Temporal service running at localhost:7233
//        WorkflowServiceStubs serviceStubs = WorkflowServiceStubs.newInstance();  // No need for WorkflowServiceStubsOptions
//
//        // Create and return the WorkflowClient
//        return WorkflowClient.newInstance(serviceStubs);
//    }
//
//    @Bean
//    public Worker startWorker(WorkflowClient workflowClient) {
//        // Create a WorkerFactory with the workflow client
//        WorkerFactory factory = WorkerFactory.newInstance(workflowClient);
//
//        // Create a Worker for a specific task queue
//        Worker worker = factory.newWorker("movie-ticket-queue");
//
//        // Register the workflow and activities with the worker
//        worker.registerWorkflowImplementationTypes(MovieTicketWorkflowImpl.class);
//        worker.registerActivitiesImplementations(new MovieTicketActivitiesImpl());
//
//        // Start the worker to process workflows and activities
//        factory.start();
//
//        return worker;  // Return the worker
//    }
//}
