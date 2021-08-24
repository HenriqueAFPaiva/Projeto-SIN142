# Projeto SIN142 - Programação concorrente e distribuída - UFV CRP

O objetivo principal deste projeto é desenvolver um software para gerenciar um recurso que precisa de exclusão mútua.

O problema contará com 10 threads tentando atualizar a contagem de views (visualizações),
likes (curtidas) e dislikes (descurtidas) de um vídeo. Cada thread deverá ler uma linha do arquivo
atualizarValores.txt e atualizar a contagem dos 3 valores citados anteriormente. Cada linha terá:
views likes dislike, separados por um espaço. Cada thread irá ler uma linha e atualizar os valores, as
outras threads as próximas linhas até o fim do arquivo.
Gerencie para que mais de uma thread não leia a mesma linha. Depois de uma atualização
nos valores, verifique no arquivo diminuirValores.txt na linha lida pela thread atual para descontar
da contagem dos 3 valores. Esses valores para descontar são ditos como não válidos, por motivos
diversos (e. g., usuário repetido), para contabilizar na atualização anterior. No final o programa terá
que gerenciar o trabalho das threads (simulando as atualizações) e como o resultado o mesmo que
um programa sequencial chegaria
