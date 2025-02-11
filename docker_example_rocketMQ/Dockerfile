FROM apache/rocketmq:4.9.3

# Expose the necessary ports
EXPOSE 9876 10911 10909 10912

# Start RocketMQ nameserver and broker
CMD ["sh", "-c", "mqnamesrv & sleep 30 && mqbroker -n localhost:9876"]
