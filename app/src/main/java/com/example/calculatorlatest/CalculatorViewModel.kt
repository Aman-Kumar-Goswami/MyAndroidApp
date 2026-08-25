package com.example.calculatorlatest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable

class CalculatorViewModel : ViewModel(){

    private val _equationText = MutableLiveData("")
    val equationText : LiveData<String> =_equationText

    private val _resultText = MutableLiveData("")
    val resultText : LiveData<String> =_resultText
    fun onButtonClick(btn: String) {
        Log.i("Clicked Button", btn)

        val currentEquation = _equationText.value ?: ""

        when (btn) {
            "AC" -> {
                _equationText.value = ""
                _resultText.value = ""
                return
            }
            "C" -> {
                if (currentEquation.isNotEmpty()) {
                    _equationText.value = currentEquation.substring(0, currentEquation.length - 1)
                }
            }
            "=" -> {
                if (_resultText.value?.isNotEmpty() == true) {
                    _equationText.value = _resultText.value
                }
                return
            }
            else -> {
                _equationText.value = currentEquation + btn
            }
        }

        // calculate result
        try {
            val equation = _equationText.value ?: ""
            if (equation.isNotEmpty()) {
                val res = calculateResult(equation)
                if (res != "undefined") {
                    _resultText.value = res
                }
            } else {
                _resultText.value = ""
            }
        } catch (_: Exception) {
            // Don't update result if equation is incomplete/invalid
        }
    }

    fun calculateResult(equation: String): String {
        val context: Context = Context.enter()
        context.optimizationLevel = -1
        val scriptable: Scriptable = context.initStandardObjects()
        // Replace 'x' with '*' if user uses 'x' for multiplication
        val processedEquation = equation.replace("x", "*")
        var finalResult =
            context.evaluateString(scriptable, processedEquation, "Javascript", 1, null).toString()
        
        if (finalResult.endsWith(".0")) {
            finalResult = finalResult.substring(0, finalResult.length - 2)
        }
        return finalResult
    }
}