import java.io.File

fun main() {
    val origem = File("senhas.txt")
    val destino = File("senhas_aprovadas.txt")

    // Limpa ou cria o arquivo de destino antes de gravar as válidas
    destino.writeText("")

    origem.forEachLine { senha ->
        val limpa = senha.trim()
        if (limpa.length < 6) {
            return@forEachLine // Equivale ao continue dentro do forEachLine
        }
        destino.appendText("$limpa${System.lineSeparator()}")
    }

    println("Validação concluída. Senhas válidas salvas em senhas_aprovadas.txt.")
}