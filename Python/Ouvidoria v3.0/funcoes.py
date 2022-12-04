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
        if input == '1':
            comando= 'SELECT * FROM ELOGIOS'
            database.vercoment(Ouvidoria.conexao,comando,'Seus \033[;32mElogios:\033[m')
        elif input == '2':
            comando= 'SELECT * FROM CRITICAS'
            database.vercoment(Ouvidoria.conexao,comando,'Suas \033[;31mCriticas:\033[m')
        elif input == '3':
            comando= 'SELECT * FROM SUGESTÕES'
            database.vercoment(Ouvidoria.conexao,comando,'Suas \033[;34mSugestões:\033[m')
        elif input == '4':
            comando= 'SELECT * FROM ELOGIOS'
            database.vercoment(Ouvidoria.conexao,comando,'Seus \033[;32mElogios:\033[m')
            comando= 'SELECT * FROM CRITICAS'
            database.vercoment(Ouvidoria.conexao,comando,'Suas \033[;31mCriticas:\033[m')
            comando= 'SELECT * FROM SUGESTÕES'
            database.vercoment(Ouvidoria.conexao,comando,'Suas \033[;34mSugestões:\033[m')
        

    def apagarcoment(self,input,comentario):
        if input == '1':
            try:
                comando= 'DELETE FROM ELOGIOS WHERE ID = %s'
                database.apagarcoment(Ouvidoria.conexao,comando,comentario)
            except:
                Ouvidoria.msgerro(self,'Esse elogio não existe')
            else:
                Ouvidoria.msgsucesso(self,'Elogio apagado')
        elif input == '2':
            try:
                comando= 'DELETE FROM CRITICAS WHERE ID = %s'
                database.apagarcoment(Ouvidoria.conexao,comando,comentario)
            except:
                Ouvidoria.msgerro(self,'Essa critica não existe')
            else:
                Ouvidoria.msgsucesso(self,'Critica apagado')
        elif input == '3':
            try:
                comando= 'DELETE FROM SUGESTÕES WHERE ID = %s'
                database.apagarcoment(Ouvidoria.conexao,comando,comentario)
            except:
                Ouvidoria.msgerro(self,'Essa Sugestão não existe')
            else:
                Ouvidoria.msgsucesso(self,'Sugestão apagada')
    

    def apagartudo(self,input):
        if input == '1':
            comando= 'TRUNCATE ELOGIOS'
            database.apagarcoment(Ouvidoria.conexao,comando)
            Ouvidoria.msgsucesso(self,'Todos os elogios apagados')
        elif input == '2':
            comando= 'TRUNCATE CRITICAS'
            database.apagarcoment(Ouvidoria.conexao,comando)
            Ouvidoria.msgsucesso(self,'Todas as criticas apagadas')
        elif input == '3':
            comando= 'TRUNCATE SUGESTÕES'
            database.apagarcoment(Ouvidoria.conexao,comando)
            Ouvidoria.msgsucesso(self, 'Todas as sugestões apagadas')
        elif input == '4':
            comando= 'TRUNCATE ELOGIOS'
            database.apagarcoment(Ouvidoria.conexao,comando)
            comando= 'TRUNCATE CRITICAS'
            database.apagarcoment(Ouvidoria.conexao,comando)
            comando= 'TRUNCATE SUGESTÕES'
            database.apagarcoment(Ouvidoria.conexao,comando)
            Ouvidoria.msgsucesso(self,'Todos os comentários apagados')