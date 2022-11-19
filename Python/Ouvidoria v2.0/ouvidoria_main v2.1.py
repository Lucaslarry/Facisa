import funcoes

ouvidoria = funcoes.Ouvidoria()

while True:
    Menu= ouvidoria.menu(['Cadastrar Comentários','Ver Comentários','Apagar Comentários','Sair'])
    if Menu==1:
        ouvidoria.comentarios()
    if Menu==2:
        ouvidoria.ver()
    if Menu==3:
        ouvidoria.apagar()
    if Menu==4:
        print('Obrigado pelo Feedback')
        break
