import java.io.File

fun main() {
    val arquivo = File("estoque_galpao.txt")
    val linhas = arquivo.readLines().map { it.trim() }.filter { it.isNotEmpty() }
    val grade = Array(3) { IntArray(4) }

    for (i in 0 until 3) {
        val valores = linhas[i].split(",").map { it.trim().toInt() }
        for (j in 0 until 4) {
            grade[i][j] = valores[j]
        }
    }

    var rupturaEncontrada = false

    auditoria@ for (i in 0 until 3) {
        for (j in 0 until 4) {
            val qtd = grade[i][j]

            if (qtd == -1) {
                continue
            }

            if (qtd == 0) {
                println("ALERTA CRÍTICO: Ruptura de estoque na linha $i, coluna $j!")
                rupturaEncontrada = true
                break@auditoria
            }
        }
    }

    if (!rupturaEncontrada) {
        println("Auditoria concluída sem rupturas críticas de estoque.")
    }
}