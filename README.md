<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistema de Gestão Universitária</title>
    <style>
        /* Adicione estilos CSS conforme necessário */
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 0;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        p {
            margin-bottom: 10px;
        }
        .section {
            margin-bottom: 30px;
            border-bottom: 1px solid #ccc;
            padding-bottom: 20px;
        }
        .section h2 {
            color: #666;
        }
    </style>
</head>
<body>
    <h1>Sistema de Gestão Universitária</h1>
    
    <!-- Descrição Geral -->
    <div class="section">
        <h2>Descrição Geral</h2>
        <p>
            Pretende-se desenvolver um sistema informático que permita ao Departamento de uma Universidade ter um sistema próprio para gerir as suas atividades pedagógicas...
        </p>
    </div>
    
    <!-- Funcionalidades -->
    <div class="section">
        <h2>Funcionalidades</h2>
        <p>
            A aplicação informática deverá ser composta por duas partes: a parte de back-end que suporta o funcionamento do sistema, e a parte de front-end que suporta a interface que permite a interação com o utilizador...
        </p>
    </div>
    
    <!-- Atores do Sistema Informático -->
    <div class="section">
        <h2>Atores do Sistema Informático</h2>
        <ul>
            <li><strong>Administrador:</strong>
                <ul>
                    <li>Autenticar-se como Administrador.</li>
                    <li>Adicionar, apagar ou alterar informação dos professores.</li>
                    <li>Registar ou alterar informação de cursos e UCs.</li>
                    <li>Listar cursos, UCs, alunos ou professores registados no sistema.</li>
                    <li>Atribuir direção de curso ou regência de UC a professor.</li>
                </ul>
            </li>
            <li><strong>Professor:</strong>
                <ul>
                    <li>Criar sumário.</li>
                    <li>Consultar lista de sumários por UC e por tipo de aula.</li>
                    <li>Consultar serviço docente.</li>
                </ul>
            </li>
            <li><strong>Regente de UC:</strong>
                <ul>
                    <li>Adicionar/remover alunos ao/do curso.</li>
                    <li>Consulta assiduidade de determinado aluno.</li>
                </ul>
            </li>
            <li><strong>Diretor de Curso:</strong>
                <ul>
                    <li>Alterar designação do Curso.</li>
                    <li>Listar número de professores ou alunos por curso.</li>
                </ul>
            </li>
        </ul>
    </div>
</body>
</html>
