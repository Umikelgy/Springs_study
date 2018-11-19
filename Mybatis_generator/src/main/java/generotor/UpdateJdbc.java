package generotor;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/15 9:40
 */
public class UpdateJdbc {
    public void Update(File file,String upSkip,String data)throws IOException {
        RandomAccessFile randomFile=new RandomAccessFile(file,"rw");
//        String up="test.abc";
//        String data="ADBCD"+"\n";
        byte bs[]=new byte[10];
        StringBuilder sb=new StringBuilder();
        data=data+"\n";
        boolean isOver=false;
      while(randomFile.read(bs)!=-1){
          sb.append(new String(bs));
          if(sb.length()>upSkip.length())
          upStringBuffer(sb,upSkip);
          int index=sb.indexOf(upSkip);

          if(index!=-1){
//            randomFile.seek(index+up.length()+1);//之前读取的数据全部放在StringBuffer中，直到含有up参数值的值；方法表示设置当前偏移量（即文件指针），index表示出现up参数的指针，”1“表示":"。
              randomFile.seek(randomFile.getFilePointer()-(sb.length()-index-upSkip.length())+1);
          randomFile.writeBytes(data);
          isOver=false;
            break;
          }
          isOver=true;
        }
        if(isOver){
            randomFile.writeBytes(upSkip+"="+data);
        }

        randomFile.close();
    }

    private void upStringBuffer(StringBuilder sb,String str) {//保证StringBuffer的长度不超过2*str.length()。
        int index=sb.indexOf(str);
        if(index==-1){
            sb.delete(0,sb.length()-str.length());
        }
    }
    public Model initModel(Map<String,String> msgs){
        Model model=new Model(msgs.get("u"),msgs.get("uN"),msgs.get("p"),msgs.get("t"),msgs.get("mN"), msgs.get("nT"),msgs.get("mT"),msgs.get("dT"));
        model.init();
        return model;
    }
    public void CreateJdbc(Model model,String path) throws Exception {
//
//        String path=System.getProperty("user.dir");//获取项目路径，在其他项目使用时可能出现错误

        File file=new File(path);
        if(!file.exists()){
           file.createNewFile();
        }
        FileOutputStream fos=new FileOutputStream(file);
        List<String> writeDatas=getWriteData(model);
        for(String data:writeDatas){
            data.getBytes();
            fos.write(data.getBytes());
            fos.flush();
        }
        fos.close();
    }
    private List<String> getWriteData(Model model){
        List<String > result=new ArrayList<>();
        int modelsLength=model.toString().length();
        int  substring=model.getClass().getName().substring(model.getClass().getPackage().getName().length()+1).length();
        String data=model.toString().substring(substring).substring(1,modelsLength-substring-1);
            String datas[]=data.split(",");
            String jdbcName="jdbc.";
            for(int i=0;i<datas.length;i++){
                result.add(jdbcName+datas[i].trim()+"\n");
            }
            return result;
    }
    @Test
    public void Test(){
     Model model=new Model();
        try {
//          new UpdateJdbc().Update(new File("E:\\testFile\\test.properties"),"jdbc.Path","dao.Path");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(new UpdateJdbc().getWriteData(model));
    }

}
