package iqschool;

public class NewCourseMini {
	
	//�½�ѧ����Ϣ��ѧ������ѧ�Ʊ��
	static int i;
	static String subject [] = new String[]{"ģ��2","ģ��3"};      
	String subjectID = "A049";
	//�½��γ���Ϣ���γ������γ̱�ţ��γ���ѧʱ���γ�ѧ��ֵ���꼶��Χ
	String course [][] = new String[][]{
		{"���Ŀγ�","��ѧ�γ�","Ӣ��γ�"},
		{"��ʷ�γ�","�����γ�"}
	};
	String courseID = "C049";
	String weektime = "3";          String credit = "5";
	String classbegin = "һ�꼶";     String classfinish = "����";
	// ��ӵ��꼶�γ̳أ�ѡ���꼶���༶�������༶��������
	String grade = "һ�꼶";    String classnum = "2";  String studentmax = "30";
	// ����ѡ��ģʽ��ʱ������Ϊ1  ѡ�ε�ѡ��Ϊ2  ƽ��־ԸΪ3��
	static String CvSetting = "1";
	
	public static void main(String[] args) throws Exception{
		SettingCourse.loginIq();
		for(i = 0;i < subject.length; i++){
		SettingCourse.newDisciplineCourse();
		}
	}
}
