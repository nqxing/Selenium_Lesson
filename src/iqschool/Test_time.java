package iqschool;
import java.util.Timer;
import java.util.TimerTask;

public class Test_time extends TimerTask {
	@Override
	public void run() {
	System.out.println("Ҫ���еĳ��򡭡�");
	}


public static void main(String[] args) {
Timer timer = new Timer();
timer.schedule(new Test_time(), 5000);//�˴�����Ҫ���еĳ���
}

}

