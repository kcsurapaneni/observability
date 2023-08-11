# Observability

## How to run

### Pre requisite

- Docker should be installed

### Running

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
6. Select Loki

   ![loki](./images/Loki.png)
7. We have to select label filters, which were added as part of [logback-spring.xml](./app/src/main/resources/logback-spring.xml) file

    ![loki filter](./images/Loki%20Label%20Filters.png)
8. After selecting Label filters, click on Run query

    ![run query](./images/Loki%20Run%20Query.png)
9. Now we can see Logs volume and messages

    ![logs volume](./images/Loki%20Log%20Volume%20and%20Messages.png)
