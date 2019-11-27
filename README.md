# Spark-Secure - Hive warehouse connector Example

You can query on your existing Hive table with HWC using below example. This will take your database and table name and then connects to Hive through HWC to retrive the data.

To submit application to Yarn in client mode

spark-submit:

<code>
  /usr/hdp/current/spark2-client/bin/spark-submit --master yarn --deploy-mode client --conf spark.security.credentials.hiveserver2.enabled=false --jars /usr/hdp/current/hive_warehouse_connector/<hive warehouse connector jar>,./SparkSecureHWC-Demo-1.0.jar  --class com.hwx.SparkSecureHWCDemo ./SparkSecureHWC-Demo-1.0.jar <databasename.tablename>
<code>

To submit application to Yarn in cluster mode

spark-submit:
<code>
/usr/hdp/current/spark2-client/bin/spark-submit --master yarn --deploy-mode cluster --conf spark.security.credentials.hiveserver2.enabled=true --conf spark.sql.hive.hiveserver2.jdbc.url.principal=hive/_HOST@<your realm> --jars /usr/hdp/current/hive_warehouse_connector/<hive warehouse connector jar>,./SparkSecureHWC-Demo-1.0.jar  --class com.hwx.SparkSecureHWCDemo ./SparkSecureHWC-Demo-1.0.jar <databasename.tablename>
<code>
