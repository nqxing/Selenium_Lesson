package iqschool;

import java.io.*;

public class Flie_txt {

    /**
     * �����ļ�
     * @param fileName
     * @return
     */
    public static boolean createFile(File fileName)throws Exception{
        try{
            if(!fileName.exists()){
                fileName.createNewFile();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }


    /**
     *��ȡTXT����
     * @param file
     * @return
     */
    public static String readTxtFile(File file){
        String result = "";
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"gbk");
            BufferedReader br = new BufferedReader(reader);
            String s = null;
            while((s=br.readLine())!=null){
                result = result  + s;
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * д��TXT������ԭ����
     * @param content
     * @param fileName
     * @return
     * @throws Exception
     */
    public static boolean writeTxtFile(String content,File fileName)throws Exception{
        RandomAccessFile mm=null;
        boolean flag=false;
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(content.getBytes("gbk"));
            fileOutputStream.close();
            flag=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    /**
     * д��TXT��׷��д��
     * @param filePath
     * @param content
     */
    public static void fileChaseFW(String filePath, String content) {
        try {
            //���캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�
            FileWriter fw = new FileWriter(filePath,true);
            fw.write(content+"\r\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("�ļ�д��ʧ�ܣ�" + e);
        }
    }



    public static void main(String[] args) throws Exception{
        File file = new File(".\\Files\\1.txt");
//        createFile(file);
//        readTxtFile(file);
//        writeTxtFile("����д�������11",file);
//        fileChaseFW("D:\\123wu��.txt","66666666");
//        String j[] = {"����","����"};
//        String sum; String k;
//        for(int i = 0;i<j.length;i++){
//        	k=j[i];
//        	sum=k+"ss";
//        	sum=sum+sum;
//        	System.out.println(sum);
//        }
    	
    // ����txt�ļ�������ļ����ھ�ɾ���ڴ���
//        try {
//        	PrintWriter wr = new PrintWriter(new FileOutputStream(new File(".\\Files\\1.txt")));
////        	wr.print("11");
//        	wr.close();
//        	} catch (FileNotFoundException e) {
//        	System.out.println("���� ��");
//        	}
//        String result = "";
 
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"gbk");
            BufferedReader br = new BufferedReader(reader);
            String s = null;
            while((s=br.readLine())!=null){
//                result = result  + s;
                System.out.println(s);
            }
        
    }
}  
