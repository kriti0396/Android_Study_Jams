package com.kriti.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var inputbox:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputbox=findViewById(R.id.inputbox)
    }


    var dot:Boolean=false
    var newop:Boolean=true

    var operator:String = "X"
    var oldNum:String=""

    fun getNumbers(view: View){

        if(newop){
            inputbox.text=""
        }
        newop=false

        var getText:String = inputbox.text.toString()

        val selectedBtn = view as Button
        when(selectedBtn.id){
            R.id.bt0->{
                getText+="0"
            }
            R.id.btone->{
                getText+="1"
            }
            R.id.bttwo->{
                getText+="2"
            }
            R.id.btthree->{
                getText+="3"
            }
            R.id.btfour->{
                getText+="4"
            }
            R.id.btfive->{
                getText+="5"
            }
            R.id.btsix->{
                getText+="6"
            }
            R.id.btseven->{
                getText+="7"
            }
            R.id.bteight->{
                getText+="8"
            }
            R.id.btnine->{
                getText+="9"
            }
            R.id.btdot->{
                if(!dot){
                    getText+="."
                }
                dot=true
            }
        }
        inputbox.text=getText
    }

    fun getOperator(view:View){
        val selectedOp = view as Button
        when(selectedOp.id){
            R.id.btadd->
            {
                operator="+"
            }
            R.id.btminus->{
                operator="-"
            }
            R.id.btmutiply->{
                operator="x"
            }
            R.id.btdivide->{
                operator="/"
            }
            R.id.btpercent->{
                operator="%"
            }
            R.id.btplusminus->{
                operator="//"
            }
            R.id.btcom->{
                operator="com"
            }
            R.id.btprime->{
                operator="prime"
            }
            R.id.btfac->{
                operator="fac"
            }
        }
        oldNum=inputbox.text.toString()
        dot=false
        newop=true
    }

    fun equaloperator(view:View){
        var newNum = inputbox.text.toString()
        var result:Double?=null
        when(operator){
            "x"->{
                result=oldNum.toDouble() * newNum.toDouble()
            }
            "+"->{
                result=oldNum.toDouble() + newNum.toDouble()
            }
            "-"->{
                result=oldNum.toDouble() - newNum.toDouble()
            }
            "/"->{
                result=oldNum.toDouble() / newNum.toDouble()
            }
            "%"->{
                result=(oldNum.toDouble() * newNum.toDouble())/100
            }
            "//"->{
                val temp:Double=oldNum.toDouble() / newNum.toDouble()
                val temp2:Int=temp.toInt()
               result=temp2.toDouble()

            }
            "com"->{
                result=(oldNum.toDouble().compareTo(newNum.toDouble())).toDouble()
            }
            "prime"->{
                newNum="1"
                val num2=oldNum.toDouble()
                val num = num2.toInt()  // WILL CHECK FOR INTEGER PART ONLY
                var flag = false
                for (i in 2..num / 2) {
                    // condition for nonprime number
                    if (num % i == 0) {
                        flag = true
                        break
                    }
                }

                if (flag)
                    result=0.0
                else
                   result=1.0
            }
            "fac"->{
                newNum="1"
                val num2=oldNum.toDouble()
                val num = num2.toInt()  // WILL CHECK FOR INTEGER PART ONLY
                var factorial: Long = 1
                for (i in 1..num) {
                    // factorial = factorial * i;
                    factorial *= i.toLong()
                }
               var anss= factorial
                result=anss.toDouble()
            }

        }
        inputbox.text=result.toString()
    }

    fun cleanInput(view:View){
        inputbox.text=""
        newop=true
        dot=false
    }


}
