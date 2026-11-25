import java.io.File

fun main() {
    val arquivo = File("diario.txt")

    print("Escreva uma frase sobre o seu dia: ")
    val frase = readln()

    arquivo.writeText(frase + System.lineSeparator())

    println("\nConteúdo gravado em diario.txt:")
    println(arquivo.readText())
}