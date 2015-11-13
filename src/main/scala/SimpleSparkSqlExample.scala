import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by 608658948 on 13/11/2015.
  */

case class Person(first_name:String,last_name:String,age:Int)

object SimpleSparkSqlExample {
  def main(args : Array[String]): Unit ={
    val conf = new SparkConf().setAppName("SimpleSparkSQL Application").setMaster("local[2]").set("spark.executor.memory","1g")
    val sc = new SparkContext(conf)

    val sqlc = new org.apache.spark.sql.SQLContext(sc)//sqlsc

    val p = sc.textFile("src/test/resources/Person")
    val pmap = p.map(p => p.split(","))
    val PersonRdd = pmap.map(p=> Person(p(0),p(1),p(2).toInt))

    import sqlc.implicits._

    val PersonDF = PersonRdd.toDF //RDD+Schema, DF= Dataframe
    PersonDF.registerTempTable("Person")

    print(sqlc.sql("select * from Person").collect().toList)
  }
}

