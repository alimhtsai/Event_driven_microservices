## Distributed event-driven microservices
> Java, Spring Boot, Kafka, Elasticsearch, PostgreSQL, Prometheus, Grafana, Logstash, Kibana

### Introduction
**A distributed event-driven microservices project using Spring boot, Spring cloud, Kafka and Elasticsearch**
- Implemented CQRS and event sourcing pattern in Spring Boot, Spring Cloud, Apache Kafka, and Elasticsearch
- Utilized mock streaming tweets as source data and Docker for microservices containerization

### Event-driven Microservices Architecture

![microservices_20240528](https://github.com/alimhtsai/Event_driven_microservices/assets/48788292/63580b33-5ef0-492c-bfc2-76be5739a188)


### Live Demo
- Containerization of two microservices (twitter-to-kafka-service and kafka-to-elastic-service) with docker images

https://github.com/alimhtsai/Event_driven_microservices/assets/48788292/25778b79-4b47-436d-a5ba-aa1f5e11d47a

### TODO
- [ ] Elastic query service
- [ ] Reactive elastic web client service
- [ ] Security
- [ ] Kafak stream state store
- [ ] Postgres analytics store
- [ ] Netflex Eureka discovery service
- [ ] Spring API gateway & Redis rate limiter
- [ ] Monitored microservices with Prometheus, Grafana, and ELK stack (Elasticsearch, Logstash and Kibana)
