# mq
重试事物

消费者集群不用考虑幂等性问题,因为生产者会按幂等性分发，但是mq(生产者)集群就要考虑幂等性问题

MQ幂等性问题只与网络延迟 重试机制时才会产生幂等性