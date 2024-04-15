package com.example.vibradownloader

import android.app.Application
import org.junit.Assert.*

import org.junit.Test

class MainViewModelTest {

    // pode colocar mais de um assert por teste
    @Test
    fun idExtract() {
        // passo 1 - resgatar valores
        val viewModel = MainViewModel(Application())
        val normalUrl = "https://www.youtube.com/watch?v=IWmapG_rAQ8"
        val reducedUrl = "https://youtu.be/IWmapG_rAQ8?t=112"

        // passo 2 - executar os testes
        val expected = "IWmapG_rAQ8"
        val normalResult = viewModel.idExtract(normalUrl)
        val reducedResult = viewModel.idExtract(reducedUrl)


        // passo 3 - comparar resultados
        assertEquals(
            "Teste com link comum",
            expected,
            normalResult
        )
        assertEquals(
            "Teste com link reduzido",
            expected,
            reducedResult
        )
    }
}