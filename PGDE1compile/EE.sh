#!/bin/bash
start=${1}
end=${2}

for dir in 'mario100x100' #'mario50x100'
do
	mkdir output/$dir
	for g in 'mario3x3' 'mario5x5' 'mario7x7' 
	do
		mkdir output/$dir/$g
	done
	
	for i in `seq $start $end`;
	do
		for g in 'mario3x3' 'mario5x5' 'mario7x7' 
		do
			echo 'Resolvendo approach: ' $dir ' seed: ' $i ' grammar: ' $g
			./bin/Release/gpufjf $i input/grammar/$g.gram input/data/newf7r.dat input/data/1024.grp 0 save/$g.$i.java > output/$dir/$g/$i.dat
		done
	done
done
