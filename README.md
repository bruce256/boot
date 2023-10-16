# boot

start nacos
```
cd /Users/LvSheng/code/opensource/nacos/distribution/target/nacos-server-2.1.0-SNAPSHOT/nacos/bin
startup.sh -m standalone
```

如需启动方法监控,则配置启动参数
```
-javaagent:/Users/LvSheng/work/dev_tools/MyPerf4J-ASM-3.3.0-SNAPSHOT.jar
-DMyPerf4JPropFile=/Users/LvSheng/work/dev_tools/MyPerf4J.properties
```