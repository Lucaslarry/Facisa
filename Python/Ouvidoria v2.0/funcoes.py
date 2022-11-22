from time import sleep #só pra não ficar brotando tudo de uma vez na tela
class Ouvidoria:
    elogios= []
    criticas= []
    sugestoes= []


    def __init__(self,nome):
        """Iniciador da classe ouvidoria, ele inicia perguntando seu nome e dando boas vindas, logo após cria as listas que você vai usar para guardar as informações
        """
        print('\033[1;35m*\033[m' * 5, f'Seja bem vindo a nossa ouvidoria, {nome}', '\033[1;35m*\033[m' * 5)


    def voltando(self):
        """printa uma mensagem de voltando como se estivesse carregando
        """
        print('Voltando', end='',flush=True)
        sleep(0.23)
        for x in range(1,3):
            print('.', end='',flush=True)
            sleep(0.23)
        print('.')


    def msgerro(self,msg):
        """Printa uma mensagem personalizada de erro
        """
        sleep(0.2)
        print(f'\033[;31mErro! {msg}.\033[m')


    def msgsucesso(self,msg):
        """Printa uma mensagem personalizada de sucesso
        Args:
            msg (str): A mensagem que você quiser, lembranco que "com sucesso" já está incluso no final
        """
        sleep(0.2)
        print(f'\033[;32m{msg} com sucesso.\033[m')


    def menu(self,opcoes):
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
        sleep(0.1)
        for opcao in opcoes:
            print(f' \033[1;30m{id}\033[m: {opcao}')
            id+=1
            sleep(0.1)
        print('='*60)
        sleep(0.5)
        

    def fazercoment(self,nome,tipo,coment,seus='sua',art='A'):
        """Função pra adicionar comentário em uma das listas

        Args:
            nome (self.lista): nome da lista ue vai ser adicionada
            tipo (str): nome em string pra aparecer legal na interface
            seus (str, optional): só pra personalização. Defaults to 'sua'.
            art (str, optional): tbm pra personalização. Defaults to 'A'.
        """
        nome.append(coment)
        Ouvidoria.msgsucesso(self,f'{art} {seus} {tipo} foi resgistrado')


    def vercoment(self,nome,tipo,cor='7',seus='Suas'):
        """Função pra printar os comentários

        Args:
            nome (self.lista): lista de onde vai sair os comentários
            tipo (str): é o nome da lista pra aparecer em testo e sem o self
            cor (str, optional): cor que o nome da lista vai ser printada_. Defaults to '7'.
            seus (str, optional): só pra personalização. Defaults to 'Suas'.
        """
        id=1
        print('=' * 60)
        print(f'{seus} \033[;3{cor}m{tipo}\033[m:')
        for elog in nome:
            sleep(0.09)
            print(f'\033[;33m{id}\033[m: {elog}')
            id += 1


    def apagarcoment(self,nome,tipover,comentario,art='a'):
        """função pra apagar apenas um comentário da lista

        Args:
            nome (str): nome da lista
            tipover (str): nome da lista em strig 
            cor (str, optional): cor do nome da lista quando printada, vai ser definida depois. Defaults to '7'.
            seus (str, optional): personalização só. Defaults to 'Suas'.
            art (str, optional): personalização tbm. Defaults to 'a'.
        """
        try:
            nome.pop(comentario - 1)
        except:
            Ouvidoria.msgerro(self,f'Esse {tipover} não existe')
        else:
            Ouvidoria.msgsucesso(self,f'{tipover} apagad{art}')
