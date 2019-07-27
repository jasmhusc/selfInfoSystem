package handler;

import data.Data;
import person.Student;

import java.io.IOException;

public class HandlerQuery extends Handler
{
    public HandlerQuery(Data data)
    {
        super(data);
    }

    public void doCmd() throws IOException
    {
        if (this.data.getSize() > 0) {
            System.out.println("请输入学生ID:");
            String sid = this.sc.nextLine();
            Student student = this.data.getBySid(sid);
            if (student != null) {
                System.out.println("学号\t\t\t姓名\t\t年龄\t\t居住地");
                System.out.println(student);
            } else {
                System.out.println("ID为" + sid + "的学生不存在！\r\n");
            }
        } else {
            System.out.println("系统中没有学生信息！\r\n");
        }
    }
}
