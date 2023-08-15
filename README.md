# Observability

Observability is the ability to understand and monitor the internal state and behavior of a system. It involves collecting data, metrics, logs, traces, and other relevant information to gain insights into how the system is performing, how it's behaving, and what might be causing any issues or anomalies. </p>

Observability helps developers, operators, and other stakeholders to effectively diagnose and troubleshoot problems, optimize performance, and ensure the reliability of their systems.

Key aspects of observability include:

**Metrics:** Quantitative measurements of various aspects of a system, such as CPU usage, memory consumption, request/response rates, error rates, etc.

**Logs:** Text-based records of events and activities within a system. Logs are useful for understanding the sequence of actions taken by the system and for identifying error messages or anomalies.

**Traces:** Distributed traces show the flow of requests as they move through different components and services in a system. Traces provide insights into the end-to-end journey of a request and help identify bottlenecks or latency issues.

**Events:** Specific occurrences or incidents that are noteworthy, often emitted by the system to indicate certain conditions or transitions.

**Correlation:** The ability to link data across different components, services, and layers of the system to form a coherent understanding of what's happening.

## Running the Application with Docker

### Prerequisites

- Ensure that Docker is installed on your system.

### Run

1. Clone this project repository and navigate to it using your terminal or command prompt.

2. Move to the [docker](./docker) folder within the project directory.

3. Run the following command to start the Docker containers:
   ```
   docker-compose up -d
   ```
4. Once the containers are up and running, you can access the different components of the application through the following URLs:

   1. The [app-api](./app) can be accessed at: http://localhost:8080
   
   2. The [user-api](./user) is available at: http://localhost:8081
   
   3. The database connection is exposed on port 3312 (refer to the [docker compose](./docker/compose.yaml) file for details).
   
   4. Grafana, the monitoring tool, can be accessed at: http://localhost:3000
   
5. To interact with the `app-api`, you can make requests via your browser. For example, you can hit the following URL to retrieve user information with the ID 1
   ```
   http://localhost:8080/app/user?id=1
   ```
   Feel free to explore and interact with the various components of the application using the provided URLs.

   ![Toggle Menu](./images/Grafana%20Toggle%20Menu.png)

   ## Exploring Logs and Metrics with Loki, Tempo, and Prometheus

   To effectively analyze and visualize logs and metrics from your application, follow these steps

   ### Loki Setup

6. Navigate to the Loki section.

   ![loki](./images/Loki.png)
7. **Applying Label Filters:** Utilize the label filters that have been incorporated into the [logback-spring.xml](./app/src/main/resources/logback-spring.xml) file.

    ![loki filter](./images/Loki%20Label%20Filters.png)
8. **Executing Queries:** After configuring the label filters, proceed to execute your desired query.

    ![run query](./images/Loki%20Run%20Query.png)
9. **Viewing Logs Volume and Messages:** Observe the logs volume and the corresponding messages.

    ![logs volume](./images/Loki%20Log%20Volume%20and%20Messages.png)

   ### Tempo Integration

10. Either copy Trace ID from Log messages or by clicking on the message we can go to Tempo.

   ![TraceId Select](./images/Select%20TraceId.png)

11. **Selecting Tempo:** Switch over to the Tempo integration.

   ![Tempo](./images/Tempo.png)
12. **Using TraceQL and Running the Trace Query:** Choose the TraceQL query type, copy the Trace Id from the log messages and execute the query with the copied Trace Id.

   ![TraceQL](./images/TraceQL.png)
13. **Analyzing Service Workflow:** Explore the service workflow, detailing the duration of each operation.

   ![Service and Operation](./images/Service%20Operation.png)
14. **Node Graph Visualization:** Visualize the same workflow using the Node graph representation.

   ![Node graph](./images/Node%20Graph.png)

   ### Prometheus Integration

15. **Accessing Prometheus:** Proceed to the Prometheus integration.
16. **Metric Exploration:** Select and investigate the metrics of interest. For instance, `jvm_memory_used_bytes` of the `heap` area.

   ![Prometheus](./images/Prometheus.png)
17. **Metrics for Multiple Instances:** Observe the metrics for both instances, `app-api` and `user-api`.

   ![Metrics](./images/Prometheus%20Graph%20Table.png)


## OpenTelemetry

OpenTelemetry is an open-source project that aims to standardize and simplify observability in modern software systems. It provides a set of APIs, libraries, agents, and instrumentation to help developers capture and collect telemetry data (metrics, logs, and traces) from their applications and services. OpenTelemetry supports multiple programming languages and frameworks, making it suitable for a wide range of environments.

## Grafana

Grafana is an open-source platform for data visualization, monitoring, and analytics. It is commonly used to create interactive and customizable dashboards that display data from various sources. Grafana supports a wide range of data sources, including time-series databases like Prometheus, relational databases, cloud services, and more. Grafana's strength lies in its ability to create visually appealing and informative dashboards that provide insights into the performance and health of systems.

## Grafana Loki

Grafana Loki is a log aggregation and query system. It's designed to handle large volumes of log data and supports efficient querying of logs. Loki is often used to centralize logs from various services, making it easier to analyze and troubleshoot issues.

> Grafana Loki, Grafana Tempo, OpenTelemetry, Prometheus, and Grafana form a powerful combination of observability solutions that work together to provide comprehensive monitoring, logging, tracing, and visualization capabilities in modern software systems.

### OpenTelemetry and Grafana

OpenTelemetry's collected data can be sent to various backends, including Grafana Loki for logs and Grafana Tempo for traces. Grafana can then be used to visualize these logs and traces alongside metrics data, providing a holistic view of application behavior.

### Prometheus and Grafana

Prometheus metrics data can be visualized and analyzed in Grafana dashboards. Grafana can query Prometheus using PromQL to create visualizations that help monitor system performance.
