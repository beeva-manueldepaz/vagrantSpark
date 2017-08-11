/*
import org.apache.spark.sql.SQLContext

val sqlContext = new SQLContext(sc)
val countries = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").load("country.csv")
*/
/*
Note that:
 .option("header", "true") // Use first line of all files as header
 .option("inferSchema", "true") // Automatically infer data types
*/

// BOrrar texto

case class Country(id:Int, country:String)
val countries = sc.textFile("country.csv")
countries.map(f => { val campos = f.split(","); new Country(campos(0).toInt, campos(1));}).map(country => (country.id, country))
//val mappedCountries = countries.map(f => { val campos = f.split(","); new Country(campos(0).toInt, campos(1));}).map(country => (country.id, country))


case class Users(id:Int, first_name:String,last_name:String,email:String,gender:String,location:String)
val users = sc.textFile("users.csv")
users.map(f => { val campos = f.split(","); new Country(campos(0).toInt, campos(1));}).map(user => (user.id, user))

//val mappedUsers = users.map(f => { val campos = f.split(","); new Country(campos(0).toInt, campos(1));}).map(country => (country.id, country))



val users = sqlContext.csvFile("cars.csv")
val mappedUsers = users.map(user => (user.id, user))
val countries = sqlContext.csvFile("country.csv")

mappedUsers.join(mappedCountries).take(10).foreach(println)

/*
case class Item(id:Int, country:String)
val i1 = Item("1", "first", 2, "c1")
val i2 = i1.copy(id="2", name="second")
val i3 = i1.copy(id="3", name="third", companyId="c2")

case class Company(companyId:String, name:String, city:String)
val items = sc.parallelize(List(i1,i2,i3))
val c1 = Company("c1", "company-1", "city-1")
val c2 = Company("c2", "company-2", "city-2")

val companies = sc.parallelize(List(c1,c2))
val groupedItems = items.groupBy( x => x.companyId) 
val groupedComp = companies.groupBy(x => x.companyId)
groupedItems.join(groupedComp).take(10).foreach(println)
*/
