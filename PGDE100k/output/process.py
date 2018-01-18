import os
import sys
from numpy import *

roots = {'f1/0', 'f1/1', 'f1/2', 'f1/3', 'f1/4'}
for rootdir in roots:
	train = []
	test = []
	valid = []

	minTrain = float("inf")
	idTrain = ''
	minTest = float("inf")
	idTest = ''
	minValid = float("inf")
	idValid = ''

	for subdir, dirs, files in os.walk(rootdir):
		for file in files:
			filepath = subdir + os.sep + file
			#print(filepath)
			with open(filepath) as f:
				lines = f.readlines()
			print lines[-1]
