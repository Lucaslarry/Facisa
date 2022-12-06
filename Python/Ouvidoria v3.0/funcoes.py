from time import sleep #Modulo pra adicionar um delay entre as informações

import database #Arquivo da classe com as funções que utiliza o Modulo do MySql

class Ouvidoria:
    
    conexao= database.logar('localhost','root','lucas') #Variavel que se conecta ao banco de dados
   
    def __init__(self,nome):
        """Classe com as funções da Ouvidoria

        Args:
            nome (str): Nome do Usuario
        """
        print('\033[1;35m*\033[m' * 5, f'Seja bem vindo a nossa ouvidoria, {nome}', '\033[1;35m*\033[m' * 5)
    

    def msg_voltando(self):
        """Função com uma mensagem de voltando como os "." como se estivesse carregando
        """
        print('Voltando', end='',flush=True)
        for x in range(1,4):
            sleep(0.3)
            print('.', end='',flush=True)
 
    

    def msg_erro(self,msg=''):
        """Função que imprime uma mensagem na cor vermelha para se usar nas exeções do codigo

        Args:
            msg (str, optional): Mensagem que quer que apareça como erro. Defaults to ''.
        """
        sleep(0.2)
        print(f'\033[;31mErro! {msg}.\033[m')


    def msg_sucesso(self,msg='Ocorrido'):
        """Função que imprime uma mensagem na cor verde para se usar quando for executado

        Args:
            msg (str, optional): Mensagem que quer que apareça. Defaults to 'Ocorrido'.
        """
        sleep(0.2)
        print(f'\033[;32m{msg} com sucesso.\033[m')


    def menu(self,opcoes):
        """Função para se criar menus, já imprime com o id da opção ao lado 

        Args:
            opcoes (str): _description_
        """
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
        
    
    def fazer_coment(self,input,texto):
        """Função para adicionar comentários e passar para o banco de dados

        Args:
            input (str): input que vem do arquivo main com a opção escolhida pelo usuario
            texto (str): Comentário que o usuario deseja adicionar
        """
        if input == '1':
            comando = 'INSERT INTO ELOGIOS (elogios) values (%s)'
            database.fazer_coment(Ouvidoria.conexao,comando,[texto])
        
        elif input == '2':
            comando = 'INSERT INTO CRITICAS (criticas) values (%s)'
            database.fazer_coment(Ouvidoria.conexao,comando,[texto])
        
        elif input == '3':
            comando = 'INSERT INTO SUGESTÕES (sugestões) values (%s)'
            database.fazer_coment(Ouvidoria.conexao,comando,[texto])
    

    def ver_coment(self,input):
        """Fução para listar comentários e passar para o bancno de dados

        Args:
            input (str): input que vem do arquivo main com a opção escolhida pelo usuario
        """
        if input == '1':
            comando= 'SELECT * FROM ELOGIOS'
            database.ver_coment(Ouvidoria.conexao,comando,'Seus \033[;32mElogios:\033[m')
        
        elif input == '2':
            comando= 'SELECT * FROM CRITICAS'
            database.ver_coment(Ouvidoria.conexao,comando,'Suas \033[;31mCriticas:\033[m')
        
        elif input == '3':
            comando= 'SELECT * FROM SUGESTÕES'
            database.ver_coment(Ouvidoria.conexao,comando,'Suas \033[;34mSugestões:\033[m')
        
        elif input == '4':
            comando= 'SELECT * FROM ELOGIOS'
            database.ver_coment(Ouvidoria.conexao,comando,'Seus \033[;32mElogios:\033[m')
            comando= 'SELECT * FROM CRITICAS'
            database.ver_coment(Ouvidoria.conexao,comando,'Suas \033[;31mCriticas:\033[m')
            comando= 'SELECT * FROM SUGESTÕES'
            database.ver_coment(Ouvidoria.conexao,comando,'Suas \033[;34mSugestões:\033[m')
        

    def apagar_coment(self,input,comentario):
        """Função para apagar um comentário comentário e 

        Args:
            input (str): input que vem do arquivo main com a opção escolhida pelo usuario
            comentario (int): id do comentário que o usuario deseja apagar
        """
        if input == '1':
            try:
                comando= 'DELETE FROM ELOGIOS WHERE ID = %s'
                database.apagar_coment(Ouvidoria.conexao,comando,comentario)
            except:
                Ouvidoria.msg_erro(self,'Esse elogio não existe')
            else:
                Ouvidoria.msg_sucesso(self,'Elogio apagado')
        
        elif input == '2':
            try:
                comando= 'DELETE FROM CRITICAS WHERE ID = %s'
                database.apagar_coment(Ouvidoria.conexao,comando,comentario)
            except:
                Ouvidoria.msg_erro(self,'Essa critica não existe')
            else:
                Ouvidoria.msg_sucesso(self,'Critica apagado')
        
        elif input == '3':
            try:
                comando= 'DELETE FROM SUGESTÕES WHERE ID = %s'
                database.apagar_coment(Ouvidoria.conexao,comando,comentario)
            except:
                Ouvidoria.msg_erro(self,'Essa Sugestão não existe')
            else:
                Ouvidoria.msg_sucesso(self,'Sugestão apagada')
    

    def apagar_tudo(self,input):
        """Função para apagar todas as linhas da tabela

        Args:
            input (str): input que vem do arquivo main com a opção escolhida pelo usuario
        """
        if input == '1':
            comando= 'TRUNCATE ELOGIOS'
            database.apagar_coment(Ouvidoria.conexao,comando,'all')
            Ouvidoria.msg_sucesso(self,'Todos os elogios apagados')
        
        elif input == '2':
            comando= 'TRUNCATE CRITICAS'
            database.apagar_coment(Ouvidoria.conexao,comando,'all')
            Ouvidoria.msg_sucesso(self,'Todas as criticas apagadas')
        
        elif input == '3':
            comando= 'TRUNCATE SUGESTÕES'
            database.apagar_coment(Ouvidoria.conexao,comando,'all')
            Ouvidoria.msg_sucesso(self, 'Todas as sugestões apagadas')
        
        elif input == '4':
            comando= 'TRUNCATE ELOGIOS'
            database.apagar_coment(Ouvidoria.conexao,comando,'all')
            comando= 'TRUNCATE CRITICAS'
            database.apagar_coment(Ouvidoria.conexao,comando,'all')
            comando= 'TRUNCATE SUGESTÕES'
            database.apagar_coment(Ouvidoria.conexao,comando,'all')
            Ouvidoria.msg_sucesso(self,'Todos os comentários apagados')