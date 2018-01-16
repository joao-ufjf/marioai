from __future__ import print_function
import os
import sys
from numpy import *

root= sys.argv[1]
roots = []
roots.append((root+'/mario3x3'))
roots.append((root+'/mario5x5'))
roots.append((root+'/mario7x7'))

for rootdir in roots:
	for subdir, dirs, files in sorted(os.walk(rootdir)):
		training = []
		maxLevel = []
		win0 = []
		win3 = []
		win5 = []
		win10 = []
		score0 = []
		score3 = []
		score5 = []
		score10 = []
		print(rootdir)
		for file in sorted(files):
			filepath = subdir + os.sep + file
			#print(filepath)
			with open(filepath) as f:
				lines = f.readlines()
			training.append(float(lines[-1].split(' ')[0]))			
			maxLevel.append(float(lines[-6].split(' ')[1]))
			win0.append(float(lines[-5].split(' ')[1]))
			score0.append(float(lines[-5].split(' ')[2]))
			win3.append(float(lines[-4].split(' ')[1]))
			score3.append(float(lines[-4].split(' ')[2]))
			win5.append(float(lines[-3].split(' ')[1]))
			score5.append(float(lines[-3].split(' ')[2]))
			win10.append(float(lines[-2].split(' ')[1]))
			score10.append(float(lines[-2].split(' ')[2]))
		print(min(training), median(training), mean(training), std(training), max(training))
		print(min(maxLevel), median(maxLevel), mean(maxLevel), std(maxLevel), max(maxLevel))
