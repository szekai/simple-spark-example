import org.apache.spark.SparkConf

/**
  * Created by 608658948 on 13/11/2015.
  */
object SparkExample {
  def main(args : Array[String]): Unit ={
    val conf = new SparkConf().setAppName("Simple Application").setMaster("local[2]").set("spark.executor.memory","1g")
    val sc = new org.apache.spark.SparkContext(conf)
    val sqlc = new org.apache.spark.sql.SQLContext(sc)
  }
}
