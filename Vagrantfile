# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|
  config.vm.box = "ubuntu/trusty64"
  
  config.vm.provider "virtualbox" do |v|
	v.memory = 4096
  end
  
  config.vm.synced_folder ".", "/vagrant", type:"virtualbox"

  config.vm.provision "shell", inline: <<-SHELL
		# java install
		sudo apt-get update
		sudo add-apt-repository ppa:openjdk-r/ppa -y
		sudo apt-get update
		sudo apt-get -f install -y
		sudo apt-get install openjdk-8-jdk
  
		# scala install
		wget www.scala-lang.org/files/archive/scala-2.11.7.deb
		sudo dpkg -i scala-2.11.7.deb
		rm scala-2.11.7.deb
		 
		# sbt installation
		echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list
		sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 642AC823
		sudo apt-get update
		sudo apt-get -f install -y
		sudo apt-get install sbt
		sudo apt-get update
		sudo apt-get -f install -y
		sudo apt-get autoremove -y
  SHELL
end
