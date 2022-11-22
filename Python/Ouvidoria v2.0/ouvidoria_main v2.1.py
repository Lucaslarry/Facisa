import funcoes
nome= str(input('Para iniciar a ouvidoria digite seu nome: ')).strip().title()
ouvidoria= funcoes.Ouvidoria(nome)

while True:
    ouvidoria.menu(['Cadastrar Comentários','Ver Comentários','Apagar Comentários','Sair'])
    menu= str(input('O que deseja fazer? '))
    if menu=='1':
        ouvidoria.menu(['Elogios','Criticas','Sugestões','Voltar'])
        menucoment= str(input('O que deseja fazer? '))
        if menucoment=='1':
            comentario= str(input('Digite seu elogio: '))
            ouvidoria.fazercoment(ouvidoria.elogios,'elogio',comentario,'seu','O')
        elif menucoment=='2':
            comentario= str(input('Digite sua critica: '))
            ouvidoria.fazercoment(ouvidoria.criticas,'critica', comentario)
        elif menucoment=='3':
            comentario= str(input('Digite sua sugestão: '))
            ouvidoria.fazercoment(ouvidoria.sugestoes,'sugestão', comentario)
        elif menucoment=='4':
            ouvidoria.voltando()
        else:
            ouvidoria.msgerro('Você não escolheu uma opção valida')
    elif menu=='2':
        ouvidoria.menu(['Ver elogios','Ver criticas','Ver Sugestões','Ver tudo','Voltar'])
        menuver=str(input('O que deseja fazer? '))
        if menuver=='1':
            ouvidoria.vercoment(ouvidoria.elogios,'elogios','2','Seus')
        elif menuver=='2':
            ouvidoria.vercoment(ouvidoria.criticas,'criticas','1')
        elif menuver=='3':
            ouvidoria.vercoment(ouvidoria.sugestoes,'sugestões','3')
        elif menuver=='4':
            ouvidoria.vercoment(ouvidoria.elogios,'elogios','2','Seus')
            ouvidoria.vercoment(ouvidoria.criticas,'criticas','1')
            ouvidoria.vercoment(ouvidoria.sugestoes,'sugestões','3')
        elif menuver=='5':
            ouvidoria.voltando()
        else:
            ouvidoria.msgerro('Você não escolheu uma opção valida')
    elif menu=='3':
        ouvidoria.menu(['Apagar um comentário','Apagar todos os comentários','Voltar'])
        menuapagar= str(input('O que deseja Fazer? '))
        if menuapagar=='1':
            ouvidoria.menu(['Apagar um elogio', 'Apagar uma critica', 'Apagar uma sugestão', 'Voltar pro menu principal'])
            menuapagar2= str(input('O que deseja fazer? '))
            if menuapagar2=='1':
                ouvidoria.vercoment(ouvidoria.elogios,'elogios','2','Seus')
                try:
                    apag = int(input(f'Qual ID do elogio que você deseja apagar? '))
                except:
                    ouvidoria.msgerro(f'Esse elogio não existe')
                else:
                    ouvidoria.apagarcoment(ouvidoria.elogios,'elogio',apag,'o')         
            elif menuapagar2=='2':
                ouvidoria.vercoment(ouvidoria.criticas,'criticas','1')
                try:
                    apag = int(input(f'Qual ID da critica que você deseja apagar? '))
                except:
                    ouvidoria.msgerro(f'Essa critica não existe')
                else:
                    ouvidoria.apagarcoment(ouvidoria.criticas,'critica',apag)
            elif menuapagar2=='3':
                ouvidoria.vercoment(ouvidoria.sugestoes,'sugestões','3')
                try:
                    apag = int(input(f'Qual ID da sugestão que você deseja apagar? '))
                except:
                    ouvidoria.msgerro(f'Essa sugestão não existe')
                else:
                    ouvidoria.apagarcoment(ouvidoria.sugestoes,'sugestão',apag)
            elif menuapagar2=='4':
                ouvidoria.voltando()
            else:
                ouvidoria.msgerro('Você não escolheu uma opção valida')
        elif menuapagar=='2':
            ouvidoria.menu(['Apagar todos os elogios','Apagar todas as criticas','Apagar todas as sugestões','Apagar tudo','Voltar pro menu principal'])
            menuapagar3=str(input('O que deseja fazer? '))
            if menuapagar3=='1':
                ouvidoria.elogios.clear()
                ouvidoria.msgsucesso('Todos os elogios apagados')
            elif menuapagar3=='2':
                ouvidoria.criticas.clear()
                ouvidoria.msgsucesso('Todas as criticas apagadas')
            elif menuapagar3=='3':
                ouvidoria.sugestoes.clear()
                ouvidoria.msgsucesso('Todas as sugestões apagadas')
            elif menuapagar3=='4':
                ouvidoria.elogios.clear()
                ouvidoria.criticas.clear()
                ouvidoria.sugestoes.clear()
                ouvidoria.msgsucesso('Todas os comentários apagados')
            elif menuapagar3=='5':
                ouvidoria.voltando()
            else:
                ouvidoria.msgerro('Você não escolheu uma opção valida')
        elif menuapagar=='3':
            ouvidoria.voltando()
        else:
            ouvidoria.msgerro('Você não escolheu uma opção valida')
    elif menu=='4':
        print('Obrigado pelo feedback')
        break
    else:
        ouvidoria.msgerro('Você não escolheu uma opção valida')