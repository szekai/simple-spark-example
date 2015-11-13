import org.apache.spark.SparkConf

/**
  * Created by 608658948 on 13/11/2015.
  */
object SparkSqlCsvJsonExample {
  def main(args : Array[String]): Unit ={
    val conf = new SparkConf().setAppName("Simple Application").setMaster("local[2]").set("spark.executor.memory","1g")
    val sc = new org.apache.spark.SparkContext(conf)
    val sqlc = new org.apache.spark.sql.SQLContext(sc)

    val NyseDF =sqlc.load("com.databricks.spark.csv",Map("path"->args(0),"header"->"true"))
    NyseDF.registerTempTable("NYSE")
    NyseDF.printSchema()

    print(sqlc.sql("select distinct(symbol)from NYSE").collect.toList)

    val countNyse = NyseDF.agg(("*","count"))
    countNyse.collect().foreach(println)

    val PersonDF = sqlc.jsonFile("src/test/resources/Person.json")
    PersonDF.printSchema()

    PersonDF.registerTempTable("Person")
    sqlc.sql("select * from Person where age < 60").collect.foreach(print)
  }
}
