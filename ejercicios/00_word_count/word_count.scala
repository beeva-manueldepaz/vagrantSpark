// Firt version

val text_file = sc.textFile("quijote.txt")
text_file.first()
text_file.map(line => line.split(" ").size).count()

val counts = text_file.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(_ + _)
counts.saveAsTextFile("output")

// Version cleaned
val counts = text_file.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(_ + _)

val counts = text_file.flatMap(line => line.replaceAll(",","").split(" ")).map(x => println(x))
counts.saveAsTextFile("output3")