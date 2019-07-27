package handler;

import data.Data;
import person.Student;
import java.io.IOException;

public class HandlerAdd extends Handler
{
    public HandlerAdd(Data data)
    {
        super(data);
    }

    public void doCmd() throws IOException
    {
        System.out.println("请输入要添加的学生信息:");

        String sid = "";
        while (true)
        {
            System.out.print("学号:");
            sid = this.sc.nextLine();

            boolean flag = this.data.isUsed(sid);
            if (!flag) break;
            System.out.println("你输入的学号已经被占用，请重新输入");
        }

        System.out.print("姓名:");
        String name = this.sc.nextLine();
        System.out.print("年龄:");
        String age = this.sc.nextLine();
        System.out.print("住址:");
        String addr = this.sc.nextLine();
        Student student = new Student(sid, name, Integer.parseInt(age), addr);
        this.data.add(student);
    }
}
