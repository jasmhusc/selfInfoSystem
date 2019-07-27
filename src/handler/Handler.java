package handler;

import data.Data;
import java.io.IOException;
import java.util.Scanner;

public abstract class Handler
{
    protected Scanner sc = new Scanner(System.in);
    protected Data data;

    public Handler(Data data)
    {
        this.data = data;
    }
    public void doCmd() throws IOException {
    }
    public boolean isBye() { return false;
    }
}
