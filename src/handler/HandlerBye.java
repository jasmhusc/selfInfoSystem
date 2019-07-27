package handler;

import data.Data;

public class HandlerBye extends Handler
{
    public HandlerBye(Data data)
    {
        super(data);
    }

    public void doCmd()
    {
        System.out.print("再见！");
    }

    public boolean isBye()
    {
        return true;
    }
}
