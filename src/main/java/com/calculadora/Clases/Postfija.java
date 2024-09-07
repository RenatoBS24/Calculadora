package com.calculadora.Clases;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Postfija {
    private String text;
    public static String notation(String texto){
        Operando operando = new Operando();
        Operando operando2 = new Operando();
        Map<String, Integer> valor = new HashMap<String, Integer>();
        valor.put("(",0);
        valor.put("+",1);
        valor.put("-",1);
        valor.put("*",2);
        valor.put("/",2);
        valor.put("^",3);
        String expresion = "";
        Stack s = new Stack();
        Queue q = new LinkedList<String>();
        // patron anterior = "[0-9]+|[+|/|*|-]|[(,)]"
        // nuevo patron de prueba =
        Pattern patron = Pattern.compile("\\d+\\.\\d+|\\d+|[+*/^()-]");
        Matcher m = patron.matcher(texto);
        while (m.find()) {
            q.add(m.group());
        }
        while(!q.isEmpty()){
            operando.setValor(String.valueOf(q.poll()));
            if(operando.getValor().equals("(")){
                s.push(operando.getValor());
            }else if(operando.getValor().equals(")")){
                while(!s.peek().equals("(")){
                    expresion += " "+s.pop();
                }
                s.pop();
            }else if(operando.getValor().equals("+")||operando.getValor().equals("-")||operando.getValor().equals("*")||operando.getValor().equals("/")||operando.getValor().equals("^")){
                switch(operando.getValor()){
                    case "+","-":
                        operando.setPrecedencia(1);
                        break;
                    case "*","/":
                        operando.setPrecedencia(2);
                        break;
                    case "^":
                        operando.setPrecedencia(3);
                        break;
                }
                if(s.isEmpty()){
                    s.push(operando.getValor());
                }else{
                    Integer precedencia = valor.get(s.peek());
                    if(valor.get(s.peek()) == operando.getPrecedencia() && operando.getValor().equals("^")){
                        s.push(operando.getValor());
                    } else if (valor.get(s.peek()) == operando.getPrecedencia()) {
                        while( !s.isEmpty() && valor.get(s.peek()) ==operando.getPrecedencia()){
                            expresion += " "+s.pop();
                        }
                        s.push(operando.getValor());
                    } else if (precedencia > operando.getPrecedencia()) {
                        while(!s.isEmpty() && valor.get(s.peek()) >=operando.getPrecedencia()){
                            expresion += " "+s.pop();
                        }
                        s.push(operando.getValor());
                    } else if (precedencia < operando.getPrecedencia()) {
                        s.push(operando.getValor());
                    }
                }
            }else {
                expresion += " "+operando.getValor();
            }
        }
        while (!s.isEmpty()){
            expresion += " "+s.pop();
        }
        return expresion;
    }

    public static double Result(String text){
        Queue q = new LinkedList();
        Stack s = new Stack();
        Operando operando = new Operando();
        for(int i = 0;i<text.length();i++){
            String[] datos = text.split(" ");
            for(int j=0;j<datos.length;j++){
                q.add(datos[j]);
            }
        }
        while(!q.isEmpty()){
            operando.setValor(String.valueOf(q.poll()));
            if(operando.getValor().equals("+")||operando.getValor().equals("-")||operando.getValor().equals("*")||operando.getValor().equals("/")||operando.getValor().equals("^")){
                double operando1 = Double.parseDouble((String)s.pop());
                double operando2 = Double.parseDouble((String)s.pop());
                double result = 0;
                switch (operando.getValor()){
                    case "+":
                        result = operando1+operando2;
                        break;
                    case "-":
                        result = operando2-operando1;
                        break;
                    case "*":
                        result = operando1*operando2;
                        break;
                    case "/":
                        result = operando2/operando1;
                        break;
                    case "^":
                        result = (double) Math.pow(operando2,operando1);
                        break;
                }
                s.push(String.valueOf(result));
            }else{
                s.push(operando.getValor());
            }
        }
        double resultado = Double.parseDouble((String) s.pop());
        return resultado;

    }

}
