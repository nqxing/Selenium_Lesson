package iqschool;

/**
 * @author ������
 * @date 2018-06-12
 * selenium for Chrome
 * 1����¼���ֻ�У԰ƽ̨����ѡ���ſ�
 * 2������ѧ�ƣ������γ�
 * 3������ѡ��ģʽ
 * 4���½�ѡ�����񣬽�ȫ��ѧ�ƿγ������������
 * 5������ѡ��ʱ��
 * 6������ѡ��
 * 
 * ע�⣺���нű�ǰ��ȷ��������Ϣ�Ѱ�ע��Ҫ����д���
 */
public class NewCourse {
	static int i;
	static String CvSetting = "3"; 	// *����ѡ��ģʽ��ʱ������Ϊ1  ѡ�ε�ѡ��Ϊ2  ƽ��־ԸΪ3��
	static String subject [] = new String[]  
			{"ѧ��3��0612��","ѧ��4��0612��"};  // *����Ҫ�½���ѧ��������Ҫ�½�����ѧ�ƾ�����������Ӽ��ţ�ѧ�����ֲ����ظ���ÿ�����нű�ǰ�����޸ģ�
	String subjectID = "A810";  	// *����ѧ�Ʊ��ǰ׺��ÿ�����нű�ǰ�����޸ģ�
		String course [][] = new String[][]{  
		{"�γ�1","�γ�2","�γ�3"},  // *�����Ӧѧ���µĿγ��������ж�Ӧ�����һ��ѧ�ƣ���Ҫ�½����ſγ̾�����������Ӽ��ţ��γ����ֿ��ظ�
		{"�γ�4","�γ�5"},
	};
	String courseID = "C810";  // *����γ̱��ǰ׺��ÿ�����нű�ǰ�����޸ģ�
	// *����ѡ�ο�ʼʱ��ͽ���ʱ�䣨ע�⣺ѡ�ε��ƽ��־Ըѡ�ο�ʼʱ�䲻�����ڵ�ǰʱ�䣬���뿪ʼʱ��ʱ����Ͻű���Ԥ������ʱ�䣩
	String beginTime = "2018-06-12 15:58:13";   String endTime = "2018-06-12 20:30:13";
	String taskname = "�½�����3";  // *����ѡ���������������������ظ���ÿ�����нű�ǰ�����޸ģ� 
	String maxSubjectNum = "1";  // ����ѧ����ѡѧ������
	String prioritySub = "��ѧ"; // ƽ��־Ը�������ȼ�ѧ�Ƴɼ�
	// �½��γ̽��棬����γ���ѧʱ���γ�ѧ��ֵ
	String weektime = "3";          String credit = "5";
	// �½��γ̽��棬�����꼶��Χ
	String classbegin = "һ�꼶";     String classfinish = "����";
	// ��ӵ��꼶�γ̳أ�ѡ���꼶���༶�������༶��������
	String grade = "���꼶";    String classnum = "2";  String studentmax = "30";

	public static void main(String[] args) throws Exception{
		SettingCourse.loginIq();
		for(i = 0; i < subject.length; i++){
		SettingCourse.newDisciplineCourse();
		if (i+1 == subject.length && CvSetting == "1"){
		SettingCourse.timeCourse();
		}else if(i+1 == subject.length && CvSetting == "2"){
			SettingCourse.pointCourse();
		}else if(i+1 == subject.length && CvSetting == "3"){
			SettingCourse.parallelCourse();
		}
		}
	}
}
