package managesystem.entities;

import java.io.Serializable;
import java.util.Date;

public class DeviceOutputApply implements Serializable {
    private Integer id;
    private String de_name;
    private String de_type;
    private Integer count;
    private Date output_time;
    private String proposer;
    private Integer pro_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDe_name() {
        return de_name;
    }

    public void setDe_name(String de_name) {
        this.de_name = de_name;
    }

    public String getDe_type() {
        return de_type;
    }

    public void setDe_type(String de_type) {
        this.de_type = de_type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getOutput_time() {
        return output_time;
    }

    public void setOutput_time(Date output_time) {
        this.output_time = output_time;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public Integer getPro_id() {
        return pro_id;
    }

    public void setPro_id(Integer pro_id) {
        this.pro_id = pro_id;
    }

    @Override
    public String toString() {
        return "DeviceOutputApply{" +
                "id=" + id +
                ", de_name='" + de_name + '\'' +
                ", de_type='" + de_type + '\'' +
                ", count=" + count +
                ", output_time=" + output_time +
                ", proposer='" + proposer + '\'' +
                ", pro_id=" + pro_id +
                '}';
    }
}
