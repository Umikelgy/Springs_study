package one;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/*
 *@author 10068921(LgyTT@alog.com)
 *@date 2018/8/10 9:20
 *@description:
*使用 ScriptEngineManager, JavaScript 代码可以在 Java 中执行
 */public class Nashorn_JS {
     public static void main(String[]args){
         ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
         ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
         String name="Roobu";
         Integer result=null;

         try {
             nashorn.eval("print('"+name+"')");
             result= (Integer) nashorn.eval("10+2");
         } catch (ScriptException e) {
             System.out.println("执行脚本错误"+e.getMessage());
         }
         System.out.println(result.toString());
     }
}
