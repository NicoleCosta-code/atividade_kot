import java.io.File
import java.util.Locale

fun main() {
    val nomes = arrayOf("Ana", "Bruno", "Carla", "Diego")
    val notas = Array(4) { DoubleArray(3) }

    notas[0] = doubleArrayOf(8.0, 7.5, 8.5)
    notas[1] = doubleArrayOf(5.0, 6.0, 5.5)
    notas[2] = doubleArrayOf(9.0, 8.5, 9.5)
    notas[3] = doubleArrayOf(7.0, 7.0, 7.0)

    val relatorio = StringBuilder()

    for (i in nomes.indices) {
        val media = notas[i].average()
        val situacao = if (media >= 7.0) "Aprovado" else "Reprovado"
        val mediaFormatada = String.format(Locale.US, "%.1f", media)

        relatorio.appendLine("Aluno: ${nomes[i]} | Média: $mediaFormatada | Situação: $situacao")
    }

    File("boletim_final.txt").writeText(relatorio.toString())
    println("Boletim salvo em boletim_final.txt:\n")
    println(relatorio.toString())
}