import funcoes
nome= str(input('Para iniciar a ouvidoria digite seu nome: ')).strip().title()
ouvidoria= funcoes.Ouvidoria(nome)

while True:
    ouvidoria.menu(['Cadastrar Comentários','Ver Comentários','Apagar Comentários','Sair'])
    menu= str(input('O que deseja fazer? '))
    if menu=='1':
        ouvidoria.menu(['Elogios','Criticas','Sugestões','Voltar'])
        menucoment= str(input('O que deseja fazer? '))
        if menucoment=='1' or menucoment=='2' or menucoment=='3':
            comentario= str(input('Digite seu comentário: '))
            ouvidoria.fazercoment(menucoment,comentario)
        elif menucoment=='4':
            ouvidoria.voltando()
        else:
            ouvidoria.msgerro('Você não escolheu uma opção valida')
    elif menu=='2':
        ouvidoria.menu(['Ver elogios','Ver criticas','Ver Sugestões','Ver tudo','Voltar'])
        menuver=str(input('O que deseja fazer? '))
        ouvidoria.vercoment(menuver)