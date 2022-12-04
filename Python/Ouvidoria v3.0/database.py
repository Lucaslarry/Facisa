import mysql.connector
def logar(host,usuario,senha):
    conexao = mysql.connector.connect(
        host=host,
        user=usuario,
        password=senha,
        db='ouvidoria'
    )
    return conexao

def fazercoment(conexao,comando,comentario):
    cursor = conexao.cursor()
    cursor.execute(comando,comentario)
    conexao.commit()
    cursor.close()


def vercoment(conexao,comando,tipo='Seus comentários:'):
    cursor = conexao.cursor()
    cursor.execute(comando)
    comentarios= cursor.fetchall()
    cursor.close()
    print('='*60)
    print(tipo)
    for comentario in comentarios:
        print(f'\033[;33m{comentario[0]}:\033[m {comentario[1]}')


def apagarcoment(conexao,comando,comentario=''):
    cursor= conexao.cursor()
    if comentario=='':
        cursor.execute(comando)
    else:
        cursor.execute(comando,[comentario])
    conexao.commit()
    cursor.close()
