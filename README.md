Descrição Geral

Pretende-se desenvolver um sistema informático que permita ao Departamento de uma Universidade ter um sistema próprio para gerir as suas atividades pedagógicas. O Departamento tem diversos professores, e um conjunto de cursos. Cada professor é caracterizado por um nome, número mecanográfico, data de início de funções, e tem a si associado um serviço docente, isto é, as Unidades Curriculares (UCs) em que participa. Por sua vez, cada curso é caracterizado por uma designação, é constituído por UCs e um Diretor de Curso. As UCs são caracterizadas por uma designação, um regente da UC, e uma equipa docente. Finalmente, cada curso, tem um conjunto de alunos que são caracterizados por um nome, número mecanográfico, e o curso que frequentam.
A aplicação deverá ter um administrador responsável por atividades como adicionar/remover professores ao sistema, criar ou reestruturar informação de algum curso, entre outras. Por seu turno, na gestão das UCs, os professores podem criar
sumários de aulas, onde é registado o título, tipo e sumário da aula, entre outras atividades.

Funcionalidades

A aplicação informática deverá ser composta por duas partes: a parte de back-end que suporta o funcionamento do sistema, e a parte de front-end que suporta a interface que permite a interação com o utilizador. Estas partes deverão estar implementadas em pacotes distintos, ou seja, todas as classes que digam respeito à interface deverão estar arrumadas num pacote e as classes respeitantes à gestão das funcionalidades, noutro.
A entrada e saída de dados deve ser realizada recorrendo a uma interface em linha de comandos. Pretende-se ainda que a aplicação tenha capacidade de persistência, ou seja, que tenha capacidade de guardar em ficheiro o estado do sistema num determinado momento e recuperá-lo quando pretendido. Refere-se que não é permitida a utilização de bases de dados. Ainda em relação à entrada e saída de dados importa referir que se pretende que o sistema tenha níveis de robustez adequados, ou seja, que seja capaz de se comportar adequadamente em situações de erro (nomeadamente aquando da introdução de dados por parte dos utilizadores).

Atores do Sistema Informático
Administrador
1. Autenticar-se como Administrador.
2. Adicionar, apagar ou alterar informação dos professores.
3. Registar ou alterar informação de cursos e UCs.
4. Listar cursos, UCs, alunos ou professores registados no sistema.
5. Atribuir direção de curso ou regência de UC a professor.

Professor:
1. Criar sumário.
2. Consultar lista de sumários por UC e por tipo de aula.
3. Consultar serviço docente.

Regente de UC:
1. Adicionar/remover alunos ao/do curso.
2. Consulta assiduidade de determinado aluno.

Diretor de Curso:
1. Alterar designação do Curso.
2. Listar número de professores ou alunos por curso.
