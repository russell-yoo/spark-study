import org.apache.spark.sql.SparkSession

object Main {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("Spark Study")
      .master("local[1]")
      .config("spark.driver.bindAddress", "127.0.0.1")
      .getOrCreate()

    import spark.implicits._

    val dataset = spark.createDataset(Seq(1, 2, 3))

    dataset.show(dataset.count.asInstanceOf[Int])
  }
}
