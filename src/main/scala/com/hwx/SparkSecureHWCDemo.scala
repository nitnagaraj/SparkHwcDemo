package com.hwx

  import com.hortonworks.hwc.HiveWarehouseSession
  import org.apache.spark.SparkConf
  import org.apache.spark.sql.SparkSession
  import org.apache.spark.streaming.{Seconds, StreamingContext}

  object SparkSecureHWCDemo extends App {


  import com.hortonworks.hwc.HiveWarehouseSession
  val spark = SparkSession.builder.appName("Simple Application").getOrCreate()
  val hive = HiveWarehouseSession.session(spark).build()
  hive.execute("show databases").show

  val tname = args(0)

  hive.executeQuery(s"select * from $tname").show()


  } 

