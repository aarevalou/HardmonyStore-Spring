package com.ufro.harmonystore.services;

import java.lang.reflect.Method;
import java.util.HashMap;

public class ObjectService {
    public static Object buildObject(Object obj, HashMap<String, String> nombre_valor) {
        Class<?> claseObjeto = obj.getClass();

        for (HashMap.Entry<String, String> entry : nombre_valor.entrySet()) {
            String nombreAtributo = entry.getKey();
            String valorAtributo = entry.getValue();
            try {
                String nombreSetter = "set" + nombreAtributo.substring(0, 1).toUpperCase() + nombreAtributo.substring(1);
                Method setter;
                try{
                    setter = claseObjeto.getMethod(nombreSetter, int.class);
                    setter.invoke(obj, Integer.parseInt(valorAtributo));
                }catch (NoSuchMethodException e){
                    setter = claseObjeto.getMethod(nombreSetter, String.class);
                    setter.invoke(obj, valorAtributo);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } return obj;
    }
    /*public static HashMap<String, String> obtenerAtributosObjeto(Object objeto) {
        HashMap<String, String> atributos = new HashMap<>();
        Class<?> objectClass = objeto.getClass();
        Method[] metodos = objectClass.getMethods();

        for (Method method : metodos) {
            String getter = method.getName();
            if (getter.startsWith("get") && (method.getReturnType() == String.class || method.getReturnType() == int.class)) {
                try {
                    String nombre = Character.toLowerCase(getter.charAt(3)) + getter.substring(4);
                    try{
                        int valorNumerico = Integer.parseInt(String.valueOf(method.invoke(objeto)));
                        atributos.put(nombre, String.valueOf(valorNumerico));
                    }
                    catch (Exception e){
                        String valor = "'" + method.invoke(objeto) + "'";
                        atributos.put(nombre, valor);
                    }
                    StringBuilder nombreTabla = new StringBuilder();
                    String nombrePackage = "models.";
                    nombreTabla.append(objeto.getClass().getName());
                    int indice = nombreTabla.indexOf(nombrePackage);
                    if (indice != -1) {
                        nombreTabla.delete(indice, indice + nombrePackage.length());
                    }
                    ArrayList<String> camposTabla = GestorSQlite.obtenerCamposTabla(nombreTabla.toString());
                    if (!camposTabla.contains(nombre)) {
                        atributos.remove(nombre);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return atributos;
    }*/
}
