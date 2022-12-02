from time import sleep
import database
class Ouvidoria:
    conexao= database.logar('localhost','root','lucas')
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
        if input == '1':
            comando = 'INSERT INTO ELOGIOS (elogios) values (%s)'
            database.fazercoment(Ouvidoria.conexao,comando,[texto])
        elif input == '2':
            comando = 'INSERT INTO CRITICAS (criticas) values (%s)'
            database.fazercoment(Ouvidoria.conexao,comando,[texto])
        elif input == '3':
            comando = 'INSERT INTO SUGESTÕES (sugestões) values (%s)'
            database.fazercoment(Ouvidoria.conexao,comando,[texto])
    

    def vercoment(self,input):
        pass