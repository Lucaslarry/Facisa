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


    def fazer_coment(self,conexao,tipo,comentario):
        """Função para adicionar um comentário no banco de dados

        Args:
            conexao : variavel que está logado o banco de dados
            tipo (str): Tipo do comentário
            comentario (str): Comentario que será adicionado a tabela
        """
        comando= 'INSERT INTO COMENTARIO (comentario,tipo) values (%s,%s)'
        data=(comentario,tipo)
        cursor = conexao.cursor()
        cursor.execute(comando,data)
        conexao.commit()
        cursor.close()


    def ver_coment(self,conexao,tipo,frase='Seus comentários:'):
        """Função para Listar os comenntários feitos em determinada tabela

        Args:
            conexao (_type_): variavel que está logado o banco de dados
            tipo (str): Tipo do comentário
            frase (str, optional): Só personalização do print que aparece antes de listar os comentários. Defaults to 'Seus comentários:'.
        """
        comando= 'SELECT * FROM COMENTARIO WHERE tipo = %s'
        data=(tipo)
        cursor = conexao.cursor()
        cursor.execute(comando,[data])
        comentarios= cursor.fetchall()
        cursor.close()
        print('='*60)
        sleep(0.15)
        print(frase)
        sleep(0.15)
        for comentario in comentarios:
            print(f'\033[;33m{comentario[0]}:\033[m {comentario[1]}')
            sleep(0.15)


    def apagar_coment(self,conexao,tipo,id_coment):
        """Função para apagar algum comentário feito em determinada tabela

        Args:
            conexao (_type_): variavel que está logado o banco de dados
            tipo (str): Tipo do comentário
            id_coment (int): O id do comentário que se deseja apagar
        """
        comando= 'DELETE FROM COMENTARIO WHERE id = %s AND tipo = %s'
        data=(id_coment,tipo)
        cursor= conexao.cursor()
        cursor.execute(comando,data)
        conexao.commit()
        cursor.close()


    def apagar_todos_coment(self,conexao,tipo):
        """Função para apagar todas as linhas de determinnado tipo

        Args:
            conexao (_type_): Variavel que está logada a conexão com o mysql
            tipo (str): Tipo do comentário
        """
        comando = 'DELETE FROM COMENTARIO WHERE tipo = %s'
        data=(tipo)
        cursor=conexao.cursor()
        cursor.execute(comando,[data])
        conexao.commit()
        cursor.close()


    def atualizar_coment(self,conexao,tipo,id_comentario,novocomentario):
        """Função pra atualizar uma linha da tabea

        Args:
            conexao (_type_): Variavel que está logada a conexão com o mysql
            tipo (str): Tipo do comentárip
            id_comentario (int): Id do comentário que deseja atualizar
            novocomentario (str): Novo comentário que substituirá o antigo
        """
        comando= 'UPDATE COMENTARIO SET comentario= %s WHERE id = %s AND tipo = %s'
        data=(novocomentario,id_comentario,tipo)
        cursor = conexao.cursor()
        cursor.execute(comando,data)
        conexao.commit()
        cursor.close()