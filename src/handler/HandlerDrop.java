package handler;

import data.Data;

import java.io.IOException;

public class HandlerDrop extends Handler
{
    public HandlerDrop(Data data)
    {
        super(data);
    }

    public void doCmd() throws IOException
    {
        if (this.data.getSize() > 0) {
            System.out.println("请输入要删除的学生信息:");
            System.out.println("学号:");
            String sid3 = this.sc.nextLine();
            this.data.remove(sid3);
        } else {
            System.out.println("系统中没有学生信息！\r\n");
        }
    }
}
