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
    elif menu=='3':
        ouvidoria.menu(['Apagar um comentário','Apagar todos os comentários','Voltar'])
        menuapagar= str(input('O que deseja Fazer? '))
        if menuapagar=='1':
            ouvidoria.menu(['Apagar um elogio', 'Apagar uma critica', 'Apagar uma sugestão', 'Voltar pro menu principal'])
            menuapagar2= str(input('O que deseja fazer? '))
            if menuapagar2=='1' or menuapagar2=='2' or menuapagar2=='3':
                ouvidoria.vercoment(menuapagar2)
                try:
                    apag=int(input('Qual id do comentário que deseja apagar? '))
                except:
                    ouvidoria.msgerro('Você não escolheu uma opção valida')
                else:
                    ouvidoria.apagarcoment(menuapagar2,apag)
            elif menuapagar2=='4':
                ouvidoria.voltando()
            else:
                ouvidoria.msgerro('Você não escolheu uma opção valida')
        elif menuapagar=='2':
            ouvidoria.menu(['Apagar todos os elogios','Apagar todas as criticas','Apagar todas as sugestões','Apagar tudo','Voltar pro menu principal'])
            menuapagar2= str(input('O que deseja fazer? '))
            ouvidoria.apagartudo(menuapagar2)
        elif menuapagar=='3':
            ouvidoria.voltando()
        else:
            ouvidoria.msgerro('Você não escolheu uma opção valida')
    elif menu=='4':
        print('Obrigado pelo feedback')
        break
    else:
        ouvidoria.msgerro('Você não escolheu uma opção valida')