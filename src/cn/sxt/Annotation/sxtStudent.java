package cn.sxt.Annotation;


@Table("sxt_student")
public class sxtStudent {

    @Field(columName = "name",type = "varchar",length = 10)
    private String sname;

    @Field(columName = "name",type = "int",length = 3)
    private int sage;

    @Field(columName = "name",type = "int",length = 10)
    private int sid;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setSid(int sid,String comment){
        this.sid = sid;
        comment = "";
    }

    public sxtStudent(String sname, int sage, int sid) {
        this.sname = sname;
        this.sage = sage;
        this.sid = sid;
    }

    public sxtStudent(){

    }
}
