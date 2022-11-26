from time import sleep
class Ouvidoria:
    elogios= []
    criticas= []
    sugestoes= []


    def __init__(self,nome):
        print('\033[1;35m*\033[m' * 5, f'Seja bem vindo a nossa ouvidoria, {nome}', '\033[1;35m*\033[m' * 5)


    def voltando(self):
        print('Voltando', end='',flush=True)
        sleep(0.23)
        for x in range(1,3):
            print('.', end='',flush=True)
            sleep(0.23)
        print('.')


    def msgerro(self,msg):
        sleep(0.2)
        print(f'\033[;31mErro! {msg}.\033[m')


    def msgsucesso(self,msg):
        sleep(0.2)
        print(f'\033[;32m{msg} com sucesso.\033[m')


    def menu(self,opcoes):
        sleep(0.5)
        print('='*60)
        id=1
        print('\033[;33mNossas opções são:\033[m')
        sleep(0.1)
        for opcao in opcoes:
            print(f' \033[1;30m{id}\033[m: {opcao}')
            id+=1
            sleep(0.1)
        print('='*60)
        sleep(0.5)
        

    def fazercoment(self,input,texto):
        if input=='1':
            Ouvidoria.elogios.append(texto)
            Ouvidoria.msgsucesso(self,'O seu elogio foi resgistrado')
        elif input=='2':
            Ouvidoria.criticas.append(texto)
            Ouvidoria.msgsucesso(self,'A sua critica foi registrada')
        elif input=='3':
            Ouvidoria.sugestoes.append(texto)


    def vercoment(self,input):
        if input=='1':
            id=1
            print('=' * 60)
            print('Seus \033[;32melogios\033[m:')
            for elog in Ouvidoria.elogios:
                sleep(0.09)
                print(f'\033[;36m{id}\033[m: {elog}')
                id += 1
        elif input=='2':
            id=1
            print('=' * 60)
            print('Suas \033[;31mcriticas\033[m:')
            for crit in Ouvidoria.criticas:
                sleep(0.09)
                print(f'\033[;36m{id}\033[m: {crit}')
                id += 1
        elif input=='3':
            id=1
            print('=' * 60)
            print('Suas \033[;33msugestões\033[m:')
            for sug in Ouvidoria.sugestoes:
                sleep(0.09)
                print(f'\033[;36m{id}\033[m: {sug}')
                id += 1
        elif input=='4':
            id=1
            print('=' * 60)
            print('Seus \033[;32melogios\033[m:')
            for elog in Ouvidoria.elogios:
                sleep(0.09)
                print(f'\033[;36m{id}\033[m: {elog}')
                id += 1
            id2=1
            print('=' * 60)
            print('Suas \033[;31mcriticas\033[m:')
            for crit in Ouvidoria.criticas:
                sleep(0.09)
                print(f'\033[;36m{id2}\033[m: {crit}')
                id2 += 1
            id3=1
            print('=' * 60)
            print('Suas \033[;33msugestões\033[m:')
            for sug in Ouvidoria.sugestoes:
                sleep(0.09)
                print(f'\033[;36m{id3}\033[m: {sug}')
                id3 += 1
        elif input=='5':
            Ouvidoria.voltando(self)
        else:
            Ouvidoria.msgerro(self,'Você não escolheu uma opção valida')

            
    def apagarcoment(self,input,comentario):
        if input=='1':
            try:
                Ouvidoria.elogios.pop(comentario - 1)
            except:
                Ouvidoria.msgerro(self,'Esse elogio não existe')
            else:
                Ouvidoria.msgsucesso(self,'Elogio apagado')
        elif input=='2':
            try:
                Ouvidoria.criticas.pop(comentario - 1)
            except:
                Ouvidoria.msgerro(self,'Essa critica não existe')
            else:
                Ouvidoria.msgsucesso(self,'Critica apagada')
        elif input=='3':
            try:
                Ouvidoria.sugestoes.pop(comentario - 1)
            except:
                Ouvidoria.msgerro(self,'Essa sugestão não existe')
            else:
                Ouvidoria.msgsucesso(self,'Sugestão apagada')


    def apagartudo(self,input):
        if input=='1':
            Ouvidoria.elogios.clear()
            Ouvidoria.msgsucesso(self,'Todos os elogios apagados')
        elif input=='2':
            Ouvidoria.criticas.clear()
            Ouvidoria.msgsucesso(self,'Todas as criticas apagadas')
        elif input=='3':
            Ouvidoria.sugestoes.clear()
            Ouvidoria.msgsucesso(self,'Todas as sugestões apagadas')
        elif input=='4':
            Ouvidoria.elogios.clear()
            Ouvidoria.criticas.clear()
            Ouvidoria.sugestoes.clear()
            Ouvidoria.msgsucesso(self,'Todos os comentários apagados')
        elif input=='5':
            Ouvidoria.voltando(self)
        else:
            Ouvidoria.msgerro(self,'Você não escolheu uma opção valida')
