import java.io.File

fun main() {
    val arquivo = File("funcionarios.txt")
    val funcionarios = mutableListOf<Pair<String, Double>>()

    arquivo.forEachLine { linha ->
        if (linha.isNotBlank()) {
            val partes = linha.split(";")
            if (partes.size == 2) {
                val nome = partes[0].trim()
                val salario = partes[1].trim().toDoubleOrNull()
                if (salario != null) {
                    funcionarios.add(nome to salario)
                }
            }
        }
    }

    if (funcionarios.isNotEmpty()) {
        val mediaSalarial = funcionarios.map { it.second }.average()
        println("Média salarial da empresa: R$ %.2f".format(mediaSalarial))
        println("Funcionários acima da média:")

        for ((nome, salario) in funcionarios) {
            if (salario > mediaSalarial) {
                println("- $nome (R$ %.2f)".format(salario))
            }
        }
    } else {
        println("Nenhum funcionário válido encontrado.")
    }
}