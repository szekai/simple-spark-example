name := "simple-spark-project"

version := "1.0"

scalaVersion := "2.11.7"

val sparkVersion = "1.5.2"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-streaming" % sparkVersion,
  "mysql" % "mysql-connector-java" % "5.1.37",
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "com.databricks" %% "spark-csv" % "1.2.0",
  "org.apache.spark" %% "spark-streaming-twitter" % sparkVersion,
  "org.twitter4j" % "twitter4j-stream" % "3.0.3",
  "org.twitter4j" % "twitter4j-core" % "3.0.3",
  "org.twitter4j" % "twitter4j" % "3.0.3"
)
