
mysql> create database wdwk default charset utf8 default collate utf8_bin;
mysql> grant all on wdwk.* to 'wdwk'@'localhost' identified by 'wdwk';
mysql> grant all on wdwk.* to 'wdwk'@'localhost.localdomain' identified by 'wdwk';
mysql> grant all on wdwk.* to 'wdwk'@'%' identified by 'wdwk';
