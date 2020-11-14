package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Stack;
import java.math.BigDecimal;
import java.lang.Math;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.widget.Toast;

import static java.lang.System.out;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button_0, button_1, button_2, button_3, button_4, button_5, button_6,
            button_7, button_8, button_9, button_clear, button_percent,
            button_delete, button_leftbra, button_rightbra, btn_PandM,

    btn_squ2, button_sin, button_cos, button_divide, button_multiply,
            button_sub, button_add, button_equal, button_point;
    EditText text;
    int parenthess1 = 0; //定义两个变量用于判断左右括号是否匹配，0为匹配，不为0就不匹配
    int parenthess2 = 0;
    Stack<Double> stack_number = new Stack();   //存储操作数
    Stack<Character> stack_operator = new Stack();      //存储运算符


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_0 = (Button) findViewById(R.id.button_0);
        button_0.setOnClickListener(this);

        button_1 = (Button) findViewById(R.id.button_1);
        button_1.setOnClickListener(this);

        button_2 = (Button) findViewById(R.id.button_2);
        button_2.setOnClickListener(this);

        button_3 = (Button) findViewById(R.id.button_3);
        button_3.setOnClickListener(this);

        button_4 = (Button) findViewById(R.id.button_4);
        button_4.setOnClickListener(this);

        button_5 = (Button) findViewById(R.id.button_5);
        button_5.setOnClickListener(this);

        button_6 = (Button) findViewById(R.id.button_6);
        button_6.setOnClickListener(this);

        button_7 = (Button) findViewById(R.id.button_7);
        button_7.setOnClickListener(this);

        button_8 = (Button) findViewById(R.id.button_8);
        button_8.setOnClickListener(this);

        button_9 = (Button) findViewById(R.id.button_9);
        button_9.setOnClickListener(this);

        button_clear = (Button) findViewById(R.id.btn_clear);
        button_clear.setOnClickListener(this);

        button_percent = (Button) findViewById(R.id.btn_percent);
        button_percent.setOnClickListener(this);

        button_delete = (Button) findViewById(R.id.btn_del);
        button_delete.setOnClickListener(this);

        button_leftbra = (Button) findViewById(R.id.btn_leftbra);
        button_leftbra.setOnClickListener(this);

        button_rightbra = (Button) findViewById(R.id.btn_rightbra);
        button_rightbra.setOnClickListener(this);

        btn_PandM = (Button) findViewById(R.id.btn_PandM);
        btn_PandM.setOnClickListener(this);

        btn_squ2 = (Button) findViewById(R.id.btn_squ2);
        btn_squ2.setOnClickListener(this);

        button_sin = (Button) findViewById(R.id.btn_sin);
        button_sin.setOnClickListener(this);

        button_cos = (Button) findViewById(R.id.btn_cos);
        button_cos.setOnClickListener(this);

        button_divide = (Button) findViewById(R.id.button_divide);
        button_divide.setOnClickListener(this);

        button_multiply = (Button) findViewById(R.id.button_multiply);
        button_multiply.setOnClickListener(this);

        button_sub = (Button) findViewById(R.id.button_sub);
        button_sub.setOnClickListener(this);

        button_add = (Button) findViewById(R.id.button_add);
        button_add.setOnClickListener(this);

        button_equal = (Button) findViewById(R.id.button_equal);
        button_equal.setOnClickListener(this);

        button_point = (Button) findViewById(R.id.button_point);
        button_point.setOnClickListener(this);

        text = (EditText) findViewById(R.id.text);
    }

    @Override
    public void onClick(View v) {
        String str = text.getText().toString();

        switch (v.getId()) {

            case R.id.button_0:
                if (str.equals("0")) {
                    str = "0";
                } else {
                    str += "0";
                }
                text.setText(str);
                break;
            case R.id.button_1:
                if (str.equals("0")) {
                    str = "1";
                } else {
                    str += "1";
                }
                text.setText(str);
                break;
            case R.id.button_2:
                if (str.equals("0")) {
                    str = "2";
                } else {
                    str += "2";
                }
                text.setText(str);
                break;
            case R.id.button_3:
                if (str.equals("0")) {
                    str = "3";
                } else {
                    str += "3";
                }
                text.setText(str);
                break;
            case R.id.button_4:
                if (str.equals("0")) {
                    str = "4";
                } else {
                    str += "4";
                }
                text.setText(str);
                break;
            case R.id.button_5:
                if (str.equals("0")) {
                    str = "5";
                } else {
                    str += "5";
                }
                text.setText(str);
                break;
            case R.id.button_6:
                if (str.equals("0")) {
                    str = "6";
                } else {
                    str += "6";
                }
                text.setText(str);
                break;
            case R.id.button_7:
                if (str.equals("0")) {
                    str = "7";
                } else {
                    str += "7";
                }
                text.setText(str);
                break;
            case R.id.button_8:
                if (str.equals("0")) {
                    str = "8";
                } else {
                    str += "8";
                }
                text.setText(str);
                break;
            case R.id.button_9:
                if (str.equals("0")) {
                    str = "9";
                } else {
                    str += "9";
                }
                text.setText(str);
                break;
            case R.id.btn_del:
                if (str.length() > 1) {
                    str = str.substring(0, str.length() - 1);
                } else {
                    str = "0";
                }
                text.setText(str);
                break;
            case R.id.btn_clear:
                str = "0";
                text.setText(str);
                break;
            case R.id.button_point:
                //小数点前不为数字报错
                if (str.charAt(str.length() - 1) == '+' || str.charAt(str.length() - 1) == '-' || str.charAt(str.length() - 1) == '×' || str.charAt(str.length() - 1) == '÷' || str.charAt(str.length() - 1) == '.') {
                    Toast.makeText(MainActivity.this, "输入有误!", Toast.LENGTH_SHORT).show();
                    text.setText(str);
                } else {
                    str += ".";
                    text.setText(str);
                }
                break;
            case R.id.button_add:
                if (str.charAt(str.length() - 1) == '+' || str.charAt(str.length() - 1) == '-' || str.charAt(str.length() - 1) == '×' || str.charAt(str.length() - 1) == '÷' || str.charAt(str.length() - 1) == '.') {
                    Toast.makeText(MainActivity.this, "输入有误!", Toast.LENGTH_SHORT).show();
                    text.setText(str);
                } else {
                    str += "+";
                    text.setText(str);
                }
                break;
            case R.id.button_sub:
                if (str.charAt(str.length() - 1) == '+' || str.charAt(str.length() - 1) == '-' || str.charAt(str.length() - 1) == '×' || str.charAt(str.length() - 1) == '÷' || str.charAt(str.length() - 1) == '.') {
                    Toast.makeText(MainActivity.this, "输入有误!", Toast.LENGTH_SHORT).show();
                    text.setText(str);
                } else {
                    if (str.charAt(str.length() - 1) == '0') {
                        str = "-";
                    } else {
                        str += "-";
                    }
                    text.setText(str);
                }
                break;
            case R.id.button_multiply:
                if (str.charAt(str.length() - 1) == '+' || str.charAt(str.length() - 1) == '-' || str.charAt(str.length() - 1) == '×' || str.charAt(str.length() - 1) == '÷' || str.charAt(str.length() - 1) == '.') {
                    Toast.makeText(MainActivity.this, "输入有误!", Toast.LENGTH_SHORT).show();
                    text.setText(str);
                } else {
                    str += "×";
                    text.setText(str);
                }
                break;
            case R.id.button_divide:
                if (str.charAt(str.length() - 1) == '+' || str.charAt(str.length() - 1) == '-' || str.charAt(str.length() - 1) == '×' || str.charAt(str.length() - 1) == '÷' || str.charAt(str.length() - 1) == '.') {
                    Toast.makeText(MainActivity.this, "输入有误!", Toast.LENGTH_SHORT).show();
                    text.setText(str);
                } else {
                    str += "÷";
                    text.setText(str);
                }
                break;
            case R.id.btn_leftbra:
                parenthess1++;
                if (str.length() == 1) {
                    str = "(";
                } else if (!str.contains("+") && !str.contains("-") && !str.contains("×") && !str.contains("÷")) {
                    str = "(" + str;
                } else {
                    str += "(";
                }
                text.setText(str);
                break;
            case R.id.btn_rightbra:
                parenthess2++;

                if (str.length() == 1) {
                    str = "0";
                } else {
                    str += ")";
                }
                text.setText(str);
                if (parenthess2 > parenthess1) {
                    Toast.makeText(MainActivity.this, "括号不匹配!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button_equal:
                if (str.charAt(str.length() - 1) == '+' || str.charAt(str.length() - 1) == '-' || str.charAt(str.length() - 1) == '×' || str.charAt(str.length() - 1) == '÷') {
                    Toast.makeText(MainActivity.this, "输入有误!", Toast.LENGTH_SHORT).show();
                    text.setText(str);
                } else {
                    String matched = isMatched(str);
                    if (matched.equals("no error")) {
                        //开始计算
                        String re = getResult();
                        if (re.contains("Infinity")) {
                            Toast.makeText(MainActivity.this, "0不能做除数!", Toast.LENGTH_SHORT).show();
                            text.setText("0");
                        } else {
                            text.setText(re);
                        }
                    } else {
                        Toast.makeText(MainActivity.this, matched, Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.btn_squ2:
                Pattern pattern1 = Pattern.compile("(0\\.?\\d{0,2}|[1-9]\\d*\\.?\\d{0,10})");
                Matcher isNum1 = pattern1.matcher(str);
                if (!isNum1.matches()) {
                    Toast.makeText(MainActivity.this, "输入有误!", Toast.LENGTH_SHORT).show();
                    text.setText("0");
                } else {
                    double x = Double.parseDouble(str);
                    x = Math.sqrt(x);
                    String x_squ2 = String.format("%.9f", x);
                    //去掉多余的0
                    x_squ2 = x_squ2.replaceAll("0+?$", "");
                    //去掉最后一位的小数点
                    x_squ2 = x_squ2.replaceAll("[.]$", "");
                    text.setText(x_squ2);
                }
                break;
            case R.id.btn_percent:
                Pattern pattern2 = Pattern.compile("^(-?\\\\d+)(\\\\.\\\\d+)?");
                Matcher isNum2 = pattern2.matcher(str);
                if (!isNum2.matches()) {
                    Toast.makeText(MainActivity.this, "输入有误!", Toast.LENGTH_SHORT).show();
                    text.setText("0");
                }
                double per = Double.parseDouble(str);
                per = per / 100;
                String per_percent = "" + per;
                //去掉多余的0
                per_percent = per_percent.replaceAll("0+?$", "");
                //如最后一位是.则去掉
                per_percent = per_percent.replaceAll("[.]$", "");
                text.setText(per_percent);
                break;
            case R.id.btn_sin:
                double sin = Double.parseDouble(str);
                sin = Math.toRadians(sin);
                sin = Math.sin(sin);
                String sin_str = String.format("%.9f", sin);//规避极小误差
                sin_str = sin_str.replaceAll("0+?$", "");//去掉多余的0
                sin_str = sin_str.replaceAll("[.]$", "");//如最后一位是.则去掉
                text.setText(sin_str);
                break;
            case R.id.btn_cos:
                double cos = Double.parseDouble(str);
                cos = Math.toRadians(cos);
                cos = Math.cos(cos);
                String cos_str = String.format("%.9f", cos);//规避极小误差
                cos_str = cos_str.replaceAll("0+?$", "");//去掉多余的0
                cos_str = cos_str.replaceAll("[.]$", "");//如最后一位是.则去掉
                text.setText(cos_str);
                break;
            case R.id.btn_PandM:
                if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
                    if (str.equals("0")) {
                        text.setText("0");
                    } else {
                        text.setText("-" + str);
                    }
                } else if (str.charAt(0) == '-')
                    text.setText(str.substring(1, str.length()));
                else
                    text.setText(str);
                break;
            default:
                break;
        }
    }

    //将中缀表达式转换成后缀表达式
    public static StringBuffer toPostfix(String infix) {
        Stack<String> stack = new Stack<String>();      //存储运算符
        StringBuffer postfix = new StringBuffer(infix.length() * 2);   //后缀表达式字符串
        int i = 0;
        while (i < infix.length()) {
            char ch = infix.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                    while (!stack.isEmpty() && !stack.peek().equals("(")) //如果栈不为空且栈顶元素不是"(",则出栈
                        postfix.append(stack.pop());   //且添加到后缀表达式串
                    stack.push(ch + ""); //ch入栈
                    i++;
                    break;

                case '×':
                case '÷':
                    while (!stack.isEmpty() && (stack.peek().equals("×") || stack.peek().equals("÷")))  //如果栈顶元素不为空且栈顶元素是"*"或是"/"时,则出栈
                        postfix.append(stack.pop());
                    stack.push(ch + "");
                    i++;
                    break;

                case '(':
                    stack.push(ch + ""); //直接入栈
                    i++;
                    break;

                case ')':
                    String out = stack.pop();
                    while (out != null && !out.equals("(")) {    //如果栈顶元素不为空且不为"("时
                        postfix.append(out);   //添加到后缀表达式串
                        out = stack.pop();   //把此时位于栈顶的"("弹出
                    }
                    i++;
                    break;

                default:
                    while ((i < infix.length() && ch >= '0' && ch <= '9') || (i < infix.length() && ch == '.')) {
                        postfix.append(ch);    //如果是数字直接添加到后缀表达式串
                        i++;
                        if (i < infix.length())
                            ch = infix.charAt(i);
                    }
                    postfix.append(" ");
            }

        }
        while (!stack.isEmpty())       //所有运算符出栈
            postfix.append(stack.pop());   //添加到后缀表达式中
        return postfix;
    }

    //计算后缀表达式
    public static Double toValue(StringBuffer postfix) {
        Stack<Double> stack = new Stack<Double>();   //存储操作数
        double value = 0;
        int j = 0;
        for (int i = 0; i < postfix.length(); i++) {
            j = i;
            char ch = postfix.charAt(i);
            if ((ch >= '0' && ch <= '9') || ch == '.') {
                value = 0;
                //while(ch!=' '){
                while (ch != ' ' && ch != '.') {
                    //获取数字
                    value = value * 10 + ch - '0';
                    out.println("value:" + value);
                    j++;
                    ch = postfix.charAt(++i);
                }
                if (ch == '.')
                    ch = postfix.charAt(++i);
                while (ch != ' ' && (i >= j + 1)) {
                    BigDecimal valueBD = new BigDecimal(Double.toString(value));
                    BigDecimal chBD = new BigDecimal(Double.toString(ch - '0'));
                    BigDecimal nBD = new BigDecimal(Double.toString(Math.pow(10, i - j)));
                    double temp = chBD.divide(nBD).doubleValue();
                    BigDecimal tempBD = new BigDecimal(Double.toString(temp));
                    value = valueBD.add(tempBD).doubleValue();
                    ch = postfix.charAt(++i);
                }

                stack.push(value);
                out.println("stack.peek:" + stack.peek());
                //}

            } else {
                if (ch != ' ') {
                    Double y = stack.pop();
                    Double x = stack.pop();
                    switch (ch) {
                        case '+':
                            value = x + y;
                            break;
                        case '-':
                            value = x - y;
                            break;
                        case '×':
                            value = x * y;
                            break;
                        case '÷':
                            value = x / y;
                            break;
                    }
                    stack.push(value);
                }
            }

        }
        return stack.pop();
    }

    boolean exit(char x) {        //判断是否存在两个括号挨着
        if (x == '(' || x == ')') return true;
        else return false;

    }

    int rp(char op) {    //判断右运算符优先级
        switch (op) {
            case '+':
            case '-':
                return 2;
            case '*':
            case '/':
                return 4;
            case '(':
                return 6;
            case ')':
                return 1;
            default:
                return 0;
        }
    }

    int lp(char op) {    //判断左运算符优先级
        switch (op) {
            case '+':
            case '-':
                return 3;
            case '*':
            case '/':
                return 5;
            case '(':
                return 1;
            case ')':
                return 6;
            default:
                return 0;
        }
    }

    double operate(char theta, double a, double b) {  //根据运算符和数字计算答案
        switch (theta) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                return 0;
        }
    }

    double calculate(String infix) {  //根据运算符和数字计算答案

        char top;
        double a = 0.0, b = 0.0;
        double answer = 0.;
        //开始遍历运算式
        for (int i = 0; i < infix.length(); ++i) {
            char ch = infix.charAt(i);
            if (exit(ch) && exit(infix.charAt(i + 1))) {
                Toast.makeText(MainActivity.this, "输入有误!", Toast.LENGTH_SHORT).show();
            }
            if (Character.isDigit(ch)) {
                double Temp = 0.0;
                //String temp;
                StringBuilder temp = new StringBuilder(infix.length() * 2);

                temp.append(ch);    //i=0,temp=A
                while (Character.isDigit(infix.charAt(i + 1)) || infix.charAt(i + 1) == '.') {
                    i++;
                    temp.append(ch);//判断下一个字符是不是也是数字以及小数点
                }
                Temp = Double.parseDouble(temp.toString());    //i=0,temp=A,Temp=A
                stack_number.push(Temp);  //number[0]=A
                temp = null;  //.delete(0, temp.length()-1);    //temp=空
            }
            if (Character.isDigit(ch)) {
                if (ch == '(') parenthess1++;  //如果是左括号parenthess1+1
                if (ch == ')') parenthess2++;  //右括号parenthess2+1
                if (parenthess2 > parenthess1) {
                    Toast.makeText(MainActivity.this, "输入有误!", Toast.LENGTH_SHORT).show();
                    break;
                }


                top = stack_operator.pop();

                if (lp(top) < rp(ch)) {  //入栈高优先级的运算符
                    stack_operator.push(ch);
                } else {
                    while (lp(top) >= rp(ch)) {
                        if (i == infix.length() - 1) {
                            answer = stack_number.pop();
                            stack_number.push(answer);
                            if (parenthess1 == parenthess2) {
                                stack_number.pop();
                                break;
                            }
                            if (parenthess1 != parenthess2) {
                                Toast.makeText(MainActivity.this, "输入有误!", Toast.LENGTH_SHORT).show();
                                break;
                            }

                        } else if (top == '(' && ch == ')') {  //当左右括号相遇时，跳过右括号，删除左括号
                            i++;
                            //stack_operator.pop();
                            top = stack_operator.pop();
                            continue;
                        } else {
                            a = stack_number.pop();
                            //stack_number.pop();
                            b = stack_number.pop();
                            //stack_number.pop();

                            stack_number.push(operate(top, b, a));
                            stack_operator.pop();
                            top = stack_operator.pop();
                            stack_operator.push(ch);
                        }
                    }

                }
                stack_operator.push(ch);
            }
        }
        return answer;
    }

    public String getResult() {
        String result = text.getText().toString();
        double answer = calculate(result);
        out.print(answer);
        String re = String.format("%.7f", answer);//规避极小误差
        re = re.replaceAll("0+?$", "");//去掉多余的0
        re = re.replaceAll("[.]$", "");//如最后一位是.则去掉
        return re;
    }

    public static String isMatched(String infix) {
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            switch (ch) {
                case '(':
                    stack.push(ch + "");
                    break;
                case ')':
                    if (stack.isEmpty() || !stack.pop().equals("("))
                        return "括号不匹配！";
            }
        }
        return (stack.isEmpty()) ? "no error" : "括号不匹配！";
    }
}
