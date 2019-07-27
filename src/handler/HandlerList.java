package handler;

import data.Data;
import java.io.IOException;

public class HandlerList extends Handler
{
    public HandlerList(Data data)
    {
        super(data);
    }

    public void doCmd() throws IOException
    {
        this.data.list();
    }
}
