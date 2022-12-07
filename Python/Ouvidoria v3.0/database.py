from time import sleep #Modulo pra adicionar um delay entre as informações

import mysql.connector
class Database:

    def __init__(self):
        pass


    def logar(self,host,usuario,senha):
        """Função para logar no banco de dados

        Args:
            host (str): Nome do Host
            usuario (str): Nome do usuario
            senha (str): Senha

        Returns:
            variavel: Retorna o comando conectado
        """
        return mysql.connector.connect(
            host=host,
            user=usuario,
            password=senha,
            db='ouvidoria'
        )


    def deslogar(self,conexao):
        """função para deslogar no banco de dados

        Args:
            conexao (_type_): variavel que está logado o banco de dados

        Returns:
            _type_: retorna o comando de fechar a conexão
        """
        return conexao.close()


    def fazer_coment(self,conexao,comando,comentario):
        """Função para adicionar um comentário no banco de dados

        Args:
            conexao : variavel que está logado o banco de dados
            comando (str): Comando (de adicioar em uma tabela) que será usado no mysql
            comentario (str): Comentario que será adicionado a tabela
        """
        cursor = conexao.cursor()
        cursor.execute(comando,[comentario])
        conexao.commit()
        cursor.close()


    def ver_coment(self,conexao,comando,tipo='Seus comentários:'):
        """Função para Listar os comenntários feitos em determinada tabela

        Args:
            conexao (_type_): variavel que está logado o banco de dados
            comando (str): Comando (de listar a tabela) que será usado o mysql
            tipo (str, optional): Só personalização do print que aparece antes de listar os comentários. Defaults to 'Seus comentários:'.
        """
        cursor = conexao.cursor()
        cursor.execute(comando)
        comentarios= cursor.fetchall()
        cursor.close()
        print('='*60)
        sleep(0.15)
        print(tipo)
        sleep(0.15)
        for comentario in comentarios:
            print(f'\033[;33m{comentario[0]}:\033[m {comentario[1]}')
            sleep(0.15)


    def apagar_coment(self,conexao,comando,comentario):
        """Função para apagar algum comentário feito em determinada tabela

        Args:
            conexao (_type_): variavel que está logado o banco de dados
            comando (str): Comando (de apagar liha na tabela) que será usado no mysql
            comentario (str, optional): O id do comentário que se deseja apagar, caso queria apagar todas as linhas da tabela, definir esse parâmetro como "all". Defaults to ''.
        """
        cursor= conexao.cursor()
        
        if comentario=='all':
            cursor.execute(comando)
        
        else:
            cursor.execute(comando,[comentario])
        conexao.commit()
        cursor.close()


    def atualizar_coment(self,conexao,comando,id_comentario,novocomentario):
        """Função para atualizar uma linha da tabela
        Args:
            conexao (_type_): variavel que está logado o banco de dados
            comando (str): Comando (de atualizar liha na tabela) que será usado no mysql
            id_comentario (int): id da linha do comentário que o usuario deseja atualizar
            novocomentario (str): Novo comentário que será posto
        """
        cursor = conexao.cursor()
        data= (novocomentario,id_comentario)
        cursor.execute(comando,data)
        conexao.commit()
        cursor.close()