#!/bin/bash
start=${1}
end=${2}
grammar='mario3x3.gram'
grammarDE='itaDE.dat'

#rmdir output/mario
mkdir output/mario
for g in 'mario3x3'
do
	mkdir output/mario/$g
	for i in `seq $start $end`;
	do
		echo 'Resolvendo ' $g ' seed: ' $i 'input/grammar/'$g.gram
		./bin/Release/gpufjf $i input/grammar/$g.gram input/data/newf7r.dat input/data/1024.grp 0 save/$g.$i.10.java
# > output/mario/$g/$i.dat
	done
done
