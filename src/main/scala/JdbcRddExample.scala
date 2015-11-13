import java.sql.DriverManager

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.JdbcRDD

/**
  * Created by 608658948 on 13/11/2015.
  */
object JdbcRddExample {

  def main(args: Array[String]): Unit ={
    val url="jdbc:mysql://hdpserver.itversity.com/demo"
    val username = "demo_user"
    val password = "itversity"
    Class.forName("com.mysql.jdbc.Driver").newInstance()

    val conf = new SparkConf().setAppName("JDBC RDD").setMaster("local[2]").set("spark.executor.memory", "1g")
    val sc = new SparkContext(conf)

    val myRDD = new JdbcRDD(sc, () => DriverManager.getConnection(url,username,password),
    "select first_name, last_name, gender from person limit ?, ?",
    3,5,1,r => r.getString("last_name") + "," + r.getString("first_name"))

    myRDD.foreach(println)
    myRDD.saveAsTextFile("C:\\jdbcrdd")
  }

}
