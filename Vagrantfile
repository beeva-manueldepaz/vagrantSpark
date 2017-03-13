# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|
  config.vm.box = "ubuntu/trusty64"

  config.vm.provider "virtualbox" do |v|
	v.memory = 4096
  end

  config.vm.network "forwarded_port", guest: 4040, host: 4040
  config.vm.synced_folder ".", "/vagrant", type:"virtualbox"

  config.vm.provision "shell", inline: <<-SHELL
    chmod +x /vagrant/install.sh
    bash -c '/vagrant/install.sh'
  SHELL
end
