from time import sleep #só pra não ficar brotando tudo de uma vez na tela
class Ouvidoria:
    def __init__(self):
        """Iniciador da classe ouvidoria, ele inicia perguntando seu nome e dando boas vindas, logo após cria as listas que você vai usar para guardar as informações
        """
        self.nome= str(input('Para iniciar a ouvidoria digite seu nome: ')).strip().title()
        print('\033[1;35m*\033[m' * 5, f'Seja bem vindo a nossa ouvidoria, {self.nome}', '\033[1;35m*\033[m' * 5)
        self.elogios= []
        self.criticas= []
        self.sugestoes= []


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
        try:
            op=int(input('O que deseja fazer? '))
            if op>len(opcoes):
                Ouvidoria.msgerro(self, 'Você não digitou uma opção valida')
        except:
            Ouvidoria.msgerro(self,'Você não digitou uma opção valida')
        else:
            return op


    def fazerdnv(self,msg):
        """pergunta ao usuario se ele quer fazer a msm ação de novo

        Args:
            msg (string): a pergunta 

        Returns:
            int: caso seja igual a 2 ele volta pro menu principal
        """
        while True:
            x= Ouvidoria.menu(self,[msg,'Sair'])
            if x==1:
                break
            elif x==2:
                return x


    def fazercoment(self,nome,tipo,seus='sua',art='A'):
        """Função pra adicionar comentário em uma das listas

        Args:
            nome (self.lista): nome da lista ue vai ser adicionada
            tipo (str): nome em string pra aparecer legal na interface
            seus (str, optional): só pra personalização. Defaults to 'sua'.
            art (str, optional): tbm pra personalização. Defaults to 'A'.
        """
        coment = str(input(f'Por favor digite {seus} {tipo}: '))
        nome.append(coment)
        Ouvidoria.msgsucesso(self,f'{art} {seus} {tipo} foi resgistrado')


    def comentarios(self):
        """função principal dos comentários, aqui apresenta um menu onde o usuario escolhe onde quer adicionar o comentário e passa como parametro pra função fazercoment
        """
        while True:
            x = Ouvidoria.menu(self,['Elogios', 'Criticas', 'Sugestões', 'Voltar'])
            if x == 1:
                Ouvidoria.fazercoment(self,self.elogios,'elogio','seu','O')
            elif x == 2:
                Ouvidoria.fazercoment(self,self.criticas,'critica')
            elif x == 3:
                Ouvidoria.fazercoment(self,self.sugestoes,'sugestão')
            elif x == 4:
                Ouvidoria.voltando(self)
                break
            if x in (1,2,3):
                y = Ouvidoria.fazerdnv(self, 'Fazer mais algum comentário')
                if y==2:
                    break


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


    def ver(self):
        """menu principal da função ver, aqui que o usuario escolhe qual lista ele quer ver e passa como parametro pra função vercoment
        """
        while True:
            x = Ouvidoria.menu(self,['Ver seus elogios', 'Ver suas Criticas', 'Ver suas Sugestões', 'Ver tudo', 'Voltar'])
            if x == 1:
                Ouvidoria.vercoment(self,self.elogios,'elogios','2','Seus')
            elif x == 2:
                Ouvidoria.vercoment(self,self.criticas,'criticas','1')
            elif x == 3:
                Ouvidoria.vercoment(self,self.sugestoes,'sugestões','3')
            elif x==4:
                Ouvidoria.vercoment(self,self.elogios,'elogios','2','Seus')
                Ouvidoria.vercoment(self,self.criticas,'criticas','1')
                Ouvidoria.vercoment(self,self.sugestoes,'sugestões','3')
            elif x == 5:
                Ouvidoria.voltando(self)
                break
            if x in (1, 2, 3, 4):
                y = Ouvidoria.fazerdnv(self, 'Ver mais algum comentário?')
                if y == 2:
                    break


    def apagarcoment(self,nome,tipover,cor='7',seus='Suas',art='as'):
        """função pra apagar apenas um comentário da lista

        Args:
            nome (str): nome da lista
            tipover (str): nome da lista em strig 
            cor (str, optional): cor do nome da lista quando printada, vai ser definida depois. Defaults to '7'.
            seus (str, optional): personalização só. Defaults to 'Suas'.
            art (str, optional): personalização tbm. Defaults to 'a'.
        """
        Ouvidoria.vercoment(self,nome,tipover,cor,seus)
        try:
            apag = int(input(f'Qual ID d{art} {tipover} que você deseja apagar? '))
        except:
            Ouvidoria.msgerro(self,f'Esse {tipover} não existe')
        else:
            try:
                nome.pop(apag - 1)
            except:
                Ouvidoria.msgerro(self,f'Esse {tipover} não existe')
            else:
                Ouvidoria.msgsucesso(self,f'{tipover} apagad{art}')


    def apagartudo(self):
        """função para apagar completamente o que tem dentro de uma lista que o usuario escolher
        """
        k= Ouvidoria.menu(self,['Apagar todos os elogios','Apagar todas as criticas','Apagar todas as sugestões','Apagar tudo','Voltar pro menu principal'])
        if k==1:
            self.elogios.clear()
            Ouvidoria.msgsucesso(self,'Todos os elogios apagados')
        elif k==2:
            self.criticas.clear()
            Ouvidoria.msgsucesso(self, 'Todas as criticas apagados')
        elif k==3:
            self.sugestoes.clear()
            Ouvidoria.msgsucesso(self, 'Todas as sugestões apagados')
        elif k==4:
            self.elogios.clear()
            self.criticas.clear()
            self.sugestoes.clear()
            Ouvidoria.msgsucesso(self, 'Todos os comentários apagados')
        elif k==5:
            Ouvidoria.voltando(self)
            print()
        if k in range(1,2,3):
           while True:
                y = Ouvidoria.fazerdnv(self, 'apagar mais alguma coisa')
                if y==2:
                    break



    def apagar(self):
        """Menu principal da função de apagar, aqui o usuario escolhe se quer apagar um comentário ou todos de uma lista 
        """
        while True:
            x = Ouvidoria.menu(self,['Apagar apenas um comentário', 'Apagar tudo', 'Voltar'])
            if x==1:
                menu = Ouvidoria.menu(self,['Apagar um elogio', 'Apagar uma critica', 'Apagar uma sugestão', 'Voltar pro menu principal'])
                if menu==1:
                    Ouvidoria.apagarcoment(self,self.elogios,'elogios','2','Seus','os')
                elif menu==2:
                    Ouvidoria.apagarcoment(self,self.criticas,'criticas','1')
                elif menu==3:
                    Ouvidoria.apagarcoment(self,self.sugestoes,'sugestões','3')
                if menu in (1, 2, 3):
                    y = Ouvidoria.fazerdnv(self, 'apagar mais alguma coisa')
                    if y==2:
                        break
            elif x==2:
                Ouvidoria.apagartudo(self)
            elif x==3:
                Ouvidoria.voltando(self)
                break
