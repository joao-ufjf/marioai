 # -*- coding: latin-1 -*-
import sys
import random

nome_arquivo = sys.argv[1]
i = sys.argv[2]
tam_treino = int(sys.argv[3])
tam_teste = int(sys.argv[4])
tam_validacao = int(sys.argv[5])

treino_vec = []
validacao_vec = []
teste_vec = []

random.seed(i)
cont = 0
tam_total = int(tam_treino) + int(tam_validacao) + int(tam_teste)
lista = range(tam_total)
random.shuffle(lista)


for i in range(tam_treino):
	treino_vec.append(lista[cont])
	cont = cont+1
for i in range(tam_teste):
	teste_vec.append(lista[cont])
	cont = cont+1
for i in range(tam_validacao):
	validacao_vec.append(lista[cont])
	cont = cont+1
cont = 0
treino_vec.sort()
validacao_vec.sort()
teste_vec.sort()


arq = open("../input/data/group/"+nome_arquivo+".grp", "w")
arq.write(str(tam_treino)+" "+str(tam_teste)+" "+str(tam_validacao)+" ")
arq.write("\n")
for i in range(tam_treino):
	arq.write( str(treino_vec[cont]) )
	arq.write(" ")
	cont = cont+1

arq.write("\n")
for i in range(tam_teste):
	arq.write( str(teste_vec[cont-tam_treino]) )
	arq.write(" ")
	cont = cont+1

arq.write("\n")
for i in range(tam_validacao):
	arq.write( str(validacao_vec[cont-tam_treino-tam_teste]) )
	arq.write(" ")
	cont = cont+1
	#para inserir quebra de linha
arq.write("\n")
