package handler;

import data.Data;

public class HandlerHelp extends Handler
{
    public HandlerHelp(Data data)
    {
        super(data);
    }

    public void doCmd()
    {
        System.out.println("命令提示: add, modify, query, drop, list, clear, bye");
        System.out.println("\r\n");
    }
}
