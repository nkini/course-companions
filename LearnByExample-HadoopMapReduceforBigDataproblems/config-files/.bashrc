if [ -f ~/.bash_aliases ]; then
    . ~/.bash_aliases
fi
if [ -f ~/.bash_prompt ]; then
    . ~/.bash_prompt
fi

JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home
#http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

MAVEN_HOME=/usr/local/java/apache-maven-3.5.0
#https://maven.apache.org/download.cgi

HADOOP_HOME=/opt/hadoop-2.8.0
HADOOP_CONF_DIR=$HADOOP_HOME/etc/hadoop
YARN_CONF_DIR=$HADOOP_HOME/etc/yarn
#http://hadoop.apache.org/releases.html

SPARK_HOME=/opt/spark-2.1.1-bin-hadoop2.7
#https://spark.apache.org/downloads.html
    
PATH=$MAVEN_HOME/bin:$HADOOP_HOME/bin:$HADOOP_HOME/sbin:$SPARK_HOME/bin:$PATH
