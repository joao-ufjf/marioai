#!/bin/bash

experiment=${1}

id=${1}
	echo Todos os casos sao apenas no melhor individuo
	echo 0 GGP normal
	echo 1 GGPDE no final 10%
	echo 2 GGPDE durante 
	echo 3 GGPEE 1,1 durante 
	echo 4 GGPEE 1,2 durante
	echo 5 GGPEE 1,4 durante
	echo 6 GGPEE 1,1 final 10%
	echo 7 GGPEE 1,2 final 10%
	echo 8 GGPEE 1,4 final 10%
	echo 9 GGPDE final 5%
	echo 10 GGPEE 1,1 final 5%
	echo 11 GGPEE 1,2 final 5%
	echo 12 GGPEE 1,4 final 5%
	echo Todos os casos sao na elite
	echo 13 GGPDE no final 10%
	echo 14 GGPDE durante 
	echo 15 GGPEE 1,1 durante 
	echo 16 GGPEE 1,2 durante
	echo 17 GGPEE 1,4 durante
	echo 18 GGPEE 1,1 final 10%
	echo 19 GGPEE 1,2 final 10%
	echo 20 GGPEE 1,4 final 10%
	echo 21 GGPDE final 5%
	echo 22 GGPEE 1,1 final 5%
	echo 23 GGPEE 1,2 final 5%
	echo 24 GGPEE 1,4 final 5%

for table in $experiment/*;
do
	echo "%$table"
	python process2.py $table
done
