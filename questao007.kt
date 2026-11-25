import java.io.File

fun main() {
    val turmaA = File("turma_a.txt").readLines().map { it.trim() }.filter { it.isNotEmpty() }
    val turmaB = File("turma_b.txt").readLines().map { it.trim() }.filter { it.isNotEmpty() }

    val todosAlunos = (turmaA + turmaB).sortedWith(String.CASE_INSENSITIVE_ORDER)

    val listaGeral = File("lista_geral.txt")
    listaGeral.writeText(todosAlunos.joinToString(System.lineSeparator()) + System.lineSeparator())

    println("Lista geral gerada em ordem alfabética:")
    todosAlunos.forEach { println(it) }
}