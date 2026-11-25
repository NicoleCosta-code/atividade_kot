import java.io.File

fun main() {
    val logFile = File("sistema.log")
    val eventos = arrayOf(
        "Sistema iniciado",
        "Usuário logado",
        "Backup concluído",
        "Sistema encerrado"
    )

    for (evento in eventos) {
        logFile.appendText("$evento${System.lineSeparator()}")
    }

    println("Eventos adicionados ao arquivo sistema.log com sucesso!")
}