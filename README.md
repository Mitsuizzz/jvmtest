# jvmtest
# jvm内存溢出排查实战代码

# 快速开始
## 一、参数自动生成堆文件
1.为快速产生内存溢出，右击 Run As > Run Configurations,Program Arguments 标签中填入
-Xmx32M -Xms32M
2.访问 http://localhost:8877/heap
```
Exception in thread "http-nio-8080-ClientPoller-0" java.lang.OutOfMemoryError: GC overhead limit exceeded
at java.util.HashMap$KeySet.iterator(HashMap.java:916)
at java.util.HashSet.iterator(HashSet.java:172)
at java.util.Collections$UnmodifiableCollection$1.<init>(Collections.java:1039)
```
如果想实现内存溢出自动导出，需要加上这两个参数
-XX:+HeapDumpOnOutOfMemoryError
-XX:HeapDumpPath=./
右击 Run As > Run Configurations,Program Arguments 标签中填入
-Xmx32M -Xms32M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./
当内存溢出时可以看到自动在当前目录中生成了一个java_pid660.hprof文件
java.lang.OutOfMemoryError: GC overhead limit exceeded
Dumping heap to ./java_pid660.hprof ...
## 二、jmap生成堆文件
使用jps -l获取pid通过pid导出文件
```
jps -l
10476 sun.tools.jps.Jps
6744
14980 com.imooc.monitor_tuning.MonitorTuningApplication
```
通过pid导出文件jmap -dump:format=b,file=heap.hprof [pid]
```
jmap -dump:format=b,file=heap.hprof 14980
Dumping heap to C:\Users\Mr Chen\Desktop\heap.hprof ...
Heap dump file created
```
之后将导出的heap.hprof导入mat进行内存分析,展开占用内存占比较高的中的树形图。