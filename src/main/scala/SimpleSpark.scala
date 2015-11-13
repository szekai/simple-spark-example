import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by 608658948 on 12/11/2015.
  */
object SimpleSpark {
  def main(args: Array[String]): Unit ={
    val logFile = "C:\\apps\\spark-1.5.2-bin-hadoop2.4\\README.md"
    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("hadoop")).count()
    val numBs = logData.filter(line => line.contains("spark")).count()
    println("Lines with hadoop: %s, Lines with spark: %s".format(numAs, numBs))
  }
}
