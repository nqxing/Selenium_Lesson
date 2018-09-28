package iqschool;

public class NewCourseMini {
	
	//新建学科信息，学科名，学科编号
	static int i;
	static String subject [] = new String[]{"模拟2","模拟3"};      
	String subjectID = "A049";
	//新建课程信息，课程名，课程编号，课程周学时，课程学分值，年级范围
	String course [][] = new String[][]{
		{"语文课程","数学课程","英语课程"},
		{"历史课程","美术课程"}
	};
	String courseID = "C049";
	String weektime = "3";          String credit = "5";
	String classbegin = "一年级";     String classfinish = "高三";
	// 添加到年级课程池，选择年级，班级数量，班级上限人数
	String grade = "一年级";    String classnum = "2";  String studentmax = "30";
	// 设置选课模式（时间优先为1  选课点选课为2  平行志愿为3）
	static String CvSetting = "1";
	
	public static void main(String[] args) throws Exception{
		SettingCourse.loginIq();
		for(i = 0;i < subject.length; i++){
		SettingCourse.newDisciplineCourse();
		}
	}
}
