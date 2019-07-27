package person;

public class Student extends Person
{
    private String sid;

    public void setSid(String sid)
    {
        this.sid = sid;
    }

    public String getSid() {
        return this.sid;
    }

    public Student(String id, String name, int age, String address) {
        super(name, age, address);
        this.sid = id;
    }

    public String toString()
    {
        return this.sid + "\t" + this.getName() + "\t" + this.getAge() + "岁\t\t" + this.getAddress();
    }
}
