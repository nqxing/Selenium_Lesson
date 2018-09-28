package iqschool;

/**
 * @author 聂钦兴
 * @date 2018-06-12
 * selenium for Chrome
 * 1、登录数字化校园平台，打开选课排课
 * 2、新增学科，新增课程
 * 3、设置选课模式
 * 4、新建选课任务，将全部学科课程添加至任务中
 * 5、设置选课时间
 * 6、发布选课
 * 
 * 注意：运行脚本前请确保如下信息已按注释要求填写完毕
 */
public class NewCourse {
	static int i;
	static String CvSetting = "3"; 	// *设置选课模式（时间优先为1  选课点选课为2  平行志愿为3）
	static String subject [] = new String[]  
			{"学科3（0612）","学科4（0612）"};  // *输入要新建的学科名，需要新建几门学科就往数组里添加几门，学科名字不可重复（每次运行脚本前必须修改）
	String subjectID = "A810";  	// *输入学科编号前缀（每次运行脚本前必须修改）
		String course [][] = new String[][]{  
		{"课程1","课程2","课程3"},  // *输入对应学科下的课程名，该行对应上面第一门学科，需要新建几门课程就往数组里添加几门，课程名字可重复
		{"课程4","课程5"},
	};
	String courseID = "C810";  // *输入课程编号前缀（每次运行脚本前必须修改）
	// *输入选课开始时间和结束时间（注意：选课点和平行志愿选课开始时间不能早于当前时间，输入开始时间时请加上脚本的预计运行时间）
	String beginTime = "2018-06-12 15:58:13";   String endTime = "2018-06-12 20:30:13";
	String taskname = "新建任务3";  // *输入选课任务名，任务名不可重复（每次运行脚本前必须修改） 
	String maxSubjectNum = "1";  // 输入学生可选学科数量
	String prioritySub = "数学"; // 平行志愿设置优先级学科成绩
	// 新建课程界面，输入课程周学时，课程学分值
	String weektime = "3";          String credit = "5";
	// 新建课程界面，输入年级范围
	String classbegin = "一年级";     String classfinish = "高三";
	// 添加到年级课程池，选择年级，班级数量，班级上限人数
	String grade = "九年级";    String classnum = "2";  String studentmax = "30";

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
