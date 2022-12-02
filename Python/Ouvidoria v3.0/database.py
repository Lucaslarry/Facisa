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