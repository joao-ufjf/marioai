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
		all = []
		all.append(training)		
		all.append(maxLevel)		
		all.append(win0)		
		all.append(score0)
		all.append(win3)		
		all.append(score3)
		all.append(win5)		
		all.append(score5)
		all.append(win10)		
		all.append(score10)
		
		names = []
		names.append("training")		
		names.append("maxLevel")		
		names.append("win0")		
		names.append("score0")
		names.append("win3")		
		names.append("score3")
		names.append("win5")		
		names.append("score5")
		names.append("win10")		
		names.append("score10")
		i = 0		
		
		print("Nome & min & max & median & mean & std & max \\\ ")
		for line in all:
			#print(line)
			print(names[i], " & ", min(line), " & ", median(line), " & ", mean(line), " & ", std(line), " & ", max(line), " \\\ ")
			i += 1
