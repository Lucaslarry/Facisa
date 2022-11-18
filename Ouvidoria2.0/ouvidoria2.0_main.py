import funcoes

listaelogios=[]
listacriticas=[]
listasugestoes=[]

nome=str(input('Para iniciar a ouvidoria digite seu nome: ')).strip().title()
print('\033[1;35m*\033[m'*5,f'Seja bem vindo a nossa ouvidoria, {nome}','\033[1;35m*\033[m'*5)

while True:
    op=funcoes.menu(['Cadastrar Comentários','Ver Comentários','Apagar Comentários','Sair'])
    if op==1:
        funcoes.comentarios(listaelogios,listacriticas,listasugestoes)
    elif op==2:
        funcoes.ver(listaelogios,listacriticas,listasugestoes)
    elif op==3:
        funcoes.apagar(listaelogios,listacriticas,listasugestoes)
    elif op==4:
        print('Obrigado pelo feedback')
        break
        