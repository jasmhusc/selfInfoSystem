package data;

import person.Student;
import java.io.*;
import java.util.ArrayList;

public class Data {
    private File fileName;
    private ArrayList<Student> list;

    public Data() {
        this.fileName = new File("studata.txt");
        this.list = new ArrayList<Student>();
    }

    public int getSize() {
        return this.list.size();
    }

    public void add(Student student) throws IOException {
        this.list.add(student);
        System.out.println("添加成功!\r\n");
        writreData();
    }

    public void remove(String id) throws IOException {
        Student bn = getBySid(id);
        if (bn != null) {
            this.list.remove(bn);
            System.out.println("删除成功!\r\n");
            writreData();
        } else {
            System.out.println("该学生不存在.\r\n");
        }
    }

    public void set(String id, String name, int age, String address) throws IOException {
        Student bn = getBySid(id);
        if (bn != null) {
            bn.setSid(id);
            bn.setName(name);
            bn.setAge(age);
            bn.setAddress(address);
            System.out.println("ID为" + id + "的学生信息已更新!\r\n");
            writreData();
        } else {
            System.out.println("该学生不存在.\r\n");
        }
    }

    public Student getBySid(String id) throws IOException {
        this.list.clear();
        readData();
        Student ret = null;
        for (Student student : this.list) {
            String sid = student.getSid();
            if (id.equals(sid))
                ret = student;
        }
        return ret;
    }

    public void list() throws IOException {
        this.list.clear();

        readData();

        if ((this.list == null) || (this.list.size() == 0)) {
            System.out.println("无信息，请先添加信息再查询");

            return;
        }

        System.out.println("学号\t\t\t姓名\t\t年龄\t\t居住地");

        for (int i = 0; i < this.list.size(); i++) {
            Student s = this.list.get(i);
            System.out.println(s.getSid() + "\t" + s
                    .getName() + "\t" + s
                    .getAge() + "岁\t\t" + s
                    .getAddress());
        }
    }

    public void clear() {
        this.list.clear();
        System.out.println("清除成功!\r\n");
    }

    public boolean isUsed(String id) throws IOException {
        return getBySid(id) != null;
    }

    public void readData()
            throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] str = line.split(",");
            Student s = new Student(str[0], str[1], Integer.parseInt(str[2]), str[3]);
            this.list.add(s);
        }
        br.close();
    }

    public void writreData() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(this.fileName));
        for (Student s : this.list) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.getSid()).append(",")
                    .append(s.getName()).append(",")
                    .append(s.getAge()).append(",")
                    .append(s.getAddress());
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}
