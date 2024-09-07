package com.calculadora.Clases;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separador {
    public static void main(String[] args) {
       Queue q = new LinkedList();
       String texto = "22+25-(26*27)";
       Pattern patron = Pattern.compile("[0-9]+|[+|/|*|-]|[(,)]");
       Pattern patron2 = Pattern.compile("");
       Matcher m = patron.matcher(texto);
       Matcher m2 = patron2.matcher(texto);
       boolean alerta = true;
       while (m.find()) {
           q.add(m.group());
       }
      /* while (alerta) {
          if(m.find()) {
              q.add(m.group());
              if(m2.find()){
                  q.add(m2.group());
              }
          }else {
              alerta = false;
          }
       }*/
       for(Object o : q) {
           System.out.println(o);
       }
    }
}
