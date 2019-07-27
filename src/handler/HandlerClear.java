package handler;

import data.Data;

public class HandlerClear extends Handler
{
    public HandlerClear(Data data)
    {
        super(data);
    }

    public void doCmd()
    {
        this.data.clear();
    }
}
