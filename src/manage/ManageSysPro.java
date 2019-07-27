package manage;

import data.Data;
import handler.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class ManageSysPro {
    private HashMap<String, Handler> handlers = new HashMap<>();

    private ManageSysPro() {
        Data data = new Data();
        this.handlers.put("add", new HandlerAdd(data));
        this.handlers.put("modify", new HandlerModify(data));
        this.handlers.put("drop", new HandlerDrop(data));
        this.handlers.put("query", new HandlerQuery(data));
        this.handlers.put("list", new HandlerList(data));
        this.handlers.put("clear", new HandlerClear(data));
        this.handlers.put("bye", new HandlerBye(data));
        this.handlers.put("help", new HandlerHelp(data));
    }

    public static void main(String[] args) throws IOException {
        ManageSysPro sysPro = new ManageSysPro();
        sysPro.showWelcome();
        sysPro.Run();
        System.out.println("感谢您对我们的支持，欢迎再次到访。");
    }

    private void Run() throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            ShowPromt();

            String words = sc.nextLine();
            Handler handler = (Handler) this.handlers.get(words);
            if (handler != null) {
                if (handler.isBye()) {
                    handler.doCmd();
                    break;
                }
                handler.doCmd();
            }
        }
    }

    private void showWelcome() {
        System.out.println("欢迎光临！");
        System.out.println("学生管理系统真诚为您服务!\r\n");
        System.out.println("请输入命令，如：add--添加学生信息 !");
        System.out.println("如需要帮助，请输入：help");
        System.out.println("\r\n");
    }

    private void ShowPromt() {
        System.out.println("等待命令...");
    }
}
