import java.io.File

data class JogadorPontuacao(val nome: String, val pontos: Int)

fun main() {
    val arquivo = File("ranking.txt")
    val ranking = mutableListOf<JogadorPontuacao>()

    if (arquivo.exists()) {
        arquivo.forEachLine { linha ->
            if (linha.isNotBlank()) {
                val partes = linha.split(";")
                if (partes.size == 2) {
                    val nome = partes[0].trim()
                    val pontos = partes[1].trim().toIntOrNull()
                    if (pontos != null) {
                        ranking.add(JogadorPontuacao(nome, pontos))
                    }
                }
            }
        }
    }

    print("Digite o nome do novo jogador: ")
    val novoNome = readln().trim()

    print("Digite a pontuação de $novoNome: ")
    val novosPontos = readln().trim().toIntOrNull() ?: 0

    ranking.add(JogadorPontuacao(novoNome, novosPontos))

    val top5 = ranking
        .sortedByDescending { it.pontos }
        .take(5)

    val conteudoAtualizado = top5.joinToString(System.lineSeparator()) { "${it.nome};${it.pontos}" } +
            System.lineSeparator()

    arquivo.writeText(conteudoAtualizado)

    println("\nTop 5 atualizado em ranking.txt:")
    top5.forEachIndexed { index, jogador ->
        println("${index + 1}º - ${jogador.nome}: ${jogador.pontos} pts")
    }
}