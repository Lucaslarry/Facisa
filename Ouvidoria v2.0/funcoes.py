from time import sleep #só pra não ficar brotando tudo de uma vez na tela
def msgerro(msg):
    """Printa uma mensagem personalizada de erro
    """
    sleep(0.2)
    print(f'\033[;31mErro! {msg}.\033[m')


def msgsucesso(msg):
    """Printa uma mensagem personalizada de sucesso

    Args:
        msg (str): A mensagem que você quiser, lembranco que "com sucesso" já está incluso no final
    """
    sleep(0.2)
    print(f'\033[;32m{msg} com sucesso.\033[m')

   
def menu(opcoes):
    """Função para os menus da ouvidoria, ele pede como parametro as opções do menu e apresenta elas no terminal, logo depois pergunta o que o usuario deseja fazer e entao retorna o valor

    Args:
        opcoes (_type_): são as opções que você quer que tenha no menu

    Returns:
       op _type_: retorna pra que aba ele deseja ir 
    """
    sleep(0.5)
    print('='*60)
    id=1
    print('\033[;33mNossas opções são:\033[m')
    for opcao in opcoes:
        print(f' \033[1;30m{id}\033[m: {opcao}')
        id+=1
        sleep(0.1)
    print('='*60)
    sleep(0.5)
    try:
        op=int(input('O que deseja fazer? '))
    except:
        msgerro('Você não digitou uma opção valida')
    else:
        return op


def fazerdnv(msg):
    """Pra não ter que voltar pro menu principal todas as vezes, fiz essa função de fazer algo de novo

    Args:
        msg (str): Qual a msg que aparece

    Returns:
        int: Pra poder parar o while
    """
    while True:
        x=menu([msg,'Sair'])
        if x==1:
            break
        elif x==2:
            return x
    
                             
def comentarios(elogios,criticas,sugestoes):
    """Função feita pra adicionar comentarios nas listas de elogios, criticas e sugestões

    Args:
        elogios (lista): nome da lista de elogios
        criticas (lista): nome da ista de criticas
        sugestoes (lista): nome da lista de sugestões
    """
    while True:
        x=menu(['Elogios','Criticas','Sugestões','Voltar'])
        if x==1:
            elo=str(input('Por favor digite seu elogio: '))
            elogios.append(elo)
            msgsucesso('Elogio registrado')
        elif x==2:
            cri=str(input('Por favor digite sua critica: '))
            criticas.append(cri)
            msgsucesso('Critica registrada')
        elif x==3:
            sug=str(input('Por favor digite sua sugestão: '))
            sugestoes.append(sug)
            msgsucesso('Sugestão')
        elif x==4:
            print('Voltando...')
            break
        y=fazerdnv('Fazer mais algum comentário')
        if y==2:
            break        

 
def ver(elogios,criticas,sugestoes):
    """Função feita pra printar as listas com o id delas.

    Args:
        elogios (lista): nome da lista de elogios
        criticas (lista): nome da ista de criticas
        sugestoes (lista): nome da lista de sugestões
    """
    while True:
        x=menu(['Ver seus elogios','Ver suas Criticas','Ver suas Sugestões','Ver tudo','Voltar'])     
        id=1
        if x==1:
            print('='*60)
            print('Seus \033[;32melogios\033[m:')
            for elog in elogios:
                sleep(0.09)
                print(f'{id}: {elog}')
                id+=1
        elif x==2:
            print('='*60)
            print('Suas \033[;31mcriticas\033[m:')
            for crit in criticas:
                sleep(0.09)
                print(f'{id}: {crit}')
                id+=1
        elif x==3:
            print('='*60)
            print('Suas \033[;33msugestões\033[m:')
            for sug in sugestoes:
                sleep(0.09)
                print(f'{id}: {sug}')
                id+=1
        elif x==4:
            id1=1
            id2=1
            id3=1
            print('='*60)
            print('Seus \033[;32melogios\033[m:')
            for elog in elogios:
                sleep(0.09)
                print(f'{id1}: {elog}')
                id1+=1
            print('='*60)
            print('Suas \033[;31mcriticas\033[m:')
            for crit in criticas:
                sleep(0.09)
                print(f'{id2}: {crit}')
                id2+=1
            print('='*60)
            print('Suas \033[;33msugestões\033[m:')
            for sug in sugestoes:
                sleep(0.09)
                print(f'{id3}: {sug}')
                id3+=1
            print('='*60)
        elif x==5:
            print('Voltando...')
        y=fazerdnv('Ver mais algum comentario')
        if y==2:
            break      


def apagar(elogios,criticas,sugestoes):
    """Função para apagar um comentário ou todos das listas

    Args:
        elogios (lista): nome da lista de elogios
        criticas (lista): nome da ista de criticas
        sugestoes (lista): nome da lista de sugestões
    """
    while True:    
        id=1
        x=menu(['Apagar apenas um comentário em expecifico','Apagar tudo','Voltar'])
        if x==1:
            menu2=menu(['Apagar um elogio','Apagar uma critica','Apagar uma sugestão','Voltar pro menu principal'])
            if menu2==1:
                print('='*60)
                print('Seus \033[;32melogios\033[m:')
                for elog in elogios:
                    sleep(0.09)
                    print(f'{id}: {elog}')
                    id+=1
                try:
                    apag=int(input('Qual ID do elogio que você deseja apagar?'))
                except:
                    msgerro('Esse elogio não existe')
                else:
                    try:
                        elogios.pop(apag-1)
                    except:
                        msgerro('Não existe esse elogio')
                    else:
                        msgsucesso('Elogio apagado')
            elif menu2==2:
                print('='*60)
                print('Suas \033[;31mcriticas\033[m:')
                for crit in criticas:
                    sleep(0.09)
                    print(f'{id}: {crit}')
                    id+=1
                try:
                    apag=int(input('Qual ID da critica que você deseja apagar?'))
                except:
                    msgerro('Essa critica não existe')
                else: 
                    try:   
                        criticas.pop(apag-1)
                    except:
                        msgerro('Essa critica não existe')
                    else:
                        msgsucesso('Critica apagada')
            elif menu2==3:
                print('='*60)
                print('Suas \033[;33msugestões\033[m:')
                for sug in sugestoes:
                    sleep(0.09)
                    print(f'{id}: {sug}')
                    id+=1
                try:
                    apag=int(input('Qual ID da sugestão que você deseja apagar?'))
                except:
                    msgerro('Essa sugestão não existe')
                else:
                    try:
                        sugestoes.pop(apag-1)
                    except:
                        msgerro('Essa sugestão não existe')
                    else:
                        msgsucesso('Sugestão apagado')
            elif menu2==4:
                print('Voltado pro menu principal...')
        elif x==2:
            menu2=menu(['Apagar todos os elogios','Apagar todas as criticas','Apagar todas as sugestões','Apagar tudo','Voltar pro menu principal'])
            if menu2==1:
                elogios.clear()
                msgsucesso('Todas os elogios apagados')
            elif menu2==2:
                criticas.clear()
                msgsucesso('Todas as criticas apagadas')
            elif menu2==3:
                sugestoes.clear()
                msgsucesso('Todas as sugestões apagadas')
            elif menu2==4:
                elogios.clear()
                criticas.clear()
                sugestoes.clear()
                msgsucesso('Todos os comentários apagados')
            elif menu2==5:
                print('Voltando...')
        elif x==3:
            print('Voltando...')
        y=fazerdnv('Apagar mais algum comentário')
        if y==2:
            break      