# docker prom 
docker pull prom/prometheus
docker run --name prometheus -d -p 9090:9090 -v /Users/swadesh/Downloads/spring-boot-app/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus

# docker grafana
docker pull grafana/grafana-oss
docker run -d -p 3000:3000 --name=grafana grafana/grafana-oss

# docker kafka 
use the Kafka_compose.yml {Kraft used} 
Test 
access kafka terminal
1. docker exec -it kafka bash
create test topic
2. /usr/bin/kafka-topics --create --topic test-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
produce messages 
3. /usr/bin/kafka-console-producer --broker-list localhost:9092 --topic test-topic
consume messages
4. /usr/bin/kafka-console-consumer --bootstrap-server localhost:9092 --topic test-topic --from-beginning

