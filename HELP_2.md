# docker prom 
docker pull prom/prometheus
docker run --name prometheus -d -p 9090:9090 -v /Users/swadesh/Downloads/rest/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus

# docker grafana
docker pull grafana/grafana-oss
docker run -d -p 3000:3000 --name=grafana grafana/grafana-oss