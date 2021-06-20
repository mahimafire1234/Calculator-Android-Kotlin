package com.mahima.calculatorapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //    declaring the varibables
    private lateinit var etinput: TextView;
    private lateinit var tvoutput: TextView;
    private lateinit var btnadd: Button;
    private lateinit var btnsub: Button;
    private lateinit var btnmul: Button;
    private lateinit var btndiv: Button;
    private lateinit var btnmod: Button;
    private lateinit var btnnumclr: Button;
    private lateinit var btnequals: Button;
    private lateinit var btnpow: Button;
    private lateinit var btndecimal: Button;
    private lateinit var btnnumone: Button;
    private lateinit var btnnumtwo: Button;
    private lateinit var btnnumthree: Button;
    private lateinit var btnnumfour: Button;
    private lateinit var btnnumfive: Button;
    private lateinit var btnnumsix: Button;
    private lateinit var btnnumseven: Button;
    private lateinit var btnnumeight: Button;
    private lateinit var btnnumnine: Button;
    private lateinit var btnnumzero: Button;
    private lateinit var process: String;
    private var add:Boolean=false;
    private var sub:Boolean=false;
    private var mul:Boolean=false;
    private var div:Boolean=false;
    private var mod:Boolean=false;
    private var pow:Boolean=false;
    private var num1:Float=0.0f;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        initialize the above declared variables
        etinput = findViewById(R.id.etinput)
        tvoutput = findViewById(R.id.tvoutput);
//        operators
        btnadd = findViewById(R.id.btnadd)
        btnsub = findViewById(R.id.btnsub)
        btnmul = findViewById(R.id.btnmul)
        btndiv = findViewById(R.id.btndiv)
        btnmod = findViewById(R.id.btnmod)
//        other operators binding
        btnnumclr = findViewById(R.id.btnnumclr)
        btnequals = findViewById(R.id.btnequals)
        btnpow = findViewById(R.id.btnpow)
        btndecimal = findViewById(R.id.btndecimal)
//        numbers binding
        btnnumone = findViewById(R.id.btnnumone)
        btnnumtwo = findViewById(R.id.btnnumtwo)
        btnnumthree = findViewById(R.id.btnnumthree)
        btnnumfour = findViewById(R.id.btnnumfour)
        btnnumfive = findViewById(R.id.btnnumfive)
        btnnumsix = findViewById(R.id.btnnumsix)
        btnnumseven = findViewById(R.id.btnnumseven)
        btnnumeight = findViewById(R.id.btnnumeight)
        btnnumnine = findViewById(R.id.btnnumnine)
        btnnumzero = findViewById(R.id.btnnumzero)

//        for clear button
        btnnumclr.setOnClickListener { clear() };

//        for numbers
        btnnumone.setOnClickListener {
            clickbtnnum(btnnumone);
        }
        btnnumtwo.setOnClickListener {
            clickbtnnum(btnnumtwo);
        }
        btnnumthree.setOnClickListener {
            clickbtnnum(btnnumthree);
        }
        btnnumfour.setOnClickListener {
            clickbtnnum(btnnumfour);
        }
        btnnumfive.setOnClickListener {
            clickbtnnum(btnnumfive);
        }
        btnnumsix.setOnClickListener {
            clickbtnnum(btnnumsix);
        }
        btnnumseven.setOnClickListener {
            clickbtnnum(btnnumseven);
        }
        btnnumeight.setOnClickListener {
            clickbtnnum(btnnumeight);
        }
        btnnumnine.setOnClickListener {
            clickbtnnum(btnnumnine);
        }
        btnnumzero.setOnClickListener {
            clickbtnnum(btnnumzero);
        }

        btndecimal.setOnClickListener {
            clickbtnnum(btndecimal);
        }
// listeners for operations
        /* the following process converts the first input number to
        * float
        * it then sets the operator's boolean value to true
        * */
        btnadd.setOnClickListener {
            num1=(etinput.text.toString() ).toFloat();
            add=true;
            etinput.setText(null)
        }
        btnsub.setOnClickListener {
            num1=(etinput.text.toString() ).toFloat();
            sub=true;
            etinput.setText(null)
        }
        btnmul.setOnClickListener {
            num1=(etinput.text.toString() ).toFloat();
            mul=true;
            etinput.setText(null)

        }
        btndiv.setOnClickListener {
            num1=(etinput.text.toString() ).toFloat();
            div=true;
            etinput.setText(null)

        }
        btnmod.setOnClickListener {
            num1=(etinput.text.toString() ).toFloat();
            mod=true;
            etinput.setText(null)
        }
        btnpow.setOnClickListener {
            num1=(etinput.text.toString() ).toFloat();
            pow=true;
            etinput.setText(null)
        }
//for equals
        btnequals.setOnClickListener { equals(num1)}
    }
//    function clears the input window
    private fun clear() {
        etinput.setText("");
        tvoutput.setText("");
    }

    //    process creates a string of number by adding input numbers
    private fun clickbtnnum(view: View) {
        var button = view as Button;
        process = etinput.text.toString();
        etinput.setText(process + button.text);
    }

    private fun equals(num1:Float){
//        takes the second input from the user and converts it to float
        var num2=etinput.text.toString().toFloat();
//        for addition
        if(add==true){
            var result=num1+num2;
            tvoutput.text=result.toString();
            add=false;
            etinput.setText("$num1+$num2")
        }
//        for subtraction
        else if(sub==true){
            var result=num1-num2;
            tvoutput.text=result.toString();
            sub=false;
            etinput.setText("$num1-$num2")

        }
//        for multiplication
        else if(mul==true){
            var result=num1*num2;
            tvoutput.text=result.toString();
            mul=false;
            etinput.setText("$num1*$num2")

        }
//        for floor division
        else if(div==true){
            var result=num1/num2;
            tvoutput.text=result.toString();
            div=false;
            etinput.setText("$num1/$num2")

        }
//        for modular division
        else if(mod==true){
            var result=num1%num2;
            tvoutput.text=result.toString();
            mod=false;
            etinput.setText("$num1%$num2")
        }
//        for power
        else if(pow==true){
            var result=Math.pow(num1.toDouble(),num2.toDouble());
            tvoutput.text=result.toString();
            pow=false;
            etinput.setText("$num1^$num2")
        }
    }
}