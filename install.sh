#!/bin/bash 

# java install
sudo apt-get update
sudo add-apt-repository ppa:openjdk-r/ppa -y
sudo apt-get update
sudo apt-get -f install -y
sudo apt-get install -y openjdk-8-jdk

# scala install
wget --quiet www.scala-lang.org/files/archive/scala-2.11.7.deb
sudo dpkg -i scala-2.11.7.deb
rm scala-2.11.7.deb

# sbt installation
wget --quiet https://dl.bintray.com/sbt/native-packages/sbt/0.13.13/sbt-0.13.13.tgz
sudo mv sbt-0.13.13.tgz /opt
cd /opt && sudo tar xvzf sbt-0.13.13.tgz
sudo ln -s sbt-launcher-packaging-0.13.13/ sbt
sudo rm /opt/sbt-0.13.13.tgz

# spark install
wget --quiet http://d3kbcqa49mib13.cloudfront.net/spark-2.1.0-bin-hadoop2.7.tgz
sudo mv spark-2.1.0-bin-hadoop2.7.tgz /opt
cd /opt && sudo tar xvzf spark-2.1.0-bin-hadoop2.7.tgz
sudo ln -s spark-2.1.0-bin-hadoop2.7 spark
sudo rm /opt/spark-2.1.0-bin-hadoop2.7.tgz

# env config
echo "export PATH=$PATH:/opt/sbt/bin:/opt/spark/bin" >> /home/vagrant/.bashrc
