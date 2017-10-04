#!/bin/bash
hadoop jar /opt/hadoop-2.8.0/share/hadoop/yarn/hadoop-yarn-applications-distributedshell-2.8.0.jar org.apache.hadoop.yarn.applications.distributedshell.Client --jar /opt/hadoop-2.8.0/share/hadoop/yarn/hadoop-yarn-applications-distributedshell-2.8.0.jar --shell_command date 2>&1 | tee test1
