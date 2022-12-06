import funcoes

continuar= True

nome= str(input('Para iniciar a ouvidoria digite seu nome: ')).strip().title()

ouvidoria= funcoes.Ouvidoria(nome)

while continuar:
    
    ouvidoria.menu(['Cadastrar Comentários','Ver Comentários','Apagar Comentários','Sair'])
    menu_principal= str(input('O que deseja fazer? ')).strip()
    

    if menu_principal=='1':
        ouvidoria.menu(['Elogios','Criticas','Sugestões','Voltar'])
        menu_fazer_coment= str(input('O que deseja fazer? ')).strip()
        if menu_fazer_coment=='1' or menu_fazer_coment=='2' or menu_fazer_coment=='3':
            comentario= str(input('Digite seu comentário: ')).strip()
            ouvidoria.fazer_coment(menu_fazer_coment,comentario)
        elif menu_fazer_coment=='4':
            ouvidoria.msg_voltando()
        else:
            ouvidoria.msg_erro('Você não escolheu uma opção valida')
    

    elif menu_principal=='2':
        ouvidoria.menu(['Ver elogios','Ver criticas','Ver Sugestões','Ver tudo','Voltar'])
        menu_ver_coment=str(input('O que deseja fazer? ')).strip()
        if menu_ver_coment=='1' or menu_ver_coment=='2' or menu_ver_coment=='3' or menu_ver_coment=='4':
            ouvidoria.ver_coment(menu_ver_coment)
        elif menu_ver_coment=='5':
            ouvidoria.msg_voltando()
        else:
            ouvidoria.msg_erro('Você não escolheu uma opção valida')
    
    
    elif menu_principal=='3':
        ouvidoria.menu(['Apagar um comentário','Apagar todos os comentários','Voltar'])
        menu_apagar_principal= str(input('O que deseja Fazer? ')).strip()
        if menu_apagar_principal=='1':
            ouvidoria.menu(['Apagar um elogio', 'Apagar uma critica', 'Apagar uma sugestão',\
                 'Voltar pro menu principal'])
            menu_apagar_coment= str(input('O que deseja fazer? ')).strip()
            if menu_apagar_coment=='1' or menu_apagar_coment=='2' or menu_apagar_coment=='3':
                ouvidoria.ver_coment(menu_apagar_coment)
                try:
                    apag=int(input('Qual id do comentário que deseja apagar? '))
                except:
                    ouvidoria.msg_erro('Você não escolheu uma opção valida')
                else:
                    ouvidoria.apagar_coment(menu_apagar_coment,apag)
            elif menu_apagar_coment=='4':
                ouvidoria.msg_voltando()
            else:
                ouvidoria.msg_erro('Você não escolheu uma opção valida')
        elif menu_apagar_principal=='2':
            ouvidoria.menu(['Apagar todos os elogios','Apagar todas as criticas','Apagar todas as sugestões',\
                'Apagar tudo','Voltar pro menu principal'])
            menu_apagar_todos= str(input('O que deseja fazer? ')).strip()
            if menu_apagar_todos=='1' or menu_apagar_todos=='2' or menu_apagar_todos=='3' or menu_apagar_todos=='4':
                ouvidoria.apagar_tudo(menu_apagar_todos)
            elif menu_apagar_todos=='5':
                ouvidoria.msg_voltando()
            else:
                ouvidoria.msg_erro('Você não escolheu uma opção valida')
        elif menu_apagar_principal=='3':
            ouvidoria.msg_voltando()
        else:
            ouvidoria.msg_erro('Você não escolheu uma opção valida')
    
    
    elif menu_principal=='4':
        print('Obrigado pelo feedback')
        continuar=False
    
    else:
        ouvidoria.msg_erro('Você não escolheu uma opção valida')