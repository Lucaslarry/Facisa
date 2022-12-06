import mysql.connector
def logar(host,usuario,senha):
    """Função para logar no banco de dados

    Args:
        host (str): Nome do Host
        usuario (str): Nome do usuario
        senha (str): Senha

    Returns:
        variavel: Retorna o comando conectado
    """
    conexao = mysql.connector.connect(
        host=host,
        user=usuario,
        password=senha,
        db='ouvidoria'
    )
    return conexao

def fazer_coment(conexao,comando,comentario):
    """Função para adicionar um comentário no banco de dados

    Args:
        conexao : variavel que está logado o banco de dados
        comando (str): Comando (de adicioar em uma tabela) que será usado no mysql
        comentario (str): Comentario que será adicionado a tabela
    """
    cursor = conexao.cursor()
    cursor.execute(comando,comentario)
    conexao.commit()
    cursor.close()


def ver_coment(conexao,comando,tipo='Seus comentários:'):
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
    print(tipo)
    for comentario in comentarios:
        print(f'\033[;33m{comentario[0]}:\033[m {comentario[1]}')


def apagar_coment(conexao,comando,comentario):
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
