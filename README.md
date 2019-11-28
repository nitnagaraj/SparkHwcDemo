# Spark-Secure - Hive warehouse connector Example

You can query on your existing Hive table with HWC using below example. This will take your database and table name and then connects to Hive through HWC to retrive the data.

For testing, you can create a sample table like below and query on the same:

1) Create a table employee in hive and load some data
        eg: 
        Create table 
        ----------------
```        
CREATE TABLE IF NOT EXISTS employee ( eid int, name String, salary String, destination String)
COMMENT 'Employee details'
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
STORED AS TEXTFILE;

 # Load data data.txt file into hdfs
         
1,Aadi,10,CE
2,Tamil,20,CE2
3,Aman,30,CE3
4,Somraj,40,CE4
```

LOAD DATA INPATH '/tmp/data.txt' OVERWRITE INTO TABLE employee;

1. To submit application to Yarn in client mode

> spark-submit:

```
/usr/hdp/current/spark2-client/bin/spark-submit --master yarn --deploy-mode client --conf spark.security.credentials.hiveserver2.enabled=false --jars /usr/hdp/current/hive_warehouse_connector/<hive warehouse connector jar>,./SparkSecureHWC-Demo-1.0.jar  --class com.hwx.SparkSecureHWCDemo ./SparkSecureHWC-Demo-1.0.jar <databasename.tablename>
```

2. To submit application to Yarn in cluster mode

> spark-submit:

```
/usr/hdp/current/spark2-client/bin/spark-submit --master yarn --deploy-mode cluster --conf spark.security.credentials.hiveserver2.enabled=true --conf spark.sql.hive.hiveserver2.jdbc.url.principal=hive/_HOST@<your realm> --jars /usr/hdp/current/hive_warehouse_connector/<hive warehouse connector jar>,./SparkSecureHWC-Demo-1.0.jar  --class com.hwx.SparkSecureHWCDemo ./SparkSecureHWC-Demo-1.0.jar <databasename.tablename>
```
