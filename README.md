# Observability

Observability is the ability to understand and monitor the internal state and behavior of a system. It involves collecting data, metrics, logs, traces, and other relevant information to gain insights into how the system is performing, how it's behaving, and what might be causing any issues or anomalies. </p>

Observability helps developers, operators, and other stakeholders to effectively diagnose and troubleshoot problems, optimize performance, and ensure the reliability of their systems.

Key aspects of observability include:

**Metrics:** Quantitative measurements of various aspects of a system, such as CPU usage, memory consumption, request/response rates, error rates, etc.

**Logs:** Text-based records of events and activities within a system. Logs are useful for understanding the sequence of actions taken by the system and for identifying error messages or anomalies.

**Traces:** Distributed traces show the flow of requests as they move through different components and services in a system. Traces provide insights into the end-to-end journey of a request and help identify bottlenecks or latency issues.

**Events:** Specific occurrences or incidents that are noteworthy, often emitted by the system to indicate certain conditions or transitions.

**Correlation:** The ability to link data across different components, services, and layers of the system to form a coherent understanding of what's happening.

## How to run

### Pre requisite

- Docker should be installed

### Run

1. Clone the project, open in terminal/command prompt
2. Move to the [docker](./docker) folder
3. Run `docker compose up -d` command
   1. [app-api](./app) will be running on http://localhost:8080
   2. [user-api](./user) is running on http://localhost:8081
   3. DB connection is also exposed in `3312` port, please refer [docker compose](./docker/compose.yaml) file
   4. Grafana is running on http://localhost:3000
4. Hit `app-api` by calling http://localhost:8080/app/user?id=1 in browser
5. Go to Grafana dashboard and click on toggle menu

   ![Toggle Menu](./images/Grafana%20Toggle%20Menu.png)
   
   ### Loki

6. Select Loki

   ![loki](./images/Loki.png)
7. We have to select label filters, which were added as part of [logback-spring.xml](./app/src/main/resources/logback-spring.xml) file

    ![loki filter](./images/Loki%20Label%20Filters.png)
8. After selecting Label filters, click on Run query

    ![run query](./images/Loki%20Run%20Query.png)
9. Now we can see Logs volume and messages

    ![logs volume](./images/Loki%20Log%20Volume%20and%20Messages.png)
10. Either copy Trace Id from Log messages or by clicking on the message we can Tempo

   ![TraceId Select](./images/Select%20TraceId.png)

   ### Tempo

11. Select Tempo

   ![Tempo](./images/Tempo.png)
12. Select Query type as TraceQL and copy the Trace Id, click on Run query

   ![TraceQL](./images/TraceQL.png)
13. Now we can see the Service workflow by each operation and how much it took to perform that operation

   ![Service and Operation](./images/Service%20Operation.png)
14. We can see the same workflow in Node graph as well

   ![Node graph](./images/Node%20Graph.png)

   ### Prometheus

15. In same way select Prometheus and Let's check metric of `jvm_memory_used_bytes` of `heap` area

   ![Prometheus](./images/Prometheus.png)
16. Now we can see the metrics of both the instances `app-api` and `user-api`

   ![Metrics](./images/Prometheus%20Graph%20Table.png)


## OpenTelemetry

OpenTelemetry is an open-source project that aims to standardize and simplify observability in modern software systems. It provides a set of APIs, libraries, agents, and instrumentation to help developers capture and collect telemetry data (metrics, logs, and traces) from their applications and services. OpenTelemetry supports multiple programming languages and frameworks, making it suitable for a wide range of environments.
