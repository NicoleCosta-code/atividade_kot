import java.io.File

fun main() {
    val poema = File("poema.txt")

    if (poema.exists()) {
        val linhas = poema.readLines()
        val totalCaracteres = linhas.sumOf { it.length }

        println("Total de linhas: ${linhas.size}")
        println("Total de caracteres (sem quebras de linha): $totalCaracteres")
    } else {
        println("O arquivo poema.txt não foi encontrado.")
    }
}