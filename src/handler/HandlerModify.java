package handler;

import data.Data;
import java.io.IOException;

public class HandlerModify extends Handler
{
    public HandlerModify(Data data)
    {
        super(data);
    }

    public void doCmd() throws IOException
    {
        System.out.println("请输入要更新的学生学号:");
        String sid = this.sc.nextLine();
        if (this.data.getBySid(sid) != null) {
            System.out.print("新姓名:");
            String name = this.sc.nextLine();
            System.out.print("新年龄:");
            String age = this.sc.nextLine();
            System.out.print("新住址:");
            String addr = this.sc.nextLine();
            this.data.set(sid, name, Integer.parseInt(age), addr);
        } else {
            System.out.println("该学生不存在，无法更新学生信息！\r\n");
        }
    }
}
