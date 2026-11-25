import java.io.File

fun main() {
    val arquivoNumeros = File("numeros.txt")
    val arquivoPares = File("pares.txt")

    // Gera numeros.txt de 1 a 50
    arquivoNumeros.writeText((1..50).joinToString(System.lineSeparator()) + System.lineSeparator())

    // Lê e filtra apenas os números pares
    val pares = arquivoNumeros.readLines()
        .mapNotNull { it.trim().toIntOrNull() }
        .filter { it % 2 == 0 }

    arquivoPares.writeText(pares.joinToString(System.lineSeparator()) + System.lineSeparator())
    println("Arquivo pares.txt gerado com ${pares.size} números pares.")
}