#!/bin/bash
start=${2}
end=${3}
grammar='ita.dat'
grammarDE='itaDE.dat'

for problem in 'newf1' 'newf5' 'newf5r' 'newf6' 'newf6r' 'newf7' 'newf7r' 'newf8' 'newf8r' 'newf9' 'newf9r' 'newf10' 'newf10r' 'newf11' 'newf11r'
do
	id=${1}
	#Todos os casos sao apenas no melhor individuo
	mkdir output/all/$problem
	mkdir output/all/$problem/0 #GGP normal
	mkdir output/all/$problem/1 #GGPDE no final 10%
	mkdir output/all/$problem/2 #GGPDE durante 
	mkdir output/all/$problem/3 #GGPEE 1,1 durante 
	mkdir output/all/$problem/4 #GGPEE 1,2 durante
	mkdir output/all/$problem/5 #GGPEE 1,4 durante
	mkdir output/all/$problem/6 #GGPEE 1,1 final 10%
	mkdir output/all/$problem/7 #GGPEE 1,2 final 10%
	mkdir output/all/$problem/8 #GGPEE 1,4 final 10%
	mkdir output/all/$problem/9 #GGPDE final 5%
	mkdir output/all/$problem/10 #GGPEE 1,1 final 5%
	mkdir output/all/$problem/11 #GGPEE 1,2 final 5%
	mkdir output/all/$problem/12 #GGPEE 1,4 final 5%
	#Todos os casos sao na elite
	mkdir output/all/$problem/13 #GGPDE no final 10%
	mkdir output/all/$problem/14 #GGPDE durante 
	mkdir output/all/$problem/15 #GGPEE 1,1 durante 
	mkdir output/all/$problem/16 #GGPEE 1,2 durante
	mkdir output/all/$problem/17 #GGPEE 1,4 durante
	mkdir output/all/$problem/18 #GGPEE 1,1 final 10%
	mkdir output/all/$problem/19 #GGPEE 1,2 final 10%
	mkdir output/all/$problem/20 #GGPEE 1,4 final 10%
	mkdir output/all/$problem/21 #GGPDE final 5%
	mkdir output/all/$problem/22 #GGPEE 1,1 final 5%
	mkdir output/all/$problem/23 #GGPEE 1,2 final 5%
	mkdir output/all/$problem/24 #GGPEE 1,4 final 5%
	
	for i in `seq $start $end`;
	do
		echo 'Resolvendo ' $problem ' seed: ' $i 'input/grammar/'$grammarDE 'input/data/'$problem'.dat' 'input/data/1024.grp'
		for j in `seq 0 24`;
		do
			echo '--- '$j
			./bin/Release/gpufjf $((id + i)) 'input/grammar/'$grammarDE 'input/data/'$problem'.dat' 'input/data/1024.grp' $j  > output/all/$problem/$j/$((id + i)).txt
		done
	done
done

grammarDE='polynomialDEpow.dat'
for problem in 'A10' 'AA10' 'B10' 'BB10' 'C10' 'CC10' 'D10' 'DD10'
do
	echo 'Resolvendo ' $problem

	#Todos os casos sao apenas no melhor individuo
	mkdir output/all/$problem
	mkdir output/all/$problem/0 #GGP normal
	mkdir output/all/$problem/1 #GGPDE no final 10%
	mkdir output/all/$problem/2 #GGPDE durante 
	mkdir output/all/$problem/3 #GGPEE 1,1 durante 
	mkdir output/all/$problem/4 #GGPEE 1,2 durante
	mkdir output/all/$problem/5 #GGPEE 1,4 durante
	mkdir output/all/$problem/6 #GGPEE 1,1 final 10%
	mkdir output/all/$problem/7 #GGPEE 1,2 final 10%
	mkdir output/all/$problem/8 #GGPEE 1,4 final 10%
	mkdir output/all/$problem/9 #GGPDE final 5%
	mkdir output/all/$problem/10 #GGPEE 1,1 final 5%
	mkdir output/all/$problem/11 #GGPEE 1,2 final 5%
	mkdir output/all/$problem/12 #GGPEE 1,4 final 5%
	#Todos os casos sao na elite
	mkdir output/all/$problem/13 #GGPDE no final 10%
	mkdir output/all/$problem/14 #GGPDE durante 
	mkdir output/all/$problem/15 #GGPEE 1,1 durante 
	mkdir output/all/$problem/16 #GGPEE 1,2 durante
	mkdir output/all/$problem/17 #GGPEE 1,4 durante
	mkdir output/all/$problem/18 #GGPEE 1,1 final 10%
	mkdir output/all/$problem/19 #GGPEE 1,2 final 10%
	mkdir output/all/$problem/20 #GGPEE 1,4 final 10%
	mkdir output/all/$problem/21 #GGPDE final 5%
	mkdir output/all/$problem/22 #GGPEE 1,1 final 5%
	mkdir output/all/$problem/23 #GGPEE 1,2 final 5%
	mkdir output/all/$problem/24 #GGPEE 1,4 final 5%

	id=${1}
	for i in `seq $start $end`;
	do
		echo 'Resolvendo ' $problem ' seed: ' $i 'input/grammar/'$grammarDE 'input/data/'$problem'.dat' 'input/data/1024.grp'
		for j in `seq 0 24`;
		do
			echo '--- '$j
			./bin/Release/gpufjf $((id + i)) 'input/grammar/'$grammarDE 'input/data/'$problem'.dat' 'input/data/1024.grp' $j  > output/all/$problem/$j/$((id + i)).txt
		done
	done
done
