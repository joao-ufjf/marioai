#!/bin/bash
start=${1}
end=${2}
grammar='mario3x3.gram'
grammarDE='itaDE.dat'

rmdir output/mario
mkdir output/mario
for g in 'mario3x3.gram' 'mario5x5.gram' 'mario7x7.gram'
do
	mkdir output/mario/$g
	for i in `seq $start $end`;
	do
		echo 'Resolvendo ' $g ' seed: ' $i 'input/grammar/'$g
		./bin/Release/gpufjf $i 'input/grammar/'$g 'input/data/newf7r.dat input/data/1024.grp 0'  > output/mario/$g/$i.txt
	done
done
