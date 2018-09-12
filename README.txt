the following Kafka Implementation is based on the following piece of reference:
http://blog.empeccableweb.com/wp/2016/11/30/kafka-producer-and-consumer-example/

for running -:
if storm-core is on 1.2.2
then the storm core must be of the same version on the cluster or compatible version

--the only artifact needed for the running of the simple storm is the storm-core
the packaging command becomes
mvn clean assembly:single