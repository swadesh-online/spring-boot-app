# create docker network
docker network create swadesh_network

# docker prom
docker pull prom/prometheus
docker run --network swadesh_network --name prometheus-container -d -p 9090:9090 -v /Users/swadesh/Downloads/spring-boot-app/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus

# docker grafana
docker pull grafana/grafana-oss
docker run --network swadesh_network -d -p 3000:3000 --name=grafana-container grafana/grafana-oss

# docker kafka 
use the Kafka_compose.yml {Kraft used}
docker compose -f Kafka_compose.yml up

Test 
access kafka terminal
1. docker exec -it kafka bash
create test topic
2. /usr/bin/kafka-topics --create --topic test-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
produce messages 
3. /usr/bin/kafka-console-producer --broker-list localhost:9092 --topic test-topic
consume messages
4. /usr/bin/kafka-console-consumer --bootstrap-server localhost:9092 --topic test-topic --from-beginning

# build image and create container
docker build -t my-spring-app .
docker run -p 8080:8080 --network swadesh_network --name spring-app-container my-spring-app

adding all deps to single compose file. 