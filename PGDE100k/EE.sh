#!/bin/bash
start=${1}
end=${2}

echo 2000x50
./bin/Release/gpufjf 10 input/grammar/mario7x7.gram input/data/newf7r.dat input/data/1024.grp 0 save/2000x50.10.java > output/2000x50/10.dat 10 10
echo 1000x100
./bin/Release/gpufjf 10 input/grammar/mario7x7.gram input/data/newf7r.dat input/data/1024.grp 0 save/1000x100.10.java > output/1000x100/10.dat 10 10
